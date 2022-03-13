package Básico.Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Ejercicio8 {
    private static WebDriver getFacebookDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        return driver;
    }

    @Test
    public static void completeRegistration() throws InterruptedException {
        WebDriver driver = getFacebookDriver();
        driver.findElement(By.linkText("Create New Account")).click();

        Thread.sleep(1000);
        driver.findElement(By.name("firstname")).sendKeys("Yisel");
        driver.findElement(By.name("lastname")).sendKeys("Obiol");
        driver.findElement(By.name("reg_email__")).sendKeys("yobiol@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("yobiol@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("testEjercicio8");

        Thread.sleep(1000);
        setBirthdate(driver, "Nov","8" ,"1992");
    }

    private static void setBirthdate(WebDriver driver, String mes, String dia,  String año){

        WebElement monthElement = driver.findElement(By.name("birthday_month"));
        Select monthSelect = new Select(monthElement);
        monthSelect.selectByVisibleText(mes);

        WebElement dayElement = driver.findElement(By.name("birthday_day"));
        Select daySelect = new Select(dayElement);
        daySelect.selectByVisibleText(dia);

        WebElement yearElement = driver.findElement(By.name("birthday_year"));
        Select yearSelect = new Select(yearElement);
        yearSelect.selectByVisibleText(año);
    }
}
