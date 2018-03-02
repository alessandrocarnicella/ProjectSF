package Bean;

import Control.ControlloreRCerchioQuadrato;
import Control.ControlloreRContrastoEllittcita;
import Entity.Filamento;

import java.util.ArrayList;

/**
 * Created by alessandro on 01/03/18.
 */
public class BeanPosRaggioLato {

    private Float lonG;
    private Float latG;
    private Float raggio;
    private Float lato;

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

    public Float getRaggio() {
        return raggio;
    }

    public void setRaggio(Float raggio) {
        this.raggio = raggio;
    }

    public Float getLato() {
        return lato;
    }

    public void setLato(Float lato) {
        this.lato = lato;
    }

    //method
    public ArrayList<Filamento> selectFilamentoFromBean(){
        ArrayList<Filamento> filamento = ControlloreRCerchioQuadrato.getInstance().selectForRegionePosSpazialeFromBean(this);
        return filamento;
    }
}
