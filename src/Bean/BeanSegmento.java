package Bean;

import Control.ControlloreRFilamentsBySegmentsRange;

import java.util.ArrayList;


public class BeanSegmento {

    private int idSegmento;
    private int idFilamento;

    //getter and setter
    public int getIdSegmento() {
        return idSegmento;
    }
    public void setIdSegmento(int idSegmento) {
        this.idSegmento = idSegmento;
    }

    public int getIdFilamento() {
        return idFilamento;
    }
    public void setIdFilamento(int idFilamento) {
        this.idFilamento = idFilamento;
    }


    //method
    public ArrayList<String[]> selectFilamentsBySegmentsNumber(int int1,int int2){
        ArrayList<String[]> val=ControlloreRFilamentsBySegmentsRange.getInstance().selectFilamentsBySegmentsNumberFromBean(int1,int2);
        if(val!=null) {
            return val;
        }
        else
            return null;
    }


    //method
    public boolean controlloMinMax(int min,int max){
        if (min<=max){
            return true;
        }
        return false;
    }

}
