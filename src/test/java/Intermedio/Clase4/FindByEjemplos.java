package Intermedio.Clase4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindByEjemplos {
    String URL = "https://www.netflix.com";
    public WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "p")
    public List<WebElement> listaParrafos;

    @FindBy(tagName = "a")
    public List<WebElement> listaLinks;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(xpath = "//*[@href='/login']")
    private WebElement sigInElement;

    @FindBy (linkText = "Privacidad y Seguridad")
    private WebElement privacidadLink;

    @Test
    public void ejercicio1() throws InterruptedException {
        Assert.assertNotEquals(listaParrafos.size(),0);
        Assert.assertNotEquals(listaLinks.size(),0);

        for (WebElement parrafo: listaParrafos){
            if (parrafo.getText().isEmpty()==false)
            System.out.println("---> " + parrafo.getText());
        }

        System.out.println("***Links***");
        for (WebElement links: listaLinks){
            if (links.getText().isEmpty()==false)
                System.out.println("---> " + links .getText());
        }

        emailField.sendKeys("test@testing.com");
        Thread.sleep(5000);
        sigInElement.click();
       // driver.close();
    }


}
