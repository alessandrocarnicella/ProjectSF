package Bean;

import Control.ControlloreRCentroideEstensione;
import Control.ControlloreRFilamentsBySegmentsRange;

import java.util.ArrayList;

/**
 * Created by Manuel on 20/02/2018.
 */
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






}
