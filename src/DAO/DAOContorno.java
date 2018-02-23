package DAO;

import Bean.BeanContorno;
import Bean.BeanFilamento;
import Entity.Contorno;
import Entity.Stella;

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


    //method
    public void openConnection() {
        try {
            conn = this.DataSource.getConnection();
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //method
    public void closeConnection() {
        try {
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //method
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

}
