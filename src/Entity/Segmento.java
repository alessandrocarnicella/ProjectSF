package Entity;

/**
 * Created by Manuel on 08/02/2018.
 */
public class Segmento {

    private int idSegmento;
    private int idFilamento;

    //constructor
    public Segmento() {
        }

    //constructor
    public Segmento(int idSegmento, int idFilamento) {
        this.idSegmento = idSegmento;
        this.idFilamento = idFilamento;
    }

    //getter and setter
    public int getIdSegmento() {
        return idSegmento;
    }

    public void setIdSegmento(int idSegmento) {
        this.idSegmento = idSegmento;
    }

    public int getIdFilamento() {
        return idFilamento;
    }

    public void setIdFilamento(int idFilamento) {
        this.idFilamento = idFilamento;
    }
}
