package Básico.Clase5.factorys;

import org.testng.annotations.Factory;

public class SpotifyFactory {

    @Factory
    public Object[] spotifyFactory() {
        return new Object[]{
                new SpotifyTest("testing@test.com"),
                new SpotifyTest("qwesdf@test.com"),
                new SpotifyTest("testing1@test.com")
        };
    }
}
