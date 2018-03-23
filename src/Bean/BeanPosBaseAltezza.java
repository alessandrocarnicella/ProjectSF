package Bean;

import Control.ControlloreRStelleRegione;

import java.util.ArrayList;


public class BeanPosBaseAltezza {

    private Float lonG;
    private Float latG;
    private Float base;
    private Float altezza;

    //getter and setter
    public Float getLonG() {
        return lonG;
    }
    public void setLonG(Float lonG) {
        this.lonG = lonG;
    }

    public Float getLatG() {
        return latG;
    }
    public void setLatG(Float latG) {
        this.latG = latG;
    }

    public Float getBase() {
        return base;
    }
    public void setBase(Float base) {
        this.base = base;
    }

    public Float getAltezza() {
        return altezza;
    }
    public void setAltezza(Float altezza) {
        this.altezza = altezza;
    }


    //method
    public ArrayList<String> searchStarsByRegion(){
        ArrayList<String> val= ControlloreRStelleRegione.getInstance().searchStarsByRegionFromBean(this);
        if(val!=null){
            return val;
        }else
            return null;
    }

}
