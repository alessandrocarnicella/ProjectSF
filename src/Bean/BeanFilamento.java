package Bean;

import Control.ControlloreRCentroideEstensione;

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

    private int  pagina;

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

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
}
