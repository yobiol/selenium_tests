package Básico.Clase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio3 {
    WebDriver driver;
    @Test
    public void bbcMMundoTest(){
        String URL_BBC_MUNDO  = "https://www.bbc.com/mundo";
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL_BBC_MUNDO);

        List<WebElement> listaH1s = driver.findElements(By.tagName("h1"));
        System.out.println("La cantidad de H1s del sitio son: " + listaH1s.size());
        System.out.println("-----> Elementos H1: <-----");
        for (WebElement elementoH1: listaH1s){
            System.out.println(elementoH1.getText());
        }
        System.out.println("***********************");

        List<WebElement> listaH2s = driver.findElements(By.tagName("h2"));
        System.out.println("La cantidad de H2s del sitio son: " + listaH2s.size());
        System.out.println("-----> Elementos H2: <-----");
        for (WebElement elementoH2: listaH2s){
            System.out.println(elementoH2.getText());
        }


        List<WebElement> listaLinks = driver.findElements(By.tagName("a"));
        System.out.println("Cantidad de links del sitio: " +listaLinks.size());
        int contadorLinksSinTexto = 0;
        for (WebElement link: listaLinks){
            if(link.getText().isEmpty()==false) {
                System.out.println("Link ---> " + link.getText());
            }
            else {
                contadorLinksSinTexto++;
            }
        }
        System.out.println("Se encontraron " + contadorLinksSinTexto + " links sin texto. ");



        List<WebElement> listaBotones = driver.findElements(By.tagName("button"));
        System.out.println("Cantidad de botones : " + listaBotones.size());
        driver.close();
    }


    @Test
    public void netflixTest(){
        String URL_NETFLIX  = "https://www.netflix.com/uy/";
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL_NETFLIX);

        List<WebElement> listaBotones = driver.findElements(By.tagName("button"));
        System.out.println("Cantidad de botones : " + listaBotones.size());

        for (WebElement botones: listaBotones){
            System.out.println(botones.getText());
        }

        /*WebElement cuantoCuestaNetflixBtn = listaBotones.get(2);
        cuantoCuestaNetflixBtn.click();*/

        listaBotones.get(0).click();
    }
}
