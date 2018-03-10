package DAO;

import Bean.BeanFilamento;
import Bean.BeanPosRaggioLato;
import Entity.Contorno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by alessandro on 10/02/18.
 */
public class DAOContorno {

    private DataSource DataSource;
    private static DAOContorno instance;
    private Connection conn = null;

    protected DAOContorno() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static DAOContorno getInstance() {
        if (DAOContorno.instance == null)
            DAOContorno.instance = new DAOContorno();
        return instance;
    }


    //method apertura connessione
    public void openConnection() {
        try {
            conn = this.DataSource.getConnection();
            /* l'autocommit viene settato a null,
                verra' effettuato un unica volta
                alla chiusura della connessione  */
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //method chiusura connessione
    public void closeConnection() {
        try {
            //unico commit
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //method inserimento contorni in DB
    public void insertContorno(Contorno contorno) {

        PreparedStatement stmt = null;

        String insertQuery = "INSERT INTO contorno(idfilamento,long,latg) VALUES (?,?,?)";

        try {
            stmt = conn.prepareStatement(insertQuery);
            stmt.setInt(1, contorno.getIdFilamento());
            stmt.setFloat(2, contorno.getLonG());
            stmt.setFloat(3, contorno.getLatG());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // release resources
            if (stmt !=null) {
                try {
                    stmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }


    //method
    public boolean  findItemById(Contorno contorno) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String selectQuery ="SELECT * FROM contorno WHERE idfilamento=?  AND long=?  AND latg=?";
        try {
            stmt = conn.prepareStatement(selectQuery);
            stmt.setInt(1, contorno.getIdFilamento());
            stmt.setFloat(2, contorno.getLonG());
            stmt.setFloat(3, contorno.getLatG());
            rs = stmt.executeQuery();

            if(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // release resources
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return false;
    }



    //method
    public ArrayList<String> selectForIdOrNameFilCentroidExtensionFromDB(BeanFilamento beanFilamento){

        ArrayList<String> val=new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs=null;

        String selectQuery = "SELECT  AVG(long) AS mediaLong, AVG(latg) AS mediaLatg, MIN(long) AS minLong, MAX(long) AS maxLong, MIN(latg) AS minLatg, MAX(latg) AS maxLatg, COUNT(DISTINCT(idsegmento))" +
                " FROM contorno JOIN filamento  ON contorno.idfilamento = filamento.idfilamento JOIN segmento ON contorno.idfilamento = segmento.idfilamento" +
                " WHERE contorno.idfilamento=? OR filamento.nome=?";

        try {

            openConnection();
            stmt = conn.prepareStatement(selectQuery);
            stmt.setInt(1,beanFilamento.getIdFilamento());
            stmt.setString(2,beanFilamento.getNome());
            rs = stmt.executeQuery();


            if (!rs.isBeforeFirst() ) {
                return null;
            }

            while (rs.next()){

                val.add(rs.getString(1));
                val.add(rs.getString(2));
                val.add(rs.getString(3));
                val.add(rs.getString(4));
                val.add(rs.getString(5));
                val.add(rs.getString(6));
                val.add(rs.getString(7));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            // release resources
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // release resources
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // close connection
            if(conn  != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return val;

    }

    public ArrayList<String> selectForRegionePosSpazialeFromDB(BeanPosRaggioLato beanPosRaggioLato) {

        ArrayList<String> val=new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs=null;

        String selectQuery = "SELECT DISTINCT f.idfilamento,f.nome,f.flussototale,f.densitamedia,f.temperaturamedia,f.ellitticita,f.contrasto,f.nomesatellite,f.nomestrumento\n" +
                "FROM contorno as c1 JOIN filamento as f ON c1.idfilamento = f.idfilamento\n" +
                "WHERE exists (SELECT c1.latg,c1.long\n" +
                "              FROM  contorno as c2\n" +
                "              WHERE ((sqrt((c2.long-?)^2+(c2.latg-?)^2) < ?)\n" +
                "                     OR (c2.long> ? and c2.latg > ? and c2.long < ? and c2.latg < ?))\n" +
                "                    AND (c1.idfilamento = c2.idfilamento))";

        try {

            openConnection();
            stmt = conn.prepareStatement(selectQuery);

            stmt.setFloat(1,beanPosRaggioLato.getLatG());
            stmt.setFloat(2,beanPosRaggioLato.getLonG());
            if  (beanPosRaggioLato.getRaggio() != null) {
                stmt.setFloat(3, beanPosRaggioLato.getRaggio());
            }else {
                stmt.setFloat(3, 0);
            }

            if  (beanPosRaggioLato.getLato() != null) {
                stmt.setFloat(4, beanPosRaggioLato.getLonG() - beanPosRaggioLato.getLato() / 2);
                stmt.setFloat(5, beanPosRaggioLato.getLatG() - beanPosRaggioLato.getLato() / 2);
                stmt.setFloat(6, beanPosRaggioLato.getLonG() + beanPosRaggioLato.getLato() / 2);
                stmt.setFloat(7, beanPosRaggioLato.getLatG() + beanPosRaggioLato.getLato() / 2);
            }else {
                stmt.setFloat(4, 0);
                stmt.setFloat(5, 0);
                stmt.setFloat(6, 0);
                stmt.setFloat(7, 0);
            }

            rs = stmt.executeQuery();

            if (!rs.isBeforeFirst() ) {
                return null;
            }

            while (rs.next()){
                val.add(rs.getString(1));
                val.add(rs.getString(2));
                val.add(rs.getString(3));
                val.add(rs.getString(4));
                val.add(rs.getString(5));
                val.add(rs.getString(6));
                val.add(rs.getString(7));
                val.add(rs.getString(8));
                val.add(rs.getString(9));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            // release resources
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // release resources
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // close connection
            if(conn  != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return val;

    }


    //method
    public ArrayList<String> selectAllPerimeterPointsFromDB(BeanFilamento beanFilamento){

        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<String> val=new ArrayList<>();
        String selectQuery="SELECT latg,long FROM public.contorno WHERE idfilamento=?";

        try {
            openConnection();
            stmt = conn.prepareStatement(selectQuery);
            stmt.setInt(1,beanFilamento.getIdFilamento());

            rs = stmt.executeQuery();
            if (!rs.isBeforeFirst() ) {
                return null;
            }

            while(rs.next()){
                val.add(rs.getString(1));
                val.add(rs.getString(2));

            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            // release resources
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // release resources
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // close connection
            if(conn  != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return val;
    }


    //method
    public ArrayList<String> selectAllPointsFromDB(){

        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<String> val=new ArrayList<>();
        String selectQuery="SELECT * FROM public.contorno";

        try {
            openConnection();
            stmt = conn.prepareStatement(selectQuery);


            rs = stmt.executeQuery();
            if (!rs.isBeforeFirst() ) {
                return null;
            }

            while(rs.next()){
                val.add(rs.getString(1));
                val.add(rs.getString(2));
                val.add(rs.getString(3));

            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            // release resources
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // release resources
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // close connection
            if(conn  != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return val;
    }
}
