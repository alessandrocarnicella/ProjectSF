package DAO;


import Util.ConfigFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private String dbURI = "jdbc:postgresql://localhost:5432/"+ConfigFile.DBName;
    private String user = ConfigFile.DBUser;
    private String password = ConfigFile.DBPassword;

    //method
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(ConfigFile.DBDriver);
        Connection connection = DriverManager.getConnection(dbURI,user, password);
        return connection;
    }

}

