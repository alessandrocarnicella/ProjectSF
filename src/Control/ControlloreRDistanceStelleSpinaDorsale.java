package Control;

import Bean.BeanFilamento;
import DAO.DAOContorno;
import DAO.DAOStelle;
import Entity.Punto;
import Entity.Stella;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Manuel on 05/03/2018.
 */
public class ControlloreRDistanceStelleSpinaDorsale {

    private ArrayList<String[]> val = new ArrayList<>();

    // Singleton
    private static ControlloreRDistanceStelleSpinaDorsale  instance;

    public static synchronized final ControlloreRDistanceStelleSpinaDorsale  getInstance() {
        if (instance == null)
            instance = new ControlloreRDistanceStelleSpinaDorsale ();
        return instance;
    }


    //method
    public ArrayList<String[]> searchDistanceStelleSpinaDorsaleFromBean(BeanFilamento beanFilamento){

        ArrayList<String> strStelle = DAOStelle.getInstance().selectAllStarsFromDB();
        ArrayList<String> strContorno = DAOContorno.getInstance().selectAllPerimeterPointsFromDB(beanFilamento);
        ArrayList<Stella> stelle = new ArrayList<>();
        ArrayList<Punto> puntiContorno = new ArrayList<>();

        DAOStelle.getInstance().createTableOrdinamento();

        if(strContorno == null){
            return null;
        }

        arrayStelle(strStelle,stelle);

        arrayContorni(strContorno,puntiContorno);

        //verifica presenza di una stella nei punti di un controno
        trovaStella(stelle,puntiContorno,beanFilamento);

        // beanFilamento.getOrdinamento mi dice come ordinare
        ordinamento(beanFilamento);

        DAOStelle.getInstance().deleteTableOrdinamento();
        return val;
    }


    //method
    private void arrayContorni( ArrayList<String> strContorno,ArrayList<Punto> puntiContorno){
        int j = 0;
        while (j < strContorno.size()){
            Punto puntoContorno=new Punto(Float.valueOf(strContorno.get(j)),Float.valueOf(strContorno.get(j+1)));
            j = j+2;
            puntiContorno.add(puntoContorno);
        }

    }


    //method
    private void arrayStelle(ArrayList<String> strStelle,ArrayList<Stella> stelle){
        int i=0;
        while (i < strStelle.size()){
            Stella Stella = new Stella(Integer.valueOf(strStelle.get(i)),String.valueOf(strStelle.get(i+1)),Float.valueOf(strStelle.get(i+2)), Float.valueOf(strStelle.get(i+3)),Float.valueOf(strStelle.get(i+4)),strStelle.get(i+5));
            i = i+6;
            stelle.add(Stella);
        }
    }

    //method
    private void ordinamento(BeanFilamento beanFilamento){
        if(beanFilamento.getOrdinamento().equals("ordflusso")){
            val = DAOStelle.getInstance().orderByFluxFromDB();
        }
        if(beanFilamento.getOrdinamento().equals("orddistanza")){
            val = DAOStelle.getInstance().orderByDistanceFromDB();
        }
    }

    //method
    private void trovaStella (ArrayList<Stella> stelle, ArrayList<Punto> puntiContorno,BeanFilamento beanFilamento){
        Double result=0.0;
        for(int r = 0; r < stelle.size(); r++){
            for(int k = 0; k < puntiContorno.size()-2; k++){
                result = result + Math.atan(
                        (((puntiContorno.get(k).getLonG()-stelle.get(r).getLonG())*(puntiContorno.get(k+1).getLatG()-stelle.get(r).getLatG()))
                                -((puntiContorno.get(k).getLatG()-stelle.get(r).getLatG())*(puntiContorno.get(k+1).getLonG()-stelle.get(r).getLonG())))
                                /(((puntiContorno.get(k).getLonG()-stelle.get(r).getLonG())*(puntiContorno.get(k+1).getLonG()-stelle.get(r).getLonG()))
                                +((puntiContorno.get(k).getLatG()-stelle.get(r).getLatG())*(puntiContorno.get(k+1).getLatG()-stelle.get(r).getLatG())))
                );
            }
            if (Math.abs(Math.toRadians(result)) >= 0.01){
                //se la stella è allinterno dei punti del controno calcolo la distanza
                foundStars(stelle.get(r),beanFilamento.getIdFilamento());

                result = 0.0;
            }else {
                result = 0.0;
            }
        }
    }

    //method
    private void foundStars(Stella s, int id){
        // calcolo la distanza minima
        ArrayList<String> val2 = DAOStelle.getInstance().selectMinDistanceFromDB(s,id);
        String[] v = new String[9];
        //id filamento
        v[0] = (String.valueOf(id));
        //id stella
        v[1] = (String.valueOf(s.getIdStella()));
        //nome stella
        v[2] = (s.getNomeStella());
        //val flusso
        v[3] = (s.getValoreFlusso().toString());
        //lat stella
        v[4] = (s.getLatG().toString());
        double latv1 = s.getLatG();
        //lon stella
        v[5] = (s.getLonG().toString());
        double lonv1 = s.getLonG();
        //lat punto dorsale
        v[6] = (val2.get(4));
        double latp1 = Double.valueOf(val2.get(4));
        //lon punto dorsale
        v[7] = (val2.get(5));
        double lonp1 = Double.valueOf(val2.get(4));
        //distance
        double distance = Math.sqrt(((lonv1-lonp1)*(lonv1-lonp1)+(latv1-latp1)*(latv1-latp1)));
        v[8] = (String.valueOf(distance));

        DAOStelle.getInstance().insertValue(v);
    }

/*
    public static void main(String[] args){
        BeanFilamento beanFilamento=new BeanFilamento();
        beanFilamento.setIdFilamento(1013661);
        beanFilamento.setOrdinamento("ordflusso");
        ControlloreRDistanceStelleSpinaDorsale.getInstance().searchDistanceStelleSpinaDorsaleFromBean(beanFilamento);
    }
*/
}
