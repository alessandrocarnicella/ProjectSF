package Bean;

import Control.ControlloreInserimentoCSV;

public class BeanInserimentoCSV {

    private String nome;
    private String path;
    private boolean errore = false;

    //getter and setter
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public boolean getErrore() {
        return errore;
    }
    public void setErrore(boolean errore) {
        this.errore = errore;
    }


    //method
    public boolean inserisciDatiCSV(String nome, String path) {
        boolean inserimento = ControlloreInserimentoCSV.getInstance().inserisciDatiCSVFromBean(nome, path);
        if (inserimento == true) {
            return true;
        }

        return false;
    }

}
