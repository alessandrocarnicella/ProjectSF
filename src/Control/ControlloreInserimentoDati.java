package Control;

import Bean.BeanUtente;
import DAO.DAOUtente;

/**
 * Created by Manuel on 10/02/2018.
 */
public class ControlloreInserimentoDati {

    // Singleton
    private static ControlloreInserimentoDati instance;

    public static synchronized final ControlloreInserimentoDati getInstance() {
        if (instance == null)
            instance = new ControlloreInserimentoDati();
        return instance;
    }


    public boolean insertNewUserFromBean(BeanUtente beanUtente){

        DAOUtente daoUtente= DAOUtente.getInstance();
        boolean inserimento= daoUtente.insertNewUtenteInDB(beanUtente);
        if (inserimento==true)
            return true;
        else
            return false;


    }




}
