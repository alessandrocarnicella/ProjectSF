package DAO;

import Entity.Utente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by alessandro on 08/02/18.
 */
public class DAOLogin {
    private DataSource dataSource;
    private static DAOLogin instance;
    private ResultSet res;
    private Connection con;

    protected DAOLogin() {
        this.dataSource = new DataSource();
    }

    public synchronized static DAOLogin getInstance() {
        if (DAOLogin.instance == null)
            DAOLogin.instance = new DAOLogin();
        return instance;
    }

    public ArrayList<String> findUtente(String userName) {
        Statement stmt = null;
        Connection conn = null;


        try {
            stmt = conn.createStatement();
            final String query = "SELECT * FROM Utente WHERE username=?";
            ResultSet rs = stmt.executeQuery(query);

            if (!rs.first()) {// rs not empty
                return null;
                //System.out.println("NOME O PASSW ERRATI");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

