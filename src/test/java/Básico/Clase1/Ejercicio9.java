package Básico.Clase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ejercicio9 {
    WebDriver driver;

    public static void main(String[] args) {
        getDriver("https://www.google.com/");
    }


    @Test
    public static WebDriver getDriver (String sitioWeb){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(sitioWeb);
        return driver;
    }
}
