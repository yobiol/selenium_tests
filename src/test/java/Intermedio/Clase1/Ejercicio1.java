package Intermedio.Clase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio1 {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver =  new ChromeDriver();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void facebookTest(){
        List<WebElement> elements = driver.findElements(By.className("qqqqqq"));
        for (WebElement elemenotsQ: elements){
            System.out.println(elemenotsQ.getText());
        }

        List<WebElement> h1List = driver.findElements(By.tagName("h2"));
        for (WebElement h112List: h1List){
            System.out.println(h112List.getText());
        }
        Assert.assertNotEquals(h1List.size(), 0);


    }
}
