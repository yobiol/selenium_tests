package Básico.ExamenSimulacion;

import org.testng.annotations.Factory;

public class Factorys {
    @Factory
    public Object[] ejecutarTest(){
        return new Object[]{
                new Prueba_mailchimp(),
                new Prueba_mailchimp()
        };
    }
}
