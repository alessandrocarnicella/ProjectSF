package DAO;

import Entity.Contorno;
import Entity.Stella;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public boolean findItemById(Contorno contorno) {
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
}
