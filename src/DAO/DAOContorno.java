package DAO;

import Entity.Contorno;
import Entity.Stella;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alessandro on 10/02/18.
 */
public class DAOContorno {
    private DataSource DataSource;
    private static DAOContorno instance;


    protected DAOContorno() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static DAOContorno getInstance() {
        if (DAOContorno.instance == null)
            DAOContorno.instance = new DAOContorno();
        return instance;
    }

    public void insertContorno(Contorno contorno) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = this.DataSource.getConnection();




        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
