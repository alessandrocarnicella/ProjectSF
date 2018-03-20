package Control;

import Bean.BeanInserimentoCSV;
import DAO.*;
import Entity.*;
import com.sun.deploy.util.SyncAccess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

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

    //constructor
    protected ControlloreInserimentoCSV() {
    }

    // singleton
    public static synchronized final ControlloreInserimentoCSV getInstance() {
        if (instance == null)
            instance = new ControlloreInserimentoCSV();
        return instance;
    }

    //method
    public boolean inserisciDatiCSVFromBean(String nome, String path) {
        String controllo = nome.substring(0,7);
        System.out.println(controllo);
        String controllo2 = nome.substring(0,9);
        System.out.println(controllo2);
        String controllo3 = nome.substring(0,10);
        System.out.println(controllo3);
        if (controllo.equals("stelle_")) {
            return this.inserisciStelle(nome, path);
        } else if (controllo2.equals("contorni_")) {
            return this.inserisciContornoFilamento(nome, path);
        } else if (controllo3.equals("filamenti_")) {
            return this.inserisciFilamento(nome, path);
        } else if (controllo3.equals("scheletro_")) {
            return this.inserisciScheletroFilamento(nome, path);
        }  else {
            return false;
        }
    }

    //method
    private boolean inserisciContornoFilamento(String nome, String path) {
        BufferedReader br = null;
        String line = "";
        String split = ",";
        int num = 0;
        int count = 0;

        Contorno contorno = new Contorno();
        Punto punto = new Punto();

        Filamento filamento = new Filamento();

        DAOContorno = DAOContorno.getInstance();
        DAOPunto = DAOPunto.getInstance();
        DAOFilamento = DAOFilamento.getInstance();

        try {
            DAOPunto.openConnection();
            num = 0;
            count = 0;
            br = new BufferedReader(new FileReader(path + "/" + nome));
            stampaTempo();
            while ((line = br.readLine()) != null) {
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(split, -1)));
                if (num == 1) {
                    count++;

                    punto.setLonG(Float.valueOf(values.get(1)));
                    punto.setLatG(Float.valueOf(values.get(2)));

                    if ( !DAOPunto.findItemById(punto) ){
                        DAOPunto.insertPunto(punto);
                    }

                }else if(equalsColoumnsNamesContorno(values)){
                    num++;
                }
                if(count%10000 == 0) {
                    System.out.println(count);
                }
            }
            DAOPunto.closeConnection();
            stampaTempo();
            br.close();

            DAOFilamento.openConnection();
            num = 0;
            count = 0;
            br = new BufferedReader(new FileReader(path + "/" + nome));
            stampaTempo();
            while ((line = br.readLine()) != null) {
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(split, -1)));
                if (num == 1) {
                    count++;

                    filamento.setIdFilamento(Integer.valueOf(values.get(0)));
                    filamento.setNome(String.valueOf(""));
                    filamento.setFlussoTotale(Float.valueOf(0));
                    filamento.setDensitaMedia(Float.valueOf(0));
                    filamento.setTemperaturaMedia(Float.valueOf(0));
                    filamento.setEllitticita(Float.valueOf(0));
                    filamento.setContrasto(Float.valueOf(0));
                    filamento.setNomeSatellite(String.valueOf("Herschel"));
                    filamento.setNomeStrumento(String.valueOf("PACS"));

                    if ( !DAOFilamento.findItemById(filamento) ) {
                        DAOFilamento.insertFilamento(filamento);

                    }
                }else if(equalsColoumnsNamesContorno(values)){
                    num++;
                }
                if(count%10000 == 0) {
                    System.out.println(count);
                }
            }
            DAOFilamento.closeConnection();
            stampaTempo();
            br.close();


            DAOContorno.openConnection();
            num = 0;
            count = 0;
            br = new BufferedReader(new FileReader(path + "/" + nome));
            stampaTempo();
            while ((line = br.readLine()) != null) {
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(split, -1)));

                if (num == 1) {
                    count++;

                    contorno.setIdFilamento(Integer.valueOf(values.get(0)));
                    contorno.setLonG(Float.valueOf(values.get(1)));
                    contorno.setLatG(Float.valueOf(values.get(2)));

                    if ( !DAOContorno.findItemById(contorno) ) {
                        DAOContorno.insertContorno(contorno);
                    }

                }else if(equalsColoumnsNamesContorno(values)){
                    num++;
                }
                if(count%10000 == 0) {
                    System.out.println(count);
                }
            }
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
        DAOContorno.closeConnection();
        return true;
    }




    //method
    private boolean inserisciFilamento(String nome, String path) {
        BufferedReader br = null;
        String line = "";
        String split = ",";
        int num = 0;
        int count = 0;

        DAOFilamento = DAOFilamento.getInstance();
        Filamento filamento = new Filamento();
        stampaTempo();

        try {
            br = new BufferedReader(new FileReader(path + "/" + nome));
            DAOFilamento.openConnection();
            while ((line = br.readLine()) != null) {
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(split, -1)));
                if (num == 1) {
                    count++;
                    filamento.setIdFilamento(Integer.valueOf(values.get(0)));
                    filamento.setNome(values.get(1));
                    filamento.setFlussoTotale(Float.valueOf(values.get(2)));
                    filamento.setDensitaMedia(Float.valueOf(values.get(3)));
                    filamento.setTemperaturaMedia(Float.valueOf(values.get(4)));
                    filamento.setEllitticita(Float.valueOf(values.get(5)));
                    filamento.setContrasto(Float.valueOf(values.get(6)));
                    filamento.setNomeSatellite(values.get(7));
                    filamento.setNomeStrumento(values.get(8));

                    if ( !DAOFilamento.findItemById(filamento) ){
                        DAOFilamento.insertFilamento(filamento);

                    }else {
                        DAOFilamento.updateFilamento(filamento);
                    }
                }else if(equalsColoumnsNamesFilamento(values)){
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

    //method
    private boolean inserisciScheletroFilamento(String nome, String path) {
        BufferedReader br = null;
        String line = "";
        String split = ",";
        int num = 0;
        int count = 0;
        stampaTempo();

        Punto punto = new Punto();
        Segmento segmento = new Segmento();
        Scheletro scheletro = new Scheletro();
        Filamento filamento = new Filamento();

        DAOPunto = DAOPunto.getInstance();
        DAOSegmento = DAOSegmento.getInstance();
        DAOScheletro = DAOScheletro.getInstance();
        DAOFilamento = DAOFilamento.getInstance();

        try {
            br = new BufferedReader(new FileReader(path + "/" + nome));
            DAOPunto.openConnection();

            while ((line = br.readLine()) != null) {
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(split, -1)));
                if (num==1) {
                    count++;
                    punto.setLonG(Float.valueOf(values.get(3)));
                    punto.setLatG(Float.valueOf(values.get(4)));

                    if ( !DAOPunto.findItemById(punto) ){
                        DAOPunto.insertPunto(punto);
                    }

                }else if(equalsColoumnsNamesScheletro(values)){
                    num++;
                }
                if(count%10000 == 0) {
                    System.out.println(count);
                }
            }
            DAOPunto.closeConnection();
            stampaTempo();
            br.close();

            DAOFilamento.openConnection();
            num = 0;
            count = 0;
            br = new BufferedReader(new FileReader(path + "/" + nome));
            stampaTempo();
            while ((line = br.readLine()) != null) {
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(split, -1)));
                if (num == 1) {
                    count++;

                    filamento.setIdFilamento(Integer.valueOf(values.get(0)));
                    filamento.setNome(String.valueOf(" "));
                    filamento.setFlussoTotale(Float.valueOf(0));
                    filamento.setDensitaMedia(Float.valueOf(0));
                    filamento.setTemperaturaMedia(Float.valueOf(0));
                    filamento.setEllitticita(Float.valueOf(0));
                    filamento.setContrasto(Float.valueOf(0));
                    filamento.setNomeSatellite(String.valueOf("Herschel"));
                    filamento.setNomeStrumento(String.valueOf("PACS"));

                    if ( !DAOFilamento.findItemById(filamento) ) {
                        DAOFilamento.insertFilamento(filamento);

                    }
                }else if(equalsColoumnsNamesScheletro(values)){
                    num++;
                }
                if(count%10000 == 0) {
                    System.out.println(count);
                }
            }
            DAOFilamento.closeConnection();
            stampaTempo();
            br.close();

            DAOSegmento.openConnection();
            num = 0;
            count = 0;
            stampaTempo();
            br = new BufferedReader(new FileReader(path + "/" + nome));
            while ((line = br.readLine()) != null) {
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(split, -1)));
                if (num == 1) {
                    count++;
                    segmento.setIdFilamento(Integer.valueOf(values.get(0)));
                    segmento.setIdSegmento(Integer.valueOf(values.get(1)));

                    if ( !DAOSegmento.findItemById(segmento) ){
                        DAOSegmento.insertSegmento(segmento);
                    }
                }else if(equalsColoumnsNamesScheletro(values)){
                    num++;
                }
                if(count%10000 == 0) {
                    System.out.println(count);
                }
            }
            DAOSegmento.closeConnection();
            stampaTempo();
            br.close();

            DAOScheletro.openConnection();
            num = 0;
            count = 0;
            stampaTempo();
            br = new BufferedReader(new FileReader(path + "/" + nome));
            while ((line = br.readLine()) != null) {
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(split, -1)));
                if (num == 1) {
                    count++;
                    scheletro.setIdFilamento(Integer.valueOf(values.get(0)));
                    scheletro.setIdSegmento(Integer.valueOf(values.get(1)));
                    scheletro.setTipoRamo(values.get(2));
                    scheletro.setLonG(Float.valueOf(values.get(3)));
                    scheletro.setLatG(Float.valueOf(values.get(4)));
                    scheletro.setnProg(Integer.valueOf(values.get(5)));
                    scheletro.setFlussoMisurato(Double.valueOf(values.get(6)));

                    if ( !DAOScheletro.findItemById(scheletro) ){
                        DAOScheletro.insertScheletro(scheletro);
                    }else {
                        DAOScheletro.updateScheletro(scheletro);
                    }
                }else if(equalsColoumnsNamesScheletro(values)){
                    num++;
                }
                if(count%10000 == 0) {
                    System.out.println(count);
                }
            }
            DAOScheletro.closeConnection();
            stampaTempo();
            br.close();

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


    //method
    public boolean inserisciStelle(String nome, String path) {

        BufferedReader br = null;
        String line = "";
        String split = ",";
        int num = 0;
        int count = 0;

        Stella stella = new Stella();
        Punto punto = new Punto();

        DAOStella = DAOStelle.getInstance();
        DAOPunto = DAOPunto.getInstance();
        stampaTempo();

        try {
            br = new BufferedReader(new FileReader(path + "/" + nome));
            DAOPunto.openConnection();

            while ((line = br.readLine()) != null) {
                count++;
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(split, -1)));
                if(num==1) {
                    punto.setLonG(Float.valueOf(values.get(2)));
                    punto.setLatG(Float.valueOf(values.get(3)));

                    if ( !DAOPunto.findItemById(punto) ){
                        DAOPunto.insertPunto(punto);
                    }
                }else if(equalsColoumnsNamesStella(values)){
                    num++;
                }
                if(count%10000 == 0) {
                    System.out.println(count);
                }
            }
            stampaTempo();
            DAOPunto.closeConnection();
            br.close();

            num = 0;
            count = 0;
            br = new BufferedReader(new FileReader(path + "/" + nome));
            DAOStella.openConnection();

            while ((line = br.readLine()) != null) {
                count++;
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(split, -1)));
                if(num==1) {
                    stella.setIdStella(Integer.valueOf(values.get(0)));
                    stella.setNomeStella(values.get(1));
                    stella.setLonG(Float.valueOf(values.get(2)));
                    stella.setLatG(Float.valueOf(values.get(3)));
                    stella.setValoreFlusso(Float.valueOf(values.get(4)));
                    stella.setTipoStella(values.get(5));

                    if ( !DAOStella.findItemById(stella) ){
                        DAOStella.insertStella(stella);
                    }else {
                        DAOStella.updateStella(stella);
                    }
                }else if(equalsColoumnsNamesStella(values)){
                    num++;
                }
                if(count%10000 == 0) {
                    System.out.println(count);
                }
            }
            stampaTempo();
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

    //method
    public void stampaTempo(){
        System.out.println(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+":"
                +Calendar.getInstance().get(Calendar.MINUTE)+":"
                +Calendar.getInstance().get(Calendar.SECOND));
    }

    //method
    private boolean equalsColoumnsNamesContorno(ArrayList<String> values){
        if(values.get(0).equals("IDFIL")&&values.get(1).equals("GLON_CONT")
                &&values.get(2).equals("GLAT_CONT")) {
            return true;
        }
        return false;
    }

    //method
    private boolean equalsColoumnsNamesScheletro(ArrayList<String> values){
        if(values.get(0).equals("IDFIL")&&
                values.get(1).equals("IDBRANCH")&&
                values.get(2).equals("TYPE")&&
                values.get(3).equals("GLON_BR")&&
                values.get(4).equals("GLAT_BR")&&
                values.get(5).equals("N")&&
                values.get(6).equals("FLUX")){
            return true;
        }
        return false;
    }

    //method
    private boolean equalsColoumnsNamesStella(ArrayList<String> values){
        if(values.get(0).equals("IDSTAR")&&
                values.get(1).equals("NAMESTAR")&&
                values.get(2).equals("GLON_ST")&&
                values.get(3).equals("GLAT_ST")&&
                values.get(4).equals("FLUX_ST")&&
                values.get(5).equals("TYPE_ST")){
            return true;
        }
        return false;
    }

    //method
    private boolean equalsColoumnsNamesFilamento(ArrayList<String> values){
        if(values.get(0).equals("IDFIL")&&
                values.get(1).equals("NAME")&&
                values.get(2).equals("TOTAL_FLUX")&&
                values.get(3).equals("MEAN_DENS")&&
                values.get(4).equals("MEAN_TEMP")&&
                values.get(5).equals("ELLIPTICITY")&&
                values.get(6).equals("CONTRAST")&&
                values.get(7).equals("SATELLITE")&&
                values.get(8).equals("INSTRUMENT")) {
            return true;
        }
        return false;
    }
/*
    ///home/alessandro/Scrivania/ProgettoBasiDati/ProgettoDb_TestDati
    public static void main(String args[]){

        System.out.println("scheletro HER ");
        ControlloreInserimentoCSV.getInstance().inserisciDatiCSVFromBean("scheletro_filamenti_Herschel.csv", "/home/alessandro/Scrivania/ProgettoBasiDati/ProgettoDb_TestDati");

        System.out.println("filamenti HER");
        ControlloreInserimentoCSV.getInstance().inserisciDatiCSVFromBean("filamenti_Herschel.csv", "/home/alessandro/Scrivania/ProgettoBasiDati/ProgettoDb_TestDati");

        System.out.println("contorni HER");
        ControlloreInserimentoCSV.getInstance().inserisciDatiCSVFromBean("contorni_filamenti_Herschel.csv", "/home/alessandro/Scrivania/ProgettoBasiDati/ProgettoDb_TestDati");

        System.out.println("stelle");
        ControlloreInserimentoCSV.getInstance().inserisciDatiCSVFromBean("stelle_Herschel.csv", "/home/alessandro/Scrivania/ProgettoBasiDati/ProgettoDb_TestDati");

        System.out.println("contorni SPR");
        ControlloreInserimentoCSV.getInstance().inserisciDatiCSVFromBean("contorni_filamenti_Spitzer.csv", "/home/alessandro/Scrivania/ProgettoBasiDati/ProgettoDb_TestDati");

        System.out.println("scheletro HER ");
        ControlloreInserimentoCSV.getInstance().inserisciDatiCSVFromBean("scheletro_filamenti_Herschel.csv", "/home/alessandro/Scrivania/ProgettoBasiDati/ProgettoDb_TestDati");

        System.out.println("filamenti SPR");
        ControlloreInserimentoCSV.getInstance().inserisciDatiCSVFromBean("filamenti_Spitzer.csv", "/home/alessandro/Scrivania/ProgettoBasiDati/ProgettoDb_TestDati");

        System.out.println("scheletro SPR ");
        ControlloreInserimentoCSV.getInstance().inserisciDatiCSVFromBean("scheletro_filamenti_Spitzer.csv", "/home/alessandro/Scrivania/ProgettoBasiDati/ProgettoDb_TestDati");
    }
*/
}