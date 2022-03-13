package Intermedio.Clase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebElementsTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void primerTest(){

        driver.get("https://www.spotify.com");

       // WebElement fakeElement = driver.findElement(By.tagName("curso"));

        List<WebElement> fakeLista = driver.findElements(By.xpath("//*[@class = 'errors']"));
        //Assert.assertNotEquals(0, fakeLista.size(), "No se encontraron elementos en la lista");
        Assert. assertFalse(fakeLista.isEmpty(), "No se encontraron elementos en la lista");

        Assert.assertTrue(fakeLista.isEmpty()==false);


        Assert.assertFalse(fakeLista.isEmpty() == true);

        for(WebElement e: fakeLista){
            System.out.println("---->  " + e.getText());
        }

        System.out.println("Fin del test");

    }

    @Test
    public void bookingTest(){
        driver.get("https://booking.com");
        List<WebElement> listaH2s= driver.findElements(By.tagName("h2"));
        Assert.assertNotEquals(0, listaH2s.size());

        boolean encontreTexto = false;
        for (WebElement h2: listaH2s){
            System.out.println(h2.getText());
            if (h2.getText().equals("Connect with other travelers")){
                encontreTexto = true;
            }
        }

        Assert.assertTrue(encontreTexto, "No se encontró el texto");
        Assert.assertFalse(encontreTexto == false);
    }

    @Test
    public void netflixTest(){
        driver.get("https://www.netflix.com/uy/");

        WebElement h1 = driver.findElement(By.tagName("h1"));
        System.out.println("H1 " + h1.getText());
        System.out.println(h1.getAttribute("class"));
        System.out.println(h1.getAttribute("data-uia"));

    }

    @Test
    public void mundoMacTest(){
        driver.get("https://mundomac.com");

        WebElement elementoTienda = driver.findElement(By.id("menu-item-8120"));
        System.out.println("---> " + elementoTienda.getText());


        List<WebElement> elementosDeLaTienda = elementoTienda.findElements(By.tagName("li"));
        Assert.assertFalse(elementosDeLaTienda.isEmpty(), "No se encontraron elementos dentro del menú ");
        System.out.println("Cantidad de elementos " + elementosDeLaTienda.size());

        for (WebElement elemento : elementosDeLaTienda){
            System.out.println(elemento.getText());
            WebElement link = elemento.findElement(By.tagName("a"));
            System.out.println("---->" + link.getText());
        }
    }

}
