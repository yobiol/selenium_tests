package Básico.Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FacebookTest {

   private static WebDriver getFacebookDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        return driver;
    }

    @Test
    public static void facebookLinkTest() throws InterruptedException {
        WebDriver driver = getFacebookDriver();
        driver.findElement(By.linkText("Forgot Password?")).click();
        Thread.sleep(5000);
        driver.close();
    }

    @Test
    public static void facebookPartialLinkTest() throws InterruptedException {
       WebDriver driver = getFacebookDriver();

        System.out.println("Titulo: " + driver.getTitle());
        System.out.println("Url: " + driver.getCurrentUrl());

        Assert.assertEquals(driver.getTitle(), "Facebook - Log In or Sign Up");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");

        driver.findElement(By.partialLinkText("Forgot")).click();
        System.out.println("Se ha clickeado el link Olvidaste tu contraseña?");

        System.out.println("Titulo " + driver.getTitle());
        System.out.println("Url " + driver.getCurrentUrl());


        Assert.assertEquals(driver.getTitle(), "Forgot Password | Can't Log In | Facebook");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0");

        Thread.sleep(5000);
        //driver.close();
    }

    @Test
    public void facebookRegistrationTest() throws InterruptedException {
       WebDriver driver = getFacebookDriver();
       driver.findElement(By.linkText("Create New Account")).click();
       Thread.sleep(1000);
       driver.findElement(By.name("firstname")).sendKeys("Jhon");

       driver.findElement(By.name("lastname")).sendKeys("Smith");
       driver.findElement(By.name("reg_email__")).sendKeys("test@qa.com");
       driver.findElement(By.name("reg_email_confirmation__")).sendKeys("test@qa.com");
       driver.findElement(By.id("password_step_input")).sendKeys("holamundo");

       WebElement monthElement = driver.findElement(By.name("birthday_month"));
       WebElement daysElement = driver.findElement(By.name("birthday_day"));
       WebElement yearElement = driver.findElement(By.name("birthday_year"));

       Select monthSelect = new Select(monthElement);
       Select daySelect = new Select(daysElement);
       Select yearSelect = new Select(yearElement);

       monthSelect.selectByVisibleText("Nov");
       daySelect.selectByIndex(8);
       yearSelect.selectByValue("1992");


        List<WebElement> listaSexos = driver.findElements(By.name("sex"));
        Assert.assertEquals(listaSexos.size(), 3);

        WebElement sexoFemElement= listaSexos.get(0);
        sexoFemElement.click();


       Thread.sleep(10000);
       driver.close();
    }
}
