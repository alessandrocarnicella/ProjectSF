package DAO;

import Bean.BeanBanda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Manuel on 14/02/2018.
 */
public class DAOBanda {

    private DataSource DataSource;
    private static DAOBanda instance;


    protected DAOBanda() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static DAOBanda getInstance() {
        if (DAOBanda.instance == null)
            DAOBanda.instance = new DAOBanda();
        return instance;
    }

    public boolean insertNewBandaInDB(BeanBanda beanBanda) {
        Connection conn = null;
        PreparedStatement stmt = null;


        try {

            conn = this.DataSource.getConnection();

            String query = "INSERT INTO banda(lunghezza)VALUES (?)";
            stmt = conn.prepareStatement(query);
            stmt.setDouble(1,beanBanda.getLunghezza());
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

