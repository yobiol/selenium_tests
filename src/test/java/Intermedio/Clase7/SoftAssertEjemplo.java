package Intermedio.Clase7;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEjemplo {
    @Test
    public void testAsserts(){
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(4,5, "los números no coinciden");
        softAssert.assertTrue(false,"Fallo la condicion");
        softAssert.assertNotEquals("hola", "hola", "los textos no deberían ser iguales");
        softAssert.assertTrue("hola".contains("x"), "No se encontro la variable X");

        softAssert.assertAll();
    }
}
