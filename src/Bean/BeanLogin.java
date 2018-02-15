package Bean;

import Control.ControlloreInserimentoDati;
import Control.ControlloreLogin;
import Entity.Utente;

/**
 * Created by Manuel on 08/02/2018.
 */
public class BeanLogin {

    private String nome;
    private String cognome;
    private String username;
    private String password;
    private String email;
    private String tipoUtente;
    private boolean utente;


    //getter and setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoUtente() {
        return tipoUtente;
    }

    public void setTipoUtente(String tipoUtente) {
        this.tipoUtente = tipoUtente;
    }

    public boolean getUtente() {
        return utente;
    }

    public void setUtente(boolean utente) {
        this.utente = utente;
    }

    //method
    public boolean verifyLogin(){
        this.utente=ControlloreLogin.getInstance().verifyLoginFromBean(this);
        if (utente==true)
            return true;
        else
            return false;

    }

}
