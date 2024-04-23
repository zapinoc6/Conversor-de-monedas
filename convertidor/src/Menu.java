import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Principal principal = new Principal();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al conversor de monedas");
        System.out.println("Por favor ingresa la cantidad en USD:");

        // Leer la cantidad en USD desde la entrada del usuario
        double amountInUSD = scanner.nextDouble();

        // Mostrar las opciones de monedas disponibles
        System.out.println("Elige a qué moneda quieres convertir:");
        System.out.println("1. ARS - Peso argentino");
        System.out.println("2. BOB - Boliviano boliviano");
        System.out.println("3. BRL - Real brasileño");
        System.out.println("4. CLP - Peso chileno");
        System.out.println("5. RMB - moneda china");
        System.out.println("6. COP - Peso colombiano");
        System.out.println("7. JPY - moneda japonesa");
        System.out.println("8. Sol - moneda peruana ");
        System.out.println("Escribe 'salir' para terminar.");

        // Leer la opción del usuario
        String option = scanner.next();

        switch (option.toLowerCase()) {
            case "1":
                double amountInARS = principal.convertToARS(amountInUSD);
                System.out.println(amountInUSD + " USD equivale a " + amountInARS + " ARS");
                break;
            case "2":
                double amountInBOB = principal.convertToBOB(amountInUSD);
                System.out.println(amountInUSD + " USD equivale a " + amountInBOB + " BOB");
                break;
            case "3":
                double amountInBRL = principal.convertToBRL(amountInUSD);
                System.out.println(amountInUSD + " USD equivale a " + amountInBRL + " BRL");
                break;
            case "4":
                double amountInCLP = principal.convertToCLP(amountInUSD);
                System.out.println(amountInUSD + " USD equivale a " + amountInCLP + " CLP");
                break;
            case "5":
                double amountInRMB = principal.convertToRMB(amountInUSD);
                System.out.println(amountInUSD + " USD equivale a " + amountInRMB + " CLP");
                break;
            case "6":
                double amountInCOP = principal.convertToCOP(amountInUSD);
                System.out.println(amountInUSD + " USD equivale a " + amountInCOP + " COP");
                break;
            case "7":
                double amountInJPY = principal.convertToJPY(amountInUSD);
                System.out.println(amountInUSD + " USD equivale a " + amountInJPY + " JPY");
                break;
            case "salir":
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
}