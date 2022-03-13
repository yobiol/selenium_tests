package Básico.Clase4.Practico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngSalesforce {
    public WebDriver driver;
    private static final String SALESFORCE_URL = "https://login.salesforce.com/";

    @Test(groups = {"successTest", "failureTest"})

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(SALESFORCE_URL);
    }

    @Test(priority = 1, groups = {"successTest"})
    public void validateSalesforceLogoTest(){
        WebElement logo = driver.findElement(By.xpath("//*[@id='logo']"));
        System.out.println(logo.getTagName());
        System.out.println(logo.getAttribute("alt"));
    }

    @Test(priority = 4, groups = {"failureTest"})
    public void rememberMeIsSelected(){
        driver.get("https://login.salesforce.com/?locale=eu");
        WebElement rememberButton = driver.findElement(By.xpath("//*[@id='rememberUn']"));
        rememberButton.click();
        Assert.assertTrue(rememberButton.isSelected());
    }

    @Test(enabled = false)
    public void footerIsValid(){
        driver.get("https://login.salesforce.com/?locale=eu");
        WebElement footer = driver.findElement(By.id("footer"));
        Assert.assertTrue(footer.getText().contains("All rights reserved."));
    }

}
