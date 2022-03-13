package Intermedio.Clase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio2 {
    public WebDriver driver;


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver =  new ChromeDriver();
        driver.get("https://www.booking.com/");
    }

    @Test
    public void bookingTest(){
        List<WebElement> h2List = driver.findElements(By.tagName("h2"));
        Assert.assertFalse(h2List.isEmpty());

        boolean foundText = false;
        for (WebElement h2: h2List){
            if (h2.getText().equals("Connect with other travelers")){
                foundText = true;
            }
        }

        Assert.assertTrue(foundText);
    }

    @Test
    public void encontreTexto(){
        WebElement iniciaSesionBtn = signInTest("Sign in");
        iniciaSesionBtn.click();
    }

    @Test
    public WebElement signInTest(String btnText){
        List<WebElement> button = driver.findElements(By.xpath("//*[@class='bui-button__text']"));
        Assert.assertNotEquals(button.size(),0);

        for (WebElement btn: button){
            if (btn.getText().equals(btnText)){
                return btn;
            }
        }
        return null;
        }
    }

