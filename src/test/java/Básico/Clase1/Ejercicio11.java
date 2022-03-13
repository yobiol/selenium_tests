package Básico.Clase1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ejercicio11 {

    @Test
    public static void searchInGoogleAndGoBack(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("WebElement" + Keys.ENTER);
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();


    }
}
