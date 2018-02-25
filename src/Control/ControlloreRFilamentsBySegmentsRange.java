package Control;

import Bean.BeanSegmento;
import DAO.DAOSegmento;

import java.util.ArrayList;

/**
 * Created by Manuel on 25/02/2018.
 */
public class ControlloreRFilamentsBySegmentsRange {

    // Singleton
    private static ControlloreRFilamentsBySegmentsRange instance;

    public static synchronized final ControlloreRFilamentsBySegmentsRange getInstance() {
        if (instance == null)
            instance = new ControlloreRFilamentsBySegmentsRange();
        return instance;
    }

    //method
    public ArrayList<String> selectFilamentsBySegmentsNumberFromBean(int int1,int int2){

        DAOSegmento daoSegmento=DAOSegmento.getInstance();
        ArrayList<String> val=daoSegmento.selectFilamentsBySegmentsNumberFromDB(int1,int2);
        if (val!=null){
            return val;
        }else
            return null;
    }



    public static void main(String[] args){
        BeanSegmento beanSegmento=new BeanSegmento();
        ArrayList<String> val= beanSegmento.selectFilamentsBySegmentsNumber(0,3);
        System.out.println(val);
    }

}
