package Básico.Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ejercicio2 {
    private static WebDriver getFacebookDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        return driver;
    }

    @Test
    public static void forgotAccountPartialLinkTest(){
        WebDriver driver = getFacebookDriver();
        driver.findElement(By.partialLinkText("Forgot")).click();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Forgot Password | Can't Log In | Facebook");
    }
}
