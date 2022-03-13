package Básico.Clase5.Practico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

public class TestParametrizables {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/signup/");
    }

    @Test
    @Parameters({"tag"})
    public void pruebaConParametros (@Optional("h2") String tagName){
        List<WebElement> listaElementos  = driver.findElements(By.tagName(tagName));
         //for (WebElement elemento: listaElementos){
            if (tagName.equals("h1")){
                System.out.println("H1");
            } else if (tagName.equals("h2")){
                System.out.println("H2");
            }else if (tagName.equals("h3")){
                System.out.println("H3");
            }
        //}

    }


}
