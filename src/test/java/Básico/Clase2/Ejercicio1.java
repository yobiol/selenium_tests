package Básico.Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ejercicio1 {
    private static WebDriver getFacebookDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        return driver;
    }

    @Test
    public static void forgotAccountTest(){
        WebDriver driver = getFacebookDriver();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Facebook - Log In or Sign Up");

        driver.findElement(By.linkText("Forgot Password?")).click();

        System.out.println(driver.getCurrentUrl());
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.facebook.com/");

        driver.close();
    }
}
