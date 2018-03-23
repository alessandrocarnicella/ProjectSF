package Bean;

import Control.ControlloreInserimentoDati;


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
