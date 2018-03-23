package Bean;

import Control.ControlloreInserimentoDati;

import java.util.ArrayList;


public class BeanAgenzia {

    private String nome;

    //getter and setter
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //method
    public ArrayList<String> selectAgenzie(){
        ArrayList<String> agenzie= ControlloreInserimentoDati.getInstance().selectAgenziaFromBean();
        if (agenzie!=null)
        return agenzie;
        else
            return null;
    }

}
