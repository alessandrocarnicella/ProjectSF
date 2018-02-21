package Control;

import Bean.BeanBrillantezzaEllitticita;
import Bean.BeanFilamento;
import Bean.BeanInserimentoCSV;
import DAO.DAOAgenzia;
import DAO.DAOFilamento;
import Entity.Filamento;
import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;

/**
 * Created by alessandro on 19/02/18.
 */
public class ControlloreRContrastoEllittcita {
    private static ControlloreRContrastoEllittcita instance;

    //constructor
    protected ControlloreRContrastoEllittcita() {
    }

    // singleton
    public static synchronized final ControlloreRContrastoEllittcita getInstance() {
        if (instance == null)
            instance = new ControlloreRContrastoEllittcita();
        return instance;
    }


    //method
    public ArrayList<String> selectFilamentoFromBean(BeanBrillantezzaEllitticita beanBE){
        DAOFilamento daoFilamento = DAOFilamento.getInstance();

        Float contrasto = RicavaContrasto(beanBE.getBrillantezza());

        ArrayList<String> filamenti = daoFilamento.selectFilamentiFromDB(contrasto,beanBE.getMinEllitticita(),beanBE.getMaxEllitticita());

        int i=0;
        while (i<filamenti.size()) {

            Filamento filamento = new Filamento(filamenti.get(i+1), Integer.valueOf(filamenti.get(i)), Float.valueOf(filamenti.get(i+2)), Float.valueOf(filamenti.get(i+3)),Float.valueOf(filamenti.get(i+4)),Float.valueOf(filamenti.get(i+5)),Float.valueOf(filamenti.get(i+6)),filamenti.get(i+7),filamenti.get(i+8));
            i=i+9;
            System.out.println(filamento);
            BeanFilamento beanFilamento = new BeanFilamento();
            beanFilamento.setIdFilamento(filamento.getIdFilamento());
            beanFilamento.setNome(filamento.getNome());
            beanFilamento.setFlussoTotale(filamento.getFlussoTotale());
            beanFilamento.setDensitaMedia(filamento.getDensitaMedia());
            beanFilamento.setTemperaturaMedia(filamento.getTemperaturaMedia());
            beanFilamento.setEllitticita(filamento.getEllitticita());
            beanFilamento.setContrasto(filamento.getContrasto());
            beanFilamento.setNomeSatellite(filamento.getNomeSatellite());
            beanFilamento.setNomeSatellite(filamento.getNomeStrumento());
            beanFilamento.setPagina(1);
        }

        if(filamenti!=null) {
            return filamenti;
        } else{
            return null;
        }
    }

    private Float RicavaContrasto(Float brillantezza) {
        return (1+brillantezza/100);
    }



    public static void main(String args[]){
        BeanBrillantezzaEllitticita beanBE = new BeanBrillantezzaEllitticita();
        beanBE.setBrillantezza((float) 50);
        beanBE.setMinEllitticita((float) 5.0);
        beanBE.setMaxEllitticita((float) 6.0);
        ControlloreRContrastoEllittcita.getInstance().selectFilamentoFromBean(beanBE);

    }


}
