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

    private int stelleTrovate=0;
    private int stelleProtostellar=0;
    private int stellePrestellar=0;
    private int stelleUnbound=0;

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

        if(strContorno==null){
            return null;
        }
        ArrayList<Stella> stelle=new ArrayList<>();
        ArrayList<Punto> puntiContorno=new ArrayList<>();

        int i=0;
        int j=0;
        while (i<strStelle.size()){
            Stella Stella=new Stella(Integer.valueOf(strStelle.get(i)),String.valueOf(strStelle.get(i+1)),Float.valueOf(strStelle.get(i+2)), Float.valueOf(strStelle.get(i+3)),Float.valueOf(strStelle.get(i+4)),strStelle.get(i+5));
            i=i+6;
            stelle.add(Stella);
        }

        while (j<strContorno.size()){
            Punto puntoContorno=new Punto(Float.valueOf(strContorno.get(j)),Float.valueOf(strContorno.get(j+1)));
            j=j+2;
            puntiContorno.add(puntoContorno);
        }

        int count=0;
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
            }else
                System.out.println("stella non contenuta");
        }
        Float percentualePRO= ((float)stelleProtostellar/(float) stelleTrovate)*100;
        Float percentualePRE= ((float)stellePrestellar/(float) stelleTrovate)*100;;
        Float percentualeUNB= ((float)stelleUnbound/(float) stelleTrovate)*100;;
        val.add(String.valueOf(stelleTrovate));
        val.add(String.valueOf(percentualePRO));
        val.add(String.valueOf(percentualePRE));
        val.add(String.valueOf(percentualeUNB));
        return val;

    }


    private void foundStars(Stella s){

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


    /*public static void main(String[] args){
        BeanFilamento beanFilamento=new BeanFilamento();
        beanFilamento.setIdFilamento(1013661);
        System.out.println(ControlloreRStelleInFilamento.getInstance().searchStarsInFilamentFromBean(beanFilamento));


    }*/

}
