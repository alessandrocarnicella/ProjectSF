package Bean;

import Control.ControlloreInserimentoDati;

public class BeanBanda {

    private float lunghezza;

    //getter and setter
    public float getLunghezza() {
        return lunghezza;
    }
    public void setLunghezza(float lunghezza) {
        this.lunghezza = lunghezza;
    }

    //method
    public boolean insertNewBanda(){
        boolean inserimento= ControlloreInserimentoDati.getInstance().insertNewBandaFromBean(this);
        if (inserimento==true)
            return true;
        else
            return false;
    }

}
