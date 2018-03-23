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
 * Created by alessandro on 21/03/18.
 */
@RunWith(value = Parameterized.class)
public class ControlloreRCentroideEstensioneTest {
    private BeanFilamento beanFilamento;
    private static final float DELTA = 0.0001f;

    @Parameterized.Parameters
    public static Collection<BeanFilamento> data() {
        BeanFilamento caso1 = new BeanFilamento();
        caso1.setIdFilamento(133);

        BeanFilamento caso2 = new BeanFilamento();
        caso2.setIdFilamento(1000);

        return Arrays.asList(caso1,caso2);
    }


    public ControlloreRCentroideEstensioneTest(BeanFilamento beanFilamento) {
        this.beanFilamento = beanFilamento;
    }




    @Test
    public void selectForIdOrNameFilCentroidExtensionFromBean() throws Exception {
        ArrayList<String> val = beanFilamento.selectForIdOrNameFilCentroidExtension();
        ArrayList<String> confronto = new ArrayList<>();

        confronto.add("13.5642");
        confronto.add("-1.1988");
        confronto.add("13.5348");
        confronto.add("13.6019");
        confronto.add("-1.2281");
        confronto.add("-1.1674");
        confronto.add("3");
        confronto.add("19.1886");
        confronto.add("1.69451");

        if(beanFilamento.getIdFilamento() == 133) {
            Assert.assertNotNull(val);

            for(int i=0; i<confronto.size(); i++) {
                Assert.assertEquals(Float.valueOf(val.get(i)),Float.valueOf(confronto.get(i)),DELTA);
            }
        }
        if(beanFilamento.getIdFilamento() == 1000) {
            Assert.assertNull(beanFilamento.selectForIdOrNameFilCentroidExtension());
        }

    }

}