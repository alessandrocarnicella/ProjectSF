package Bean;

import Control.ControlloreRCentroideEstensione;

import java.util.ArrayList;

/**
 * Created by Manuel on 19/02/2018.
 */
public class BeanContorno {

    private int idFilamento;
    private Float lonG;
    private Float latG;


    //getter and setter
    public int getIdFilamento() {
        return idFilamento;
    }

    public void setIdFilamento(int idFilamento) {
        this.idFilamento = idFilamento;
    }

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


    //method
    public ArrayList<String> selectIdFilFromContorno(){
        ArrayList<String> idFilamenti= ControlloreRCentroideEstensione.getInstance().selectIdFilFromContornoFromBean();
        if (idFilamenti!=null)
            return idFilamenti;
        else
            return null;
    }


    //method: torna un ArrayList di float con all'interno due float ( rispettivamente media Long e Latg)
    public ArrayList<Float> selectCentroidPosition(){
        ArrayList<Float> centroidPosition=ControlloreRCentroideEstensione.getInstance().selectCentroidPositionFrombean(this);
        if(centroidPosition!=null)
            return centroidPosition;
        else
            return null;

    }


    //method
    public ArrayList<Double> selectEstensionPosition(){
        ArrayList<Double> estensioni= ControlloreRCentroideEstensione.getInstance().selectEstensionPositionFromBean(this);
        if (estensioni!= null)
            return estensioni;
        else
            return null;

    }



}
