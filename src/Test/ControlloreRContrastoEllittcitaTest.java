package Test;

import Bean.BeanBrillantezzaEllitticita;
import Entity.Filamento;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Manuel on 22/03/2018.
 */

@RunWith(value = Parameterized.class)
public class ControlloreRContrastoEllittcitaTest {

    private BeanBrillantezzaEllitticita beanBrillantezzaEllitticita;
    private static final float DELTA = 0f;

    @Parameterized.Parameters
    public static Collection<BeanBrillantezzaEllitticita> data() {

        BeanBrillantezzaEllitticita BBe=new BeanBrillantezzaEllitticita();
        BBe.setBrillantezza(1f);
        BBe.setMaxEllitticita(1f);
        BBe.setMinEllitticita(1f);

        return Arrays.asList(BBe);
    }

    public ControlloreRContrastoEllittcitaTest(BeanBrillantezzaEllitticita beanBrillantezzaEllitticita) {
        this.beanBrillantezzaEllitticita =  beanBrillantezzaEllitticita;
    }



    @Test
    public void selectFilamentoFromBean() throws Exception {

        ArrayList<Filamento> val=beanBrillantezzaEllitticita.selectFilamentoFromBean();

        Filamento confronto = new Filamento();
        confronto.setIdFilamento(7537);
        confronto.setNome("SDC328.251-0.301");
        confronto.setFlussoTotale(53.9f);
        confronto.setDensitaMedia(1.2908896E23f);
        confronto.setTemperaturaMedia(12.43f);
        confronto.setEllitticita(1.0f);
        confronto.setContrasto(1.74419f);
        confronto.setNomeSatellite("Spitzer");
        confronto.setNomeStrumento("IRAC");

        if(val!=null){
            Assert.assertEquals(confronto.getIdFilamento(),val.get(0).getIdFilamento());
            Assert.assertEquals(confronto.getNome(),val.get(0).getNome());
            Assert.assertEquals(confronto.getFlussoTotale(),val.get(0).getFlussoTotale(),DELTA);
            Assert.assertEquals(confronto.getDensitaMedia(),val.get(0).getDensitaMedia(),DELTA);
            Assert.assertEquals(confronto.getTemperaturaMedia(),val.get(0).getTemperaturaMedia(),DELTA);
            Assert.assertEquals(confronto.getEllitticita(),val.get(0).getEllitticita(),DELTA);
            Assert.assertEquals(confronto.getContrasto(),val.get(0).getContrasto(),DELTA);
            Assert.assertEquals(confronto.getNomeSatellite(),val.get(0).getNomeSatellite());
            Assert.assertEquals(confronto.getNomeStrumento(),val.get(0).getNomeStrumento());

            Assert.assertEquals(true,val.get(0).getEllitticita()>=beanBrillantezzaEllitticita.getMinEllitticita());
            Assert.assertEquals(true,val.get(0).getEllitticita()<=beanBrillantezzaEllitticita.getMaxEllitticita());


            Assert.assertEquals(true,val.get(0).getContrasto()>1.01);

        }



    }

}