package Control;

import Bean.BeanBrillantezzaEllitticita;
import Bean.BeanInserimentoCSV;
import DAO.DAOAgenzia;
import DAO.DAOFilamento;
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

        System.out.print(filamenti);

        //TODO rivedi stampe ed errore
        int i=0;

        while (i<=filamenti.size()) {
            System.out.print(filamenti.get(i)+" -- ");
            System.out.print(filamenti.get(i + 5)+" -- ");
            System.out.println(filamenti.get(i + 6));
            i = i + 9;
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
        beanBE.setBrillantezza((float) 1.1);
        beanBE.setMinEllitticita((float) 4.0);
        beanBE.setMaxEllitticita((float) 6.0);
        ControlloreRContrastoEllittcita.getInstance().selectFilamentoFromBean(beanBE);

    }


}
