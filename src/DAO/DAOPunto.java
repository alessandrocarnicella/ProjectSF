package DAO;

import Entity.Punto;
import Entity.Stella;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alessandro on 12/02/18.
 */
public class DAOPunto {
    private DataSource DataSource;
    private static DAOPunto instance;
    private Connection conn = null;

    protected DAOPunto() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static DAOPunto getInstance() {
        if (DAOPunto.instance == null)
            DAOPunto.instance = new DAOPunto();
        return instance;
    }


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

    public void closeConnection() {
        try {
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertPunto(Punto punto) {

        PreparedStatement stmt = null;

        String insertQuery = "INSERT INTO punto(long,latg) VALUES (?,?)";

        try {
            stmt = conn.prepareStatement(insertQuery);
            stmt.setFloat(1, punto.getLonG());
            stmt.setFloat(2, punto.getLatG());
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

    public boolean findItemById(Punto punto) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String selectQuery = "SELECT latg,long FROM public.punto WHERE long=? AND latg=?";

               // "select * from punto where punto.latg=? AND punto.long";

        try {
            stmt = conn.prepareStatement(selectQuery);
            stmt.setFloat(1, punto.getLonG());
            stmt.setFloat(2, punto.getLatG());
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

}
