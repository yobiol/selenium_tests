package Básico.Clase4.EjercicioGit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class SpotifyTestWithParameters {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/");
    }

    @Test
    @Parameters({"tag"})
    public void spotifyTags(@Optional("h4") String tagNameParameter) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> tags = driver.findElements(By.tagName(tagNameParameter));
        for (WebElement elementos: tags){
            System.out.println("Elementos: " + elementos.getText());
        }
    }
}
