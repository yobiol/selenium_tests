import java.util.Scanner;

public class Test {
    private String pepe;


    public Test() {
    }

    public void gpepe(){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el dato");
        this.pepe = input.nextLine();
    }

    public String getPepe() {
        return pepe;
    }
}
