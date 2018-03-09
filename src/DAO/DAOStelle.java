package DAO;

import Bean.BeanPosBaseAltezza;
import Bean.BeanStella;
import Entity.Stella;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by alessandro on 09/02/18.
 */
public class DAOStelle {

    private DataSource DataSource;
    private static DAOStelle instance;
    private Connection conn = null;

    protected DAOStelle() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static DAOStelle getInstance() {
        if (DAOStelle.instance == null)
            DAOStelle.instance = new DAOStelle();
        return instance;
    }

    //method open connection
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

    //method close connection
    public void closeConnection() {
        try {
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //method inserimento setlla in DB
    public void insertStella(Stella stella) {

        PreparedStatement stmt = null;

        String insertQuery = "INSERT INTO public.stella(idstella,nomestella,long,latg,valoreflusso,tipostella) VALUES (?,?,?,?,?,?)";
        try {
            stmt = conn.prepareStatement(insertQuery);
            stmt.setInt(1, stella.getIdStella());
            stmt.setString(2, stella.getNomeStella());
            stmt.setFloat(3, stella.getLonG());
            stmt.setFloat(4, stella.getLatG());
            stmt.setDouble(5, stella.getValoreFlusso());
            stmt.setString(6, stella.getTipoStella());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
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
    }


    //method ricerca presenza stella in DB
    public boolean findItemById(Stella stella) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String selectQuery = "SELECT idstella FROM public.stella WHERE idstella=?";

        try {
            stmt = conn.prepareStatement(selectQuery);
            stmt.setInt(1, stella.getIdStella());
            rs = stmt.executeQuery();
            if (rs.next()) {
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

    //method aggiornamneto stella in DB
    public void updateStella(Stella stella) {

        PreparedStatement stmt = null;

        String insertQuery = "UPDATE public.stella SET  nomestella=?, long=?, latg=?, valoreflusso=?, tipostella=? WHERE idstella=?";

        try {
            stmt = conn.prepareStatement(insertQuery);
            stmt.setString(1, stella.getNomeStella());
            stmt.setFloat(2, stella.getLonG());
            stmt.setFloat(3, stella.getLatG());
            stmt.setDouble(4, stella.getValoreFlusso());
            stmt.setString(5, stella.getTipoStella());
            stmt.setInt(6, stella.getIdStella());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
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
    }


    //method: selezione di tutte le stelle from DB
    public ArrayList<String> selectAllStarsFromDB(){

        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<String> val=new ArrayList<>();
        String selectQuery="SELECT* FROM stella";

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
                val.add(rs.getString(4));
                val.add(rs.getString(5));
                val.add(rs.getString(6));

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


    //method: ricerca tutte le stelle from DB in base a una regione
    public ArrayList<String> searchStarsByRegionFromDB(BeanPosBaseAltezza beanPosBaseAltezza){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<String> val=new ArrayList<>();

        String selectQuery="SELECT stella.idstella,stella.nomestella,stella.long,stella.latg,stella.valoreflusso,stella.tipostella " +
                "FROM public.stella " +
                "WHERE stella.long> ? and stella.latg > ? and stella.long < ? and stella.latg < ?";

        try {
            openConnection();
            stmt = conn.prepareStatement(selectQuery);

            stmt.setFloat(1, beanPosBaseAltezza.getLonG()-beanPosBaseAltezza.getAltezza()/2);
            stmt.setFloat(2, beanPosBaseAltezza.getLatG()-beanPosBaseAltezza.getBase()/2);
            stmt.setFloat(3, beanPosBaseAltezza.getLonG()+beanPosBaseAltezza.getAltezza()/2);
            stmt.setFloat(4, beanPosBaseAltezza.getLatG()+beanPosBaseAltezza.getBase()/2);

            rs = stmt.executeQuery();

            if (!rs.isBeforeFirst() ) {
                return null;
            }

            while(rs.next()){
                val.add(rs.getString(1));
                val.add(rs.getString(2));
                val.add(rs.getString(3));
                val.add(rs.getString(4));
                val.add(rs.getString(5));
                val.add(rs.getString(6));
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


    public ArrayList<String> selectMinDistanceFromDB(Stella s,int id) {
        ArrayList<String> val = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs=null;

        String selectQuery = "SELECT s2.idfilamento,idsegmento,nprog, tiporamo, s2.latg, s2.long\n" +
                "FROM scheletro as s2\n" +
                "WHERE sqrt((? - s2.latg) ^ 2 + (? - s2.long) ^ 2)\n" +
                "          =\n" +
                "          (SELECT min(sqrt((? - scheletro.latg) ^ 2 + (? -scheletro.long) ^ 2))\n" +
                "          FROM scheletro\n" +
                "          WHERE scheletro.idfilamento = ? AND scheletro.tiporamo='S'\n" +
                ") AND s2.tiporamo='S'\n";

        try {

            openConnection();
            stmt = conn.prepareStatement(selectQuery);

            stmt.setFloat(1,s.getLatG());
            stmt.setFloat(2,s.getLonG());
            stmt.setFloat(3,s.getLatG());
            stmt.setFloat(4,s.getLonG());
            stmt.setInt(5,id);

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
}
