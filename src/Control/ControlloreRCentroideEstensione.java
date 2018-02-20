package Control;

import Bean.BeanContorno;
import Bean.BeanSegmento;
import DAO.DAOContorno;
import DAO.DAOSegmento;

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
    public ArrayList<String> selectIdFilFromContornoFromBean(){
        DAOContorno daoContorno=DAOContorno.getInstance();
        ArrayList<String> idFilamenti= daoContorno.selectIdFilFromContornoFromDB();
        if(idFilamenti!=null)
            return idFilamenti;
        else
            return null;
    }


    //method : torna un ArrayList<Float> con dentro la media di long e latg rispettivamente
    public ArrayList<Float> selectCentroidPositionFrombean(BeanContorno beanContorno){
        ArrayList<Float> centroidPosition= DAOContorno.getInstance().selectCentroidPositionFromDB(beanContorno);
        if(centroidPosition!=null) {
            return centroidPosition;
        }else
            return null;

    }


    //method : torna un ArrayList<Double> con in prima posizione l'estensione di long e in seconda quella di latg
    public  ArrayList<Double> selectEstensionPositionFromBean(BeanContorno beanContorno){
        ArrayList<Double> distances= new ArrayList<>();
        ArrayList<Float> arrayMinEMax = DAOContorno.getInstance().selectEstensionPositionFromDB(beanContorno);
        if(arrayMinEMax!=null) {
            Double distanceLong = Math.hypot(arrayMinEMax.get(0), arrayMinEMax.get(1));
            Double distanceLatg = Math.hypot(arrayMinEMax.get(2), arrayMinEMax.get(3));
            distances.add(distanceLong);
            distances.add(distanceLatg);
            return distances;
        }else
            return null;

    }


    //method
    public int selectSegmentsFromFilamentFromBean(BeanSegmento beanSegmento){
        int numSegments= DAOSegmento.getInstance().selectSegmentsFromFilamentFromDB(beanSegmento);
        if(numSegments!=0)
            return numSegments;
        else
            return 0;

    }





}
