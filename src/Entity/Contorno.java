package Entity;


public class Contorno {

    private int idFilamento;
    private Float lonG;
    private Float latG;

    //default constructor
    public Contorno() {
    }

    //constructor
    public Contorno(int idFilamento, Float lonG, Float latG) {
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

}
