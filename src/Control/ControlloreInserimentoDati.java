package Control;

import Bean.*;
import DAO.*;

import java.util.ArrayList;

/**
 * Created by Manuel on 10/02/2018.
 */
public class ControlloreInserimentoDati {

    // Singleton
    private static ControlloreInserimentoDati instance;

    public static synchronized final ControlloreInserimentoDati getInstance() {
        if (instance == null)
            instance = new ControlloreInserimentoDati();
        return instance;
    }


    //method
    public boolean insertNewUserFromBean(BeanRegistrazione beanRegistrazione){

        DAOUtente daoUtente = DAOUtente.getInstance();
        boolean inserimento = daoUtente.insertNewUtenteInDB(beanRegistrazione);
        if (inserimento == true)
            return true;
        else
            return false;
    }


    //method
    public boolean insertNewSatelliteFromBean(BeanSatellite beanSatellite){

        DAOSatellite daoSatellite = DAOSatellite.getInstance();
        boolean inserimento = daoSatellite.insertNewSatelliteInDB(beanSatellite);
        if (inserimento == true)
            return true;
        else
            return false;
    }


    //method
    public boolean insertNewStrumentoFromBean(BeanStrumento beanStrumento){
        DAOStrumento daoStrumento = DAOStrumento.getInstance();
        boolean inserimento = daoStrumento.insertNewStrumentoInDB(beanStrumento);
        if (inserimento == true)
            return true;
        else
            return false;
    }

    //method
    public boolean insertNewBandaFromBean(BeanBanda beanBanda){
        DAOBanda daoBanda = DAOBanda.getInstance();
        boolean inserimento = true;

        if ( !daoBanda.findItemById(beanBanda) ) {
            inserimento = daoBanda.insertNewBandaInDB(beanBanda);
        }
        if (inserimento == true)
            return true;
        else
            return false;
    }


    //method
    public boolean insertNewMisurazioneFromBean(BeanMisurazione beanMisurazione){
        DAOMisurazione daoMisurazione= DAOMisurazione.getInstance();
        boolean inserimento=daoMisurazione.insertNewMisurazioneInDB(beanMisurazione);
        if (inserimento==true)
            return true;
        else
            return false;
    }


    //method
    public ArrayList<String> selectSatellitiFromBean(){
        DAOSatellite daoSatellite=DAOSatellite.getInstance();
        ArrayList<String> satelliti= daoSatellite.selectSatellitiFromDB();
        if (satelliti!= null)
            return satelliti;
        else
            return null;
    }


    //method
    public ArrayList<String> selectAgenziaFromBean(){
        DAOAgenzia daoAgenzia=DAOAgenzia.getInstance();
        ArrayList<String> agenzie= daoAgenzia.selectAgenziaFromDB();
        if(agenzie!=null)
        return agenzie;
        else
            return null;
    }
}
