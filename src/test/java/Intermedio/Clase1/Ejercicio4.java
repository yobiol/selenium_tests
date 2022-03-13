package Intermedio.Clase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio4 {
    public WebDriver driver;


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver =  new ChromeDriver();
        driver.get("https://www.netflix.com/uy/");
    }

    @Test
    public void netflixTest(){
         List<WebElement> formElement = driver.findElements(By.tagName("form"));
         System.out.println("Cantidad de elementos form: " + formElement.size());

         for(WebElement form: formElement){
            List<WebElement> h3Elements = form.findElements(By.tagName("h3"));
            System.out.println("Cantidad de elementos h3: " + h3Elements.size());

            for(WebElement h3: h3Elements){
                System.out.println(h3.getText());
            }

         }
    }
}
