package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by alessandro on 08/02/18.
 */
public class DAOLogin {

    private DataSource DataSource;
    private static DAOLogin instance;

    protected DAOLogin() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static DAOLogin getInstance() {
        if (DAOLogin.instance == null)
            DAOLogin.instance = new DAOLogin();
        return instance;
    }

    //method ricerca utente in DB
    public ArrayList<String> findUtente(String userName) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<String> val = new ArrayList<String>();
        ResultSet rs = null;

        try {
            conn = this.DataSource.getConnection();

            String query = "select * from utente where username=?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1,userName);
            rs = stmt.executeQuery();

            if (rs.next()) {
                val.add(rs.getString("nome"));
                val.add(rs.getString("cognome"));
                val.add(rs.getString("username"));
                val.add(rs.getString("password"));
                val.add(rs.getString("email"));
                val.add(rs.getString("tipoUtente"));
            }else {
               return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            // release resources
            if(rs != null){
                rs.close();
            }
            // release resources
            if(stmt != null){
                stmt.close();
            }
            // close connection
            if(conn  != null){
                conn.close();
            }
        }
        return val;
    }
}

