package Básico.Clase5.Practico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Salesforce {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
           }

    @Test
    public void Salesforce() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By. id("forgot_password_link")).click();
    }

    @Test
    public void implicitWaitTest(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By. id("forgot_password_link")).click();
    }
}
