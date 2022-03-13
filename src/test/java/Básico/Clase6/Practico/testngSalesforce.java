package Básico.Clase6.Practico;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testngSalesforce {

    @Test (dataProvider = "datosPersona", dataProviderClass = DataProvider1.class)
    public void crearPersonas(String nombre, Integer edad){
        System.out.println(nombre + " tiene " + edad+ " años" );

    }

}
