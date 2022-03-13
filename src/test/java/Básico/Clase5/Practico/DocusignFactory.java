package Básico.Clase5.Practico;

import org.testng.annotations.Factory;

public class DocusignFactory {
    @Factory
    public Object[] docusignFactory(){
        return new Object[]{
                new DocusignFactoryTest(),
                new DocusignFactoryTest(),
                new DocusignFactoryTest()
        };
    }
}
