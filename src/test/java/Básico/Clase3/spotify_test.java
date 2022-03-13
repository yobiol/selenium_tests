package Básico.Clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class spotify_test {
    public static WebDriver getSpotifyDriver(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/signup/");
        return driver;
    }

    @Test
    public static void spotifyByNameTest(){
        WebDriver driver = getSpotifyDriver();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@name='displayname']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@name='day']")).sendKeys("08");
        WebElement month = driver.findElement(By.xpath("//select[@name='month']"));
        Select monthElement = new Select(month);
        monthElement.selectByValue("11");
        driver.findElement(By.xpath("//input[@name='year']")).sendKeys("1992");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/form/fieldset/div/div[2]/label/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/form/div[6]/div/label/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/form/div[7]/div/label/span[2]/span")).click();
    }

    @Test
    public static void spotifyByPlaceHolder(){
        WebDriver driver = getSpotifyDriver();
        driver.findElement(By.xpath("//input[@placeholder='Introduce tu correo electrónico.']")).sendKeys("testing@test.com");
        driver.findElement(By.xpath("//input[@placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("testing@test.com");
        driver.findElement(By.xpath("//input[@placeholder='Crea una contraseña.']")).sendKeys("test123");
        driver.findElement(By.xpath("//input[@placeholder='Introduce un nombre de perfil.']")).sendKeys("Yisel");

    }

    @Test
    public static void spotifyByName(){
        WebDriver driver= getSpotifyDriver();
        driver.findElement(By.cssSelector("input#email")).sendKeys("testing2@tets.com");
        driver.findElement(By.cssSelector("input#confirm")).sendKeys("testing2@tets.com");
        driver.findElement(By.cssSelector("input#password")).sendKeys("test3");
        driver.findElement(By.cssSelector("input#displayname")).sendKeys("Yisel");
    }
}
