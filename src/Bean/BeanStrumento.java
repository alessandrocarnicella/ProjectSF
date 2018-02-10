package Bean;

import Control.ControlloreInserimentoDati;

/**
 * Created by Manuel on 10/02/2018.
 */
public class BeanStrumento {

    private String nome;
    private String nomeSatellite;


    //getter and setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeSatellite() {
        return nomeSatellite;
    }

    public void setNomeSatellite(String nomeSatellite) {
        this.nomeSatellite = nomeSatellite;
    }


    //method
    public boolean insertNewStrumento(){
        boolean inserimento= ControlloreInserimentoDati.getInstance().insertNewStrumentoFromBean(this);
        if (inserimento==true){
            return true;
        }
        else
            return false;
    }




}
