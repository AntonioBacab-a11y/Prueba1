import java.util.Scanner;

public class funciones2 {
    void main(){
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Estoy en el main");
        IO.println("Ingresa un valor entero");
        int valorEntero=leer.nextInt();
        int valorDuplicado=duplicar(valorEntero);
        IO.println(valorDuplicado);
        leer.close();
    }
    public static int duplicar (int valor){
        System.out.println("Estoy en la funcion");
        int valorDuplicado=valor*2;
        return valorDuplicado;
    }
}