package DAO;

import Entity.Contorno;
import Entity.Scheletro;
import Entity.Stella;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alessandro on 10/02/18.
 */
public class DAOScheletro {
    private DataSource DataSource;
    private static DAOScheletro instance;
    private Connection conn = null;
    private PreparedStatement stmt = null;
    protected DAOScheletro() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static DAOScheletro getInstance() {
        if (DAOScheletro.instance == null)
            DAOScheletro.instance = new DAOScheletro();
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


    public void insertScheletro(Scheletro scheletro) {

        String insertQuery = "INSERT INTO scheletro(idfilamento,idsegmento,tiporamo,long,latg,nprog,flussomisurato) VALUES (?,?,?,?,?,?,?)";
        try {
            stmt = conn.prepareStatement(insertQuery);
            stmt.setInt(1, scheletro.getIdFilamento());
            stmt.setInt(2, scheletro.getIdSegmento());
            stmt.setString(3, scheletro.getTipoRamo());
            stmt.setDouble(4, scheletro.getLonG());
            stmt.setDouble(5, scheletro.getLatG());
            stmt.setInt(6, scheletro.getnProg());
            stmt.setDouble(7, scheletro.getFlussoMisurato());
            stmt.executeUpdate();
        } catch (SQLException e) {
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
}
