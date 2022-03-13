package Básico.Clase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ejercicio8 {
    public static void main(String[] args) {

        getGoogleDriver();
    }

    @Test
    public static WebDriver getGoogleDriver(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        return driver;
    }
}
