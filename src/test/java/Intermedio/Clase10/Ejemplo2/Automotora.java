package Intermedio.Clase10.Ejemplo2;

public class Automotora {
    public static void main(String args[]){
        IVehiculo automvil1= new Auto();
        automvil1.acelerar();
        automvil1.girar();
        automvil1.reversa();
        automvil1.velocidadMexima();

        IVehiculo motor = new Mooto();
        automvil1.acelerar();
        automvil1.girar();
        automvil1.reversa();
        automvil1.velocidadMexima();

    }


}
