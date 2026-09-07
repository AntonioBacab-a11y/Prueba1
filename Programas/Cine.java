import java.util.Scanner;

public class Cine {

    static String [][] sala1 = new String [5][5];
    static String [][] sala2 = new String [5][5];
    static String [][] sala3 = new String [5][5];
    static int ganancias = 0;
    public static void main (String [] args){
        Scanner menu = new Scanner (System.in);

        llenarSala(sala1);
        llenarSala(sala2);
        llenarSala(sala3);

        int seleccion;

        do{
            seleccion=menuPrincipal(menu);
            if (seleccion==1){
                int costoAdulto = 0;
                int costoNiño = 0;
                int adultos = 0;
                int niños = 0;
                int pelicula = comprarBoletos(menu);
                String[][] salaActual=sala1;
                if(pelicula==1){
                    salaActual=sala1;
                }else if(pelicula==2){
                    salaActual=sala2;
                }else if(pelicula==3){
                    salaActual=sala3;
                }
                mostrarHorarios(pelicula);
                int horario = selecHorario(menu);
                int cantBoletos = cantBoletos(menu);


                for (int i=0; i<cantBoletos; i++){
                    IO.println("Boleto #"+ (i+1));

                    int tipo = tipoBoleto(menu);

                    if(tipo==1){
                        costoAdulto = costoAdulto+100;
                        adultos++;
                }else if(tipo==2){
                        costoNiño = costoNiño+50;
                        niños++;
                    }else{
                        IO.println("Selecciona un tipo de boleto válido (1-2)");
                    }
                }
                int costoTotal= costoAdulto + costoNiño;
                ganancias= ganancias + costoTotal;
                IO.println("El costo total de tu compra es: $" + costoTotal);

                IO.println("Por favor selecciona tus asientos:");
                mostrarSala(salaActual);
                for (int i=0; i<cantBoletos; i++){
                    selecAsientos(menu, salaActual);
                    mostrarSala(salaActual);
                }
                mostrarTicket(pelicula, horario, adultos, niños, costoTotal, cantBoletos);

            }else if(seleccion==2){
                IO.println("Seleccione la película de la compra que desea cancelar:");
                int pelicula = comprarBoletos(menu);
                cancelarCompra(menu, pelicula);


            }else if(seleccion==3){
                mostrarGanancias();

            }else if(seleccion==4){
                IO.println("Gracias por visitar nuestro cine, ¡vuelve pronto!");

            }else{
                IO.println("Selecciona una opción válida (1-4)");
            }
        }while(seleccion != 4);
        
        menu.close();
    }

    public static int menuPrincipal(Scanner menu){
        IO.println("Bienvenido a la taquilla de boletos");
        IO.println("Selecciona una de las siguientes opciones:");
        IO.println("1. Comprar boletos");
        IO.println("2. Cancelar compra");
        IO.println("3. Ganancias");
        IO.println("4. Salir");

        int seleccion = menu.nextInt();

        return seleccion;
    }

    public static int comprarBoletos(Scanner menu){
        IO.println("Entraste a la compra de boletos");
        IO.println("Seleccione una pelicula:");
        IO.println("1. Super Mario Galaxy");
        IO.println("2. Star Wars");
        IO.println("3. No dejes a los niños solos");

        int pelicula = menu.nextInt();

        return pelicula;
    }

    public static void mostrarHorarios(int pelicula){
        IO.println("Horarios disponibles:");
        if (pelicula==1){
            IO.println("1. 10:00 AM");
            IO.println("2. 1:00 PM");
            IO.println("3. 4:00 PM");
        }else if(pelicula==2){
            IO.println("1. 11:00 AM");
            IO.println("2. 2:00 PM");
            IO.println("3. 5:00 PM");
        }else if(pelicula==3){
            IO.println("1. 12:00 PM");
            IO.println("2. 3:00 PM");
            IO.println("3. 6:00 PM");
        }
    }

    public static int selecHorario(Scanner menu){
        IO.println("Selecciona un horario:");

        int horario= menu.nextInt();

        return horario;
    }

    public static int cantBoletos(Scanner menu){
        IO.println("¿Cuántos boletos deseas comprar?");

        int cantidad = menu.nextInt();

        return cantidad;
    }

    public static int tipoBoleto(Scanner menu){
        int bolNiño=50;
        int bolAdulto=100;
        IO.println("Selecciona el tipo de boleto:");
        IO.println("1. Adulto - $"+bolAdulto);
        IO.println("2. Niño - $"+bolNiño);

        int tipo = menu.nextInt();

        return tipo;
    }

    public static void llenarSala(String[][] sala){
        for (int i=0; i<5;i++){
            for (int j=0; j<5; j++){
                sala[i][j]="[ ]";
            }
        }
    }

    public static void mostrarSala(String[][] sala){
        IO.println("   1  2  3  4  5");
        char letraFila='A';
        for (int i=0; i<5;i++){
            IO.print(letraFila+" ");
            for (int j=0; j<5; j++){
                IO.print(sala[i][j]);
            }
            letraFila++;
            IO.println();
        }
    }

    public static void selecAsientos(Scanner menu, String[][] sala){
        IO.println("Seleccione una fila (A-E):");
        char filaLetra = menu.next().toUpperCase().charAt(0);
        int fila = filaLetra - 'A';
        IO.println("Seleccione una columna (1-5):");
        int columna = menu.nextInt() - 1;
        if (fila >=0 && fila < 5 && columna >=0 && columna <5){
            if (sala[fila][columna].equals("[ ]")){
                sala[fila][columna] = "[X]";
                IO.println("Asiento reservado correctamente");
            }else{
                IO.println("El asiento ya esta ocupado, por favor selecciona otro");
            }
        }else{
            IO.println("Asiento invalido");
        }
    }

    public static void mostrarTicket(int pelicula, int horario, int adultos, int niños, int costoTotal, int cantBoletos){
        String nombrePelicula="";
        String horarioPelicula="";

        if (pelicula==1){
            nombrePelicula="Super Mario Galaxy";
            if (horario==1){
                horarioPelicula="10:00 AM";
            }else if(horario==2){
                horarioPelicula="1:00 PM";
            }else if(horario==3){
                horarioPelicula="4:00 PM";
            }
        }else if(pelicula==2){
            nombrePelicula="Star Wars";
            if (horario==1){
                horarioPelicula="11:00 AM";
            }else if(horario==2){
                horarioPelicula="2:00 PM";
            }else if(horario==3){
                horarioPelicula="5:00 PM";
            }
        }else if(pelicula==3){
            nombrePelicula="No dejes a los niños solos";
            if (horario==1){
                horarioPelicula="12:00 PM";
            }else if(horario==2){
                horarioPelicula="3:00 PM";
            }else if(horario==3){
                horarioPelicula="6:00 PM";
            }
        }


        IO.println("====== TICKET ======");
        IO.println("Película: " + nombrePelicula);
        IO.println("Horario: " + horarioPelicula);
        IO.println("Boletos adulto: " + adultos);
        IO.println("Boletos niño: " + niños);
        IO.println("Cantidad de boletos: " + cantBoletos);
        IO.println("Costo: $"+ costoTotal);
        IO.println("====================");
    }

    public static void mostrarGanancias(){
        IO.println("Las ganancias actuales son: $" + ganancias);
    }

    public static void cancelarCompra(Scanner menu, int pelicula){
        String[][] salaActual=sala1;
        if(pelicula==1){
            salaActual=sala1;
        }else if(pelicula==2){
            salaActual=sala2;
        }else if(pelicula==3){
            salaActual=sala3;
        }
        IO.println("Cuantos boletos desea cancelar?");
        int boletosCancelados = menu.nextInt();
        for (int i=0; i<boletosCancelados; i++){
            mostrarSala(salaActual);
        IO.println("Ingrese la fila del boleto a cancelar (A-E):");
        char filaLetra = menu.next().toUpperCase().charAt(0);
        int fila = filaLetra - 'A';
        IO.println("Ingrese la columna del boleto a cancelar (1-5):");
        int columna = menu.nextInt() - 1;
        if (fila >=0 && fila < 5 && columna >=0 && columna <5){
            if (salaActual[fila][columna].equals("[X]")){
                salaActual[fila][columna] = "[ ]";
                IO.println("Compra cancelada correctamente");
                mostrarSala(salaActual);
            }else{
                IO.println("El asiento no esta ocupado, no se puede cancelar");
            }
        }else{
            IO.println("Asiento invalido");
        }
        }

    }
}
