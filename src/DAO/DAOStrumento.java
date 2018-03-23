package DAO;

import Bean.BeanStrumento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DAOStrumento {

    private DataSource DataSource;
    private static DAOStrumento instance;

    //constructor
    protected DAOStrumento() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static DAOStrumento getInstance() {
        if (DAOStrumento.instance == null)
            DAOStrumento.instance = new DAOStrumento();
        return instance;
    }


    //method inserimento strumento in DB
    public boolean insertNewStrumentoInDB(BeanStrumento beanStrumento) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = this.DataSource.getConnection();

            String query = "INSERT INTO strumento(nome, nomesatellite) " +
                    "VALUES (?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1,beanStrumento.getNome());
            stmt.setString(2,beanStrumento.getNomeSatellite());

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
