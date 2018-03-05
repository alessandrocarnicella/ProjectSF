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
    public ArrayList<Filamento> selectFilamentoFromBean(BeanBrillantezzaEllitticita beanBE){
        DAOFilamento daoFilamento = DAOFilamento.getInstance();
        Float contrasto = RicavaContrasto(beanBE.getBrillantezza());
        ArrayList<String> val = daoFilamento.selectFilamentiFromDB(contrasto,beanBE.getMinEllitticita(),beanBE.getMaxEllitticita());
        ArrayList<Filamento> filamenti=new ArrayList<>();
        int i=0;
        while (i<val.size()) {
            Filamento filamento = new Filamento(val.get(i+1), Integer.valueOf(val.get(i)), Float.valueOf(val.get(i+2)), Float.valueOf(val.get(i+3)),Float.valueOf(val.get(i+4)),Float.valueOf(val.get(i+5)),Float.valueOf(val.get(i+6)),val.get(i+7),val.get(i+8));
            i=i+9;
            System.out.println(filamento);
            filamenti.add(filamento);
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


/*
    public static void main(String args[]){
        BeanBrillantezzaEllitticita beanBE = new BeanBrillantezzaEllitticita();
        beanBE.setBrillantezza((float) 50);
        beanBE.setMinEllitticita((float) 5.0);
        beanBE.setMaxEllitticita((float) 6.0);
        ControlloreRContrastoEllittcita.getInstance().selectFilamentoFromBean(beanBE);

    }
*/

}
