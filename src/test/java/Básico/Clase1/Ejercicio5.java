package Básico.Clase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio5 {
    WebDriver driver;
    @Test
    public static void bbcMundoLinks(){
        String URL_BBC_MUNDO = "https://www.bbc.com/mundo";
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get(URL_BBC_MUNDO);

        List<WebElement> listaLi = driver.findElements(By.tagName("li"));
        System.out.println("Cantidad de etiquetas <li> en el sitio: " + listaLi.size());
        for (WebElement listaElementos: listaLi){
            if(listaElementos.getText().isEmpty() == false){
            System.out.println(listaElementos.getText());
            }
        }


    }



}
