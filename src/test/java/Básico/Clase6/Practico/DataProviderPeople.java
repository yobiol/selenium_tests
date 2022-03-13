package Básico.Clase6.Practico;

import org.testng.annotations.DataProvider;

public class DataProviderPeople {

    @DataProvider (name = "people")
    public Object[][] datosPersonas(){
        return new Object[][]{
                {"Luisa", "Fernández", 25},
                {"Olga", "González", 55},
        };
    }
}
