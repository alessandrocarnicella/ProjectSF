package Control;

import Bean.BeanFilamento;
import DAO.DAOContorno;

import java.util.ArrayList;

/**
 * Created by Manuel on 19/02/2018.
 */
public class ControlloreRCentroideEstensione {

    // Singleton
    private static ControlloreRCentroideEstensione instance;

    public static synchronized final ControlloreRCentroideEstensione getInstance() {
        if (instance == null)
            instance = new ControlloreRCentroideEstensione();
        return instance;
    }


    //method
    public ArrayList<String> selectForIdOrNameFilCentroidExtensionFromBean(BeanFilamento beanFilamento){
        DAOContorno daoContorno = DAOContorno.getInstance();
        ArrayList<String> val = daoContorno.selectForIdOrNameFilCentroidExtensionFromDB(beanFilamento);
        if(val.get(0)!= null) {
            String distanceMinMaxLong = String.valueOf(Math.hypot(Double.valueOf(val.get(2)), Double.valueOf(val.get(3))));
            String distanceMinMaxLatg = String.valueOf(Math.hypot(Double.valueOf(val.get(4)), Double.valueOf(val.get(5))));
            val.add(distanceMinMaxLong);
            val.add(distanceMinMaxLatg);
            return val;
        } else {
            return null;
        }
    }
}
