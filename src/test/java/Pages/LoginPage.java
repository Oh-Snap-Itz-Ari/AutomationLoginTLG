package Pages;

import Data.User;
import Test.TestUtility;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@name='email']")
    private WebElement campoEmail;
    @FindBy(xpath = "//*[@name='password']")
    private WebElement campoPassword;
    @FindBy(xpath = "//*[contains (text(),'Iniciar sesión')]")
    private WebElement loginButton;
    @FindBy(xpath = "//*[contains(text(),'Área Temática')]")
    private WebElement usuarioLogueado;

    public  LoginPage(WebDriver driver){
        this.driver= driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(this.driver,this);
    }

    public void Login(User user) throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        campoEmail.clear();
        campoEmail.sendKeys(user.email);
        Allure.addAttachment("Ingresando el Correo Electrónico", TestUtility.getScreenshotPathAsFileStream());
        campoPassword.clear();
        campoPassword.sendKeys(user.password);
        Allure.addAttachment("Ingresando la Contraseña", TestUtility.getScreenshotPathAsFileStream());
        loginButton.click();
    }

    public boolean LoginConfirm() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(usuarioLogueado));
        Allure.addAttachment("Usuario con Sesión Iniciada Correctamente", TestUtility.getScreenshotPathAsFileStream());
        return usuarioLogueado.isDisplayed();
    }

}
