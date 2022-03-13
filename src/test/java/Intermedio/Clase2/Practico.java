package Intermedio.Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Practico {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://airbnb.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void reserva() throws InterruptedException {
        Thread.sleep(2000);
        WebElement locationFIeld = driver.findElement(By.id("bigsearch-query-detached-query-input"));

        locationFIeld.sendKeys("Sevilla");
        WebElement date = driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-split-dates-0']"));
        date.click();
        Thread.sleep(2000);

        WebElement checkInDate=  driver.findElement(By.xpath("//*[@data-testid='datepicker-day-2021-07-30']"));
        checkInDate.click();
        WebElement checkOutDate = driver.findElement(By.xpath("//*[@data-testid='datepicker-day-2021-08-15']"));
        checkOutDate.click();
        WebElement guests = driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-guests-button']"));
        guests.click();
        WebElement adults = driver.findElement(By.xpath("(//*[@aria-label='increase value'])[1]"));
        adults.click();
        adults.click();
        WebElement childrens = driver.findElement(By.xpath("(//*[@aria-label='increase value'])[2]"));
        childrens.click();
        WebElement infants = driver.findElement(By.xpath("(//*[@aria-label='increase value'])[3]"));
        infants.click();
        WebElement searchButton = driver.findElement(By.xpath("//*[@data-testid='structured-search-input-search-button']"));
        searchButton.click();
        Thread.sleep(5000);

        List<WebElement> guestsNumber = driver.findElements(By.xpath("//*[contains(text(), '3 guests')]")); //Numero de huespedes
        Assert.assertEquals(guestsNumber.size(), 4, "Deberían haber tres elementos en la lista");

        boolean encontroTexto = false; //Para validar la fecha
        for (WebElement elemento: guestsNumber){
            if (elemento.getText().contains("Jul 30")&& elemento.getText().contains("Aug 15")){
                encontroTexto = true;
            }}

            Assert.assertTrue(encontroTexto);

        WebElement h1Element = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(h1Element.getText(), "Stays in Seville");











    }
}
