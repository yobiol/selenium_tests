package Básico.Clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XPatchTest {
    public static WebDriver getSpotifyriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spotify.com/");
        return driver;
    }

    @Test
    public static void fullRegistrationTest() throws InterruptedException {
        WebDriver driver = getSpotifyriver();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        //Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@placeholder= 'Introduce tu correo electrónico.']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//*[@placeholder= 'Vuelve a introducir tu correo electrónico.']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//*[@placeholder= 'Crea una contraseña.']")).sendKeys("testing1");
        driver.findElement(By.xpath("//*[@placeholder= 'Introduce un nombre de perfil.']")).sendKeys("Yisel");

    }

    @Test
    public static void cssSelectorByPlaceHolder() throws InterruptedException {
        WebDriver driver = getSpotifyriver();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[href='https://www.spotify.com/uy/signup/']")).click();
        driver.findElement(By.cssSelector("input[placeholder= 'Introduce tu correo electrónico.']")).sendKeys("test@test.com");
        /*driver.findElement(By.xpath("//*[@placeholder= 'Introduce tu correo electrónico.']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//*[@placeholder= 'Vuelve a introducir tu correo electrónico.']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//*[@placeholder= 'Crea una contraseña.']")).sendKeys("testing1");
        driver.findElement(By.xpath("//*[@placeholder= 'Introduce un nombre de perfil.']")).sendKeys("Yisel");*/

    }
}
