package Intermedio.Clase3;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EcommerceSiteTesting {
    public WebDriver driver;
    public static String H1_AUTHENTICATION = "AUTHENTICATION";

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void registrationTest()throws InterruptedException {
        completeRegistration();

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
        driver.close();

    }

    @Test
    public void loginTest() throws InterruptedException {
        completeRegistration();

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

        WebElement signInElement = driver.findElement(By.id("SubmitLogin"));
        Assert.assertEquals(signInElement.getText(), "Sign in", "No se encontro el boton de Sign In");

        WebElement emailAddressLoginElement = driver.findElement(By.id("email"));
        emailAddressLoginElement.sendKeys(Constants.EMAIL_ADDRESS);
        WebElement passwordElement = driver.findElement(By.id("passwd"));
        passwordElement.sendKeys(Constants.PASSWORD);

        //SIGN IN
        signInElement.click();

        logoutElement = driver.findElement(By.className("logout"));

        nameElement = driver.findElement(By.xpath("(//*[@href='http://automationpractice.com/index.php?controller=my-account']/span)[1]"));
        System.out.println("--->" + nameElement.getText());
        fullName = Constants.FAKE_FIRST_NAME + " " + Constants.FAKE_LAST_NAME;
        Assert.assertEquals(nameElement.getText(), fullName, "Se esperaba otro nombre");
        Assert.assertTrue(nameElement.getText().contains(Constants.FAKE_FIRST_NAME), "El primer nombre no se encontro");
        Assert.assertTrue(nameElement.getText().contains(Constants.FAKE_LAST_NAME), "El apellido no se encontro");
        Assert.assertEquals(logoutElement.getText(), "Sign out", "El link Sign out debería estar presente");

        driver.close();
    }

    @Test
    public void uniqueEmailTest() throws InterruptedException {
        completeRegistration();
        WebElement logoutElement = driver.findElement(By.className("logout"));
        logoutElement.click();
        WebElement signInElement = driver.findElement(By.id("SubmitCreate"));
        Assert.assertEquals(signInElement.getText(), "Create an account", "No se encontro el boton de Create an account");
        WebElement emailRegistrationField = driver.findElement(By.id("email_create"));
        emailRegistrationField.sendKeys(Constants.EMAIL_ADDRESS);
        signInElement.click();

        WebElement errorMsgElement = driver.findElement(By.xpath("//*[@id='create_account_error']/ol/li"));
        System.out.println("-----> " + errorMsgElement.getText());
        Assert.assertEquals(errorMsgElement.getText(),"An account using this email address has already been registered. Please enter a valid password or request a new one.", "No se encontró el error esperado");

    }

    private void completeRegistration() throws InterruptedException {
        driver.findElement(By.xpath("//*[@href = 'http://automationpractice.com/index.php?controller=my-account']")).click();
        Assert.assertEquals(driver.getTitle(),"Login - My Store", "Se esperaba otro título");
        Assert.assertEquals(driver.getCurrentUrl(),"http://automationpractice.com/index.php?controller=authentication&back=my-account", "Se esperaba otra URL");
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"));

        Thread.sleep(2000);
        WebElement h1Element = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(h1Element.getText(), H1_AUTHENTICATION, "Se esperaba el h1: " + H1_AUTHENTICATION);

        System.out.println("====> " + Constants.EMAIL_ADDRESS);
        driver.findElement(By.name("email_create")).sendKeys(Constants.EMAIL_ADDRESS);
        driver.findElement(By.id("SubmitCreate")).click();

        Thread.sleep(5000);
        WebElement emailElement = driver.findElement(By.id("email"));
        Thread.sleep(6000);
        String  populatedEmail = emailElement.getAttribute("value");
        System.out.println(" -----> populatedEmail: " + populatedEmail);
        Assert.assertEquals(populatedEmail, Constants.EMAIL_ADDRESS, "Los emails deberían de coincidir");


        WebElement femaleRadioButton = driver.findElement(By.id("id_gender2"));
        WebElement firstNameField = driver.findElement(By.id("customer_firstname"));
        WebElement lastNameField = driver.findElement(By.id("customer_lastname"));
        WebElement paswordField = driver.findElement(By.id("passwd"));
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

        femaleRadioButton.click();


        firstNameField.sendKeys(Constants.FAKE_FIRST_NAME);
        lastNameField.sendKeys(Constants.FAKE_LAST_NAME);
        paswordField.sendKeys(Constants.PASSWORD);
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

