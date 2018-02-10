package Bean;

import Control.ControlloreInserimentoDati;

import java.util.ArrayList;

/**
 * Created by Manuel on 10/02/2018.
 */
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
        return agenzie;
    }

}
