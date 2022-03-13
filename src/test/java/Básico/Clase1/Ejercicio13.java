package Básico.Clase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ejercicio13 {
    @Test

    public static void sendKeysToFacebook(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.name("pass")).sendKeys("holamundo");
        driver.findElement(By.name("login")).click();
    }
}
