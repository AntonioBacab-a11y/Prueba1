import java.util.Scanner;

public class SumaMatricesFor {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.print("Ingresa el tamaño de la matriz: ");
        int n = leer.nextInt();

        int[][] matriz1 = new int[n][n];
        int[][] matriz2 = new int[n][n];
        int[][] suma = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("matriz1[" + i + "][" + j + "] = ");
                matriz1[i][j] = leer.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("matriz2[" + i + "][" + j + "] = ");
                matriz2[i][j] = leer.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                suma[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        System.out.println("Suma de matrices:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(suma[i][j] + " ");
            }
            System.out.println();
        }

        leer.close();
    }
}