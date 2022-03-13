package Intermedio.Clase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio5 {
    public WebDriver driver;


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver =  new ChromeDriver();
        driver.get("https://www.bbc.com/");
    }

    @Test
    public void bbcTest() throws InterruptedException {
        WebElement divList = driver.findElement(By.tagName("div"));
      //  System.out.println("Cantidad de elementos div: " + divList.size());
        Thread.sleep(3000);
        List<WebElement> pElements = divList.findElements(By.tagName("p"));
        for (WebElement p: pElements){
            System.out.println(p.getText());
        }
    }

    @Test
    public void cantidadId() throws InterruptedException {
        int cont = 0;
        Thread.sleep(1000);
        List<WebElement> divList = driver.findElements(By.tagName("div"));
        for (WebElement div : divList){
            if (div.getAttribute("id").isEmpty() ==false){
                cont++;
            }
        }
        System.out.println("La cantidad de div con id es " + cont);
    }

}
