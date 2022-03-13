package Intermedio.Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AirbnbTest {
    public WebDriver driver;
    public static String BUDAPEST_CITY= "Budapest";

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://airbnb.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void busquedaAlojamientoTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("bigsearch-query-detached-query-input")).sendKeys(BUDAPEST_CITY);
        driver.findElement(By.xpath("//*[@data-testid= 'structured-search-input-field-split-dates-0']")).click();

        driver.findElement(By.xpath("//*[@data-testid= 'datepicker-day-2021-07-23']")).click();
        driver.findElement(By.xpath("//*[@data-testid= 'datepicker-day-2021-08-01']")).click();

        driver.findElement(By.xpath("//*[@data-testid= 'structured-search-input-field-guests-button']")).click();
        WebElement aumentarAdultosElement = driver.findElement(By.xpath("(//*[@aria-label='increase value'])[1]"));
        aumentarAdultosElement.click();
        aumentarAdultosElement.click();

        WebElement aumentarNiñosElement = driver.findElement(By.xpath("(//*[@aria-label='increase value'])[2]"));
        aumentarNiñosElement.click();

        driver.findElement(By.xpath("//*[@data-testid= 'structured-search-input-search-button']")).click();

        Thread.sleep(5000); // Para validar la cantidad de huespedes
        List<WebElement> tresHuespedesList= driver.findElements(By.xpath("//*[contains(text(), '3 guests')]"));
        Assert.assertEquals(tresHuespedesList.size(), 8, "Deberían haber tres elementos en la lista");

        boolean encontroTexto = false; //Para validar la fecha
        for (WebElement elemento: tresHuespedesList){
            if (elemento.getText().contains("Jul 23")&& elemento.getText().contains("Aug 1")){
                encontroTexto = true;
            }
        }
        Assert.assertTrue(encontroTexto);

        WebElement h1Element = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(h1Element.getText(), "Stays in Budapest");
        Assert.assertTrue(h1Element.getText().contains(BUDAPEST_CITY));
        Assert.assertTrue(h1Element.getText().endsWith(BUDAPEST_CITY));

        boolean encontroBudapest = false;
        List<WebElement> h1List = driver.findElements(By.tagName("h1"));
        for (WebElement h1: h1List){
            if (h1.getText().contains(BUDAPEST_CITY)){
                encontroBudapest =true;
                break;
            }
        }

        Assert.assertTrue(encontroBudapest);
    }
}
