package Intermedio.Clase10.Ejemplo2;

public class Mooto implements IVehiculo{
    @Override
    public void acelerar() {
        System.out.println("La moto está acelerando....");
    }

    @Override
    public void girar() {
        System.out.println("La moto está girando....");
    }

    @Override
    public void reversa() {
        System.out.println("La moto está retrocediendo....");
    }

    @Override
    public void velocidadMexima() {
        System.out.println("La moto tiene velocidad máaxima de 90km/h....");
    }
}
