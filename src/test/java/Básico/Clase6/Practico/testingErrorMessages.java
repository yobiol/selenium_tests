package Básico.Clase6.Practico;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class testingErrorMessages {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/?locale=eu");
    }

    @Test
    public void salesforceTest() throws InterruptedException {
        Faker faker = new Faker();
        driver.findElement(By.id("signup_link")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("Start my free trial")).click();
        List<WebElement> errorsList = driver.findElements(By.xpath("//*[@class = 'error-msg']"));
        boolean firstNameError = false;
        boolean lastNameError = false;
        boolean titleError = false;
        boolean emailError = false;
        boolean phoneError = false;
        boolean companyError = false;
        boolean employeesError = false;
        for (WebElement errores : errorsList) {
            System.out.println(errores.getText());
            if (errores.getText().equals("Enter your first name")) {
                firstNameError = true;
            }
            if (errores.getText().equals("Enter your last name")) {
                lastNameError = true;
            }
            if (errores.getText().equals("Enter your title")) {
                titleError = true;
            }
            if (errores.getText().equals("Enter a valid email address")) {
                emailError = true;
            }
            if (errores.getText().equals("Enter a valid phone number")) {
                phoneError = true;
            }
            if (errores.getText().equals("Enter your company name")) {
                companyError = true;
            }
            if (errores.getText().equals("Select the number of employees")) {
                employeesError = true;
            }
        }

        Assert.assertTrue(firstNameError);
        Assert.assertTrue(lastNameError);
        Assert.assertTrue(titleError);
        Assert.assertTrue(emailError);
        Assert.assertTrue(phoneError);
        Assert.assertTrue(companyError);
        Assert.assertTrue(employeesError);


        driver.findElement(By.name("UserFirstName")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("UserLastName")).sendKeys(faker.name().lastName());
        driver.findElement(By.name("UserTitle")).sendKeys(faker.job().title());
        driver.findElement(By.name("UserEmail")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.name("UserPhone")).sendKeys(faker.phoneNumber().phoneNumber());
        driver.findElement(By.name("Start my free trial")).click();

        emailError = false;
        for (WebElement errores : errorsList) {
            System.out.println(errores.getText());
            if (errores.getText().equals("Enter a valid email address")) {
                emailError = true;
            }

            Assert.assertFalse(emailError);
        }
    }


 /*  @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(10000);
        driver.close();

    }*/

}
