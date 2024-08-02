import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            if (opcion == 5) {
                System.out.println("Saliendo de la calculadora.");
                break;
            }

            double numero1 = solicitarNumero(scanner, "Ingrese el primer numero: ");
            double numero2 = solicitarNumero(scanner, "Ingrese el segundo numero: ");

            realizarOperacion(opcion, numero1, numero2);
        } while (opcion != 5);

        scanner.close();
    }

    // Procedimiento para mostrar el menu
    public static void mostrarMenu() {
        System.out.println("Seleccione la operacion:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");
        System.out.println("5. Salir");
        System.out.print("Ingrese su opcion: ");
    }

    // Funcion para solicitar un numero al usuario
    public static double solicitarNumero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    // Procedimiento para realizar la operacion seleccionada
    public static void realizarOperacion(int opcion, double numero1, double numero2) {
        switch (opcion) {
            case 1:
                System.out.println("Resultado de la Suma: " + sumar(numero1, numero2));
                break;
            case 2:
                System.out.println("Resultado de la Resta: " + restar(numero1, numero2));
                break;
            case 3:
                System.out.println("Resultado de la Multiplicacion: " + multiplicar(numero1, numero2));
                break;
            case 4:
                dividir(numero1, numero2);
                break;
            default:
                System.out.println("Opcion no valida, por favor intente de nuevo.");
                break;
        }
    }

    // Funcion para sumar dos numeros
    public static double sumar(double a, double b) {
        return a + b;
    }

    // Funcion para restar dos numeros
    public static double restar(double a, double b) {
        return a - b;
    }

    // Funcion para multiplicar dos numeros
    public static double multiplicar(double a, double b) {
        return a * b;
    }

    // Procedimiento para dividir dos numeros
    public static void dividir(double a, double b) {
        if (b != 0) {
            System.out.println("Resultado de la Division: " + (a / b));
        } else {
            System.out.println("Error: No se puede dividir por cero.");
        }
    }
}
