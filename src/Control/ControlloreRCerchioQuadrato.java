package Control;

import Bean.BeanPosRaggioLato;
import DAO.DAOContorno;
import Entity.Filamento;

import java.util.ArrayList;

public class ControlloreRCerchioQuadrato {

    // Singleton
    private static ControlloreRCerchioQuadrato instance;

    public static synchronized final ControlloreRCerchioQuadrato getInstance() {
        if (instance == null)
            instance = new ControlloreRCerchioQuadrato();
        return instance;
    }


    //method
    public ArrayList<Filamento> selectForRegionePosSpazialeFromBean(BeanPosRaggioLato beanPosRaggioLato){
        DAOContorno daoContorno = DAOContorno.getInstance();
        ArrayList<String> val = daoContorno.selectForRegionePosSpazialeFromDB(beanPosRaggioLato);
        ArrayList<Filamento> filamenti = new ArrayList<Filamento>();
        if(val != null) {
            int i = 0;
            while (i < val.size()) {
                Filamento filamento = new Filamento(val.get(i+1), Integer.valueOf(val.get(i)), Float.valueOf(val.get(i+2)), Float.valueOf(val.get(i+3)),Float.valueOf(val.get(i+4)),Float.valueOf(val.get(i+5)),Float.valueOf(val.get(i+6)),val.get(i+7),val.get(i+8));
                i = i+9;
                filamenti.add(filamento);
            }
            return filamenti;
        } else {
            return null;
        }
    }
/*
    public static void main(String args[]){
        BeanPosRaggioLato beanPRL = new BeanPosRaggioLato();
        beanPRL.setLatG((float) 0);
        beanPRL.setLonG((float) 0);
        beanPRL.setRaggio(null);
        beanPRL.setLato((float) 20);
        //beanPRL.setLato(null);
        //beanPRL.setRaggio((float) 10);
        ControlloreRCerchioQuadrato.getInstance().selectForRegionePosSpazialeFromBean(beanPRL);

    }
*/
}
