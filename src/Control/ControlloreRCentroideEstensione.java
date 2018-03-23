package Control;

import Bean.BeanFilamento;
import DAO.DAOContorno;

import java.util.ArrayList;

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

            float MinMaxLong = (float)(Math.hypot(Float.valueOf(val.get(2)), Float.valueOf(val.get(3))));
            float MinMaxLatg = (float)(Math.hypot(Float.valueOf(val.get(4)), Float.valueOf(val.get(5))));

            String distanceMinMaxLong = String.valueOf(MinMaxLong);
            String distanceMinMaxLatg = String.valueOf(MinMaxLatg);

            val.add(distanceMinMaxLong);
            val.add(distanceMinMaxLatg);
            System.out.println(val);
            return val;
        } else {
            return null;
        }
    }

}
