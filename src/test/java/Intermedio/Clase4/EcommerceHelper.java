package Intermedio.Clase4;

import Intermedio.Clase3.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EcommerceHelper extends BasePage{
    public WebDriver driver;


    public EcommerceHelper(WebDriver remoteDriver){
        driver = remoteDriver;
        PageFactory.initElements(driver, this);

    }

    public void completeRegistration() throws InterruptedException {
        loginBtn.click();

        Assert.assertEquals(driver.getTitle(),"Login - My Store", "Se esperaba otro título");
        Assert.assertEquals(driver.getCurrentUrl(),"http://automationpractice.com/index.php?controller=authentication&back=my-account", "Se esperaba otra URL");
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"));

        Thread.sleep(2000);
        Assert.assertEquals(authenticationH1.getText(), H1_AUTHENTICATION, "Se esperaba el h1: " + H1_AUTHENTICATION);

        String emailAddress = "seleniumintermedio" + Math.random() + "test@gmail.com";

        emailNewAccountField.sendKeys(emailAddress);
        createAccountBtn.click();

        Thread.sleep(3000);
        String  populatedEmail = emailUserField.getAttribute("value");
        System.out.println(" -----> populatedEmail: " + populatedEmail);
        Assert.assertEquals(populatedEmail, emailAddress, "Los emails deberían de coincidir");

        femaleGenderRadioButton.click();
        WebElement dayField = driver.findElement(By.id("days"));
        Select day = new Select(dayField);
        WebElement monthField = driver.findElement(By.id("months"));
        Select month = new Select(monthField);
        WebElement yearField = driver.findElement(By.id("years"));
        Select year = new Select(yearField);
        WebElement signUpCheck = driver.findElement(By.id("newsletter"));
        WebElement offersCheck = driver.findElement(By.id("optin"));
        WebElement companyField = driver.findElement(By.id("company"));
        WebElement addressField1 = driver.findElement(By.id("address1"));
        WebElement addressField2 = driver.findElement(By.id("address2"));
        WebElement cityField = driver.findElement(By.id("city"));
        WebElement stateField = driver.findElement(By.id("id_state"));
        Select state = new Select(stateField);
        WebElement postalCodeField = driver.findElement(By.id("postcode"));
        WebElement homePhoneField = driver.findElement(By.id("phone"));
        WebElement phoneMobileField = driver.findElement(By.id("phone_mobile"));
        WebElement addressAliasField = driver.findElement(By.id("alias"));
        WebElement registerButton = driver.findElement(By.id("submitAccount"));

        femaleGenderRadioButton.click();


        firstNameField.sendKeys(Constants.FAKE_FIRST_NAME);
        lastNameField.sendKeys(Constants.FAKE_LAST_NAME);
        passwordField.sendKeys(Constants.PASSWORD);
        day.selectByValue(Constants.BIRTH_DAY);
        month.selectByValue(Constants.BIRTH_MONTH);
        year.selectByValue(Constants.BIRTH_YEAR);


        if (signUpCheck.isSelected() == false){
            signUpCheck.click();
        }
        if (offersCheck.isSelected() == false){
            offersCheck.click();
        }
        companyField.sendKeys("My Company");
        addressField1.sendKeys("My address Nr1");
        addressField2.sendKeys("My address Nr2");
        cityField.sendKeys(Constants.CITY);
        state.selectByValue("11");
        postalCodeField.sendKeys("96708");
        homePhoneField.sendKeys("1-709-275-1427");
        phoneMobileField.sendKeys("1-709-276-1428");
        addressAliasField.clear();
        addressAliasField.sendKeys("Buceo");
        registerButton.click();
    }
}
