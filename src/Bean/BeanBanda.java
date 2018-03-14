package Bean;

import Control.ControlloreInserimentoDati;

/**
 * Created by Manuel on 14/02/2018.
 */
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
