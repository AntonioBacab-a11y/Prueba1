import java.util.Scanner;

public class funciones {
    public static void main(String[] args){

        Scanner leer = new Scanner(System.in);
System.out.println("estoy en el main");
    System.out.println(saludar(leer.nextLine(), leer.nextLine()));

    leer.close();
}
public static String saludar(String name, String lastName){
    System.out.println("estoy en la funcion");
        String saludar = "Hola "+ name+" "+ lastName;
        return saludar;

    }
}
