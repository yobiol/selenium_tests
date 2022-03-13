package Básico.Clase1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ejercicio7 {
    WebDriver driver;
    @Test
    public static void getWindowsSizeTest(){
        String URL_GOOGLE = "https://www.google.com/";
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL_GOOGLE);
        driver.manage().window().fullscreen();
        int alto = driver.manage().window().getSize().getHeight();
        int ancho = driver.manage().window().getSize().getWidth();
        System.out.println("El largo actual es: " + alto);
        System.out.println("El ancho actual es: " + ancho);

        driver.manage().window().setSize(new Dimension(1024, 768));

        alto = driver.manage().window().getSize().getHeight();
        ancho = driver.manage().window().getSize().getWidth();
        System.out.println("El largo actual es: " + alto);
        System.out.println("El ancho actual es: " + ancho);

    }
}
