package Test;

import Bean.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;


/**
 * Created by Manuel on 21/03/2018.
 */
@RunWith(value = Parameterized.class)
public class ControlloreInserimentoDatiTest {

    private BeanLogin beanLogin;

    //constructor
    public ControlloreInserimentoDatiTest(BeanLogin beanLogin) {
        this.beanLogin = beanLogin;
    }


    @Parameterized.Parameters
    public static Collection<BeanLogin> data() {

        BeanLogin beanLogin = new BeanLogin();
        beanLogin.setUsername("MarcoR94");
        beanLogin.setPassword("marcobasi94");
        beanLogin.verifyLogin();

        BeanLogin beanLogin2 = new BeanLogin();
        beanLogin2.setUsername("FrancoG94");
        beanLogin2.setPassword("francobasi94");
        beanLogin2.verifyLogin();

        return Arrays.asList(beanLogin, beanLogin2);
    }


    @Test
    //test sull'inserimento di un nuovo utente nel sistema
    public void testInsertNewUser() throws Exception {
        if (beanLogin.getTipoUtente().equals("Amministratore")) {

            BeanRegistrazione beanRegistrazione = new BeanRegistrazione();
            beanRegistrazione.setNome("nuovoUtenteNome");
            beanRegistrazione.setCognome("nuovoUtenteCognome");
            beanRegistrazione.setUsername("nuovoUtenteUsername");
            beanRegistrazione.setPassword("nuovoUtentePassword");
            beanRegistrazione.setEmail("nuovoUtenteEmail");
            beanRegistrazione.setTipoUtente("nuovoUtenteTipoUtente");

            Assert.assertEquals(true, beanRegistrazione.insertNewUtente());

        } else {
            Assert.assertEquals("utenteRegistrato", beanLogin.getTipoUtente());
        }
    }


    @Test
    //test sull'inserimento di un utente gia' registrato nel sistema
    public void testUserAlreadyInserted() throws Exception {
        if (beanLogin.getTipoUtente().equals("Amministratore")) {

            BeanRegistrazione beanRegistrazione2 = new BeanRegistrazione();
            beanRegistrazione2.setNome("Marco");
            beanRegistrazione2.setCognome("Rossi");
            beanRegistrazione2.setUsername("MarcoR94");
            beanRegistrazione2.setPassword("marcobasi94");
            beanRegistrazione2.setEmail("MarcoR94@gmail.com");
            beanRegistrazione2.setTipoUtente("Amministratore");

            Assert.assertEquals(false, beanRegistrazione2.insertNewUtente());

        } else {
            Assert.assertEquals("utenteRegistrato", beanLogin.getTipoUtente());
        }
    }


    @Test
    //test sull'inserimento di un nuovo satellite all'interno del sistema
    public void testInsertNewSatellite() throws Exception {

        if (beanLogin.getTipoUtente().equals("Amministratore")) {

            BeanSatellite beanSatellite = new BeanSatellite();
            beanSatellite.setNome("nuovoSatelliteNome");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date javaDate = sdf.parse("2018/10/06");
            Date javaDate2 = sdf.parse("2018/10/07");
            java.sql.Date dataInizio = new java.sql.Date(javaDate.getTime());
            java.sql.Date dataFine = new java.sql.Date(javaDate2.getTime());

            beanSatellite.setDataInizio(dataInizio);
            beanSatellite.setDataFine(dataFine);
            beanSatellite.setNomeAgenzia("ESA");

            Assert.assertEquals(true, beanSatellite.insertNewSatellite());

        } else {
            Assert.assertEquals("utenteRegistrato", beanLogin.getTipoUtente());
        }

    }


    @Test
    public void testInsertNewStrumentoBandaMisurazione() throws Exception {
        if (beanLogin.getTipoUtente().equals("Amministratore")) {

            BeanStrumento beanStrumento = new BeanStrumento();
            beanStrumento.setNome("nuovoStrumentoNome");
            beanStrumento.setNomeSatellite("Herschel");

            BeanBanda beanBanda = new BeanBanda();
            beanBanda.setLunghezza(20.65f);

            BeanMisurazione beanMisurazione = new BeanMisurazione();
            beanMisurazione.setNomeStrumento(beanStrumento.getNome());
            beanMisurazione.setBanda(beanBanda.getLunghezza());

            Assert.assertEquals(true, beanStrumento.insertNewStrumento() && beanBanda.insertNewBanda() && beanMisurazione.insertNewMisurazione());

        } else {
            Assert.assertEquals("utenteRegistrato", beanLogin.getTipoUtente());
        }

    }
}