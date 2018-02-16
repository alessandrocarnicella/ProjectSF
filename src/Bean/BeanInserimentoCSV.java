package Bean;

import Control.ControlloreInserimentoCSV;

/**
 * Created by Manuel on 14/02/2018.
 */
public class BeanInserimentoCSV {

    private String nome;
    private String path;

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

    public boolean inserisciDatiCSV(String nome, String path){
        boolean inserimento= ControlloreInserimentoCSV.getInstance().inserisciDatiCSVFromBean(nome,path);
        if (inserimento==true){
            return true;
        }
        return false;
    }

}
