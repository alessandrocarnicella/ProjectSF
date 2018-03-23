package Test;

import Bean.BeanPosRaggioLato;
import Entity.Filamento;
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
public class ControlloreRCerchioQuadratoTest {
    private BeanPosRaggioLato beanPosRaggioLato;
    private static final float DELTA = 0f;

    @Parameterized.Parameters
    public static Collection<BeanPosRaggioLato> data() {

        BeanPosRaggioLato caso1 = new BeanPosRaggioLato();
        caso1.setLatG(0f);
        caso1.setLonG(0f);
        caso1.setRaggio(5.0f);

        BeanPosRaggioLato caso2 = new BeanPosRaggioLato();
        caso2.setLatG(0f);
        caso2.setLonG(0f);
        caso2.setLato(10.0f);

        BeanPosRaggioLato caso3 = new BeanPosRaggioLato();
        caso3.setLatG(0.0f);
        caso3.setLonG(0.0f);
        caso3.setLato(10000.0f);

        BeanPosRaggioLato caso4 = new BeanPosRaggioLato();
        caso4.setLatG(0.0f);
        caso4.setLonG(0.0f);
        caso4.setRaggio(10000.0f);

        BeanPosRaggioLato caso5 = new BeanPosRaggioLato();
        caso5.setLatG(0.0f);
        caso5.setLonG(0.0f);
        caso5.setLato(1.0f);

        BeanPosRaggioLato caso6 = new BeanPosRaggioLato();
        caso6.setLatG(0.0f);
        caso6.setLonG(0.0f);
        caso6.setRaggio(1.0f);


        return Arrays.asList(caso1,caso2,caso3,caso4,caso5,caso6);
    }


    public ControlloreRCerchioQuadratoTest(BeanPosRaggioLato beanPosRaggioLato) {
        this.beanPosRaggioLato = beanPosRaggioLato;
    }



    @Test
    public void selectForRegionePosSpazialeFromBean() throws Exception {
        ArrayList<Filamento> val = beanPosRaggioLato.selectFilamentoFromBean();

        float raggio = beanPosRaggioLato.getRaggio();
        float lato = beanPosRaggioLato.getLato();

        Filamento confronto = new Filamento();
        confronto.setIdFilamento(1051462);
        confronto.setNome("HiGALFil005.0970-0.1082");
        confronto.setFlussoTotale(2.7059E25f);
        confronto.setDensitaMedia(4.0985E21f);
        confronto.setTemperaturaMedia(19.72f);
        confronto.setEllitticita(3.125f);
        confronto.setContrasto(1.6014f);
        confronto.setNomeSatellite("Herschel");
        confronto.setNomeStrumento("SPIRE");

        if (raggio == 5.0f) {
            Assert.assertEquals(4, val.size());
            Assert.assertEquals(confronto.getIdFilamento(),val.get(0).getIdFilamento());
            Assert.assertEquals(confronto.getNome(),val.get(0).getNome());
            Assert.assertEquals(confronto.getFlussoTotale(),val.get(0).getFlussoTotale(),DELTA);
            Assert.assertEquals(confronto.getDensitaMedia(),val.get(0).getDensitaMedia(),DELTA);
            Assert.assertEquals(confronto.getTemperaturaMedia(),val.get(0).getTemperaturaMedia(),DELTA);
            Assert.assertEquals(confronto.getEllitticita(),val.get(0).getEllitticita(),DELTA);
            Assert.assertEquals(confronto.getContrasto(),val.get(0).getContrasto(),DELTA);
            Assert.assertEquals(confronto.getNomeStrumento(),val.get(0).getNomeStrumento());
            Assert.assertEquals(confronto.getNomeSatellite(),val.get(0).getNomeSatellite());
        }
        if (lato == 10.0f) {
            Assert.assertEquals(6, val.size());
        }
        if (raggio == 10000.0f ) {
            Assert.assertEquals(11450, val.size());
        }
        if (lato == 1.0f ) {
            Assert.assertNull(val);
        }
        if ( lato == 100500.0f) {
            Assert.assertEquals(11450, val.size());
        }
        if (raggio == 1.0f) {
            Assert.assertNull(val);
        }
    }

}