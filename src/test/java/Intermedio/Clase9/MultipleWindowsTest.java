package Intermedio.Clase9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MultipleWindowsTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://salesforce.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void registrationTest() throws InterruptedException {
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());
        String mainTab = driver.getWindowHandle();
        System.out.println("Página Principal: " + mainTab);
        driver.findElement(By.xpath("//a[@href='/mx/form/signup/freetrial-sales-pe/?d=70130000000EqoP']")).click();


        Set<String> allTabs = driver.getWindowHandles();
        String  registrationTab = " ";
        for (String tab: allTabs){
            System.out.println("---->" + tab);

            if (tab.equals(mainTab) == false){
                driver.switchTo().window(tab);
                System.out.println("Cambiando de tab...");
                registrationTab = tab;
            }
        }
        System.out.println("URL:" + driver.getCurrentUrl());
        System.out.println("Title:" + driver.getTitle());

        driver.findElement(By.name("UserFirstName")).sendKeys("Maria");
        driver.findElement(By.name("UserLastName")).sendKeys("González");
        driver.findElement(By.name("UserTitle")).sendKeys("SQA");

        driver.switchTo().window(mainTab);
        Thread.sleep(2000);
        driver.switchTo().window(registrationTab);
        Thread.sleep(2000);
        driver.switchTo().window(mainTab);
        Thread.sleep(2000);
        driver.switchTo().window(registrationTab);
        Thread.sleep(2000);
    }


    @Test
    public void multipleTabTest() throws InterruptedException {
        driver.get("http://naukri.com");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String mainWindow = driver.getWindowHandle();
        System.out.println("Página Principal: " + mainWindow);
        Set<String> allWindows = driver.getWindowHandles();

        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());
        System.out.println(allWindows.size());
        System.out.println("Main Window --->" + mainWindow);
        for (String windows: allWindows){
            if (windows.equals(mainWindow) == false){
                System.out.println("Closing window:" + windows);
                driver.switchTo().window(windows);
                driver.close();
            }
        }

    }
}
