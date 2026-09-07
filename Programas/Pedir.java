import java.util.Scanner;

public class Pedir {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Escribe tu nombre: ");
        String nombre = entrada.nextLine();

        System.out.print("Escribe tu edad: ");
        int edad = entrada.nextInt();

        System.out.println("Hola " + nombre + ", tienes " + edad + " años.");
        entrada.close();

    }
}
