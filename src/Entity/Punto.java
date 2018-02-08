package Entity;

/**
 * Created by Manuel on 08/02/2018.
 */
public class Punto {

    private Double latG;
    private Double lonG;

    //constructor
    public Punto(Double latG, Double lonG) {
        this.latG = latG;
        this.lonG = lonG;
    }

    //getter and setter
    public Double getLatG() {
        return latG;
    }

    public void setLatG(Double latG) {
        this.latG = latG;
    }

    public Double getLonG() {
        return lonG;
    }

    public void setLonG(Double lonG) {
        this.lonG = lonG;
    }
}
