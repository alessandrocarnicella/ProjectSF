package Bean;

import Control.ControlloreInserimentoDati;

/**
 * Created by Manuel on 14/02/2018.
 */
public class BeanBanda {

    private Double lunghezza;

    //getter and setter
    public Double getLunghezza() {
        return lunghezza;
    }
    public void setLunghezza(Double lunghezza) {
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
