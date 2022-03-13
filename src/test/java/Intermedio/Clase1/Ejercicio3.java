package Intermedio.Clase1;

import Básico.Clase7.Iframes.TelefonicaTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Stack;

public class Ejercicio3 {
    public WebDriver driver;

    @Test
    public static List<WebElement> getElementsByClassName(WebDriver driver, String TelefonicaTest){
        TelefonicaTest = new String();
        List<WebElement> elementsList  = driver.findElements(By.className(TelefonicaTest));
        return elementsList;

    }
}
