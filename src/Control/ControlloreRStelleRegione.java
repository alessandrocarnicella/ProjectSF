package Control;

import Bean.BeanPosBaseAltezza;
import DAO.DAOContorno;
import DAO.DAOStelle;
import Entity.Contorno;
import Entity.Punto;
import Entity.Stella;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Manuel on 07/03/2018.
 */
public class ControlloreRStelleRegione {

    private int stelleTrovate=0;
    private int st_ProtTrov=0;
    private int st_PretTrov=0;
    private int st_UnbTrov=0;

    private int stelleNonTrovate=0;
    private int st_ProtNonTrov=0;
    private int st_PretNonTrov=0;
    private int st_UnbNonTrov=0;

    // Singleton
    private static ControlloreRStelleRegione instance;

    public static synchronized final ControlloreRStelleRegione getInstance() {
        if (instance == null)
            instance = new ControlloreRStelleRegione();
        return instance;
    }


    //method
    public ArrayList<String> searchStarsByRegionFromBean(BeanPosBaseAltezza beanPosBaseAltezza){

        ArrayList<String> val=new ArrayList<>();
        ArrayList<Stella> stelle=new ArrayList<>();
        ArrayList<Contorno> puntiContorno=new ArrayList<>();

        ArrayList<String> strStelle= DAOStelle.getInstance().searchStarsByRegionFromDB(beanPosBaseAltezza);
        ArrayList<String> strContorno= DAOContorno.getInstance().selectAllPointsFromDB();

        if(strStelle==null||strContorno==null){
            return null;
        }

        int i=0;
        int j=0;
        while (i<strStelle.size()){
            Stella Stella=new Stella(Integer.valueOf(strStelle.get(i)),String.valueOf(strStelle.get(i+1)),Float.valueOf(strStelle.get(i+2)), Float.valueOf(strStelle.get(i+3)),Float.valueOf(strStelle.get(i+4)),strStelle.get(i+5));
            i=i+6;
            stelle.add(Stella);
        }
        while (j<strContorno.size()){
            Contorno singoloPuntoContorno=new Contorno(Integer.valueOf(strContorno.get(j)),Float.valueOf(strContorno.get(j+1)),Float.valueOf(strContorno.get(j+2)));
            j=j+3;
            puntiContorno.add(singoloPuntoContorno);
        }

        Double result=0.0;
        int num=0;
        for(int r=0;r<stelle.size();r++) {

            for (int k = 0; k < puntiContorno.size(); k++) {

                ArrayList<Contorno> singoloContorno=new ArrayList<>();

                for (int w = 0; w < puntiContorno.size() - 1; w++) {

                    singoloContorno.add(puntiContorno.get(k));
                    if (puntiContorno.get(k).getIdFilamento() == puntiContorno.get(w + 1).getIdFilamento()) {
                        singoloContorno.add(puntiContorno.get(w + 1));
                    } else {
                        break;
                    }
                }


                System.out.println("singolo contorno.size(): " + singoloContorno.size());

                arctanCondition(result, r, singoloContorno, stelle);

            /*for (int k = 0; k < singoloContorno.size() - 2; k++) {
                result = result + Math.atan(
                        (((singoloContorno.get(k).getLonG() - stelle.get(r).getLonG()) * (singoloContorno.get(k + 1).getLatG() - stelle.get(r).getLatG()))
                                - ((singoloContorno.get(k).getLatG() - stelle.get(r).getLatG()) * (singoloContorno.get(k + 1).getLonG() - stelle.get(r).getLonG())))
                                / (((singoloContorno.get(k).getLonG() - stelle.get(r).getLonG()) * (singoloContorno.get(k + 1).getLonG() - stelle.get(r).getLonG()))
                                + ((singoloContorno.get(k).getLatG() - stelle.get(r).getLatG()) * (singoloContorno.get(k + 1).getLatG() - stelle.get(r).getLatG())))
                );
            }
            */

                System.out.println(Math.abs(Math.toRadians(result)));
                if (Math.abs(Math.toRadians(result)) >= 0.01) {
                    foundStars(stelle.get(r));
                    result = 0.0;
                } else {
                    System.out.println("stella NON trovata");
                    notFoundStars(stelle.get(r));
                    result = 0.0;
                }
                if (singoloContorno.size() != 0) {
                    num = singoloContorno.size();
                } else {
                    num++;
                }
            }
        }


        /*
        System.out.println("tutte le stelle sono: "+stelle.size());
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

            System.out.println(Math.abs(Math.toRadians(result)));
            if (Math.abs(Math.toRadians(result))>=0.01){
                foundStars(stelle.get(r));
                result=0.0;
            }
            else {
                System.out.println("stella NON trovata");
                notFoundStars(stelle.get(r));
                result=0.0;
            }
        }
        */
        Float perPROTrov= ((float)st_ProtTrov/(float) stelleTrovate)*100;
        Float perPRETrov= ((float)st_PretTrov/(float) stelleTrovate)*100;
        Float perUNBTrov= ((float)st_UnbTrov/(float) stelleTrovate)*100;

        Float perPRONonTrov= ((float)st_ProtNonTrov/(float) stelleNonTrovate)*100;
        Float perPRENonTrov= ((float)st_PretNonTrov/(float) stelleNonTrovate)*100;
        Float perUNBNonTrov= ((float)st_UnbNonTrov/(float) stelleNonTrovate)*100;


        val.add(String.valueOf(stelleTrovate));
        val.add(String.valueOf(perPROTrov));
        val.add(String.valueOf(perPRETrov));
        val.add(String.valueOf(perUNBTrov));

        val.add(String.valueOf(stelleNonTrovate));
        val.add(String.valueOf(perPRONonTrov));
        val.add(String.valueOf(perPRENonTrov));
        val.add(String.valueOf(perUNBNonTrov));

        return val;
    }


    //method
    private void foundStars(Stella s){

        stelleTrovate++;

        if (s.getTipoStella().equals("PROTOSTELLAR")){
            st_ProtTrov++;
        }
        else if (s.getTipoStella().equals("PRESTELLAR")){
            st_PretTrov++;
        }
        else if (s.getTipoStella().equals("UNBOUND")){
            st_UnbTrov++;
        }
    }

    //method
    private void notFoundStars(Stella s){

        stelleNonTrovate++;

        if (s.getTipoStella().equals("PROTOSTELLAR")){
            st_ProtNonTrov++;
        }
        else if (s.getTipoStella().equals("PRESTELLAR")){
            st_PretNonTrov++;
        }
        else if (s.getTipoStella().equals("UNBOUND")){
            st_UnbNonTrov++;
        }
    }


    //method
    private void arctanCondition(Double res,int r, ArrayList<Contorno> val, ArrayList<Stella> stelle){
        for (int k = 0; k < val.size() - 2; k++) {
            res = res + Math.atan(
                    (((val.get(k).getLonG() - stelle.get(r).getLonG()) * (val.get(k + 1).getLatG() - stelle.get(r).getLatG()))
                            - ((val.get(k).getLatG() - stelle.get(r).getLatG()) * (val.get(k + 1).getLonG() - stelle.get(r).getLonG())))
                            / (((val.get(k).getLonG() - stelle.get(r).getLonG()) * (val.get(k + 1).getLonG() - stelle.get(r).getLonG()))
                            + ((val.get(k).getLatG() - stelle.get(r).getLatG()) * (val.get(k + 1).getLatG() - stelle.get(r).getLatG())))
            );
        }

    }



    public static void main(String[] args){
        BeanPosBaseAltezza beanPosBaseAltezza=new BeanPosBaseAltezza();
        beanPosBaseAltezza.setAltezza((float)20);
        beanPosBaseAltezza.setBase((float)20);
        beanPosBaseAltezza.setLatG((float)0.0);
        beanPosBaseAltezza.setLonG((float) 0.0);
        System.out.println(ControlloreRStelleRegione.getInstance().searchStarsByRegionFromBean(beanPosBaseAltezza));
    }

}
