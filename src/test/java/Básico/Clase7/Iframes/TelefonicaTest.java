package Básico.Clase7.Iframes;

import Básico.Clase6.dataProviders.DataProviderGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;
import java.lang.ref.WeakReference;
import java.util.List;

public class TelefonicaTest {
    public WebDriver driver;
    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.telefonica.com/es/web/shareholders-investors");
    }


    @Test
    public void telefonicaTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        Thread.sleep(3000);
        System.out.println("Before switching ...." + driver.getTitle());
        System.out.println("Before switching ...." + driver.getCurrentUrl());
        driver.switchTo().frame("euroland-ticker-es");

        List<WebElement> tabs = driver.findElements(By.className("Tab"));
        Assert.assertEquals(tabs.size(), 2, "Deberían haber dos tabs seleccionadas");

        for (WebElement tab: tabs){
            System.out.println("====> " + tab.getText());
            if(tab.getText().equals("NYSE")){
                tab.click();
            }
        }

        WebElement activeTab = driver.findElement(By.className("Tab_Active"));
        Assert.assertEquals(activeTab.getText(), "NYSE", "La tab NYSE debería estar seleccionada");

        List<WebElement> dataItemsList = driver.findElements(By.className("DataItem"));
        System.out.println("====> DATA ITEMS " + dataItemsList.size());

        Thread.sleep(2000);
        List<WebElement> dataValuesList = driver.findElements(By.className("DataValue"));
        System.out.println("====> DATA VALUES " + dataValuesList.size());


        /*System.out.println("After switching ...." + driver.getTitle());
        System.out.println("Before switching ...." + driver.getCurrentUrl());*/
        driver.findElement(By.className("DataItem"));

        //Thread.sleep(30000);
        //driver.close();
    }

}
