package Básico.Clase6.Practico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SalesforceTest {
    public WebDriver driver;
    DataFactory dataFactory = new DataFactory(driver);
    String firstName = dataFactory.getFirstName();
    String lastName = dataFactory.getLastName();
    String email = dataFactory.getEmail();
    String phoneNumber = dataFactory.getPhone();
    String address = dataFactory.getAddress();
    String job = dataFactory.getJob();


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/?locale=eu");
    }


    @Test
    public void fillFormWithFakersTest(){
        driver.findElement(By.id("signup_link")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("UserFirstName")).sendKeys(firstName);
        driver.findElement(By.name("UserLastName")).sendKeys(lastName);
        driver.findElement(By.name("UserTitle")).sendKeys(job);
        driver.findElement(By.name("UserEmail")).sendKeys(email);
        driver.findElement(By.name("UserPhone")).sendKeys(phoneNumber);
        driver.findElement(By.name("CompanyName")).sendKeys("Evertec");
        WebElement employeesElement = driver.findElement(By.name("CompanyEmployees"));
        Select employees = new Select(employeesElement);
        employees.selectByValue("15");

        WebElement languageElement = driver.findElement(By.name("CompanyLanguage"));
        Select language = new Select(languageElement);
        language.selectByValue("es");

        System.out.println("Nombre: " + firstName);
        System.out.println("Apellido: " + lastName);
        System.out.println("Ocupación: " + job);
        System.out.println("Email: " + email);
        System.out.println("Teléfono: " + phoneNumber);

        WebElement errorMessage = driver.findElement(By.xpath("//*[@class = 'error-msg']"));
        System.out.println(errorMessage.getText());

     }

}
