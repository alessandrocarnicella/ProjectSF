package DAO;

import Entity.Filamento;
import Entity.Stella;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alessandro on 10/02/18.
 */
public class DAOFilamento {
    private DataSource DataSource;
    private static DAOFilamento instance;


    protected DAOFilamento() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static DAOFilamento getInstance() {
        if (DAOFilamento.instance == null)
            DAOFilamento.instance = new DAOFilamento();
        return instance;
    }

    public void insertFilamento(Filamento filamento) {

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
