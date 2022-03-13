package Básico.Clase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ejercicio6 {
    WebDriver driver;
    @Test
    public void spotifyTitleTest(){
        String URL_SPOTIFY = "https://www.spotify.com";
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL_SPOTIFY);
        String titulo = driver.getTitle();


        if(titulo.equals(" Escuchar es todo - Spotify")){
            System.out.println("Test Passed!!");
        }
       else {
            System.out.println(titulo);
            System.out.println("Test Failed!!");
        }


    }



}
