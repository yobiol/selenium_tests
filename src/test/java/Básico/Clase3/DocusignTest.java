package Básico.Clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DocusignTest {
    public static WebDriver getDocusignDriver(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://go.docusign.com/o/trial/");
        return driver;
    }

    @Test
    public static void completeDocusignRegistrationForm() throws InterruptedException {
        WebDriver driver = getDocusignDriver();
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Maria");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("González");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("094945236");
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys("test");
        Thread.sleep(1000);
        WebElement industria = driver.findElement(By.xpath("//select[@name='ds_industry']"));
        Select elementoIndustria = new Select(industria);
        elementoIndustria.selectByValue("Technology");
    }

    @Test
    public static void defaultxPath(){
        WebDriver driver = getDocusignDriver();
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_First_Name\"]/input")).sendKeys("Luisa");
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Last_Name\"]/input")).sendKeys("Pérez");
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Email\"]/input")).sendKeys("test1@test.com");
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Phone\"]/input")).sendKeys("555555");
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Job_Title\"]/input")).sendKeys("Testing1");
        WebElement industria = driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Industry\"]/select"));
        Select industriaElemento = new Select(industria);
        industriaElemento.selectByValue("Legal");

    }
}
