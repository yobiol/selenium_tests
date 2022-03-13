package Básico.Clase6.dataProviders;

import org.testng.annotations.Test;

public class ClaseTestDeDatos {
    @Test(dataProvider = "paises", dataProviderClass = DataProviderGenerator.class)
    public void mostrarPaises(String unaCapital, String unPais){
        System.out.println("La capital de " + unPais + " es " + unaCapital);
    }


}
