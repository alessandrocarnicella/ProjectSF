package Entity;

/**
 * Created by alessandro on 08/02/18.
 */
public class Misurazione {

    private String nomeStrumento;
    private double banda;

    //constructor
    public Misurazione(String nomeStrumento, double banda) {
        this.nomeStrumento = nomeStrumento;
        this.banda = banda;
    }

    //getter and setter
    public String getNomeStrumento() {
        return nomeStrumento;
    }

    public void setNomeStrumento(String nomeStrumento) {
        this.nomeStrumento = nomeStrumento;
    }

    public double getBanda() {
        return banda;
    }

    public void setBanda(double banda) {
        this.banda = banda;
    }
}
