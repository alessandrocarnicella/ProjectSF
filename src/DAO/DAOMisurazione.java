package DAO;

import Bean.BeanMisurazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Manuel on 14/02/2018.
 */
public class DAOMisurazione {

    private DataSource DataSource;
    private static  DAOMisurazione instance;


    protected  DAOMisurazione() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static  DAOMisurazione getInstance() {
        if ( DAOMisurazione.instance == null)
            DAOMisurazione.instance = new  DAOMisurazione();
        return instance;
    }


    public boolean insertNewMisurazioneInDB(BeanMisurazione beanMisurazione) {

        Connection conn = null;
        PreparedStatement stmt = null;
        try {

            conn = this.DataSource.getConnection();

            String query = "INSERT INTO misurazione(nomestrumento, banda) " +
                    "VALUES (?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1,beanMisurazione.getNomeStrumento());
            stmt.setDouble(2,beanMisurazione.getBanda());
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

