package Control;

import Bean.BeanFilamento;
import Bean.BeanPosBaseAltezza;
import DAO.DAOContorno;
import DAO.DAOStelle;
import Entity.Contorno;
import Entity.Punto;
import Entity.Stella;

import java.util.ArrayList;
import java.util.Arrays;
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

        ArrayList<String> val= new ArrayList<>();
        ArrayList<Stella> stelle = new ArrayList<>();
        ArrayList<Contorno> puntiContorno = new ArrayList<>();

        ArrayList<String> strStelle = DAOStelle.getInstance().searchStarsByRegionFromDB(beanPosBaseAltezza);
        ArrayList<String> strContorno = DAOContorno.getInstance().selectAllPointsFromDB();

        if(strStelle == null || strContorno == null){
            return null;
        }

        int i = 0;
        int j = 0;
        Double result = 0.0;
        int num = 0;


        while (i < strStelle.size()){
            Stella Stella = new Stella(Integer.valueOf(strStelle.get(i)),String.valueOf(strStelle.get(i+1)),Float.valueOf(strStelle.get(i+2)), Float.valueOf(strStelle.get(i+3)),Float.valueOf(strStelle.get(i+4)),strStelle.get(i+5));
            i = i+6;
            stelle.add(Stella);
        }
        System.out.println(stelle.size());
        while (j < strContorno.size()){
            Contorno singoloPuntoContorno = new Contorno(Integer.valueOf(strContorno.get(j)),Float.valueOf(strContorno.get(j+1)),Float.valueOf(strContorno.get(j+2)));
            j = j+3;
            puntiContorno.add(singoloPuntoContorno);
        }

        ArrayList<ArrayList<Contorno>> tuttiContorni = new ArrayList<>();

        int k = 0;
        int count = 0;
        while (k < puntiContorno.size()) {
            int w = k;
            ArrayList<Contorno> singoloContorno = new ArrayList<>();
            singoloContorno.add(puntiContorno.get(k));
            while (w < puntiContorno.size() - 1) {
                if((puntiContorno.get(k).getIdFilamento() == puntiContorno.get(w+1).getIdFilamento())){
                    //if(puntiContorno.get(k).getIdFilamento() == puntiContorno.get(w+1).getIdFilamento()){
                    singoloContorno.add(puntiContorno.get(w+1));
                    //System.out.println(puntiContorno.get(w+1).getIdFilamento());
                }
                else{
                    //System.out.println("break");
                    break;
                }
                w = w+1;
            }
            count++;
            //System.out.println(count);
            k = k + singoloContorno.size();
            tuttiContorni.add(singoloContorno);
        }
        //System.out.println(tuttiContorni.size());
        //System.out.println(puntiContorno.size());
/*
        for (int n=0; n<tuttiContorni.size();n++ ){
            int cont = 0;
            for (int m=0; m<tuttiContorni.get(n).size();m++ ){
                    System.out.println((tuttiContorni.get(n).get(m).getIdFilamento()));

                cont++;
            }
            System.out.println("cont: "+cont);
            System.out.println("----");
        }
*/
        int a = 0;
        int b = 0;
        //verifica presenza di una stella nei punti di un controno
        for (int x = 0; x < stelle.size();x++) {
            if (!trovaStella(stelle.get(x),tuttiContorni)){
                notFoundStars(stelle.get(x));
               // System.out.println("non"+a);
            } else {
                // System.out.println("si "+b);
            }
            a++;
             System.out.println("st: "+a);
        }


        Float perPROTrov = ((float)st_ProtTrov/(float) stelleTrovate)*100;
        Float perPRETrov = ((float)st_PretTrov/(float) stelleTrovate)*100;
        Float perUNBTrov = ((float)st_UnbTrov/(float) stelleTrovate)*100;

        Float perPRONonTrov = ((float)st_ProtNonTrov/(float) stelleNonTrovate)*100;
        Float perPRENonTrov = ((float)st_PretNonTrov/(float) stelleNonTrovate)*100;
        Float perUNBNonTrov = ((float)st_UnbNonTrov/(float) stelleNonTrovate)*100;


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
    private boolean trovaStella (Stella stella, ArrayList<ArrayList<Contorno>> tuttiContorni ){


        boolean trovata = false;

        for(int k = 0; k < tuttiContorni.size(); k++){

            Double result=0.0;

            for(int j = 0; j < tuttiContorni.get(k).size()-1;j++) {

                result = result + Math.atan(
                        (((tuttiContorni.get(k).get(j).getLonG() - stella.getLonG()) * (tuttiContorni.get(k).get(j+1).getLatG() - stella.getLatG()))
                                - ((tuttiContorni.get(k).get(j).getLatG() - stella.getLatG()) * (tuttiContorni.get(k).get(j+1).getLonG() - stella.getLonG())))
                                / (((tuttiContorni.get(k).get(j).getLonG() - stella.getLonG()) * (tuttiContorni.get(k).get(j+1).getLonG() - stella.getLonG()))
                                + ((tuttiContorni.get(k).get(j).getLatG() - stella.getLatG()) * (tuttiContorni.get(k).get(j+1).getLatG() - stella.getLatG())))
                );
                /*
                result = result + Math.atan(
                        ((
                                (tuttiContorni.get(k).get(j).getLonG() - stella.getLonG())
                                        * (tuttiContorni.get(k).get(j + 1).getLatG() - stella.getLatG())
                        )
                                -
                                (
                                        (tuttiContorni.get(k).get(j).getLatG() - stella.getLatG())
                                                * (tuttiContorni.get(k).get(j + 1).getLonG() - stella.getLonG())
                                ))
                                /

                                ((
                                        (tuttiContorni.get(k).get(j).getLonG() - stella.getLonG())
                                                * (tuttiContorni.get(k).get(j + 1).getLonG() - stella.getLonG())
                                )
                                        +
                                        (
                                                (tuttiContorni.get(k).get(j).getLatG() - stella.getLatG())
                                                        * (tuttiContorni.get(k).get(j + 1).getLatG() - stella.getLatG())
                                        ))
                );
                */
            }

            //System.out.println(Math.toRadians(result));
            if (Math.abs(Math.toRadians(result)) >= 0.01){
                foundStars(stella);
                result = 0.0;
                trovata =  true;
                break;
            }else {
                result = 0.0;
            }
        }

        if (trovata){
            return true;
        }else{
            return false;
        }
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

    /*

    //method
    private double arctanCondition(Double res,int r, ArrayList<Contorno> val, ArrayList<Stella> stelle){
        for (int k = 0; k < val.size() - 2; k++) {
            res = res + Math.atan(
                    (((val.get(k).getLonG() - stelle.get(r).getLonG()) * (val.get(k + 1).getLatG() - stelle.get(r).getLatG()))
                            - ((val.get(k).getLatG() - stelle.get(r).getLatG()) * (val.get(k + 1).getLonG() - stelle.get(r).getLonG())))
                            / (((val.get(k).getLonG() - stelle.get(r).getLonG()) * (val.get(k + 1).getLonG() - stelle.get(r).getLonG()))
                            + ((val.get(k).getLatG() - stelle.get(r).getLatG()) * (val.get(k + 1).getLatG() - stelle.get(r).getLatG())))
            );
        }
        return res;
    }


*/
    public static void main(String[] args){
        BeanPosBaseAltezza beanPosBaseAltezza = new BeanPosBaseAltezza();
        beanPosBaseAltezza.setAltezza((float)100000);
        beanPosBaseAltezza.setBase((float)1000000);
        beanPosBaseAltezza.setLatG((float)0.0);
        beanPosBaseAltezza.setLonG((float) 0.0);
        System.out.println(ControlloreRStelleRegione.getInstance().searchStarsByRegionFromBean(beanPosBaseAltezza));
    }

}
