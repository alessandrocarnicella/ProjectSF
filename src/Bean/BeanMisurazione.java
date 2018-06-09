package Bean;

import Control.ControlloreInserimentoDati;


public class BeanMisurazione {

    private String nomeStrumento;
    private float banda;
    private String nomeSatellite;

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

    public void setNomeSatellite(String nomeSatellite) {
        this.nomeSatellite = nomeSatellite;
    }

    public String getNomeSatellite() {
        return nomeSatellite;
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
