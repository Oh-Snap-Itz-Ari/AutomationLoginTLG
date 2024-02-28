package Test;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest{

    public static WebDriver driver;
    public LoginPage loginPage;

    static final String APP_URL = "https://mylearningapp.tec.mx/signin";
    static final String HOST_URL = "http://localhost:4444";

    @BeforeMethod
    public void beforeMethod(){

        ChromeOptions opts = new ChromeOptions();

        try {
            driver = new RemoteWebDriver(new URL(HOST_URL), opts);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

        /* Los siguientes elementos se desactivan para correr Docker:
        opts.addArguments("--disable-notifications"); // Permite desactivar las notificaciones de Chrome
        opts.addArguments("--start-maximized"); // Permite iniciar Chrome Maximizado
        driver = new ChromeDriver(opts); */

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(APP_URL);

        loginPage = new LoginPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

}
