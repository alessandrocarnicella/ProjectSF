package Bean;

import Control.ControlloreRContrastoEllittcita;
import Entity.Filamento;

import java.util.ArrayList;

/**
 * Created by alessandro on 19/02/18.
 */
public class BeanBrillantezzaEllitticita {

    private Float minEllitticita;
    private Float maxEllitticita;
    private Float brillantezza;

    //getter and setter
    public Float getMinEllitticita() {
        return minEllitticita;
    }
    public void setMinEllitticita(Float minEllitticita) {
        this.minEllitticita = minEllitticita;
    }

    public Float getMaxEllitticita() {
        return maxEllitticita;
    }
    public void setMaxEllitticita(Float maxEllitticita) {
        this.maxEllitticita = maxEllitticita;
    }

    public Float getBrillantezza() {
        return brillantezza;
    }
    public void setBrillantezza(Float brillantezza) {
        this.brillantezza = brillantezza;
    }

    //method
    public ArrayList<Filamento> selectFilamentoFromBean(){
        ArrayList<Filamento> filamenti =ControlloreRContrastoEllittcita.getInstance().selectFilamentoFromBean(this);
        return filamenti;
    }

    //method
    public boolean ControlloMinMax(float min,float max){
        if (min<=max){
            return true;
        }
        return false;
    }
}
