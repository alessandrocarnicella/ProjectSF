package DAO;

import Entity.Filamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAOFilamento {

    private DataSource DataSource;
    private static DAOFilamento instance;
    private Connection conn = null;

    //constructor
    protected DAOFilamento() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static DAOFilamento getInstance() {
        if (DAOFilamento.instance == null)
            DAOFilamento.instance = new DAOFilamento();
        return instance;
    }


    //method open connection
    public void openConnection() {
        try {
            conn = this.DataSource.getConnection();
            /* l'autocommit viene settato a null,
                verra' effettuato un unica volta
                alla chiusura della connessione  */
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //method close connection
    public void closeConnection() {
        try {
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // method inserimento filamento in DB
    public void insertFilamento(Filamento filamento) {

        PreparedStatement stmt = null;
        String insertQuery = "INSERT INTO filamento(idfilamento,nome,flussototale,densitamedia,temperaturamedia,ellitticita,contrasto,nomesatellite,nomestrumento) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            stmt = conn.prepareStatement(insertQuery);
            stmt.setInt(1, filamento.getIdFilamento());
            stmt.setString(2, filamento.getNome());
            stmt.setFloat(3, filamento.getFlussoTotale());
            stmt.setFloat(4, filamento.getDensitaMedia());
            stmt.setFloat(5, filamento.getTemperaturaMedia());
            stmt.setFloat(6, filamento.getEllitticita());
            stmt.setFloat(7, filamento.getContrasto());
            stmt.setString(8, filamento.getNomeSatellite());
            stmt.setString(9, filamento.getNomeStrumento());
            stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // release resources
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }


    //method ricerca filamento in DB
    public boolean findItemById(Filamento filamento) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String selectQuery = "SELECT idfilamento FROM filamento WHERE idfilamento=?";

        try {
            stmt = conn.prepareStatement(selectQuery);
            stmt.setInt(1, filamento.getIdFilamento());

            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // release resources
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return false;
    }


    //method aggiornamento filamento in DB
    public void updateFilamento(Filamento filamento) {

        PreparedStatement stmt = null;
        String insertQuery = "UPDATE public.filamento SET  nome=?, flussototale=?, densitamedia=?, temperaturamedia=?, ellitticita=?, contrasto=?, nomesatellite=?, nomestrumento=? WHERE idfilamento=?";

        try {
            stmt = conn.prepareStatement(insertQuery);
            stmt.setString(1, filamento.getNome());
            stmt.setFloat(2, filamento.getFlussoTotale());
            stmt.setFloat(3, filamento.getDensitaMedia());
            stmt.setFloat(4, filamento.getTemperaturaMedia());
            stmt.setFloat(5, filamento.getEllitticita());
            stmt.setFloat(6, filamento.getContrasto());
            stmt.setString(7, filamento.getNomeSatellite());
            stmt.setString(8, filamento.getNomeStrumento());
            stmt.setInt(9, filamento.getIdFilamento());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // release resources
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }


    //method selezione id filamento from DB
    public ArrayList<Integer> selectFilamenti(int idfilamento){

        ArrayList<Integer> idfilamenti =new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String selectQuery = "SELECT idfilamento FROM filamento WHERE idfilamento=?";
        try {
            stmt = conn.prepareStatement(selectQuery);
            stmt.setInt(1, idfilamento);
            rs = stmt.executeQuery();

            if (!rs.isBeforeFirst() ) {
                return null;
            }

            while (rs.next()){
                idfilamenti.add(rs.getInt(1));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // release resources
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return idfilamenti;
    }


    //method selezione filamenti from DB
    public ArrayList<String> selectFilamentiFromDB(Float contrasto, Float minEllitticita, Float maxEllitticita) {
        openConnection();

        ArrayList<String> filamenti =new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String selectQuery = "SELECT * FROM filamento WHERE contrasto>=? AND ellitticita>=? AND ellitticita<=?";
        try {
            stmt = conn.prepareStatement(selectQuery);
            stmt.setFloat(1, contrasto);
            stmt.setFloat(2, minEllitticita);
            stmt.setFloat(3, maxEllitticita);
            rs = stmt.executeQuery();

            if (!rs.isBeforeFirst() ) {
                return null;
            }

            while (rs.next()){
                filamenti.add(rs.getString(1));
                filamenti.add(rs.getString(2));
                filamenti.add(rs.getString(3));
                filamenti.add(rs.getString(4));
                filamenti.add(rs.getString(5));
                filamenti.add(rs.getString(6));
                filamenti.add(rs.getString(7));
                filamenti.add(rs.getString(8));
                filamenti.add(rs.getString(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // release resources
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        closeConnection();
        return filamenti;
    }

}
