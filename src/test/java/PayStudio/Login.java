package PayStudio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Login {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = getWebDriver("http://10.195.25.5/PayStudioBO/View/Login/LoginPage.aspx");
        login(driver);
        mantLimiteCred(driver);
    }

    @Test
    public static WebDriver getWebDriver(String url){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }

    @Test
    public static void login(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"ctl00_CphContent_LoginControl1_TextBoxUser\"]")).sendKeys("yobiol");
        driver.findElement(By.xpath("//*[@id=\"ctl00_CphContent_LoginControl1_TextBoxPassword\"]")).sendKeys("yobiol");
        driver.findElement(By.xpath("//*[@id=\"ctl00_CphContent_LoginControl1_ButtonLogIn\"]")).click();
        Thread.sleep(1000);
    }


    @Test
    public static void mantLimiteCred(WebDriver driver) throws InterruptedException {
        String  limiteCred = "500";
        driver.findElement(By.id("ctl00_HeaderControl1_SelectOrganization")).click();
        Thread.sleep(1200);
        driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/header/div[1]/div/div/ul[1]/li[4]/ul/li[3]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"MainNavMenu\"]/li[2]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"MainNavMenu\"]/li[2]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_SearchByFields_txtAccountNumber\"]")).sendKeys("2822");
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_SearchByFields_btnSearch\"]")).click();
        Thread.sleep(12000);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_SearchResults_grdSearchResults_row_0")).click();
        Thread.sleep(12000);
        driver.findElement(By.name("ctl00$ContentPlaceHolder1$SearchResults$btnConsultAccount")).click();
        Thread.sleep(1200);
        driver.findElement(By.className("cart-txt")).click();
        Thread.sleep(1200);
        driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_AccountMenu_5\"]/nobr/div/a/span/span")).click();
        Thread.sleep(1200);
        driver.findElement(By.name("ctl00$ctl00$ContentPlaceHolder1$IssuerContextMainContent$txtNewCreditLimit$textbox")).sendKeys(limiteCred);
        Thread.sleep(1000);
        driver.findElement(By.name("ctl00$ctl00$ContentPlaceHolder1$IssuerContextMainContent$btnSave")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_pnlEventControl\"]/div[1]/div/div[2]/p/button")).click();
        Thread.sleep(1000);

        String limiteCredNuevo = driver.findElement(By.id("ctl00_ctl00_ContentPlaceHolder1_t31")).getText(); /*LC del botón Ver Mas*/
        if (limiteCred.concat(".00").equals(limiteCredNuevo.substring(3).trim())){
            System.out.println("Límite de crédito modificado con éxito");
            System.out.println("El nuevo Límite de crédito es: " + limiteCredNuevo);
        }
       // driver.close();
     }

}
