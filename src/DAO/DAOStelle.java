package DAO;

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
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public void insertStella(Stella stella) {

        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;

        String insertQuery = "INSERT INTO stella(idstella,nomestella,long,latg,valoreflusso,tipostella) VALUES (?,?,?,?,?,?)";
        String insertQuery2 = "INSERT INTO punto(long,latg) VALUES (?,?)";

        try {

            stmt2 = conn.prepareStatement(insertQuery2);
            stmt2.setDouble(1, stella.getLonG());
            stmt2.setDouble(2, stella.getLatG());
            stmt2.executeUpdate();

            stmt = conn.prepareStatement(insertQuery);
            stmt.setInt(1, stella.getIdStella());
            stmt.setString(2, stella.getNomeStella());
            stmt.setDouble(3, stella.getLonG());
            stmt.setDouble(4, stella.getLatG());
            stmt.setDouble(5, stella.getValoreFlusso());
            stmt.setString(6, stella.getTipoStella());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // release resources
            if (stmt != null) {
                try {
                    stmt2.close();
                    stmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
