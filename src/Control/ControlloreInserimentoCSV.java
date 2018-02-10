package Control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import DAO.*;
import Entity.Contorno;
import Entity.Filamento;
import Entity.Scheletro;
import Entity.Stella;

/**
 * Created by alessandro on 09/02/18.
 */

public class ControlloreInserimentoCSV {
    private static ControlloreInserimentoCSV instance;
    private DAOStelle DAOStella;
    private DAOContorno DAOContorno;
    private DAOFilamento DAOFilamento;
    private DAOScheletro DAOScheletro;
    // singleton
    public static synchronized final ControlloreInserimentoCSV getInstance() {
        if (instance == null)
            instance = new ControlloreInserimentoCSV();
        return instance;
    }

    protected ControlloreInserimentoCSV() {
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

        DAOContorno = DAOContorno.getInstance();

        try {
            br = new BufferedReader(new FileReader(path + "/" + nome));
            Contorno contorno = new Contorno();
            while ((line = br.readLine()) != null) {
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(split, -1)));
                contorno.setIdFilamento(Integer.valueOf(values.get(0)));
                contorno.setLonG(Double.valueOf(values.get(1)));
                contorno.setLatG(Double.valueOf(values.get(2)));

                DAOContorno.insertContorno(contorno);
            }
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

        DAOFilamento = DAOFilamento.getInstance();

        try {
            br = new BufferedReader(new FileReader(path + "/" + nome));
            Filamento filamento = new Filamento();
            while ((line = br.readLine()) != null) {
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(split, -1)));
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
            }
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

        DAOScheletro = DAOScheletro.getInstance();

        try {
            br = new BufferedReader(new FileReader(path + "/" + nome));
           Scheletro scheletro = new Scheletro();
            while ((line = br.readLine()) != null) {
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(split, -1)));
                scheletro.setIdFilamento(Integer.valueOf(values.get(0)));
                scheletro.setIdSegmento(Integer.valueOf(values.get(1)));
                scheletro.setTipoRamo(values.get(2).charAt(0));
                scheletro.setLonG(Double.valueOf(values.get(3)));
                scheletro.setLatG(Double.valueOf(values.get(4)));
                scheletro.setnProg(Integer.valueOf(values.get(5)));
                scheletro.setFlussoMisurato(Double.valueOf(values.get(6)));

                DAOScheletro.insertScheletro(scheletro);
            }
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

        DAOStella = DAOStelle.getInstance();

        try {
            br = new BufferedReader(new FileReader(path + "/" + nome));
            Stella stella = new Stella();
            while ((line = br.readLine()) != null) {
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(split, -1)));
                stella.setIdStella(Integer.valueOf(values.get(0)));
                stella.setNomeStella(values.get(1));
                stella.setLonG(Double.valueOf(values.get(2)));
                stella.setLatG(Double.valueOf(values.get(3)));
                stella.setValoreFlusso(Double.valueOf(values.get(4)));
                stella.setTipoStella(values.get(5));

                DAOStella.insertStella(stella);
            }
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
}