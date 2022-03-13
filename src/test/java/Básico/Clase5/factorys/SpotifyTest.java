package Básico.Clase5.factorys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SpotifyTest {
    WebDriver driver;
    private String email;

    public SpotifyTest(String anEmail){
        this.email = anEmail;

    }

    @BeforeMethod
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

        driver.findElement(By.name("email")).sendKeys(email);
    }
}
