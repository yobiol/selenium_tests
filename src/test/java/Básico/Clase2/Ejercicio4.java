package Básico.Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio4 {
    private static WebDriver getFacebookDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        return driver;
    }

    @Test
    public static void checkBoxAndComboboxTest() throws InterruptedException {
        WebDriver driver = getFacebookDriver();
        driver.findElement(By.linkText("Create New Account")).click();

        Thread.sleep(1000);
        driver.findElement(By.name("firstname")).sendKeys("Alan");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("reg_email__")).sendKeys("test@test.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("test@test.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("testEjercicio4");
        WebElement monthElement = driver.findElement(By.name("birthday_month"));
        Select monthSelect = new Select(monthElement);
        monthSelect.selectByValue("4");

        WebElement dayElement = driver.findElement(By.name("birthday_day"));
        Select daySelect = new Select(dayElement);
        daySelect.selectByVisibleText("4");

        WebElement yearElement = driver.findElement(By.name("birthday_year"));
        Select yearSelect = new Select(yearElement);
        yearSelect.selectByIndex(10);

        List<WebElement> listaSexos = driver.findElements(By.name("sex"));
        WebElement femSexo = listaSexos.get(1);
        femSexo.click();

    }
}
