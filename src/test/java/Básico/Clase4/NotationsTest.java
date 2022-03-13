package Básico.Clase4;

import org.testng.annotations.*;

public class NotationsTest {
    @BeforeTest
    public void beforeTestNotation(){
        System.out.println("Se invoca al @BeforeTest");
    }

    @BeforeClass
    public void beforeClassNotation(){
        System.out.println("Se invoca al @BeforeClass");
    }

    @BeforeMethod
    public void beforeMethodNotation(){
        System.out.println("Se invoca al @BeforeMethod");
    }

    @Test(priority = 2, groups = {"successTest"})
    public void test1(){
        System.out.println("Se ejecuta el test1!!");
    }

    @Test(priority = 1, groups = {"successTest"} )
    public void test2(){
        System.out.println("Se ejecuta el test2!!");
    }

    @Test(priority = 0, groups = {"failureTest"})
    public void test3(){
        System.out.println("Se ejecuta el test3!!");
    }

    @AfterMethod
    public void afterMethodNotation(){
        System.out.println("Se invoca al @AfterMethod");
    }

    @AfterClass
    public void afterClassNotation(){
        System.out.println("Se invoca al @AfterClass");
    }

    @AfterTest
    public void afterTestNotation(){
        System.out.println("Se invoca al @AfterTest");
    }


}
