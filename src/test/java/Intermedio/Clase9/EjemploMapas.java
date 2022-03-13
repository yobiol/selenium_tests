package Intermedio.Clase9;

import org.testng.annotations.Test;

import java.util.HashMap;

public class EjemploMapas {

    //Mapa: puede tener <clave , valor>
    //<111, Ana Lopez>
    //<12341234, Juan Andres>
    //<2323, Rodrigo Perez>
    //ORDEN= tiempo que se demora en encontrar a un elemento
    //Lista de N elementos, el tiempo puede llegar a ser N
    //Mapa de N elementos, el tiempo de encontrar un elemento es 1

    @Test
    public void mapasTest(){
        HashMap<Integer, String> mapaPersonas = new HashMap<>();
        mapaPersonas.put(111, "Ana Lopez");
        mapaPersonas.put(123, "Juan Andres");
        mapaPersonas.put(222, "Rodrigo Perez");
        System.out.println(mapaPersonas.get(111));

    }
}
