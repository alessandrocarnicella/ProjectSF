package Control;

import Bean.*;
import DAO.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


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
        if(daoUtente.userAlreadyInserted(beanRegistrazione)){
            return false;
        }else {
            return daoUtente.insertNewUtenteInDB(beanRegistrazione);
        }
    }


    //method
    public boolean insertNewSatelliteFromBean(BeanSatellite beanSatellite){

        DAOSatellite daoSatellite = DAOSatellite.getInstance();
        if (daoSatellite.satelliteAlreadyInserted(beanSatellite)){
            return false;
        }else{
            if(beanSatellite.getMissioneTerminata()) {
                System.out.println("in true");
                float durata = ricavaDurata(beanSatellite.getDataInizio(),beanSatellite.getDataFine());
                beanSatellite.setDurata(durata);
                return daoSatellite.insertNewSatelliteInDB(beanSatellite);
            }else{
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                java.util.Date javaDate = null;
                try {
                    javaDate = sdf.parse("0000/01/01");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                java.sql.Date dataFine = new java.sql.Date(javaDate.getTime());
                beanSatellite.setDataFine(dataFine);
                beanSatellite.setDurata(0);
                return daoSatellite.insertNewSatelliteInDB(beanSatellite);
            }
        }
    }

    public float ricavaDurata(Date inizio, Date fine){
        float differenza = fine.getTime() - inizio.getTime();
        float days =Float.valueOf((float) Math.ceil(Double.valueOf(differenza/(1000*60*60*24))));
        System.out.println("differenza: "+differenza);
        System.out.println("time fine : "+fine.getTime());
        System.out.println("time inizio: "+inizio.getTime());
        return days;
    }

    //method
    public boolean insertNewStrumentoFromBean(BeanStrumento beanStrumento){
        DAOStrumento daoStrumento = DAOStrumento.getInstance();
        if(daoStrumento.strumentAlreadyInserted(beanStrumento)){
            return false;
        }else {
            return daoStrumento.insertNewStrumentoInDB(beanStrumento);
        }
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

