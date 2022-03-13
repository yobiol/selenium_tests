package Básico.Clase7.Test;

import Básico.Clase7.PageObject.NetflixLandingPage;
import Básico.Clase7.PageObject.NetflixLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NetflixTest {

    public WebDriver driver;
    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/uy");
    }

    @Test
    public void netflixTest() throws InterruptedException {
        NetflixLandingPage netflixLandingPage = new NetflixLandingPage(driver);

        String title = netflixLandingPage.getNetflixTitle();
        String currentUrl = netflixLandingPage.getNetflixCurrentUrl();

        Assert.assertTrue(title.contains("Ve series online, ve películas online"), "Se esperaba otro titulo");
        Assert.assertEquals(currentUrl,"https://www.netflix.com/uy/", "Se esperaba otra url"  );

        NetflixLoginPage netflixLoginPage = netflixLandingPage.clickOnIniciarSesion();

        title = netflixLoginPage.getNetflixTitle();
        currentUrl = netflixLoginPage.getNetflixCurrentUrl();


        Assert.assertEquals(netflixLoginPage.getH1Test(), "Sign In", "Se esperaba el H1 Iniciar Sesión");

        Thread.sleep(2000);
        Assert.assertTrue(title.contains("Netflix"), "Se esperaba otro titulo");
        Assert.assertTrue(currentUrl.contains("login"), "Se esperaba la url de Iniciar Sesión");

        netflixLoginPage.fillEmailField("test@test.com");
        netflixLoginPage.fillPasswordField("password1323");

    }

}
