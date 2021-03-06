package DAO;

import Bean.BeanScheletro;
import Entity.Scheletro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAOScheletro {

    private DataSource DataSource;
    private static DAOScheletro instance;
    private Connection conn = null;
    private PreparedStatement stmt = null;

    //constructor
    protected DAOScheletro() {
        this.DataSource = new DataSource();
    }

    //singleton
    public synchronized static DAOScheletro getInstance() {
        if (DAOScheletro.instance == null)
            DAOScheletro.instance = new DAOScheletro();
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


    //method inserimento schelero in DB
    public void insertScheletro(Scheletro scheletro) {

        String insertQuery = "INSERT INTO scheletro(idfilamento,idsegmento,tiporamo,long,latg,nprog,flussomisurato) VALUES (?,?,?,?,?,?,?)";
        try {
            stmt = conn.prepareStatement(insertQuery);
            stmt.setInt(1, scheletro.getIdFilamento());
            stmt.setInt(2, scheletro.getIdSegmento());
            stmt.setString(3, scheletro.getTipoRamo());
            stmt.setDouble(4, scheletro.getLonG());
            stmt.setDouble(5, scheletro.getLatG());
            stmt.setInt(6, scheletro.getnProg());
            stmt.setFloat(7, scheletro.getFlussoMisurato());
            stmt.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
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


    //method ricerca presenza scheletro from DB
    public boolean findItemById(Scheletro scheletro) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String selectQuery = "SELECT idfilamento,idsegmento, long,latg FROM public.scheletro WHERE idfilamento=? AND idsegmento=? " +
                "AND long=? AND latg=? ";

        try {
            stmt = conn.prepareStatement(selectQuery);

            stmt.setInt(1, scheletro.getIdFilamento());
            stmt.setInt(2, scheletro.getIdSegmento());
            stmt.setFloat(3, scheletro.getLonG());
            stmt.setFloat(4, scheletro.getLatG());

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


    //method aggiornamento scheleyro in DB
    public void updateScheletro(Scheletro scheletro) {

        PreparedStatement stmt = null;

        String insertQuery ="UPDATE public.scheletro SET  tiporamo=?, nprog=?, flussomisurato=? WHERE idfilamento=? AND idsegmento=? AND long=? AND latg=?";
        try {
            stmt = conn.prepareStatement(insertQuery);
            stmt.setString(1, scheletro.getTipoRamo());
            stmt.setInt(2, scheletro.getnProg());
            stmt.setFloat(3, scheletro.getFlussoMisurato());
            stmt.setInt(4, scheletro.getIdFilamento());
            stmt.setInt(5, scheletro.getIdSegmento());
            stmt.setFloat(6, scheletro.getLonG());
            stmt.setFloat(7, scheletro.getLatG());
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


    //method selezione vertici e punti con distanza minima from DB
    public ArrayList<String> selectDistanceFromDB(BeanScheletro beanBS) {

        ArrayList<String> val = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs=null;

        String selectQuery = "SELECT DISTINCT s1.idfilamento, idsegmento,nprog, s1.latg, s1.long, c1.latg, c1.long\n" +
                "FROM scheletro as s1 JOIN contorno as c1 on s1.idfilamento=c1.idfilamento\n" +
                "WHERE s1.idsegmento = ?\n" +
                "      AND sqrt((s1.latg - c1.latg) ^ 2 + (s1.long - c1.long) ^ 2)\n" +
                "          =\n" +
                "          (SELECT min(sqrt((s1.latg - contorno.latg) ^ 2 + (s1.long -contorno.long) ^ 2))\n" +
                "          FROM contorno\n" +
                "          WHERE idfilamento = c1.idfilamento\n" +
                ") AND (nprog = (SELECT max(nprog)\n" +
                "                FROM scheletro\n" +
                "                WHERE idsegmento = ? AND scheletro.idfilamento=c1.idfilamento\n" +
                "                GROUP BY idsegmento)\n" +
                "       OR nprog = 1)ORDER BY idfilamento;";

        try {

            openConnection();
            stmt = conn.prepareStatement(selectQuery);

            stmt.setFloat(1,beanBS.getIdSegmento());
            stmt.setFloat(2,beanBS.getIdSegmento());
            rs = stmt.executeQuery();

            if (!rs.isBeforeFirst() ) {
                return null;
            }

            while (rs.next()){
                val.add(rs.getString(1));
                val.add(rs.getString(2));
                val.add(rs.getString(3));
                val.add(rs.getString(4));
                val.add(rs.getString(5));
                val.add(rs.getString(6));
                val.add(rs.getString(7));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
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
