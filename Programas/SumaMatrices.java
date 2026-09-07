import java.util.Scanner;

public class SumaMatrices {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] matriz1 = new int[3][3];
        int[][] matriz2 = new int[3][3];
        int[][] suma = new int[3][3];

        System.out.println("Ingrese los valores de la primera matriz:");
        matriz1[0][0] = sc.nextInt();
        matriz1[0][1] = sc.nextInt();
        matriz1[0][2] = sc.nextInt();
        matriz1[1][0] = sc.nextInt();
        matriz1[1][1] = sc.nextInt();
        matriz1[1][2] = sc.nextInt();
        matriz1[2][0] = sc.nextInt();
        matriz1[2][1] = sc.nextInt();
        matriz1[2][2] = sc.nextInt();

        System.out.println("Ingrese los valores de la segunda matriz:");
        matriz2[0][0] = sc.nextInt();
        matriz2[0][1] = sc.nextInt();
        matriz2[0][2] = sc.nextInt();
        matriz2[1][0] = sc.nextInt();
        matriz2[1][1] = sc.nextInt();
        matriz2[1][2] = sc.nextInt();
        matriz2[2][0] = sc.nextInt();
        matriz2[2][1] = sc.nextInt();
        matriz2[2][2] = sc.nextInt();

        suma[0][0] = matriz1[0][0] + matriz2[0][0];
        suma[0][1] = matriz1[0][1] + matriz2[0][1];
        suma[0][2] = matriz1[0][2] + matriz2[0][2];

        suma[1][0] = matriz1[1][0] + matriz2[1][0];
        suma[1][1] = matriz1[1][1] + matriz2[1][1];
        suma[1][2] = matriz1[1][2] + matriz2[1][2];

        suma[2][0] = matriz1[2][0] + matriz2[2][0];
        suma[2][1] = matriz1[2][1] + matriz2[2][1];
        suma[2][2] = matriz1[2][2] + matriz2[2][2];

        System.out.println("La suma de las matrices es:");

        System.out.println(suma[0][0] + "\t" + suma[0][1] + "\t" + suma[0][2]);
        System.out.println(suma[1][0] + "\t" + suma[1][1] + "\t" + suma[1][2]);
        System.out.println(suma[2][0] + "\t" + suma[2][1] + "\t" + suma[2][2]);
    sc.close();
    }
}