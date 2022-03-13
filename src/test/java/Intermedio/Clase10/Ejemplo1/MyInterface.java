package Intermedio.Clase10.Ejemplo1;

public interface MyInterface {
    void metodo1();
    void metodo2();

    class Demo implements MyInterface {


        public void metodo1() {
            System.out.println("Este es el metodo 1");
        }


        public void metodo2() {
            System.out.println("Este es el metodo 2");
        }

        public static void main(String args[]){
            MyInterface objeto = new Demo();
            objeto.metodo1();
            objeto.metodo2();
        }
    }
}
