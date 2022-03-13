package Básico.Clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class facebookTest {
    public static WebDriver getFacebookDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        return driver;
    }

    @Test
    public static void checkBoxTest() throws InterruptedException {
        WebDriver driver = getFacebookDriver();
        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Yisel");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Obiol");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("94955325");
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("123456789");
        WebElement daySelect = driver.findElement(By.xpath("//select[@id='day']"));
        Select day = new Select(daySelect);
        day.selectByValue("8");
        WebElement monthSelect = driver.findElement(By.xpath("//select[@id='month']"));
        Select month = new Select(monthSelect);
        month.selectByValue("11");
        WebElement yearSelect = driver.findElement(By.xpath("//select[@id='year']"));
        Select year = new Select(yearSelect);
        year.selectByValue("1992");

        List<WebElement> gender = driver.findElements(By.xpath("//input[@name='sex']"));
        boolean isSelected = false;
        for (WebElement genderSelect : gender) {
            if (genderSelect.isSelected() == true) {
                isSelected = true;
                break;
            }
        }
        Assert.assertFalse(isSelected);
        System.out.println("No hay un sexo seleccionado");

        isSelected = false;
        driver.findElement(By.xpath("//input[@value='1']")).click();
        for (WebElement genderSelect : gender) {
            if (genderSelect.isSelected() == true) {
                isSelected = true;
                break;
            }
        }
        Assert.assertTrue(isSelected);
        System.out.println("Se seleccionó el sexo Femenino");
   }
}


