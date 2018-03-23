package Test;

import Bean.BeanFilamento;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by alessandro on 22/03/18.
 */
@RunWith(value = Parameterized.class)
public class ControlloreRDistanceStelleSpinaDorsaleTest {
    private BeanFilamento beanFilamento;
    private static final float DELTA = 0f;
    @Parameterized.Parameters
    public static Collection<BeanFilamento> data() {

        BeanFilamento caso1 = new BeanFilamento();
        caso1.setIdFilamento(1013661);
        caso1.setOrdinamento("orddistanza");

        BeanFilamento caso2 = new BeanFilamento();
        caso2.setIdFilamento(1013661);
        caso2.setOrdinamento("ordflusso");

        BeanFilamento caso3 = new BeanFilamento();
        caso3.setIdFilamento(45);
        caso3.setOrdinamento("orddistanza");


        return Arrays.asList(caso1,caso2,caso3);
    }


    public ControlloreRDistanceStelleSpinaDorsaleTest(BeanFilamento beanFilamento) {
        this.beanFilamento = beanFilamento;
    }

    @Test
    public void searchDistanceStelleSpinaDorsaleFromBean() throws Exception {
        ArrayList<String[]> val = beanFilamento.searchDistance();

        if(beanFilamento.getIdFilamento() == 45){
            Assert.assertNull(val);
        }

        if (beanFilamento.getIdFilamento() == 1013661){

            Assert.assertEquals(20,val.size());

            if (beanFilamento.getOrdinamento().equals("orddistanza")){
                for (int i = 0; i<val.size()-1; i++ ){
                    Assert.assertTrue(Float.valueOf(val.get(i)[8])< Float.valueOf(val.get(i+1)[8]));
                }
            }
            if (beanFilamento.getOrdinamento().equals("ordflusso")){
                for (int i = 0; i<val.size()-1; i++ ){
                    Assert.assertTrue(Float.valueOf(val.get(i)[3])< Float.valueOf(val.get(i+1)[3]));
                }
            }
        }

    }

}