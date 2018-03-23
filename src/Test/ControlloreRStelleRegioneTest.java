package Test;

import Bean.BeanPosBaseAltezza;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Manuel on 23/03/2018.
 */
@RunWith(value = Parameterized.class)
public class ControlloreRStelleRegioneTest {

    private BeanPosBaseAltezza beanPosBaseAltezza;
    private static final float DELTA = 0f;
    private static final float DELTA2 = 0.01f;

    @Parameterized.Parameters
    public static Collection<BeanPosBaseAltezza> data() {

        BeanPosBaseAltezza BPa=new BeanPosBaseAltezza();
        BPa.setLonG(0.0f);
        BPa.setLatG(0.0f);
        BPa.setBase(10f);
        BPa.setAltezza(20f);

        return Collections.singletonList(BPa);
    }

    public ControlloreRStelleRegioneTest( BeanPosBaseAltezza beanPosBaseAltezza) {
        this.beanPosBaseAltezza =   beanPosBaseAltezza;
    }


    @Test
    // test sul numero di stelle trovate non trovate e il loro tipo
    public void testSearchStarsByRegion() throws Exception {
        ArrayList<String> val=beanPosBaseAltezza.searchStarsByRegion();
        if(val!=null){
            Assert.assertEquals(3445,Float.valueOf(val.get(0)),DELTA);
            Assert.assertEquals(19.91,Float.valueOf(val.get(1)),DELTA2);
            Assert.assertEquals(67.02,Float.valueOf(val.get(2)),DELTA2);
            Assert.assertEquals(13.06,Float.valueOf(val.get(3)),DELTA2);
            Assert.assertEquals(47,Float.valueOf(val.get(4)),DELTA);
            Assert.assertEquals(12.76,Float.valueOf(val.get(5)),DELTA2);
            Assert.assertEquals(74.46,Float.valueOf(val.get(6)),DELTA2);
            Assert.assertEquals(12.76,Float.valueOf(val.get(7)),DELTA2);

            //totale stelle
            Assert.assertEquals(3492,Float.valueOf(val.get(0))+Float.valueOf(val.get(4)),DELTA);

        }




    }

}