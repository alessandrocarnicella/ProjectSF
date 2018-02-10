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
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertPuntiStella(Stella stella) {

        PreparedStatement stmt = null;


        String insertQuery = "INSERT INTO punto(long,latg) VALUES (?,?)";

        try {
            stmt = conn.prepareStatement(insertQuery);
            stmt.setDouble(1, stella.getLonG());
            stmt.setDouble(2, stella.getLatG());
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


    public void insertStella(Stella stella) {

        PreparedStatement stmt = null;

        insertPuntiStella(stella);

        String insertQuery = "INSERT INTO stella(idstella,nomestella,long,latg,valoreflusso,tipostella) VALUES (?,?,?,?,?,?)";

        try {
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
                    stmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
