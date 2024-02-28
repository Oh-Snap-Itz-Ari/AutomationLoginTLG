package Test;

import Listener.AllureListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static Data.User.User;

@Listeners(AllureListener.class)
public class TheLearningGateTest extends BaseTest {

    @Test
    public void testIniciarSesion() throws IOException {
        loginPage.Login(User);
        Assert.assertTrue(loginPage.LoginConfirm());
    }

}
