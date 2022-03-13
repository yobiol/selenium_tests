package Básico.ExamenSimulacion;

import org.testng.annotations.DataProvider;

public class DataProviderTest {
    @DataProvider (name = "email")
    public Object[][] datosEmail(){
            return new Object[][]{
                    {"testSelenium@gmail.com"},
                    {"qaselenium@gmail.com"},
                    {"seleniumTesting@gmail.com"},
        };
    }


}
