import java.util.Scanner;
public class Matrices {
    public Matrices (){
    }
    void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int [][] matriz1 = new int [3][3];
        int [][] matriz2 = new int [3][3];
        int[][] suma = new int [3][3];

        IO.println("ingrese los valores de la primera matriz:");
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                matriz1[i][j] = sc.nextInt();
            }
        }
        IO.println("ingres los valores de la segunda matriz:");
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                matriz2[i][j] = sc.nextInt();
            }
        }
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                suma[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        IO.println("La suma de las matrices es de:");
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                IO.print(suma[i][j] + "\t");
            }
            IO.println();
        }
        sc.close();
    }
    }

