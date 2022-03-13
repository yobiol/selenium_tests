package Básico.Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ejercicio3 {
    private static WebDriver getSalesforceDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
        return driver;
    }

    @Test
    public static void customSalesforceLink(){
        WebDriver driver = getSalesforceDriver();
        driver.findElement(By.linkText("Use Custom Domain")).click();
        driver.findElement(By.name("mydomain")).sendKeys("as");
        driver.findElement(By.id("mydomainContinue")).click();
        driver.findElement(By.name("username")).sendKeys("test@test.com");
    }
}
