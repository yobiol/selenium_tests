package Básico.Clase5.Practico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ShopifyTest {
    public WebDriver driver;
    private int parametro = 0;

    public ShopifyTest(int unParametro){
        this.parametro = unParametro;
    }

    public ShopifyTest(){
        this.parametro = 0;
    }

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://es.shopify.com/");
    }

    @Test
    public void testButtons(){
      List<WebElement> buttonsList = driver.findElements(By.tagName("button"));
        ArrayList<WebElement> noEmptyButtons = new ArrayList<WebElement>();
      for (WebElement buttons: buttonsList){
          if (buttons.getText().equals("") == false) {
                noEmptyButtons.add(buttons);
          }
          }
      WebElement btnParametro = noEmptyButtons.get(parametro);
      System.out.println(btnParametro.getText());
      }
    }

