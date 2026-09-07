import java.util.Scanner;

public class Proyecto4 {

    static Scanner menu = new Scanner(System.in);
    static int seleccion;
    static int tipoBoletos;
    static int ganancias = 0;
    static String[] peliculas = {
        "Super Mario Galaxy",
        "Star Wars: The Mandalorian and Grogu",
        "No dejes a los niños solos"
    };
    static String[][] horarios = {
        {"10:00 AM", "1:00 PM", "4:00 PM", "7:00 PM", "9:30 PM"},
        {"11:00 AM", "2:00 PM", "5:00 PM", "8:00 PM", "10:30 PM"},
        {"12:00 PM", "3:00 PM", "6:00 PM", "9:00 PM", "11:30 PM"}
    };

    // Asientos ocupados
    static boolean[][][][] asientos = new boolean[peliculas.length][5][5][5]; 
    // Precio de cada asiento ocupado
    static int[][][][] precioAsiento = new int[peliculas.length][5][5][5];

    public static void main(String[] args) {
        while (true) {
            menuPrincipal();

            if (seleccion == 1) {
                menuPeliculas();
            } else if (seleccion == 2) {
                cancelarBoletos();
            } else if (seleccion == 3) {
                System.out.println("Ganancias actuales: $" + ganancias);
            } else if (seleccion == 4) {
                System.out.println("Gracias por usar nuestro servicio");
                break;
            } else {
                System.out.println("Haz una selección válida de 1 a 4");
            }
        }
        System.exit(0);
    }

    public static void menuPrincipal() {
        System.out.println("\nBienvenido a cinepolis");
        System.out.println("Selecciona la acción que deseas realizar: ");
        System.out.println("1. Comprar boletos");
        System.out.println("2. Cancelar compra");
        System.out.println("3. Ver ganancias");
        System.out.println("4. Salir");
        System.out.print("Tu elección: ");
        seleccion = menu.nextInt();
    }

    public static void menuPeliculas() {
        System.out.println("\nSelecciona una película: ");
        for (int i = 0; i < peliculas.length; i++) {
            System.out.println((i + 1) + ". " + peliculas[i]);
        }
        System.out.print("Tu elección: ");
        int eleccionPelicula = menu.nextInt() - 1;

        if (eleccionPelicula < 0 || eleccionPelicula >= peliculas.length) {
            System.out.println("Selecciona una película válida");
        } else {
            seleccionarHorario(eleccionPelicula);
        }
    }

    public static void seleccionarHorario(int indicePelicula) {
        System.out.println("\nSelecciona el horario de la película " + peliculas[indicePelicula] + ":");
        for (int i = 0; i < horarios[indicePelicula].length; i++) {
            System.out.println((i + 1) + ". " + horarios[indicePelicula][i]);
        }
        System.out.print("Tu elección: ");
        int eleccionHorario = menu.nextInt() - 1;

        if (eleccionHorario < 0 || eleccionHorario >= horarios[indicePelicula].length) {
            System.out.println("Horario inválido");
            seleccionarHorario(indicePelicula);
        } else {
            seleccionarAsientos(indicePelicula, eleccionHorario);
        }
    }

    public static void seleccionarAsientos(int indicePelicula, int indiceHorario) {
        System.out.println("\nElige tus asientos (5 filas x 5 columnas, [O]=disponible, [X]=ocupado):");
        mostrarAsientos(indicePelicula, indiceHorario);

        System.out.println("\nTipo de boleto:");
        System.out.println("1. Adulto ($100)");
        System.out.println("2. Niño ($50)");
        System.out.print("Tu elección: ");
        tipoBoletos = menu.nextInt();
        int precioBoleto = (tipoBoletos == 1) ? 100 : 50;

        System.out.print("¿Cuántos boletos deseas comprar? ");
        int cantidad = menu.nextInt();

        int[][] seleccionados = new int[cantidad][2];
        int totalAPagar = 0;

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Selecciona fila (1-5) para el boleto #" + (i + 1) + ": ");
            int fila = menu.nextInt() - 1;
            System.out.print("Selecciona columna (1-5) para el boleto #" + (i + 1) + ": ");
            int col = menu.nextInt() - 1;

            if (fila < 0 || fila >= 5 || col < 0 || col >= 5) {
                System.out.println("Fila o columna inválida, intenta de nuevo.");
                i--;
            } else if (asientos[indicePelicula][indiceHorario][fila][col]) {
                System.out.println("Asiento ya ocupado, selecciona otro.");
                i--;
            } else {
                asientos[indicePelicula][indiceHorario][fila][col] = true;
                precioAsiento[indicePelicula][indiceHorario][fila][col] = precioBoleto;
                seleccionados[i][0] = fila;
                seleccionados[i][1] = col;
                totalAPagar += precioBoleto;
            }
        }

        System.out.println("\nHas elegido los siguientes asientos:");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Fila " + (seleccionados[i][0] + 1) + " Columna " + (seleccionados[i][1] + 1));
        }

        System.out.println("Total a pagar: $" + totalAPagar);
        System.out.print("Realizar pago? (1=Sí, 2=Cancelar): ");
        int pagar = menu.nextInt();

        if (pagar == 1) {
            ganancias += totalAPagar;
            System.out.println("Pago realizado. ¡Disfruta tu película!");
        } else {
            // liberar los asientos
            for (int i = 0; i < cantidad; i++) {
                int fila = seleccionados[i][0];
                int col = seleccionados[i][1];
                asientos[indicePelicula][indiceHorario][fila][col] = false;
                precioAsiento[indicePelicula][indiceHorario][fila][col] = 0;
            }
            System.out.println("Compra cancelada, los asientos han sido liberados.");
        }
    }

    public static void mostrarAsientos(int indicePelicula, int indiceHorario) {
        for (int fila = 0; fila < 5; fila++) {
            for (int col = 0; col < 5; col++) {
                System.out.print(asientos[indicePelicula][indiceHorario][fila][col] ? "[X]" : "[O]");
            }
            System.out.println();
        }
    }

    public static void cancelarBoletos() {
        System.out.println("\nCancelar boletos");
        System.out.println("Selecciona película:");
        for (int i = 0; i < peliculas.length; i++) {
            System.out.println((i + 1) + ". " + peliculas[i]);
        }
        System.out.print("Tu elección: ");
        int pelicula = menu.nextInt() - 1;

        System.out.println("Selecciona horario:");
        for (int i = 0; i < horarios[pelicula].length; i++) {
            System.out.println((i + 1) + ". " + horarios[pelicula][i]);
        }
        System.out.print("Tu elección: ");
        int horario = menu.nextInt() - 1;

        System.out.print("Cantidad de boletos a cancelar: ");
        int cantidad = menu.nextInt();

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Fila del asiento a cancelar (1-5) #" + (i + 1) + ": ");
            int fila = menu.nextInt() - 1;
            System.out.print("Columna del asiento a cancelar (1-5) #" + (i + 1) + ": ");
            int col = menu.nextInt() - 1;

            if (fila < 0 || fila >= 5 || col < 0 || col >= 5 || !asientos[pelicula][horario][fila][col]) {
                System.out.println("Asiento inválido o no ocupado, intenta de nuevo.");
                i--;
            } else {
                ganancias -= precioAsiento[pelicula][horario][fila][col];
                asientos[pelicula][horario][fila][col] = false;
                precioAsiento[pelicula][horario][fila][col] = 0;
                System.out.println("Asiento en fila " + (fila + 1) + " columna " + (col + 1) + " cancelado.");
            }
        }
    }
}