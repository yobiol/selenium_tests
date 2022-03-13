package Básico.Clase6.fakers;

import Básico.Clase6.dataProviders.DataProviderGenerator;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DocusignTest {
    public WebDriver driver;
    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://go.docusign.com/o/trial/");
    }

    @Test (dataProvider = "registro", dataProviderClass = DataProviderGenerator.class)
    public void docusignTest(String anEmail, String aMessage){
        Faker faker = new Faker();
        driver.findElement(By.name("first_name")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("last_name")).sendKeys(faker.name().lastName());
        driver.findElement(By.name("email")).sendKeys(anEmail);
        driver.findElement(By.name("phone")).sendKeys(faker.phoneNumber().phoneNumber());
        driver.findElement(By.name("title")).sendKeys(faker.job().title());
    }
}
