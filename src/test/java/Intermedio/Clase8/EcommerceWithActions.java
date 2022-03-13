package Intermedio.Clase8;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EcommerceWithActions {
    public WebDriver driver;
    public static String H1_AUTHENTICATION = "AUTHENTICATION";

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void registrationTest() throws InterruptedException {
        Actions action = new Actions(driver);

        Faker faker = new Faker();
        WebElement loginBtn = driver.findElement(By.xpath("//*[@href = 'http://automationpractice.com/index.php?controller=my-account']"));
        action.moveToElement(loginBtn).click().build().perform();

        Thread.sleep(2000);
        String emailAddress = "seleniumintermedio" + Math.random() + "test@gmail.com";
        System.out.println("====> " + emailAddress);

        WebElement emailField =  driver.findElement(By.name("email_create"));
        Action completeEmailFieldAction =
                        action.moveToElement(emailField)
                        .click()
                        .build();
        completeEmailFieldAction.perform();

        Thread.sleep(2000);

        WebElement submitBtn = driver.findElement(By.id("SubmitCreate"));
        action.moveToElement(submitBtn).click().build().perform();


        Thread.sleep(5000);
        WebElement maleRadioButton = driver.findElement(By.id("id_gender1"));
        Action maleRadioButtonAction = action.moveToElement(maleRadioButton).click().build();
        maleRadioButtonAction.perform();

        WebElement firstNameElement = driver.findElement(By.id("customer_firstname"));
        Action firstNameAction = action
                .moveToElement(firstNameElement)
                .click()
                .sendKeys("Jona")
                .keyDown(Keys.SHIFT)
                .sendKeys("than")
                .keyUp(Keys.SHIFT)
                .build();
        firstNameAction.perform();


        WebElement emailElement = driver.findElement(By.id("email"));
        Thread.sleep(2000);
        String populatedEmail = emailElement.getAttribute("value");
        System.out.println(" -----> populatedEmail: " + populatedEmail);
        Assert.assertEquals(populatedEmail, emailAddress, "Los emails deberían de coincidir");
    }
}