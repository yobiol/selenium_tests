package Básico.Clase4.EjercicioGit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Salesforce {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/?locale=eu");
    }

    @Test(priority = 3)
    public void LoginFailureTest() throws InterruptedException {
        WebElement logo = driver.findElement(By.xpath("//*[@id='logo']"));
        Assert.assertEquals(logo.getAttribute("alt"), "Salesforce");
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//*[@name='pw']")).sendKeys("123466");
        driver.findElement(By.xpath("//*[@name='Login']")).click();
        Thread.sleep(2000);
        WebElement error = driver.findElement(By.xpath("//*[@id='error']"));
        System.out.println("Mensaje de error: " + error.getText());
        String messageExpected = "Your access to salesforce.com has been disabled by your system administrator. Please contact your Administrator for more information.";
        Assert.assertEquals(error.getText(), messageExpected);

    }
}

