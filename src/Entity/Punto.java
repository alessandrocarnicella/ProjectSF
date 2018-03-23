package Entity;


public class Punto {

    private Float latG;
    private Float lonG;

    //default constructor
    public Punto() {
    }

    //constructor
    public Punto(Float latG, Float lonG) {
        this.latG = latG;
        this.lonG = lonG;
    }


    //getter and setter
    public Float getLatG() {
        return latG;
    }
    public void setLatG(Float latG) {
        this.latG = latG;
    }

    public Float getLonG() {
        return lonG;
    }
    public void setLonG(Float lonG) {
        this.lonG = lonG;
    }
}
