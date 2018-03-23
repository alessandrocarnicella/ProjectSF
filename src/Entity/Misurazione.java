package Entity;

public class Misurazione {

    private String nomeStrumento;
    private float banda;

    //constructor
    public Misurazione(String nomeStrumento, float banda) {
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

    public float getBanda() {
        return banda;
    }
    public void setBanda(float banda) {
        this.banda = banda;
    }

}
