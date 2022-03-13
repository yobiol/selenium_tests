package Básico.Clase6.Practico;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DataFactory {
    public WebDriver driver;

    public DataFactory(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    Faker faker = new Faker();

    @Test
    public String getFirstName(){
        String firstName = faker.name().firstName();
        return firstName;
    }
    @Test
    public String getLastName(){
        String lastName = faker.name().lastName();
        return lastName;
    }
    @Test
    public String getEmail(){
        String email = faker.internet().emailAddress();
        return email;
    }
    @Test
    public String getPhone(){
        String phoneNumber = faker.phoneNumber().cellPhone();
        return phoneNumber;
    }

    @Test
    public String getAddress(){
        String address = faker.address().fullAddress();
        return address;
    }

    @Test
    public String getJob(){
        String job = faker.job().title();
        return job;
    }
}
