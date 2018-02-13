package Control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import DAO.*;
import Entity.*;

/**
 * Created by alessandro on 09/02/18.
 */

public class ControlloreInserimentoCSV {

    private static ControlloreInserimentoCSV instance;
    private DAOStelle DAOStella;
    private DAOPunto DAOPunto;
    private DAOContorno DAOContorno;
    private DAOFilamento DAOFilamento;
    private DAOScheletro DAOScheletro;
    private DAO.DAOSegmento DAOSegmento;
    protected ControlloreInserimentoCSV() {
    }

    // singleton
    public static synchronized final ControlloreInserimentoCSV getInstance() {
        if (instance == null)
            instance = new ControlloreInserimentoCSV();
        return instance;
    }

    public boolean inserisciDatiCSV(String nome, String path) {
        if (nome.equals("stelle_Herschel.csv")) {
            return this.inserisciStelle(nome, path);
        } else if (nome.equals("contorni_filamenti_Herschel.csv")) {
            return this.inserisciContornoFilamento(nome, path);
        } else if (nome.equals("contorni_filamenti_Spitzer.csv")) {
            return this.inserisciContornoFilamento(nome, path);
        } else if (nome.equals("filamenti_Herschel.csv")) {
            return this.inserisciFilamento(nome, path);
        } else if (nome.equals("filamenti_Spitzer.csv")) {
            return this.inserisciFilamento(nome, path);
        } else if (nome.equals("scheletro_filamenti_Herschel.csv")) {
            return this.inserisciScheletroFilamento(nome, path);
        } else if (nome.equals("scheletro_filamenti_Spitzer.csv")) {
            return this.inserisciScheletroFilamento(nome, path);
        } else
            return false;
    }

    private boolean inserisciContornoFilamento(String nome, String path) {
        BufferedReader br = null;
        String line = "";
        String split = ",";
        int num = 0;
        int count = 0;
        DAOContorno = DAOContorno.getInstance();
        DAOPunto = DAOPunto.getInstance();
        DAOFilamento = DAOFilamento.getInstance();
        try {
            br = new BufferedReader(new FileReader(path + "/" + nome));
            Contorno contorno = new Contorno();
            Punto punto = new Punto();
            Filamento filamento = new Filamento();

            stampaTempo();
            DAOPunto.openConnection();
            DAOContorno.openConnection();
            DAOFilamento.openConnection();

            while ((line = br.readLine()) != null) {
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(split, -1)));

                if (num == 1) {
                    count++;

                    contorno.setIdFilamento(Integer.valueOf(values.get(0)));
                    contorno.setLonG(Float.valueOf(values.get(1)));
                    contorno.setLatG(Float.valueOf(values.get(2)));


                    punto.setLonG(Float.valueOf(values.get(1)));
                    punto.setLatG(Float.valueOf(values.get(2)));

                    filamento.setIdFilamento(Integer.valueOf(values.get(0)));

                    filamento.setNome(null);
                    filamento.setFlussoTotale(0.0);
                    filamento.setDensitaMedia(0.0);
                    filamento.setTemperaturaMedia(0.0);
                    filamento.setEllitticita(0.0);
                    filamento.setContrasto(0.0);
                    filamento.setNomeSatellite(null);
                    filamento.setNomeStrumento(null);

                   if ( !DAOFilamento.findItemById(filamento) ){
                        DAOFilamento.insertFilamento(filamento);
                    }

                    if ( !DAOPunto.findItemById(punto) ){
                        DAOPunto.insertPunto(punto);
                    }
                    if ( !DAOContorno.findItemById(contorno) ) {
                        DAOContorno.insertContorno(contorno);
                    }

                }else if(values.get(0).equals("IDFIL")&&values.get(1).equals("GLON_CONT")
                        &&values.get(2).equals("GLAT_CONT")){
                    num++;
                }
                if(count%1000 == 0) {
                    System.out.println(count);
                }
            }
            DAOPunto.closeConnection();
            DAOFilamento.closeConnection();
            DAOContorno.closeConnection();

            stampaTempo();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    private boolean inserisciFilamento(String nome, String path) {
        BufferedReader br = null;
        String line = "";
        String split = ",";
        int num = 0;
        int count = 0;
        DAOFilamento = DAOFilamento.getInstance();

        try {
            br = new BufferedReader(new FileReader(path + "/" + nome));
            Filamento filamento = new Filamento();
            stampaTempo();

            DAOFilamento.openConnection();

            while ((line = br.readLine()) != null) {
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(split, -1)));
                if (num == 1) {
                    count++;
                    filamento.setIdFilamento(Integer.valueOf(values.get(0)));
                    filamento.setNome(values.get(1));
                    filamento.setFlussoTotale(Double.valueOf(values.get(2)));
                    filamento.setDensitaMedia(Double.valueOf(values.get(3)));
                    filamento.setTemperaturaMedia(Double.valueOf(values.get(4)));
                    filamento.setEllitticita(Double.valueOf(values.get(5)));
                    filamento.setContrasto(Double.valueOf(values.get(6)));
                    filamento.setNomeSatellite(values.get(7));
                    filamento.setNomeStrumento(values.get(8));

                    DAOFilamento.insertFilamento(filamento);

                }else if(values.get(0).equals("IDFIL")&&
                        values.get(1).equals("NAME")&&
                        values.get(2).equals("TOTAL_FLUX")&&
                        values.get(3).equals("MEAN_DENS")&&
                        values.get(4).equals("MEAN_TEMP")&&
                        values.get(5).equals("ELLIPTICITY")&&
                        values.get(6).equals("CONTRAST")&&
                        values.get(7).equals("SATELLITE")&&
                        values.get(8).equals("INSTRUMENT")){
                    num++;
                }
                if(count%1000 == 0) {
                    System.out.println(count);
                }
            }
            stampaTempo();

            DAOFilamento.closeConnection();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    private boolean inserisciScheletroFilamento(String nome, String path) {
        BufferedReader br = null;
        String line = "";
        String split = ",";
        int num = 0;
        int count = 0;
        stampaTempo();

        DAOScheletro = DAOScheletro.getInstance();
        DAOPunto = DAOPunto.getInstance();
        DAOSegmento = DAOSegmento.getInstance();

        try {
            br = new BufferedReader(new FileReader(path + "/" + nome));
            Scheletro scheletro = new Scheletro();
            Segmento segmento = new Segmento();
            Punto punto = new Punto();
            DAOPunto.openConnection();
            DAOSegmento.openConnection();
            DAOScheletro.openConnection();
            while ((line = br.readLine()) != null) {
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(split, -1)));
                if (num==1) {
                    count++;
                    scheletro.setIdFilamento(Integer.valueOf(values.get(0)));
                    scheletro.setIdSegmento(Integer.valueOf(values.get(1)));
                    scheletro.setTipoRamo(values.get(2));
                    scheletro.setLonG(Double.valueOf(values.get(3)));
                    scheletro.setLatG(Double.valueOf(values.get(4)));
                    scheletro.setnProg(Integer.valueOf(values.get(5)));
                    scheletro.setFlussoMisurato(Double.valueOf(values.get(6)));

                    segmento.setIdFilamento(Integer.valueOf(values.get(0)));
                    segmento.setIdSegmento(Integer.valueOf(values.get(1)));

                    punto.setLonG(Float.valueOf(values.get(3)));
                    punto.setLatG(Float.valueOf(values.get(4)));

                    DAOPunto.insertPunto(punto);
                    DAOSegmento.insertSegmento(segmento);
                    DAOScheletro.insertScheletro(scheletro);

                }else if(values.get(0).equals("IDFIL")&&
                        values.get(1).equals("IDBRANCH")&&
                        values.get(2).equals("TYPE")&&
                        values.get(3).equals("GLON_BR")&&
                        values.get(4).equals("GLAT_BR")&&
                        values.get(5).equals("N")&&
                        values.get(6).equals("FLUX")){
                    num++;
                }
                if(count%1000 == 0) {
                    System.out.println(count);
                }
            }
            DAOPunto.closeConnection();
            DAOSegmento.closeConnection();
            DAOScheletro.closeConnection();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return true;
    }

    public boolean inserisciStelle(String nome, String path) {

        BufferedReader br = null;
        String line = "";
        String split = ",";
        int num = 0;
        int count = 0;
        DAOStella = DAOStelle.getInstance();
    //    DAOPunto = DAOPunto.getInstance();

        try {
            br = new BufferedReader(new FileReader(path + "/" + nome));
            Stella stella = new Stella();
  //          Punto punto = new Punto();
            stampaTempo();
            DAOStella.openConnection();
//            DAOPunto.openConnection();
            while ((line = br.readLine()) != null) {
                count++;
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(split, -1)));
                if(num==1) {
                    stella.setIdStella(Integer.valueOf(values.get(0)));
                    stella.setNomeStella(values.get(1));
                    stella.setLonG(Double.valueOf(values.get(2)));
                    stella.setLatG(Double.valueOf(values.get(3)));
                    stella.setValoreFlusso(Double.valueOf(values.get(4)));
                    stella.setTipoStella(values.get(5));

                 //   punto.setLonG(Double.valueOf(values.get(2)));
               //     punto.setLatG(Double.valueOf(values.get(3)));

             //       DAOPunto.insertPunto(punto);
                    DAOStella.insertStella(stella);
                }else if(values.get(0).equals("IDSTAR")&&
                        values.get(1).equals("NAMESTAR")&&
                        values.get(2).equals("GLON_ST")&&
                        values.get(3).equals("GLAT_ST")&&
                        values.get(4).equals("FLUX_ST")&&
                        values.get(5).equals("TYPE_ST")){
                    num++;
                }
                if(count%1000 == 0) {
                    System.out.println(count);
                }
            }
            stampaTempo();
           // DAOPunto.closeConnection();
            DAOStella.closeConnection();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    public void stampaTempo(){
        System.out.println(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+":"
                +Calendar.getInstance().get(Calendar.MINUTE)+":"
                +Calendar.getInstance().get(Calendar.SECOND));
    }

    public static void main(String args[]){
        ControlloreInserimentoCSV.getInstance().inserisciDatiCSV("filamenti_Herschel.csv","/home/alessandro/Scrivania/ProgettoBasiDati/ProgettoDb_TestDati");
        //ControlloreInserimentoCSV.getInstance().inserisciDatiCSV("scheletro_filamenti_Herschel.csv","/home/alessandro/Scrivania/ProgettoBasiDati/ProgettoDb_TestDati");
        //ControlloreInserimentoCSV.getInstance().inserisciDatiCSV("stelle_Herschel.csv","/home/alessandro/Scrivania/ProgettoBasiDati/ProgettoDb_TestDati");
        ControlloreInserimentoCSV.getInstance().inserisciDatiCSV("contorni_filamenti_Herschel.csv","/home/alessandro/Scrivania/ProgettoBasiDati/ProgettoDb_TestDati");

    }
}