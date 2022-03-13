package Básico.Clase4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class SpotifyWithTestngTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/");
        }

   /* @Test
    public void registrationTest() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@name='displayname']")).sendKeys("Test");
    }*/

    @Test
    @Parameters({"username", "password"})
    public void cssSelectorByPlaceHolder(@Optional("qa@qa.com") String testEmail, @Optional("holamundo") String password) throws InterruptedException {
         Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[href='https://www.spotify.com/uy/signup/']")).click();
        driver.findElement(By.cssSelector("input[placeholder= 'Introduce tu correo electrónico.']")).sendKeys(testEmail);
        }


    @Test
    @Parameters({"tagName"})
    public void parametersFromTestngXML(@Optional("a") String tagNameParameter) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Se van a impimir todos los " + tagNameParameter);
        List<WebElement> tagElementList = driver.findElements(By.tagName(tagNameParameter));
        for (WebElement elemento: tagElementList){
            System.out.println("--> " + elemento.getText());
        }

        //driver.findElement(By.cssSelector("a[href='https://www.spotify.com/uy/signup/']")).click();
        //driver.findElement(By.cssSelector("input[placeholder= 'Introduce tu correo electrónico.']")).sendKeys("test1@test.com");
    }

    @Test
    public void spotifyErrorsTest() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[href='https://www.spotify.com/uy/signup/']")).click();
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        List<WebElement> listaErrores = driver.findElements(By.xpath("//*[@aria-label='Indicador de error']"));
        Assert.assertEquals(listaErrores.size(), 9, "Se esperaban 9 mensajes de error");
        boolean errorContraseñaPresente = false;

        for (WebElement element: listaErrores){
            System.out.println("--> " + element.getText());
            if (element.getText().equals("Debes introducir una contraseña.")){
                errorContraseñaPresente = true;
            }
        }
        Assert.assertTrue(errorContraseñaPresente,"No se encontró el error de la contraseña");
        WebElement perfilVacioErrorElement = driver.findElement(By.xpath("//*[contains(text(), 'Introduce un nombre para tu perfil.')]"));
        Assert.assertEquals(perfilVacioErrorElement.getText(), "Introduce un nombre para tu perfil.", "El error del perfil debería estar presente");


        driver.findElement(By.xpath("//*[contains(text(), 'Hombre')]")).click();
    }


    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        //driver.close();
    }



}
