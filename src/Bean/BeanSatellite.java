package Bean;

import Control.ControlloreInserimentoDati;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Manuel on 10/02/2018.
 */
public class BeanSatellite {

    private String nome;
    private Date dataInizio;
    private Date dataFine;
    private String nomeAgenzia;


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


    //method
    public boolean insertNewSatellite(){
        boolean inserimento= ControlloreInserimentoDati.getInstance().insertNewSatelliteFromBean(this);
        if (inserimento==true){
            return true;
        }
        else
            return false;
    }

    //method
    public ArrayList<String> selectSatelliti() {
        ArrayList<String> satelliti = ControlloreInserimentoDati.getInstance().selectSatellitiFromBean();
        return satelliti;
    }




}