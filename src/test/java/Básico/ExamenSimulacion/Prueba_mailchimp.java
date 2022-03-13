package Básico.ExamenSimulacion;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Prueba_mailchimp {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void aceptarCookies() throws InterruptedException {
        Thread.sleep(2000);
        WebElement cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookies.click();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void validarTituloTest() throws InterruptedException {
        aceptarCookies();
        String  titleExpected = driver.getTitle();
        String title = "Login | Mailchimp";
        Assert.assertEquals(titleExpected, title, "Se esperaba el título " + driver.getTitle());
        closeDriver();
    }

    @Test(priority = 4)
    public void iniciarSesionPageTest() throws InterruptedException {
        aceptarCookies();
        WebElement logIn = driver.findElement(By.xpath("//*[@type='submit']"));
        Assert.assertEquals(logIn.getText(), "Log In", "Se esperaba el texto Log In");
        WebElement mailchimpAccount = driver.findElement(By.xpath("//*[@title = 'Signup for a Mailchimp account']"));
        Assert.assertEquals(mailchimpAccount.getText(), "Need a Mailchimp account?", "Se esperaba el texto: Need a Mailchimp account?");
        closeDriver();
    }

    @Test(priority = 3)
    public void loginErrorTest() throws InterruptedException {
        aceptarCookies();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("XXXXX@gmail.com");
        WebElement logIn = driver.findElement(By.xpath("//*[@type='submit']"));
        logIn.click();

        List<WebElement> errorMessage =  driver.findElements(By.tagName("p"));
        boolean encuentraTexto = false;
        for (WebElement error: errorMessage){
            if (error.getText().contains("Looks like you forgot your password there")){
            encuentraTexto = true;
            }
        }
        Assert.assertTrue(encuentraTexto);
        Assert.assertTrue(driver.findElement(By.id("stay-signed-in")).isEnabled());
        closeDriver();
    }

    @Test(priority = 2)
    public void fakeEmailTest() throws InterruptedException {
        Faker faker = new Faker();
        driver.navigate().to("https://login.mailchimp.com/signup/");
        aceptarCookies();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(faker.internet().emailAddress());
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("signup"));
        closeDriver();
    }


    @Test (dataProvider = "email", dataProviderClass = DataProviderTest.class, priority = 1)
    public void dataProviderEmailTest(String anEmail) throws InterruptedException {
        driver.navigate().to("https://login.mailchimp.com/signup/");
        aceptarCookies();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(anEmail);
        WebElement password = driver.findElement(By.id("new_password"));
        password.sendKeys("holamundo+TestSelenium2021");
        Thread.sleep(2000);
        WebElement signUp = driver.findElement(By.id("create-account"));
        signUp.click();

        WebElement errorUsername = driver.findElement(By.xpath("//*[@class='invalid-error']"));
        String error = errorUsername.getText();
        String expected = "Please enter a value";
        Assert.assertEquals(error, expected, "Se esperaba el error del campo Username");
        closeDriver();
    }

    @Test
    public void closeDriver(){
        driver.close();
    }
}
