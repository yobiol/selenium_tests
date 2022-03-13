package Básico.Clase6.Practico;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataGenerator {

    @DataProvider( name = "capitales")
    public Object [][] capitales (){
        return new Object[][]{
                {"Madrid", "España"},
                {"Rio de Janeiro", "Brasil"},
                {"La Habana", "Cuba"}
        };
    }

    @Test (dataProvider = "capitales")
    public void datosPaises (String aCity, String aCountry){
        System.out.println("La capital de " + aCountry + " es " + aCity );
    }


}
