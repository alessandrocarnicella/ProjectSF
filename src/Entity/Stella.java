package Entity;

/**
 * Created by Manuel on 08/02/2018.
 */
public class Stella {

    private int idStella;
    private String nomeStella;
    private Double lonG;
    private Double latG;
    private Double valoreFlusso;
    private String tipoStella;

    //constructor
    public Stella() {
    }

    //constructor
    public Stella(int idStella, String nomeStella, Double lonG, Double latG, Double valoreFlusso, String tipoStella) {
        this.idStella = idStella;
        this.nomeStella = nomeStella;
        this.lonG = lonG;
        this.latG = latG;
        this.valoreFlusso = valoreFlusso;
        this.tipoStella = tipoStella;
    }


    //getter and setter
    public int getIdStella() {
        return idStella;
    }

    public void setIdStella(int idStella) {
        this.idStella = idStella;
    }

    public String getNomeStella() {
        return nomeStella;
    }

    public void setNomeStella(String nomeStella) {
        this.nomeStella = nomeStella;
    }

    public Double getLonG() {
        return lonG;
    }

    public void setLonG(Double lonG) {
        this.lonG = lonG;
    }

    public Double getLatG() {
        return latG;
    }

    public void setLatG(Double latG) {
        this.latG = latG;
    }

    public Double getValoreFlusso() {
        return valoreFlusso;
    }

    public void setValoreFlusso(Double valoreFlusso) {
        this.valoreFlusso = valoreFlusso;
    }

    public String getTipoStella() {
        return tipoStella;
    }

    public void setTipoStella(String tipoStella) {
        this.tipoStella = tipoStella;
    }
}
