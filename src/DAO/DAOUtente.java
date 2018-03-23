package DAO;

import Bean.BeanRegistrazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOUtente {

    private DataSource DataSource;
    private static DAOUtente instance;

    //constructor
    protected DAOUtente() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static DAOUtente getInstance() {
        if (DAOUtente.instance == null)
            DAOUtente.instance = new DAOUtente();
        return instance;
    }


    //method inserimento utente in DB
    public boolean insertNewUtenteInDB(BeanRegistrazione beanRegistrazione) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = this.DataSource.getConnection();

            String query = "INSERT INTO utente(nome, cognome, username, password, email, tipoutente) " +
                    "VALUES (?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, beanRegistrazione.getNome());
            stmt.setString(2, beanRegistrazione.getCognome());
            stmt.setString(3, beanRegistrazione.getUsername());
            stmt.setString(4, beanRegistrazione.getPassword());
            stmt.setString(5, beanRegistrazione.getEmail());
            stmt.setString(6, beanRegistrazione.getTipoUtente());
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

}
