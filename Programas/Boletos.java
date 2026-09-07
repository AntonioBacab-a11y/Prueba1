import java.util.Scanner;

public class Boletos{
    public static void main (String [] args){
        Scanner menu = new Scanner(System.in);
        int seleccion;

        do{
        IO.println("Bienvenido a la taquilla de boletos");
        IO.println("Selecciona una de las siguientes opciones:");
        IO.println("1. Comprar boletos");
        IO.println("2. Cancelar compra");
        IO.println("3. Salir");

        seleccion=menu.nextInt();
        if(seleccion==1){
            IO.println("Seleccione una pelicula: ");
            IO.println("1.Super Mario Galaxy");
            IO.println("2.Star Wars: The Mnadalorian and Grogu");
            IO.println("3.No dejes a los niños solos");

            int selcPelicula=menu.nextInt();
            if(selcPelicula==1){
                IO.println("Seleccionaste Super Mario Galaxy");
                IO.println("Tipo de boleto:");
                IO.println("1. Adulto");
                IO.println("2. Niño");
                   
                int tipoBoleto=menu.nextInt();
                   if(tipoBoleto==1){
                       IO.println("El costo del boleto para adulto es de $100");
                       IO.println("¿Cuantos boletos desea comprar?");
                          
                       int boletos=menu.nextInt();
                          IO.println("El total a pagar es de: "+(boletos*100)+" pesos");
                   }else if(tipoBoleto==2){
                       IO.println("El costo del boleto para niño es de $50");
                       IO.println("¿Cuantos boletos desea comprar?");
                          
                       int boletos=menu.nextInt();
                          IO.println("El total a pagar es de: "+(boletos*50)+" pesos");
                   }else{
                       IO.println("Opcion no valida, porfavor seleccione 1 o 2");
                   }
                   
                   int fila=5;
                   int columna=5;
                   String [][] sala1 = new String [fila][columna];
                      for (int i = 0; i<fila; i++) {
                         for (int j = 0; j<columna; j++) {
                             IO.print(sala1[i][j]="[ ]");
                         }
                    IO.println();
                }
                    }
                }
      } while(seleccion==3);
        menu.close();
    }
}