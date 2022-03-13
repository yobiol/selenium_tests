package Básico.Clase5.refactoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpotifyFillingForm {

    public WebDriver driver;
    public SpotifyFillingForm(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    /*public void fillingFieldsWithAlreadyRegisteredEmail(){
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@name='displayname']")).sendKeys("Test");
        driver.findElement(By.id("day")).sendKeys("12");
    }

    public void fillingFieldsSuccessfully(){
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test5mayo2021@test.com");
        driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys("test5mayo2021@test.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@name='displayname']")).sendKeys("Test");
        driver.findElement(By.id("day")).sendKeys("12");
    }*/

    public void fillingFields(String anEmail, String aConfirmationEmail, String aPassword, String aDisplayName, String aDay){
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(anEmail);
        driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys(aConfirmationEmail);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(aPassword);
        driver.findElement(By.xpath("//input[@name='displayname']")).sendKeys(aDisplayName);
        driver.findElement(By.id("day")).sendKeys(aDay);
    }
}

