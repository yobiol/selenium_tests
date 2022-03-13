package Básico.Clase5.Practico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DependentMethods {
    public WebDriver driver;

    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test  (dependsOnMethods ={ "testTwo", "testThree"} )
    public void testOne(){
        System.out.println("Se ejecuta el Test 1");
    }

    @Test
    public void testTwo(){
        System.out.println("Se ejecuta el Test 2");
    }

    @Test
    public void testThree(){
        System.out.println("Se ejecuta el Test 3");
    }
}

