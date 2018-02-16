package Bean;

import Control.ControlloreInserimentoDati;
import Control.ControlloreLogin;

/**
 * Created by alessandro on 15/02/18.
 */
public class BeanRegistrazione {

    private String nomeRegistrazione;
    private String cognomeRegistrazione;
    private String usernameRegistrazione;
    private String passwordRegistrazione;
    private String emailRegistrazione;
    private String tipoUtenteRegistrazione;
    private boolean utenteRegistrazione;


    //getter and setter
    public String getNome() {
        return nomeRegistrazione;
    }

    public void setNome(String nome) {
        this.nomeRegistrazione = nome;
    }

    public String getCognome() {
        return cognomeRegistrazione;
    }

    public void setCognome(String cognome) {
        this.cognomeRegistrazione = cognome;
    }

    public String getUsername() {
        return usernameRegistrazione;
    }

    public void setUsername(String username) {
        this.usernameRegistrazione = username;
    }

    public String getPassword() {
        return passwordRegistrazione;
    }

    public void setPassword(String password) {
        this.passwordRegistrazione = password;
    }

    public String getEmail() {
        return emailRegistrazione;
    }

    public void setEmail(String email) {
        this.emailRegistrazione = email;
    }

    public String getTipoUtente() {
        return tipoUtenteRegistrazione;
    }

    public void setTipoUtente(String tipoUtente) {
        this.tipoUtenteRegistrazione = tipoUtente;
    }

    public boolean getUtente() {
        return utenteRegistrazione;
    }

    public void setUtente(boolean utente) {
        this.utenteRegistrazione = utente;
    }

    //method
    public boolean insertNewUtente(){
        boolean inserimento= ControlloreInserimentoDati.getInstance().insertNewUserFromBean(this);
        if (inserimento==true){
            return true;
        }
        else
            return false;
    }

}
