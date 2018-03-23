package Test;

import Bean.BeanFilamento;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


@RunWith(value = Parameterized.class)
public class ControlloreRStelleInFilamentoTest {

    private BeanFilamento beanFilamento;
    private static final float DELTA = 0f;
    private static final float DELTA2 = 0.001f;

    @Parameterized.Parameters
    public static Collection<BeanFilamento> data() {

        BeanFilamento caso1 = new BeanFilamento();
        caso1.setIdFilamento(1013661);

        BeanFilamento caso2 = new BeanFilamento();
        caso2.setIdFilamento(59);

        BeanFilamento caso3 = new BeanFilamento();
        caso3.setIdFilamento(132);

        return Arrays.asList(caso1,caso2,caso3);
    }


    public ControlloreRStelleInFilamentoTest(BeanFilamento beanFilamento) {
        this.beanFilamento = beanFilamento;
    }

    @Test
    // test sul numero di stelle trovate e sul tipo
    public void searchStarsInFilamentFromBean() throws Exception {

        ArrayList<String> val = beanFilamento.searchStarsInFilament();

        if(beanFilamento.getIdFilamento() == 59){
            Assert.assertEquals(1,Integer.valueOf(val.get(0)),DELTA);
            Assert.assertEquals(0,Float.valueOf(val.get(1)),DELTA2);
            Assert.assertEquals(100,Float.valueOf(val.get(2)),DELTA2);
            Assert.assertEquals(0,Float.valueOf(val.get(3)),DELTA2);
        }

        if(beanFilamento.getIdFilamento() == 1013661){
            Assert.assertEquals(20,Integer.valueOf(val.get(0)),DELTA);
            Assert.assertEquals(40,Float.valueOf(val.get(1)),DELTA2);
            Assert.assertEquals(60,Float.valueOf(val.get(2)),DELTA2);
            Assert.assertEquals(0,Float.valueOf(val.get(3)),DELTA2);
        }

        if(beanFilamento.getIdFilamento() == 123){
            Assert.assertNull(val);

        }
    }

}