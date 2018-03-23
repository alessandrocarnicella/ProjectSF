package Test;

import Bean.BeanScheletro;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ControlloreRDistanzaTest {

    private BeanScheletro beanScheletro;
    private static final float DELTA = 0f;
    private static final float DELTA2 = 0.0001f;

    @Parameterized.Parameters
    public static Collection<BeanScheletro> data() {

        BeanScheletro caso1 = new BeanScheletro();
        caso1.setIdSegmento(3);

        BeanScheletro caso2 = new BeanScheletro();
        caso2.setIdSegmento(334);

        BeanScheletro caso3 = new BeanScheletro();
        caso3.setIdSegmento(232323);

        return Arrays.asList(caso1,caso2,caso3);
    }

    public ControlloreRDistanzaTest(BeanScheletro beanScheletro) {
        this.beanScheletro = beanScheletro;
    }

    @Test
    // test sulla distanza, sul numero progressivo e il numero degli elementi trovati
    public void selectDistanceFromBean() throws Exception {
        ArrayList<String> val = beanScheletro.resultDistanceVertici();
        if (beanScheletro.getIdSegmento() == 3){

            Assert.assertEquals(4,val.size()/7);

            int i = 0;
            double distance = 0;
            double distance1 = 0;
            double distance2 = 0;
            double distance3 = 0;

            while (i<val.size()) {
                double lonv = Double.valueOf(val.get(i + 3));
                double latv = Double.valueOf(val.get(i + 4));
                double lonp = Double.valueOf(val.get(i + 5));
                double latp = Double.valueOf(val.get(i + 6));

                if (i == 0) {
                    distance = Math.sqrt(((lonv - lonp) * (lonv - lonp) + (latv - latp) * (latv - latp)));
                }
                if (i == 7) {
                    distance1 = Math.sqrt(((lonv - lonp) * (lonv - lonp) + (latv - latp) * (latv - latp)));
                }
                if (i == 14) {
                    distance2 = Math.sqrt(((lonv - lonp) * (lonv - lonp) + (latv - latp) * (latv - latp)));
                }
                if (i == 21) {
                    distance3 = Math.sqrt(((lonv - lonp) * (lonv - lonp) + (latv - latp) * (latv - latp)));
                }
                i=i+7;
            }

            Assert.assertEquals(1,Integer.valueOf(val.get(2)),DELTA);
            Assert.assertEquals(262.8564,(float)distance,DELTA2);
            Assert.assertEquals(51,Integer.valueOf(val.get(9)),DELTA);
            Assert.assertEquals(262.8550,(float)distance1,DELTA2);
            Assert.assertEquals(1,Integer.valueOf(val.get(16)),DELTA);
            Assert.assertEquals(97.2203,(float)distance2,DELTA2);
            Assert.assertEquals(27,Integer.valueOf(val.get(23)),DELTA);
            Assert.assertEquals(97.2241,(float)distance3,DELTA2);
        }

        if (beanScheletro.getIdSegmento()==334){
            Assert.assertEquals(6,val.size()/7);
        }

        if (beanScheletro.getIdSegmento()== 232323){
            Assert.assertNull(val);
        }

    }

}