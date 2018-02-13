package DAO;

import Entity.Filamento;
import Entity.Punto;
import Entity.Stella;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alessandro on 10/02/18.
 */
public class DAOFilamento {
    private DataSource DataSource;
    private static DAOFilamento instance;
    private Connection conn = null;

    protected DAOFilamento() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static DAOFilamento getInstance() {
        if (DAOFilamento.instance == null)
            DAOFilamento.instance = new DAOFilamento();
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

    public void insertFilamento(Filamento filamento) {

        PreparedStatement stmt = null;

        String insertQuery = "INSERT INTO filamento(idfilamento,nome,flussototale,densitamedia,temperaturamedia,ellitticita,contrasto,nomesatellite,nomestrumento) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            stmt = conn.prepareStatement(insertQuery);
            stmt.setInt(1, filamento.getIdFilamento());
            stmt.setString(2, filamento.getNome());
            stmt.setDouble(3, filamento.getFlussoTotale());
            stmt.setDouble(4, filamento.getDensitaMedia());
            stmt.setDouble(5, filamento.getTemperaturaMedia());
            stmt.setDouble(6, filamento.getEllitticita());
            stmt.setDouble(7, filamento.getContrasto());
            stmt.setString(8, filamento.getNomeSatellite());
            stmt.setString(9, filamento.getNomeStrumento());
            stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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

    public boolean findItemById(Filamento filamento) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String selectQuery = "SELECT idfilamento FROM filamento WHERE idfilamento=?";

        try {
            stmt = conn.prepareStatement(selectQuery);
            stmt.setInt(1, filamento.getIdFilamento());

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
