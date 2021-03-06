package DAO;

import Bean.BeanSatellite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAOSatellite {

    private DataSource DataSource;
    private static DAOSatellite instance;

    //constructor
    protected DAOSatellite() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static DAOSatellite getInstance() {
        if (DAOSatellite.instance == null)
            DAOSatellite.instance = new DAOSatellite();
        return instance;
    }


    //method inserimento satellite in DB
    public boolean insertNewSatelliteInDB(BeanSatellite beanSatellite) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = this.DataSource.getConnection();

            String query = "INSERT INTO satellite(nome, datainizio, datafine, nomeagenzia, durata) " +
                    "VALUES (?,?,?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1,beanSatellite.getNome());
            stmt.setDate(2, beanSatellite.getDataInizio());
            stmt.setDate(3, beanSatellite.getDataFine());
            stmt.setString(4,beanSatellite.getNomeAgenzia());
            stmt.setFloat(5,beanSatellite.getDurata());

            stmt.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } finally {
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
        return true;
    }


    //method
    public boolean satelliteAlreadyInserted(BeanSatellite beanSatellite) {

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;

        try {
            conn = this.DataSource.getConnection();
            String query = "SELECT * FROM satellite WHERE nome=?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, beanSatellite.getNome());

            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } finally {
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
        return false;


    }


    //method selezione stellite from DB
    public ArrayList<String> selectSatellitiFromDB(){

        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<String> val = new ArrayList<String>();
        ResultSet rs = null;

        try {
            conn = this.DataSource.getConnection();
            String query = "select nome from satellite";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            if (!rs.isBeforeFirst() ) {
                return null;
            }

            while (rs.next()){
                val.add(rs.getString(1));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
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


