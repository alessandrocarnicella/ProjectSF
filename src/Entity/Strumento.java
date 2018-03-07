package Entity;

/**
 * Created by alessandro on 08/02/18.
 */
public class Strumento {

    private String nome;
    private String nomeSatellite;

    //constructor
    public Strumento(String nome, String nomeSatellite) {
        this.nome = nome;
        this.nomeSatellite = nomeSatellite;
    }

    //getter and setter
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeSatellite() {
        return nomeSatellite;
    }
    public void setNomeSatellite(String nomeSatellite) {
        this.nomeSatellite = nomeSatellite;
    }
}
