package Control;

import Bean.BeanLogin;
import DAO.DAOLogin;
import Entity.Utente;

import java.sql.SQLException;
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

    //method
    public boolean verifyLoginFromBean(BeanLogin beanLogin) {
        DAOLogin d = DAOLogin.getInstance();
        try {
            ArrayList<String> risultato = d.findUtente(beanLogin.getUsername());
            if (risultato != null ) {
                if(beanLogin.getPassword().equals(risultato.get(3))) {
                    Utente utente = new Utente(risultato.get(0), risultato.get(1), risultato.get(2), risultato.get(3), risultato.get(4), risultato.get(5));
                    beanLogin.setNome(utente.getNome());
                    beanLogin.setCognome(utente.getCognome());
                    beanLogin.setEmail(utente.getEmail());
                    beanLogin.setTipoUtente(utente.getTipoUtente());
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
