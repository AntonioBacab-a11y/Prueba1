public class Condicional {
    public static void main(String[] args){
        int num1=3;
        int num2=4;
        int num3=6;
        int num4=9;
        int num5=32;
        if (num1>num2 && num1>num3 && num1>num4 && num1>num5){
            IO.println("El numero "+num1+" es el mayor");
        }else if (num2>num3 && num2>num4 && num2>num5){
            IO.println("El numero "+num2+" es el mayor");
        }else if (num3>num4 && num3>num5){
            IO.println("El numero "+num3+" es el mayor");
        }else if (num4>num5){
            IO.println("El numero "+num4+" es el mayor");
        }else {
            IO.println("El numero "+num5+" es el mayor");
        }

        String nombre1 = "Juan";
        String nombre2= "Guan";
        if (nombre1.equals(nombre2)){
            System.out.println("Los nombres son iguales");
        }else {
            System.out.println("Los nombres son diferentes");
        }
        
        boolean [] semaforo1 = {true, false, false};
        boolean [] semaforo2 = {false, true, false};
        if (semaforo1 == semaforo2){
            IO.println("Los semaforos son iguales");
        }else{
            IO.println("Los semaforos son diferentes");
        }

    }
}
