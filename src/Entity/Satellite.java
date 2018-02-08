package Entity;

import java.sql.Date;

/**
 * Created by alessandro on 08/02/18.
 */
public class Satellite {

    private String nome;
    private Date dataInizio;
    private Date dataFine;
    private String nomeAgenzia;

    //constructor
    public Satellite(String nome, Date dataInizio, Date dataFine, String nomeAgenzia) {
        this.nome = nome;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.nomeAgenzia = nomeAgenzia;
    }

    //getter and setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public String getNomeAgenzia() {
        return nomeAgenzia;
    }

    public void setNomeAgenzia(String nomeAgenzia) {
        this.nomeAgenzia = nomeAgenzia;
    }

}
