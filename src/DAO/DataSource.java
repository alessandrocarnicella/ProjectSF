package DAO;

/**
 * Created by alessandro on 08/02/18.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Util.ConfigFile;

public class DataSource {

    private String dbURI = "jdbc:postgresql://localhost:5432/"+ConfigFile.DBName;
    private String user = ConfigFile.DBName;
    private String password = ConfigFile.DBPassword;

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(dbURI,user, password);
        return connection;
    }


}

