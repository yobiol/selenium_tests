package Intermedio.Clase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.ls.LSException;

import java.util.List;

public class Ejercicio6 {
    public WebDriver driver;


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver =  new ChromeDriver();
        driver.get("https://mundomac.com/");
    }

    @Test
    public void altAttribute(){
        List<WebElement> listaAtributos = driver.findElements(By.tagName("img"));
        Assert.assertFalse(listaAtributos.isEmpty());
        int cont = 0;
        for (WebElement alt: listaAtributos){
            if (alt.getAttribute("alt").isEmpty() == false){
                System.out.println(alt.getAttribute("alt"));
            }
            else {
                cont++;
            }
        }
        System.out.println("La cantidad de elementos sin alt es: " + cont);
    }

    @Test
    public void buttons() throws InterruptedException {
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        Assert.assertFalse(buttons.isEmpty());
        Thread.sleep(2000);
        for (WebElement buttonsElement : buttons){
            Assert.assertTrue(buttonsElement.getAttribute("class").contains("btn-default"));
        }
    }

   /*  @Test
   public void links(){
        List<WebElement> elementosLi = driver.findElements(By.tagName("li"));
        Assert.assertFalse(elementosLi.isEmpty());
        for (WebElement links: elementosLi){
            String linksDeLaPagina = links.getAttribute("a");

        }
    }*/
}
