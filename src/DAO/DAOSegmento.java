package DAO;

import Entity.Punto;
import Entity.Scheletro;
import Entity.Segmento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alessandro on 12/02/18.
 */
public class DAOSegmento {
    private DataSource DataSource;
    private static DAOSegmento instance;
    private Connection conn = null;

    protected DAOSegmento() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static DAOSegmento getInstance() {
        if (DAOSegmento.instance == null)
            DAOSegmento.instance = new DAOSegmento();
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


    public void insertSegmento(Segmento segmento) {

        PreparedStatement stmt = null;
        String insertQuery = "INSERT INTO segmento(idsegmento,idfilamento) VALUES (?,?)";

        try {
            stmt = conn.prepareStatement(insertQuery);
            stmt.setInt(1, segmento.getIdSegmento());
            stmt.setInt(2, segmento.getIdFilamento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            try {
                if(conn!=null)
                    conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            //e.printStackTrace();
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

    //method
    public boolean findItemById(Segmento segmento) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String selectQuery = "SELECT idsegmento,idfilamento FROM public.segmento WHERE idsegmento=? AND idfilamento=?";

        try {
            stmt = conn.prepareStatement(selectQuery);

            stmt.setInt(1, segmento.getIdSegmento());
            stmt.setInt(2, segmento.getIdFilamento());
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
