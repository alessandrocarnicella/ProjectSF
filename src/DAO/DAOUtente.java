package DAO;

import Bean.BeanUtente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Manuel on 10/02/2018.
 */
public class DAOUtente {

    private DataSource DataSource;
    private static DAOUtente instance;


    protected DAOUtente() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static DAOUtente getInstance() {
        if (DAOUtente.instance == null)
            DAOUtente.instance = new DAOUtente();
        return instance;
    }


    public boolean insertNewUtenteInDB(BeanUtente beanUtente) {

        Connection conn = null;
        PreparedStatement stmt = null;


        try {
            conn = this.DataSource.getConnection();

            String query = "INSERT INTO utente(nome, cognome, username, password, email, tipoutente) " +
                    "VALUES (?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, beanUtente.getNome());
            stmt.setString(2, beanUtente.getCognome());
            stmt.setString(3, beanUtente.getUsername());
            stmt.setString(4, beanUtente.getPassword());
            stmt.setString(5, beanUtente.getEmail());
            stmt.setString(6, beanUtente.getTipoUtente());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }
}
