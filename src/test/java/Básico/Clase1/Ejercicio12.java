package Básico.Clase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio12 {
    @Test
    public static void facebookPageTest(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        List<WebElement> listaDivs = driver.findElements(By.tagName("div"));
        System.out.println("La cantidad de etiquetas <Div> es " + listaDivs.size());

        System.out.println("*******************");

        List<WebElement> listaHiperavinculos = driver.findElements(By.tagName("a"));
        for (WebElement listaLinks: listaHiperavinculos){
            if (listaLinks.getText().isEmpty() == false) {
                System.out.println(listaLinks.getText());
            }
        }

        System.out.println("*******************");

        List<WebElement> listaBotones = driver.findElements(By.tagName("button"));
        System.out.println("La cantidad de botones de la páginas son: " + listaBotones.size());

        for (WebElement listaButton: listaBotones){
            System.out.println(listaButton.getText());
        }
    }

}
