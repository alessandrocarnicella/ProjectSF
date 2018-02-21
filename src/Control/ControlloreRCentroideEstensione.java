package Control;

import Bean.BeanContorno;
import Bean.BeanFilamento;
import Bean.BeanSegmento;
import DAO.DAOContorno;
import DAO.DAOSegmento;

import java.util.ArrayList;
import java.util.Arrays;

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
    public ArrayList<String> selectForIdOrNameFilCentroidEstensionFromBean(BeanFilamento beanFilamento){
        DAOContorno daoContorno=DAOContorno.getInstance();
        ArrayList<String> val= daoContorno.selectForIdOrNameFilCentroidEstensionFromDB( beanFilamento);
        if(val!=null)
            return val;
        else
            return null;
    }



    public static void main(String[] args){

      BeanFilamento beanFilamento=new BeanFilamento();
      beanFilamento.setIdFilamento(52);
      String string= new String("HiGALFil013.8059-1.2194");
      beanFilamento.setNome(string);
      ArrayList<String> val=beanFilamento.selectForIdOrNameFilCentroidEstension();
      System.out.println(val);

    }


}
