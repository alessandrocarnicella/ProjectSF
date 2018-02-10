package DAO;

import Entity.Scheletro;
import Entity.Stella;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alessandro on 10/02/18.
 */
public class DAOScheletro {
    private DataSource DataSource;
    private static DAOScheletro instance;


    protected DAOScheletro() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static DAOScheletro getInstance() {
        if (DAOScheletro.instance == null)
            DAOScheletro.instance = new DAOScheletro();
        return instance;
    }

    public void insertScheletro(Scheletro scheletro) {

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
