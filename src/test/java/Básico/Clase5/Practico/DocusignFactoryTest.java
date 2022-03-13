package Básico.Clase5.Practico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DocusignFactoryTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://go.docusign.com/o/trial/");
    }

    @Test
    public void validarTitulo(){
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "DocuSign Free Trial");

    }

}
