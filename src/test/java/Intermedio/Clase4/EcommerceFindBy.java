package Intermedio.Clase4;

import Intermedio.Clase3.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EcommerceFindBy extends BasePage{


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

   // @Test (invocationCount = 5, successPercentage = 60)
    @Test
    public void registrationTest()throws InterruptedException {
        EcommerceHelper helper = new EcommerceHelper(driver);
        helper.completeRegistration();


        WebElement myPersonalInformationBtn = driver.findElement(By.xpath("//*[@href='http://automationpractice.com/index.php?controller=identity']"));
        myPersonalInformationBtn.click();

        WebElement myPersonalInfomationElement = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(myPersonalInfomationElement.getText(), "YOUR PERSONAL INFORMATION", "Se esperaba otro h1!");

        WebElement nameElement = driver.findElement(By.id("firstname"));
        String actualName = nameElement.getAttribute("value");

        WebElement lastNameElement = driver.findElement(By.id("lastname"));
        String actualLastName = lastNameElement.getAttribute("value");

        Assert.assertEquals(Constants.FAKE_FIRST_NAME, actualName, " Los nombres no coinciden");
        Assert.assertEquals(Constants.FAKE_LAST_NAME, actualLastName, "Los apellidos no coinciden");
      //  driver.close();

    }

    @Test
    public void loginTest() throws InterruptedException {
        EcommerceHelper helper = new EcommerceHelper(driver);
        helper.completeRegistration();

        WebElement logoutElement = driver.findElement(By.className("logout"));

        WebElement nameElement = driver.findElement(By.xpath("(//*[@href='http://automationpractice.com/index.php?controller=my-account']/span)[1]"));
        System.out.println("--->" + nameElement.getText());
        String fullName = Constants.FAKE_FIRST_NAME + " " + Constants.FAKE_LAST_NAME;
        Assert.assertEquals(nameElement.getText(), fullName, "Se esperaba otro nombre");
        Assert.assertTrue(nameElement.getText().contains(Constants.FAKE_FIRST_NAME), "El primer nombre no se encontro");
        Assert.assertTrue(nameElement.getText().contains(Constants.FAKE_LAST_NAME), "El apellido no se encontro");
        Assert.assertEquals(logoutElement.getText(), "Sign out", "El link Sign out debería estar presente");

        //LOG OUT
        logoutElement.click();

        Assert.assertEquals(loginBtn.getText(), "Sign in", "No se encontro el boton de Sign In");

        WebElement emailAddressLoginElement = driver.findElement(By.id("email"));

        String emailAddress = "seleniumintermedio" + Math.random() + "test@gmail.com";

        emailAddressLoginElement.sendKeys(emailAddress);
        WebElement passwordElement = driver.findElement(By.id("passwd"));
        passwordElement.sendKeys(Constants.PASSWORD);

        //SIGN IN
        loginBtn.click();

        Thread.sleep(5000);

        logoutElement = driver.findElement(By.className("logout"));

        nameElement = driver.findElement(By.xpath("(//*[@href='http://automationpractice.com/index.php?controller=my-account']/span)[1]"));
        System.out.println("--->" + nameElement.getText());
        fullName = Constants.FAKE_FIRST_NAME + " " + Constants.FAKE_LAST_NAME;
        Assert.assertEquals(nameElement.getText(), fullName, "Se esperaba otro nombre");
        Assert.assertTrue(nameElement.getText().contains(Constants.FAKE_FIRST_NAME), "El primer nombre no se encontro");
        Assert.assertTrue(nameElement.getText().contains(Constants.FAKE_LAST_NAME), "El apellido no se encontro");
        Assert.assertEquals(logoutElement.getText(), "Sign out", "El link Sign out debería estar presente");

//        driver.close();
    }

    @Test
    public void uniqueEmailTest() throws InterruptedException {
        EcommerceHelper helper = new EcommerceHelper(driver);
        helper.completeRegistration();

        WebElement logoutElement = driver.findElement(By.className("logout"));
        logoutElement.click();
        WebElement signInElement = driver.findElement(By.id("SubmitCreate"));
        Assert.assertEquals(signInElement.getText(), "Create an account", "No se encontro el boton de Create an account");
        WebElement emailRegistrationField = driver.findElement(By.id("email_create"));
        String emailAddress = "seleniumintermedio" + Math.random() + "test@gmail.com";

        emailRegistrationField.sendKeys(emailAddress);
        signInElement.click();

        WebElement errorMsgElement = driver.findElement(By.xpath("//*[@id='create_account_error']/ol/li"));
        System.out.println("-----> " + errorMsgElement.getText());
        Assert.assertEquals(errorMsgElement.getText(),"An account using this email address has already been registered. Please enter a valid password or request a new one.", "No se encontró el error esperado");

    }
/*
    @AfterMethod
    public void closeDriver(){
        driver.close();
    }*/



}



