package Bean;

import Control.ControlloreInserimentoDati;

/**
 * Created by Manuel on 14/02/2018.
 */
public class BeanMisurazione {

    private String nomeStrumento;
    private float banda;

    //getter and setter
    public String getNomeStrumento() {
        return nomeStrumento;
    }
    public void setNomeStrumento(String nomeStrumento) {
        this.nomeStrumento = nomeStrumento;
    }

    public float getBanda() {
        return banda;
    }
    public void setBanda(float banda) {
        this.banda = banda;
    }

    //method
    public boolean insertNewMisurazione(){
        boolean inserimento = ControlloreInserimentoDati.getInstance().insertNewMisurazioneFromBean(this);
        if (inserimento==true)
        return true;
        else
            return false;
    }
}
