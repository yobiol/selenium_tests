package Intermedio.Clase10.Ejemplo2;

public class Auto implements IVehiculo{
    @Override
    public void acelerar() {
        System.out.println("El auto está acelerando....");
    }

    @Override
    public void girar() {
        System.out.println("El auto está girando....");
    }

    @Override
    public void reversa() {
        System.out.println("El auto está en reversa....");
    }

    @Override
    public void velocidadMexima() {
        System.out.println("El auto tiene una velocidad maxima de 120km/h....");
    }
}
