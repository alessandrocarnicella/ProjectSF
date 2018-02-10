package DAO;

import Bean.BeanSatellite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Manuel on 10/02/2018.
 */
public class DAOSatellite {


    private DataSource DataSource;
    private static DAOSatellite instance;


    protected DAOSatellite() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static DAOSatellite getInstance() {
        if (DAOSatellite.instance == null)
            DAOSatellite.instance = new DAOSatellite();
        return instance;
    }


    public boolean insertNewSatelliteInDB(BeanSatellite beanSatellite) {

        Connection conn = null;
        PreparedStatement stmt = null;


        try {
            conn = this.DataSource.getConnection();

            String query = "INSERT INTO satellite(nome, datainizio, datafine, nomeagenzia) " +
                    "VALUES (?,?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1,beanSatellite.getNome());
            stmt.setDate(2, beanSatellite.getDataInizio());
            stmt.setDate(3, beanSatellite.getDataFine());
            stmt.setString(4,beanSatellite.getNomeAgenzia());

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

            if (rs.next()){
                val.add(rs.getString(0));
            }
            else
                return null;


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


