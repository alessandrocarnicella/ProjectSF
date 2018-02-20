package DAO;

import Bean.BeanContorno;
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
    public ArrayList<String> selectIdFilFromContornoFromDB(){

        ArrayList<String> val=new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String selectQuery = "SELECT DISTINCT idfilamento FROM public.contorno";
        try {
            stmt = conn.prepareStatement(selectQuery);
            rs = stmt.executeQuery();

            if (!rs.isBeforeFirst() ) {
                return null;
            }

            while (rs.next()){
                val.add(rs.getString(1));
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
    public ArrayList<Float> selectCentroidPositionFromDB(BeanContorno beanContorno){

        ArrayList<Float> val =new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String selectQuery = "SELECT AVG (long),AVG (latg) FROM public.contorno WHERE idfilamento=?";

        try {
            stmt = conn.prepareStatement(selectQuery);
            stmt.setInt(1, beanContorno.getIdFilamento());

            rs = stmt.executeQuery();

            if (!rs.isBeforeFirst() ) {
                return null;
            }

            while (rs.next()){
                val.add(rs.getFloat(1));
                val.add(rs.getFloat(2));


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


    //method: torna un arrayList di float con dentro min(long) max(long) min(latg) max(latg)
    public ArrayList<Float> selectEstensionPositionFromDB(BeanContorno beanContorno){

        ArrayList<Float> val =new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String selectQuery = "SELECT MIN(long),MAX(long),MIN(latg),MAX(latg)FROM public.contorno WHERE idfilamento=?";

        try {
            stmt = conn.prepareStatement(selectQuery);
            stmt.setInt(1, beanContorno.getIdFilamento());

            rs = stmt.executeQuery();
            if (!rs.isBeforeFirst() ) {
                return null;
            }

            while (rs.next()){
                val.add(rs.getFloat(1));
                val.add(rs.getFloat(2));
                val.add(rs.getFloat(3));
                val.add(rs.getFloat(4));

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
