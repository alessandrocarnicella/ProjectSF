package Control;

import Bean.BeanFilamento;
import DAO.DAOContorno;
import DAO.DAOStelle;
import Entity.Punto;
import Entity.Stella;

import java.util.ArrayList;

/**
 * Created by Manuel on 05/03/2018.
 */
public class ControlloreRStelleInFilamento {

    private int stelleTrovate = 0;
    private int stelleProtostellar = 0;
    private int stellePrestellar = 0;
    private int stelleUnbound = 0;

    // Singleton
    private static ControlloreRStelleInFilamento instance;

    public static synchronized final ControlloreRStelleInFilamento getInstance() {
        if (instance == null)
            instance = new ControlloreRStelleInFilamento();
        return instance;
    }


    //method
    public ArrayList<String> searchStarsInFilamentFromBean(BeanFilamento beanFilamento){

        ArrayList<String> val=new ArrayList<>();
        ArrayList<String> strStelle= DAOStelle.getInstance().selectAllStarsFromDB();
        ArrayList<String> strContorno= DAOContorno.getInstance().selectAllPerimeterPointsFromDB(beanFilamento);
        ArrayList<Stella> stelle=new ArrayList<>();
        ArrayList<Punto> puntiContorno=new ArrayList<>();

        if(strContorno==null){
            return null;
        }

        arrayStelle(strStelle,stelle);

        arrayContorni(strContorno,puntiContorno);

        Double result=0.0;
        for(int r=0;r<stelle.size();r++){
            for(int k=0;k<puntiContorno.size()-2;k++){
                result= result+ Math.atan(
                        (((puntiContorno.get(k).getLonG()-stelle.get(r).getLonG())*(puntiContorno.get(k+1).getLatG()-stelle.get(r).getLatG()))
                                -((puntiContorno.get(k).getLatG()-stelle.get(r).getLatG())*(puntiContorno.get(k+1).getLonG()-stelle.get(r).getLonG())))
                                /(((puntiContorno.get(k).getLonG()-stelle.get(r).getLonG())*(puntiContorno.get(k+1).getLonG()-stelle.get(r).getLonG()))
                                +((puntiContorno.get(k).getLatG()-stelle.get(r).getLatG())*(puntiContorno.get(k+1).getLatG()-stelle.get(r).getLatG())))
                );
            }

            if (Math.abs(Math.toRadians(result))>=0.01){
                foundStars(stelle.get(r));

                result = 0.0;
            }else
                result = 0.0;
        }

        //calcolo percentuali
        Float percentualePRO = calcolaPercentuale(stelleProtostellar, stelleTrovate);
        Float percentualePRE = calcolaPercentuale(stellePrestellar, stelleTrovate);
        Float percentualeUNB = calcolaPercentuale(stelleUnbound, stelleTrovate);

        val.add(String.valueOf(stelleTrovate));
        val.add(String.valueOf(percentualePRO));
        val.add(String.valueOf(percentualePRE));
        val.add(String.valueOf(percentualeUNB));

        stelleTrovate = 0;
        stellePrestellar = 0;
        stelleProtostellar = 0;
        stelleUnbound = 0;

        return val;

    }

    //method
    private float calcolaPercentuale(int s, int sT){
        float result = ((float)s/(float) sT)*100;
        return result;
    }

    //method
    private void arrayContorni( ArrayList<String> strContorno,ArrayList<Punto> puntiContorno){
        int j = 0;
        while (j<strContorno.size()){
            Punto puntoContorno=new Punto(Float.valueOf(strContorno.get(j)),Float.valueOf(strContorno.get(j+1)));
            j=j+2;
            puntiContorno.add(puntoContorno);
        }
    }


    //method
    private void arrayStelle(ArrayList<String> strStelle,ArrayList<Stella> stelle){
        int i=0;
        while (i<strStelle.size()){
            Stella Stella=new Stella(Integer.valueOf(strStelle.get(i)),String.valueOf(strStelle.get(i+1)),Float.valueOf(strStelle.get(i+2)), Float.valueOf(strStelle.get(i+3)),Float.valueOf(strStelle.get(i+4)),strStelle.get(i+5));
            i=i+6;
            stelle.add(Stella);
        }
    }


    private void foundStars(Stella s){

        System.out.println(s.getIdStella());
        stelleTrovate++;

        if (s.getTipoStella().equals("PROTOSTELLAR")){
            stelleProtostellar++;
        }
        else if (s.getTipoStella().equals("PRESTELLAR")){
            stellePrestellar++;
        }
        else if (s.getTipoStella().equals("UNBOUND")){
            stelleUnbound++;
        }
    }

/*
    public static void main(String[] args){
        BeanFilamento beanFilamento=new BeanFilamento();
        beanFilamento.setIdFilamento(1013661);
        System.out.println(ControlloreRStelleInFilamento.getInstance().searchStarsInFilamentFromBean(beanFilamento));
    }
*/
}
