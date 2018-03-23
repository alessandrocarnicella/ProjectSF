package Control;

import Bean.BeanScheletro;
import DAO.DAOScheletro;

import java.util.ArrayList;

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
