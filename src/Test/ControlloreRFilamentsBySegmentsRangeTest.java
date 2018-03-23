package Test;

import Bean.BeanSegmento;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * Created by Manuel on 23/03/2018.
 */

@RunWith(value = Parameterized.class)
public class ControlloreRFilamentsBySegmentsRangeTest {


   private int[] arrayInteri;

    @Parameterized.Parameters
    public static Collection<int[]> data() {

       int[] caso1=new int[2];
        caso1[0]=3;
        caso1[1]=5;

        int[] caso2=new int[2];
        caso2[0]=4;
        caso2[1]=6;

        int[] caso3=new int[2];
        caso3[0]=5;
        caso3[1]=7;

        int[] caso4=new int[2];
        caso4[0]=6;
        caso4[1]=8;

        int[] caso5=new int[2];
        caso4[0]=1;
        caso4[1]=1;


        return Arrays.asList(caso1,caso2,caso3,caso4,caso5);
    }

    public ControlloreRFilamentsBySegmentsRangeTest(int[] array) {
        this.arrayInteri=array;

    }


    @Test
    public void testSelectFilamentsBySegmentsNumber() throws Exception {

        BeanSegmento beanSegmento=new BeanSegmento();
        ArrayList<String[]> val=beanSegmento.selectFilamentsBySegmentsNumber(arrayInteri[0],arrayInteri[1]);
        if(val!=null){
            for(String[] s:val){
                Assert.assertEquals(true,Integer.valueOf(s[9])>=arrayInteri[0]&&Integer.valueOf(s[9])<=arrayInteri[1]);
            }

        }


    }

}