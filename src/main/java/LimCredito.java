import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.ref.WeakReference;
import java.util.Scanner;

public class LimCredito {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el LC");
        String  limiteCred = input.nextLine();
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        login(driver);

        driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/header/div[1]/div/div/ul[1]/li[4]/ul/li[3]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"MainNavMenu\"]/li[2]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"MainNavMenu\"]/li[2]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_SearchByFields_txtAccountNumber\"]")).sendKeys("2587");
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_SearchByFields_btnSearch\"]")).click();
        Thread.sleep(12000);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_SearchResults_grdSearchResults_row_0")).click();
        Thread.sleep(12000);
        driver.findElement(By.name("ctl00$ContentPlaceHolder1$SearchResults$btnConsultAccount")).click();
        Thread.sleep(1200);
        driver.findElement(By.className("cart-txt")).click();
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
        driver.close();
    }

    public static void login(WebDriver driver) throws InterruptedException {
        driver.get("http://10.195.25.5/PayStudioBO/View/Login/LoginPage.aspx");
        driver.findElement(By.xpath("//*[@id=\"ctl00_CphContent_LoginControl1_TextBoxUser\"]")).sendKeys("yobiol");
        driver.findElement(By.xpath("//*[@id=\"ctl00_CphContent_LoginControl1_TextBoxPassword\"]")).sendKeys("yobiol");
        driver.findElement(By.xpath("//*[@id=\"ctl00_CphContent_LoginControl1_ButtonLogIn\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_HeaderControl1_SelectOrganization")).click();
        Thread.sleep(1200);

    }
}


