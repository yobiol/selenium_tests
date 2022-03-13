package PayStudio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class OpManual {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getWebDriver("http://10.195.25.5/PayStudioBO/View/Login/LoginPage.aspx");
        login(driver);
        buscarCuenta(driver);
        opManual(driver);
       /* consultaBalance(driver);*/

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
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_SearchByFields_txtAccountNumber\"]")).sendKeys("2945");
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_SearchByFields_btnSearch\"]")).click();
        Thread.sleep(12000);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_SearchResults_grdSearchResults_row_0")).click();
        Thread.sleep(12000);
        driver.findElement(By.name("ctl00$ContentPlaceHolder1$SearchResults$btnConsultAccount")).click();
    }


    @Test
    public static void opManual(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        String textToSelect = "Ajuste Débito";

        driver.findElement(By.linkText("Maintenance")).click();
        driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_AccountMenu_9\"]/nobr/div/a/span/span")).click();

        /*WebElement autoOptions = driver.findElement(By.xpath("/html/body/div[1]/form/div[3]/div/div/div[2]/div[2]/div/div/app-ifnoperationentrymanual/div[1]/app-controls-handler/div/form/div/div[1]/app-control/app-select/wj-auto-complete/div/div/div/span/button/span"));
        autoOptions.sendKeys("Ajuste");

        List<WebElement> optionsToSelect = driver.findElements(By.xpath("/html/body/div[2]/div[9]"));

        for(WebElement option : optionsToSelect){
            System.out.println(option);
            if(option.getText().equals(textToSelect)) {
                System.out.println("Trying to select: "+textToSelect);
                option.click();
                break;
            }
        }*/

        WebElement categoryOperation = driver.findElement(By.xpath("//*[@id=\"toggle_GenericContainer\"]/div/app-ifnoperationentrymanual/div[1]/app-controls-handler/div/form/div/div[1]/app-control/app-select/wj-auto-complete/div/div/div/span/button"));
        Thread.sleep(1000);
        categoryOperation.click();
        Thread.sleep(1000);
        Select op = new Select(categoryOperation);
        Thread.sleep(1000);
        op.selectByVisibleText("Ajuste Débito");


        /*List<WebElement> categoryList= driver.findElements(By.xpath("//*[@id=\"toggle_GenericContainer\"]/div/app-ifnoperationentrymanual/div[1]/app-controls-handler/div/form/div/div[1]/app-control/app-select/wj-auto-complete/div/div/div/span/button"));
        Assert.assertEquals(categoryList.size(),9);*/
    }

    public static void consultaBalance(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_AccountMenu_15\"]/nobr/div/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_AccountMenu_18\"]/nobr/div/a/span/span")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_IssuerContextMainContent_PreviousSettlementsContent_grdSettlements_row_0\"]")).click();
    }

}


