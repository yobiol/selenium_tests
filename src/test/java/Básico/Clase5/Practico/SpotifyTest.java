package Básico.Clase5.Practico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SpotifyTest {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/signup/");
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void SpotifyRegistrationTest(){
        String expectedMessage = "Este correo electrónico ya está conectado a una cuenta. Inicia sesión.";
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("confirm")).sendKeys("test@test.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Indicador de error']")));
        WebElement message = driver.findElement(By.xpath("//*[@aria-label='Indicador de error']"));
        Assert.assertEquals(message.getText(), expectedMessage);
    }
}
