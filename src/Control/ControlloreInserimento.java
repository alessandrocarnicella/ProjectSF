package Control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.function.DoubleUnaryOperator;

import Util.ConfigFile;
import DAO.DAOStelle;
import Entity.Stella;

/**
 * Created by alessandro on 09/02/18.
 */
public class ControlloreInserimento {
    private static ControlloreInserimento instance;
    private DAOStelle DAOS;

    // singleton
    public static synchronized final ControlloreInserimento getInstance() {
        if (instance == null)
            instance = new ControlloreInserimento();
        return instance;
    }

    protected ControlloreInserimento() {
    }

    public boolean inserisciDatiCSV(String nome, String path) {
        if (nome.equals("stelle_Herschel.csv")) {
            return this.inserisciStelle(nome, path);
        } else if(nome.equals("contorni_filamenti_Herschel.csv")) {
            return this.inserisciContornoFilamento(nome, path);
        }
        else
            return false;
    }

    private boolean inserisciContornoFilamento(String nome, String path) {

    }

    public boolean inserisciStelle(String nome, String path) {

        BufferedReader br = null;
        String line = "";
        String split = ",";

        DAOS = DAOStelle.getInstance();

        try {
            br = new BufferedReader(new FileReader(path + "/" + nome));
            Stella stella = new Stella();
            while ((line = br.readLine()) != null) {
                ArrayList<String> values =new ArrayList<>(Arrays.asList(line.split(split,-1)));
                    stella.setIdStella(Integer.valueOf(values.get(0)));
                    stella.setNomeStella(values.get(1));
                    stella.setLonG(Double.valueOf(values.get(2)));
                    stella.setLatG(Double.valueOf(values.get(3)));
                    stella.setValoreFlusso(Double.valueOf(values.get(4)));
                    stella.setTipoStella(values.get(5));

                DAOS.insertStella(stella);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}