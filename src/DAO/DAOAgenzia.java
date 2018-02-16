package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Manuel on 10/02/2018.
 */
public class DAOAgenzia {

    private DataSource DataSource;
    private static DAOAgenzia instance;


    protected DAOAgenzia() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static DAOAgenzia getInstance() {
        if (DAOAgenzia.instance == null)
            DAOAgenzia.instance = new DAOAgenzia();
        return instance;
    }

    public ArrayList<String> selectAgenziaFromDB(){

        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<String> val = new ArrayList<String>();
        ResultSet rs = null;

        try {
            conn = this.DataSource.getConnection();
            String query = "SELECT nome FROM agenzia";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            if (!rs.isBeforeFirst() ) {
                return null;
            }

            while (rs.next()){
                val.add(rs.getString(1));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            // release resources
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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

    return val;

    }
}
