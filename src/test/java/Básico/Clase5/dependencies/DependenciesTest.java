package Básico.Clase5.dependencies;

import Básico.Clase5.refactoring.SpotifyFillingForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DependenciesTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/");
    }

    @Test
    public void landingPageTest(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.spotify.com/uy/", "Se esperaba otra URL");
        Assert.assertEquals(driver.getTitle(), "Escuchar es todo - Spotify", "Se esperaba otro título");
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.spotify.com/uy/signup/", "Se esperaba otra URL");
        Assert.assertEquals(driver.getTitle(), "Registrarte - Spotify", "Se esperaba otro título");

    }

    @Test (dependsOnMethods = {"landingPageTest"})
    public void fillingFieldsTest() throws InterruptedException {
        SpotifyFillingForm spotifyFillingForm = new SpotifyFillingForm(driver);
        spotifyFillingForm.fillingFields("test@test.com","test@test.com", "holamundo123", "Test", "12" );
        Thread.sleep(2000);
    }

    @Test (dependsOnMethods = {"fillingFieldsTest"})
    public void validateErrorMessage(){
        WebElement emailAlreadyRegisteredError = driver.findElement(By.xpath("//*[@aria-label='Indicador de error']"));
        Assert.assertEquals(emailAlreadyRegisteredError.getText(), "Este correo electrónico ya está conectado a una cuenta. Inicia sesión.", "Se esperaba un mensaje de error ya que el email ya está registrado");
        Assert.assertTrue(emailAlreadyRegisteredError.getText().contains("Este correo electrónico ya está conectado a una cuenta."), "Error, se esperaba otro mensaje de error");
        Assert.assertTrue(emailAlreadyRegisteredError.getText().contains("Inicia sesión."), "Error, se esperaba otro mensaje de error");
    }

    /*@Test
    public void registrationSuccessTest() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        SpotifyFillingForm spotifyFillingForm = new SpotifyFillingForm(driver);
        spotifyFillingForm.fillingFields("testing2021selenium@testing.com","testing2021selenium@testing.com", "holamundo123", "Test", "12" );

        Thread.sleep(2000);

        List<WebElement> errorList = driver.findElements(By.xpath("//*[@aria-label='Indicador de error']"));
        Assert.assertEquals(errorList.size(),0, "No deberían existir errores!");
        Assert.assertTrue(errorList.isEmpty());
    }*/

}
