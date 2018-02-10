package Entity;

/**
 * Created by Manuel on 08/02/2018.
 */
public class Contorno {
    private int idFilamento;
    private Double lonG;
    private Double latG;

    //constructor
    public Contorno() {
    }

    //constructor
    public Contorno(int idFilamento, Double lonG, Double latG) {
        this.idFilamento = idFilamento;
        this.lonG = lonG;
        this.latG = latG;
    }

    //getter and setter
    public int getIdFilamento() {
        return idFilamento;
    }

    public void setIdFilamento(int idFilamento) {
        this.idFilamento = idFilamento;
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
}
