package Entity;

/**
 * Created by Manuel on 08/02/2018.
 */
public class Scheletro {

    private int idFilamento;
    private int idSegmento;
    private char tipoRamo;
    private Double lonG;
    private Double latG;
    private int nProg;
    private Double flussoMisurato;

    //constructor
    public Scheletro(int idFilamento, int idSegmento, char tipoRamo, Double lonG, Double latG, int nProg, Double flussoMisurato) {
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

    public char getTipoRamo() {
        return tipoRamo;
    }

    public void setTipoRamo(char tipoRamo) {
        this.tipoRamo = tipoRamo;
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
