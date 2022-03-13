package Básico.Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SalesforceTest {
    private static WebDriver getSalesforceDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
        return driver;
    }

    @Test
    public void salesforceRegistrationTest(){
        WebDriver driver = getSalesforceDriver();
        Assert.assertEquals(driver.getTitle(), "Login | Salesforce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://login.salesforce.com/");

        driver.findElement(By.linkText("Use Custom Domain")).click();
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Título: " + driver.getTitle());

        Assert.assertEquals(driver.getCurrentUrl(), "https://login.salesforce.com/");
        Assert.assertEquals(driver.getTitle(), "Use Custom Domain | Salesforce");

       // WebElement h2UseCustomerDomainElement = driver.findElement(By.tagName("h2"));
       // System.out.println(h2UseCustomerDomainElement.getText());
        // Assert.assertEquals(h2UseCustomerDomainElement.getText(), "Use Custom Domain");

        boolean useCustomDomainFound = false;
        List<WebElement> listaH2s = driver.findElements(By.tagName("h2"));
        for (WebElement h2: listaH2s){
            if(h2.getText().equals("Use Custom Domain")){
                useCustomDomainFound = true;
            }
        }

        Assert.assertTrue(useCustomDomainFound);

        driver.findElement(By.id("mydomain")).sendKeys("as");
        driver.findElement(By.name("Continue")).click();

        System.out.println("Titulo: " + driver.getTitle());
        System.out.println("Url: " + driver.getCurrentUrl());

        Assert.assertEquals(driver.getTitle(), "American Securities - Sign In");
        Assert.assertEquals(driver.getCurrentUrl(),"https://american-securities.okta.com/app/salesforce/ko9cqogcCYKWOFOXOOSX/sso/saml");
        driver.findElement(By.name("username")).sendKeys("testing@testing.com");
        driver.findElement(By.name("password")).sendKeys("holamundo");

    }


}
