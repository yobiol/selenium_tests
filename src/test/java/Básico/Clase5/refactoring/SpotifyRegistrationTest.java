package Básico.Clase5.refactoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SpotifyRegistrationTest {
   public WebDriver driver;
   public WebDriverWait wait;
    //private ExpectedConditions expectedConditions;


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/");
     //   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void registrationEmailAlreadyRegisteredTest() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        wait.until(ExpectedConditions.urlToBe("https://www.spotify.com/uy/signup/"));
        wait.until(ExpectedConditions.titleIs("Spotify - Registrarte"));

        SpotifyFillingForm spotifyFillingForm = new SpotifyFillingForm(driver);
        spotifyFillingForm.fillingFields("test@test.com","test@test.com", "holamundo123", "Test", "12" );

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='Indicador de error']")));
        WebElement emailAlreadyRegisteredError = driver.findElement(By.xpath("//*[@aria-label='Indicador de error']"));
        Assert.assertEquals(emailAlreadyRegisteredError.getText(), "Este correo electrónico ya está conectado a una cuenta. Inicia sesión.", "Se esperaba un mensaje de error ya que el email ya está registrado");
        Assert.assertTrue(emailAlreadyRegisteredError.getText().contains("Este correo electrónico ya está conectado a una cuenta."), "Error, se esperaba otro mensaje de error");
        Assert.assertTrue(emailAlreadyRegisteredError.getText().contains("Inicia sesión."), "Error, se esperaba otro mensaje de error");
    }


    @Test
    public void registrationSuccessTest() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        SpotifyFillingForm spotifyFillingForm = new SpotifyFillingForm(driver);
        spotifyFillingForm.fillingFields("testing2021selenium@testing.com","testing2021selenium@testing.com", "holamundo123", "Test", "12" );

        List<WebElement> errorList = driver.findElements(By.xpath("//*[@aria-label='Indicador de error']"));
        Assert.assertEquals(errorList.size(),0, "No deberían existir errores!");
        Assert.assertTrue(errorList.isEmpty());
    }

}
