package Test;

import Bean.BeanLogin;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by alessandro on 21/03/18.
 */

@RunWith(value = Parameterized.class)
public class ControlloreLoginTest {
    private BeanLogin beanLogin;

    @Parameterized.Parameters
    public static Collection<BeanLogin> data() {
        BeanLogin log = new BeanLogin();
        log.setUsername("MarcoR94");
        log.setPassword("marcobasi94");
        log.verifyLogin();

        BeanLogin logNo = new BeanLogin();
        logNo.setUsername("MarcoR93");
        logNo.setPassword("marcobasi93");
        logNo.verifyLogin();

        return Arrays.asList(log,logNo);
    }


    public ControlloreLoginTest(BeanLogin beanLogin) {
        this.beanLogin = beanLogin;
    }


    @Test
    public void verifyLoginFromBean() throws Exception {

        if(beanLogin.getUtente() == false) {
            Assert.assertEquals("Name isn't empty", null, beanLogin.getNome());
            Assert.assertEquals("Surname isn't empty", null, beanLogin.getCognome());
            Assert.assertEquals("Password isn't empty", "marcobasi93", beanLogin.getPassword());
            Assert.assertEquals("UserID isn't empty", "MarcoR93", beanLogin.getUsername());
            Assert.assertEquals("Email isn't empty", null, beanLogin.getEmail());
            Assert.assertEquals("Type isn't empty", null, beanLogin.getTipoUtente());
            Assert.assertFalse("the user results logged", beanLogin.getUtente());
        }
        if(beanLogin.getUtente() == true) {
            Assert.assertEquals("Name is wrong", "Marco", beanLogin.getNome());
            Assert.assertEquals("Surname is wrong", "Rossi", beanLogin.getCognome());
            Assert.assertEquals("Password is wrong", "marcobasi94", beanLogin.getPassword());
            Assert.assertEquals("UserID is wrong", "MarcoR94", beanLogin.getUsername());
            Assert.assertEquals("Email is wrong", "MarcoR94@gmail.com", beanLogin.getEmail());
            Assert.assertEquals("Type is wrong", "Amministratore", beanLogin.getTipoUtente());
            Assert.assertTrue("the user results logged", beanLogin.getUtente());
        }

    }

}