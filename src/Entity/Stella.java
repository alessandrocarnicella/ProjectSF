package Entity;

/**
 * Created by Manuel on 08/02/2018.
 */
public class Stella {

    private int idStella;
    private String nomeStella;
    private Float lonG;
    private Float latG;
    private Double valoreFlusso;
    private String tipoStella;

    //constructor
    public Stella() {
    }

    //constructor
    public Stella(int idStella, String nomeStella, Float lonG, Float latG, Double valoreFlusso, String tipoStella) {
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
