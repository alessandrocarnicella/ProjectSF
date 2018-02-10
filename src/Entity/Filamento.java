package Entity;

/**
 * Created by alessandro on 08/02/18.
 */
public class Filamento {

    private String nome;
    private int idFilamento;
    private double flussoTotale;
    private double densitaMedia;
    private double temperaturaMedia;
    private double ellitticita;
    private double contrasto;
    private String nomeSatellite;
    private String nomeStrumento;

    //constructor
    public Filamento() {
    }

    //constructor
    public Filamento(String nome, int idFilamento, double flussoTotale, double densitaMedia, double temperaturaMedia, double ellitticita, double contrasto, String nomeSatellite, String nomeStrumento) {
        this.nome = nome;
        this.idFilamento = idFilamento;
        this.flussoTotale = flussoTotale;
        this.densitaMedia = densitaMedia;
        this.temperaturaMedia = temperaturaMedia;
        this.ellitticita = ellitticita;
        this.contrasto = contrasto;
        this.nomeSatellite = nomeSatellite;
        this.nomeStrumento = nomeStrumento;
    }

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

    public double getFlussoTotale() {
        return flussoTotale;
    }

    public void setFlussoTotale(double flussoTotale) {
        this.flussoTotale = flussoTotale;
    }

    public double getDensitaMedia() {
        return densitaMedia;
    }

    public void setDensitaMedia(double densitaMedia) {
        this.densitaMedia = densitaMedia;
    }

    public double getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(double temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    public double getEllitticita() {
        return ellitticita;
    }

    public void setEllitticita(double ellitticita) {
        this.ellitticita = ellitticita;
    }

    public double getContrasto() {
        return contrasto;
    }

    public void setContrasto(double contrasto) {
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
}
