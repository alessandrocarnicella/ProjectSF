package Control;

import Bean.*;
import DAO.DAOAgenzia;
import DAO.DAOFilamento;
import DAO.DAOScheletro;
import Entity.Filamento;
import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;

/**
 * Created by alessandro on 19/02/18.
 */
public class ControlloreRDistanza{
    private static ControlloreRDistanza instance;

    //constructor
    protected ControlloreRDistanza() {
    }

    // singleton
    public static synchronized final ControlloreRDistanza getInstance() {
        if (instance == null)
            instance = new ControlloreRDistanza();
        return instance;
    }


    //method
    public ArrayList<String> selectDistanceFromBean(BeanScheletro beanBS){
        DAOScheletro daoScheletro = DAOScheletro.getInstance();
        ArrayList<String> val = daoScheletro.selectDistanceFromDB(beanBS);
        if(val != null) {
            return val;
        } else{
            return null;
        }
    }
}
