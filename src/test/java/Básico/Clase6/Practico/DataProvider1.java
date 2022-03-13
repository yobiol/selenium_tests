package Básico.Clase6.Practico;

import org.testng.annotations.DataProvider;

public class DataProvider1 {
    @DataProvider (name = "datosPersona")
    public Object [][]crearPersonas(){
        return new Object[][]{
                {"Juan", 25},
                {"María", 56},
        };
    }
}
