package Básico.Clase6.dataProviders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SpotifyTest {
    public WebDriver driver;
    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/");
    }

    @Test(dataProvider = "registro", dataProviderClass = DataProviderGenerator.class)
    public void spotifyRegistrationTest(String anEmail, String emailRecibido) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[href='https://www.spotify.com/uy/signup/']")).click();

        driver.findElement(By.name("email")).sendKeys(anEmail);
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(2000);
        if (emailRecibido.equals("email_vacio")){
            WebElement errorMsgElement = driver.findElement(By.xpath("//*[contains(text(), 'Es necesario que introduzcas tu correo electrónico.')]"));
            Assert.assertEquals(errorMsgElement.getText(), "Es necesario que introduzcas tu correo electrónico.", "Se esperaba el error del email vacío");
        }else if (emailRecibido.equals("email_ya_registrado")){
            WebElement errorMsgElement = driver.findElement(By.xpath("//*[contains(text(), 'Este correo electrónico ya está conectado a una cuenta. ')]"));
            Assert.assertEquals(errorMsgElement.getText(), "Este correo electrónico ya está conectado a una cuenta. Inicia sesión.", "Se esperaba el error del email ya registrado");
            Assert.assertTrue(errorMsgElement.getText().contains("ya está conectado a una cuenta"));
        }else if (emailRecibido.equals("email_invalido")){
            WebElement errorMsgElement = driver.findElement(By.xpath("//*[contains(text(), 'Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com')]"));
            Assert.assertEquals(errorMsgElement.getText(), "Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com", "Se esperaba el error del email inválido");
            List<WebElement> listaErrores = driver.findElements(By.xpath("//*[@aria-label='Indicador de error']"));
            Assert.assertEquals(listaErrores.size(), 9, "Se esperaban 9 mensajes de error");
        }else if (emailRecibido.equals("email_correcto")){
            List<WebElement> listaErrores = driver.findElements(By.xpath("//*[@aria-label='Indicador de error']"));
            Assert.assertEquals(listaErrores.size(), 8, "Se esperaban 8 mensajes de error");
        }


    }

    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(10000);
        driver.close();

    }
}
