package Bean;

import Control.ControlloreInserimentoCSV;

/**
 * Created by Manuel on 14/02/2018.
 */
public class BeanInserimentoCSV {

    public boolean inserisciDatiCSV(String nome,String path){
        boolean inserimento= ControlloreInserimentoCSV.getInstance().inserisciDatiCSVFromBean(nome, path);
        if (inserimento==true){
            return true;
        }
        return false;
    }

}
