package Control;

import Bean.BeanUtente;
import Entity.Utente;

import java.util.ArrayList;

/**
 * Created by Manuel on 08/02/2018.
 */
public class ControlloreLogin {

    // Singleton
    private static ControlloreLogin instance;

    public static synchronized final ControlloreLogin getInstance() {
        if (instance == null)
            instance = new ControlloreLogin();
        return instance;
    }


    /*public Utente verifyLoginFromBean(BeanUtente beanUtente) {
        //ArrayList<String> risultato= DAO.method(beanUtente.get....)
    }*/
}
