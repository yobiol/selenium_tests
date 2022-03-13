package Básico.Clase5.Practico;

import org.testng.annotations.Factory;

public class ShopifyFactory {
    @Factory
    public Object[] docusignFactory() {
        return new Object[]{
                new ShopifyTest(0),
                new ShopifyTest(1),
                new ShopifyTest(2)
        };
    }
}
