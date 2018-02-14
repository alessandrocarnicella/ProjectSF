package Entity;

/**
 * Created by Manuel on 08/02/2018.
 */
public class Scheletro {

    private int idFilamento;
    private int idSegmento;
    private String tipoRamo;
    private Float lonG;
    private Float latG;
    private int nProg;
    private Double flussoMisurato;

    //constructor
    public Scheletro() {
    }

    //constructor
    public Scheletro(int idFilamento, int idSegmento, String tipoRamo, Float lonG, Float latG, int nProg, Double flussoMisurato) {
        this.idFilamento = idFilamento;
        this.idSegmento = idSegmento;
        this.tipoRamo = tipoRamo;
        this.lonG = lonG;
        this.latG = latG;
        this.nProg = nProg;
        this.flussoMisurato = flussoMisurato;
    }

    //getter and setter
    public int getIdFilamento() {
        return idFilamento;
    }

    public void setIdFilamento(int idFilamento) {
        this.idFilamento = idFilamento;
    }

    public int getIdSegmento() {
        return idSegmento;
    }

    public void setIdSegmento(int idSegmento) {
        this.idSegmento = idSegmento;
    }

    public String getTipoRamo() {
        return tipoRamo;
    }

    public void setTipoRamo(String tipoRamo) {
        this.tipoRamo = tipoRamo;
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

    public int getnProg() {
        return nProg;
    }

    public void setnProg(int nProg) {
        this.nProg = nProg;
    }

    public Double getFlussoMisurato() {
        return flussoMisurato;
    }

    public void setFlussoMisurato(Double flussoMisurato) {
        this.flussoMisurato = flussoMisurato;
    }
}
