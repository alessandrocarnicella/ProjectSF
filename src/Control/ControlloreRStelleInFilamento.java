package Control;

import Bean.BeanFilamento;
import Bean.BeanStella;
import DAO.DAOContorno;
import DAO.DAOStelle;
import Entity.Punto;
import Entity.Stella;

import java.util.ArrayList;

/**
 * Created by Manuel on 05/03/2018.
 */
public class ControlloreRStelleInFilamento {

    // Singleton
    private static ControlloreRStelleInFilamento instance;
    private int stelleTrovate=0;
    private int stelleProtostellar=0;
    private int stellePrestellar=0;
    private int stelleUnbound=0;


    public static synchronized final ControlloreRStelleInFilamento getInstance() {
        if (instance == null)
            instance = new ControlloreRStelleInFilamento();
        return instance;
    }


    //method
    public ArrayList<String> searchStarsInFilamentFromBean(BeanFilamento beanFilamento){

        ArrayList<String> val=new ArrayList<>();

        ArrayList<String> strStelle= DAOStelle.getInstance().selectAllStarsFromDB();
        System.out.println("strStelle:"+strStelle);
        ArrayList<String> strContorno= DAOContorno.getInstance().selectAllPerimeterPointsFromDB(beanFilamento);
        System.out.println("strContorno:"+strContorno);

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

int count=-1;
        for(Stella s: stelle){
            System.out.println("------------------------------ stella = "+count++);
            for(int k=0;k<puntiContorno.size()-1;k++){
                System.out.println("k ="+k);
                if(ArctanCondition(s, puntiContorno.get(k), puntiContorno.get(k + 1))){
                   break;
                }
                else {
                    System.out.println("non cotenuta");
                }
            }
        }

        System.out.println(stelle.size());
        System.out.println(puntiContorno.size());

        Float percentualePRO= ((float)stelleProtostellar/(float) stelleTrovate)*100;
        Float percentualePRE= ((float)stellePrestellar/(float) stelleTrovate)*100;;
        Float percentualeUNB= ((float)stelleUnbound/(float) stelleTrovate)*100;;
        val.add(String.valueOf(stelleTrovate));
        val.add(String.valueOf(percentualePRO));
        val.add(String.valueOf(percentualePRE));
        val.add(String.valueOf(percentualeUNB));
        return val;

    }


    private boolean ArctanCondition(Stella s,Punto punto1,Punto punto2){

        System.out.println("p1 lat: "+punto1.getLatG());
        System.out.println("p1 lon: "+punto1.getLonG());
        System.out.println("p2 lat: "+punto2.getLatG());
        System.out.println("p2 llon: "+punto2.getLonG());
        System.out.println("s lat: "+s.getLatG());
        System.out.println("s lon: "+s.getLonG());

        Double result= Math.atan(
                (((punto1.getLonG()-s.getLonG())*(punto2.getLonG()-s.getLonG()))
                +((punto1.getLatG()-s.getLatG())*(punto2.getLatG()-s.getLatG())))
               /(((punto1.getLonG()-s.getLonG())*(punto2.getLatG()-s.getLatG()))
                -((punto1.getLatG()-s.getLatG())*(punto2.getLonG()-s.getLonG())))
                );

        System.out.println("result:"+result);
        if(result>0.01){
            System.out.println("contenuta");
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
           return true;
        }else
            return false;
    }
/*
    public static void main(String[] args){
        BeanFilamento beanFilamento=new BeanFilamento();
        beanFilamento.setIdFilamento(45);
        System.out.println(ControlloreRStelleInFilamento.getInstance().searchStarsInFilamentFromBean(beanFilamento));
    }
*/
}
