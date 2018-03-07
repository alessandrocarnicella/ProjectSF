package Bean;

import Control.ControlloreInserimentoDati;

/**
 * Created by Manuel on 14/02/2018.
 */
public class BeanMisurazione {

    private String nomeStrumento;
    private double banda;

    //getter and setter
    public String getNomeStrumento() {
        return nomeStrumento;
    }
    public void setNomeStrumento(String nomeStrumento) {
        this.nomeStrumento = nomeStrumento;
    }

    public double getBanda() {
        return banda;
    }
    public void setBanda(double banda) {
        this.banda = banda;
    }

    //method
    public boolean insertNewMisurazione(){
        boolean inserimento= ControlloreInserimentoDati.getInstance().insertNewMisurazioneFromBean(this);
        if (inserimento==true)
        return true;
        else
            return false;
    }
}
