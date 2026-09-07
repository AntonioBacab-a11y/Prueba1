import java.util.Scanner;

public class do_while {
    void main (String[]args){
        Scanner entrada = new Scanner(System.in);
        int Opc;
        double pi=3.1416;

        do{
        IO.println("0. Salir");
        IO.println("1. Área de un Circulo");
        IO.println("2. Área de un Cuadrado");
        IO.println("3. Área de un Triángulo");
        IO.println("4. Área de un Rectángulo");
        IO.println("5. Área de un Pentágono");
        IO.println("6. Área de un Hexágono");
        IO.print("SELECCIONE UNA OPCIÓN (1 al 6):");
        Opc= entrada.nextInt();
        if (Opc==1){
            IO.print("Ingrese el radio del círculo: ");
            double radio=entrada.nextDouble();
            double Area=(radio*radio)*pi;
            IO.println("El área del circulo es de: "+Area);
        }
        else if (Opc==2){
            IO.print("Ingrese el lado del cuadrado: ");   
            double lado=entrada.nextDouble();
            double Area=lado*lado;
            IO.println("El área del cuadrado es de: "+Area);
        }
        else if (Opc==3){
            IO.print("Ingrese la altura del triángulo: ");
            double altura=entrada.nextDouble();
            IO.print("Ingrese la base del triángulo: ");
            double base=entrada.nextDouble();
            double Area=(base*altura)/2;
            IO.println("El área del triángulo es de: "+Area);
        }
        else if (Opc==4){
            IO.print("Ingrese la altura del rectángulo: ");
            double altura=entrada.nextDouble();
            IO.print("Ingrese la base del rectángulo: ");
            double base=entrada.nextDouble();
            double Area=base*altura;
            IO.println("El área del rectángulo es de: "+Area);
        }
        else if (Opc==5){
            IO.print("Ingrese el perímetro del pentágono: ");
            double perimetro=entrada.nextDouble();
            IO.print("Ingrese el apotema del pentágono: ");
            double apotema=entrada.nextDouble();
            double Area=(perimetro*apotema)/2;
            IO.println("El área del pentágono es de: "+Area);
        }
        else if(Opc==6){
            IO.print("Ingrese el perímetro del hexágono: ");
            double perimetro=entrada.nextDouble();
            IO.print("Ingrese el  apotema del hexágono: ");
            double apotema=entrada.nextDouble();
            double Area =(perimetro*apotema)/2;
            IO.println("El área del hexágono es de: "+Area);
        }
       } while (Opc!=0);
       IO.print("Nos vemos");
       entrada.close();
    }
}
