package Básico.Clase4.Practico;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngSpotify {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/");
    }

    @Test (priority =  5)
    public void verifySpotifyTitle(){
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Escuchar es todo - Spotify");
    }

    @Test (priority =  4)
    public void verifySignupUrl(){
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("signup"));

    }

    @Test(priority =  3)
    public void invalidEmailTest() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("test.com");
        driver.findElement(By.xpath("//*[@name='confirm']")).click();
        WebElement mensajeObtenido = driver.findElement((By.xpath("//*[contains(text(), 'Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com')]")));
        Assert.assertEquals(mensajeObtenido.getText(),"Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");
    }

    @Test(priority = 2)
    public void validateExistingEmail() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//*[@name='confirm']")).click();
        Thread.sleep(2000);
        WebElement mensajeEmail = driver.findElement(By.xpath("//*[contains(text(), 'Este correo electrónico ya está conectado a una cuenta. ')]"));
        Assert.assertEquals(mensajeEmail.getText(), "Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");
    }

    @Test(priority = 1)
    public void checkEqualEmailsError(){
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("test999@test.com");
        driver.findElement(By.xpath("//*[@name='confirm']")).sendKeys("hola@hola.com");
        driver.findElement(By.xpath("//*[@name='password']")).click();
        WebElement mensajeEmail = driver.findElement(By.xpath("//*[contains(text(),'Las direcciones de correo electrónico no coinciden.')]"));
        Assert.assertEquals(mensajeEmail.getText(), "Las direcciones de correo electrónico no coinciden.");
    }


    private static final String EMAIL_ERROR = "Es necesario que introduzcas tu correo electrónico.";
    private static final String CONFIRMATION_ERROR = "Es necesario que confirmes tu correo electrónico.";
    private static final String PASSWORD_ERROR = "Debes introducir una contraseña.";
    private static final String NAME = "Introduce un nombre para tu perfil.";
    private static final String DAY_ERROR = "Indica un día del mes válido.";
    private static final String MONTH_ERROR = "Selecciona tu mes de nacimiento.";
    private static final String YEAR_ERROR = "Indica un año válido.";
    private static final String SEX_ERROR = "Selecciona tu sexo.";
    private static final String CAPTCHA_ERROR = "Confirma que no eres un robot.";
    @Test(priority =  0)
    public void checkErrorMessages(){
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        WebElement email_message = driver.findElement(By.xpath("//*[contains(text(),'Es necesario que introduzcas tu correo electrónico.')]"));
        WebElement confirm_message = driver.findElement(By.xpath("//*[contains(text(),'Es necesario que confirmes tu correo electrónico.')]"));
        WebElement password_message = driver.findElement(By.xpath("//*[contains(text(),'Debes introducir una contraseña.')]"));
        WebElement name_message = driver.findElement(By.xpath("//*[contains(text(),'Introduce un nombre para tu perfil.')]"));
        WebElement day_message = driver.findElement(By.xpath("//*[contains(text(),'Indica un día del mes válido.')]"));
        WebElement month_message = driver.findElement(By.xpath("//*[contains(text(),'Selecciona tu mes de nacimiento.')]"));
        WebElement year_message = driver.findElement(By.xpath("//*[contains(text(),'Indica un año válido.')]"));
        WebElement sex_message = driver.findElement(By.xpath("//*[contains(text(),'Selecciona tu sexo.')]"));
        WebElement captcha_message = driver.findElement(By.xpath("//*[contains(text(),'Confirma que no eres un robot.')]"));
        Assert.assertEquals(EMAIL_ERROR, email_message.getText());
        Assert.assertEquals(CONFIRMATION_ERROR,confirm_message.getText());
        Assert.assertEquals(PASSWORD_ERROR,password_message.getText());
        Assert.assertEquals(NAME, name_message.getText());
        Assert.assertEquals(DAY_ERROR, day_message.getText());
        Assert.assertEquals(MONTH_ERROR, month_message.getText());
        Assert.assertEquals(YEAR_ERROR, year_message.getText());
        Assert.assertEquals(SEX_ERROR, sex_message.getText());
        Assert.assertEquals(CAPTCHA_ERROR,captcha_message.getText());

    }
}
