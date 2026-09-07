import java.util.Scanner;
public class Palindromo {
    void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        IO.println("Ingrese una frase o palabra para verificar si es un palindromo:");
        String palabra = scanner.nextLine();

        long tiempoI=System.currentTimeMillis();

        String palabraN = palabra.replace(" ", "");
        palabraN = palabraN.toLowerCase();
        int longitud = palabraN.length();
        if (longitud>=3){
            String inversa="";
            while(longitud>0){
                inversa=inversa+palabraN.substring(longitud-1,longitud);
                longitud--;
            }
            if(palabraN.equalsIgnoreCase(inversa)){
                IO.println("Tu palabra es palindroma");
            }else {
                IO.println("Tu palabra no es palindromo");
            }

            }

            long tiempoF=System.currentTimeMillis();
            IO.println("Tiempo de ejecucion: "+(tiempoF-tiempoI)+" milisegundos");

            scanner.close();
            }
        }
