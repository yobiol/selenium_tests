package Básico.Clase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EjerciciosSelenium {
    WebDriver driver;

    @Test
    public void ejercicio1(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        System.out.println("Título de la página " + driver.getTitle());
        System.out.println("URL de la página " + driver.getCurrentUrl());
    }



}
