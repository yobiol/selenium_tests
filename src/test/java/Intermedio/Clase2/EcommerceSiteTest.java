package Intermedio.Clase2;

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

public class EcommerceSiteTest {
    public WebDriver driver;
    public static String H1_AUTHENTICATION = "AUTHENTICATION";
    public final String NAME ="Joe";
    public static final String PASSWORD = "helloworld";
    public static final String BIRTH_DAY="8";
    public static final String BIRTH_MONTH = "11";
    public static final String BIRTH_YEAR ="1992";
    public static final String COUNTRY = "United States";
    public static final String CITY = "NEW YORK";

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
        Faker faker = new Faker();
        driver.findElement(By.xpath("//*[@href = 'http://automationpractice.com/index.php?controller=my-account']")).click();
        Assert.assertEquals(driver.getTitle(),"Login - My Store", "Se esperaba otro título");
        Assert.assertEquals(driver.getCurrentUrl(),"http://automationpractice.com/index.php?controller=authentication&back=my-account", "Se esperaba otra URL");
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"));

        Thread.sleep(2000);
        WebElement h1Element = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(h1Element.getText(), H1_AUTHENTICATION, "Se esperaba el h1: " + H1_AUTHENTICATION);

        String emailAddress = "seleniumintermedio" + Math.random() + "test@gmail.com" ;
        System.out.println("====> " + emailAddress);
        driver.findElement(By.name("email_create")).sendKeys(emailAddress);
        driver.findElement(By.id("SubmitCreate")).click();

        Thread.sleep(5000);
        WebElement emailElement = driver.findElement(By.id("email"));
        Thread.sleep(6000);
        String  populatedEmail = emailElement.getAttribute("value");
        System.out.println(" -----> populatedEmail: " + populatedEmail);
        Assert.assertEquals(populatedEmail, emailAddress, "Los emails deberían de coincidir");

        String fakeFirstName = faker.name().firstName();
        String fakeLastName = faker.name().lastName();

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


        firstNameField.sendKeys(fakeFirstName);
        lastNameField.sendKeys(fakeLastName);
        paswordField.sendKeys(PASSWORD);
        day.selectByValue(BIRTH_DAY);
        month.selectByValue(BIRTH_MONTH);
        year.selectByValue(BIRTH_YEAR);


        if (signUpCheck.isSelected() == false){
            signUpCheck.click();
        }
        if (offersCheck.isSelected() == false){
            offersCheck.click();
        }
        companyField.sendKeys("My Company");
        addressField1.sendKeys("My address Nr1");
        addressField2.sendKeys("My address Nr2");
        cityField.sendKeys(CITY);
        state.selectByValue("11");
        postalCodeField.sendKeys("96708");
        homePhoneField.sendKeys("1-709-275-1427");
        phoneMobileField.sendKeys("1-709-276-1428");
        addressAliasField.clear();
        addressAliasField.sendKeys("Buceo");
        registerButton.click();

        WebElement myPersonalInformationBtn = driver.findElement(By.xpath("//*[@href='http://automationpractice.com/index.php?controller=identity']"));
        myPersonalInformationBtn.click();
    }
}