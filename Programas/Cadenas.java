public class Cadenas {
    public static void main(String[] args) {
        String texto = "Hola, Mundo!";
        
        // Longitud de la cadena
        int longitud = texto.length();
        System.out.println("Longitud: " + longitud);
        
        // Convertir a mayúsculas
        String mayusculas = texto.toUpperCase();
        System.out.println("Mayúsculas: " + mayusculas);
        
        // Convertir a minúsculas
        String minusculas = texto.toLowerCase();
        System.out.println("Minúsculas: " + minusculas);
        
        // Reemplazar caracteres
        String reemplazado = texto.replace("Mundo", "Java");
        System.out.println("Reemplazado: " + reemplazado);
        
        // Subcadena
        String subcadena = texto.substring(0, 4);
        System.out.println("Subcadena: " + subcadena);
        
        // Dividir cadena
        String[] partes = texto.split(", ");
        System.out.println("Partes:");
        for (String parte : partes) {
            System.out.println(parte);
        }
    }  
}
