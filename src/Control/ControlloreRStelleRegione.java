package Control;

import Bean.BeanPosBaseAltezza;
import DAO.DAOStelle;

import java.util.ArrayList;

/**
 * Created by Manuel on 07/03/2018.
 */
public class ControlloreRStelleRegione {

    // Singleton
    private static ControlloreRStelleRegione instance;

    public static synchronized final ControlloreRStelleRegione getInstance() {
        if (instance == null)
            instance = new ControlloreRStelleRegione();
        return instance;
    }


    //method
    public ArrayList<String> searchStarsByRegionFromBean(BeanPosBaseAltezza beanPosBaseAltezza){
        ArrayList<String> val= DAOStelle.getInstance().searchStarsByRegionFromDB(beanPosBaseAltezza);
        if(val!=null){
            return val;
        }
        else
            return null;

    }


    public static void main(String[] args){
        BeanPosBaseAltezza beanPosBaseAltezza=new BeanPosBaseAltezza();
        beanPosBaseAltezza.setAltezza((float)100);
        beanPosBaseAltezza.setBase((float)50);
        beanPosBaseAltezza.setLatG((float)0.0);
        beanPosBaseAltezza.setLonG((float) 0.0);
        System.out.println(ControlloreRStelleRegione.getInstance().searchStarsByRegionFromBean(beanPosBaseAltezza));
    }

}
