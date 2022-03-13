package Básico.Clase6.Practico;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PeopleTest {
    @Test(dataProvider = "people", dataProviderClass = DataProviderPeople.class)
    public void peopleData(String aName, String aLastName, Integer aAge){
        System.out.println( aName + " " + aLastName + " tiene " + aAge + " años");
    }
}
