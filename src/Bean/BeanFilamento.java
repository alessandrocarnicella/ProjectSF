package Bean;

import Control.ControlloreRCentroideEstensione;
import Control.ControlloreRDistanceStelleSpinaDorsale;
import Control.ControlloreRStelleInFilamento;

import java.util.ArrayList;

/**
 * Created by alessandro on 21/02/18.
 */
public class BeanFilamento {

    private String nome;
    private int idFilamento;
    private float flussoTotale;
    private float densitaMedia;
    private float temperaturaMedia;
    private float ellitticita;
    private float contrasto;
    private String nomeSatellite;
    private String nomeStrumento;


    //getter and setter
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdFilamento() {
        return idFilamento;
    }
    public void setIdFilamento(int idFilamento) {
        this.idFilamento = idFilamento;
    }

    public float getFlussoTotale() {
        return flussoTotale;
    }
    public void setFlussoTotale(float flussoTotale) {
        this.flussoTotale = flussoTotale;
    }

    public float getDensitaMedia() {
        return densitaMedia;
    }
    public void setDensitaMedia(float densitaMedia) {
        this.densitaMedia = densitaMedia;
    }

    public float getTemperaturaMedia() {
        return temperaturaMedia;
    }
    public void setTemperaturaMedia(float temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    public float getEllitticita() {
        return ellitticita;
    }
    public void setEllitticita(float ellitticita) {
        this.ellitticita = ellitticita;
    }

    public float getContrasto() {
        return contrasto;
    }
    public void setContrasto(float contrasto) {
        this.contrasto = contrasto;
    }

    public String getNomeSatellite() {
        return nomeSatellite;
    }
    public void setNomeSatellite(String nomeSatellite) {
        this.nomeSatellite = nomeSatellite;
    }

    public String getNomeStrumento() {
        return nomeStrumento;
    }
    public void setNomeStrumento(String nomeStrumento) {
        this.nomeStrumento = nomeStrumento;
    }


    //method
    public ArrayList<String> selectForIdOrNameFilCentroidExtension(){
        ArrayList<String> val= ControlloreRCentroideEstensione.getInstance().selectForIdOrNameFilCentroidExtensionFromBean(this);
        if ( val!=null)
            return  val;
        else
            return null;
    }


    //method
    public ArrayList<String> searchStarsInFilament(){
        ArrayList<String> val= ControlloreRStelleInFilamento.getInstance().searchStarsInFilamentFromBean(this);
        if (val!= null){
            return val;
        }else
            return null;
    }

    //method
    public ArrayList<String[]> searchDistance(){
        ArrayList<String[]> val= ControlloreRDistanceStelleSpinaDorsale.getInstance().searchDistanceStelleSpinaDorsaleFromBean(this);
        if (val!= null){
            return val;
        }else
            return null;
    }
}
