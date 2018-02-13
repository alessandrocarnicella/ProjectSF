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
    private PreparedStatement stmt2 = null;
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
            stmt2 = conn.prepareStatement(insertQuery);
            stmt2.setInt(1, scheletro.getIdFilamento());
            stmt2.setInt(2, scheletro.getIdSegmento());
            stmt2.setString(3, scheletro.getTipoRamo());
            stmt2.setDouble(4, scheletro.getLonG());
            stmt2.setDouble(5, scheletro.getLatG());
            stmt2.setInt(6, scheletro.getnProg());
            stmt2.setDouble(7, scheletro.getFlussoMisurato());
            stmt2.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
        } finally {
            // release resources
            if (stmt2 != null) {
                try {
                    stmt2.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
