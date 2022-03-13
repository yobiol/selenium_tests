package PayStudio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;
import java.security.PublicKey;

public class OperacionesManuales {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getWebDriver("http://10.195.25.5/PayStudioBO/View/Login/LoginPage.aspx");
        login(driver);
        buscarCuenta(driver);
        opManual(driver);
        consultaBalance(driver);

    }


    public static WebDriver getWebDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver  = new ChromeDriver();
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
    public static void buscarCuenta(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("ctl00_HeaderControl1_SelectOrganization")).click();
        Thread.sleep(1200);
        driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/header/div[1]/div/div/ul[1]/li[4]/ul/li[3]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"MainNavMenu\"]/li[2]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"MainNavMenu\"]/li[2]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_SearchByFields_txtAccountNumber\"]")).sendKeys("2846");
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_SearchByFields_btnSearch\"]")).click();
        Thread.sleep(12000);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_SearchResults_grdSearchResults_row_0")).click();
        Thread.sleep(12000);
        driver.findElement(By.name("ctl00$ContentPlaceHolder1$SearchResults$btnConsultAccount")).click();
    }


    @Test
    public static void opManual(WebDriver driver) throws InterruptedException {
        //String  limiteCred = "500";
        Thread.sleep(15000);
        driver.findElement(By.className("cart-txt")).click();
        Thread.sleep(1200);
        driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_AccountMenu_9\"]/nobr/div/a/span/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"toggle_GenericContainer\"]/div/app-ifnoperationentrymanual/div[1]/app-controls-handler/div/form/div/div[1]/app-control/app-select/wj-auto-complete/div/div/div/span/button/span")).click();
        Thread.sleep(1000);
       /* WebElement categoriaOp = driver.findElement(By.xpath("//*[@id=\"_dropdown\"]/div[1]"));
        Thread.sleep(1000);
        Select operacion = new Select(categoriaOp);
        operacion.selectByVisibleText("Ajuste Crédito");*/
        driver.findElement(By.xpath("//*[@id=\"_dropdown\"]/div[9]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"toggle_GenericContainer\"]/div/app-ifnoperationentrymanual/div[1]/app-controls-handler/div/form/div/div[2]/app-control/app-select/wj-auto-complete/div/div/div/span/button/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"_dropdown\"]/div[8]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"toggle_GenericContainer\"]/div/app-ifnoperationentrymanual/div[2]/app-controls-handler/div/form/div[1]/div[3]/app-control/app-numeric-input/div/div/input")).sendKeys("1500");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"toggle_GenericContainer\"]/div/app-ifnoperationentrymanual/div[4]/app-button/div/div/div[2]/span")).click();
        Thread.sleep(15000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_listErrors_ctrl0_Label1\"]")).getText(), "El importe ingresado es superior a los saldos existentes en los rubros de la categoría seleccionada. Ingrese un importe menor");
    }

   public static void consultaBalance(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_AccountMenu_15\"]/nobr/div/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_AccountMenu_18\"]/nobr/div/a/span/span")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_IssuerContextMainContent_PreviousSettlementsContent_grdSettlements_row_0\"]")).click();
    }

}


