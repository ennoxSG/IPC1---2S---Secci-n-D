import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            // Menu de opciones
            System.out.println("Seleccione la operacion:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opcion: ");
            opcion = scanner.nextInt();

            if (opcion == 5) {
                System.out.println("Saliendo de la calculadora.");
                break;
            }

            // Solicitar numeros al usuario
            System.out.print("Ingrese el primer numero: ");
            double numero1 = scanner.nextDouble();

            System.out.print("Ingrese el segundo numero: ");
            double numero2 = scanner.nextDouble();

            // Realizar la operacion seleccionada
            switch (opcion) {
                case 1:
                    System.out.println("Resultado de la Suma: " + (numero1 + numero2));
                    break;
                case 2:
                    System.out.println("Resultado de la Resta: " + (numero1 - numero2));
                    break;
                case 3:
                    System.out.println("Resultado de la Multiplicacion: " + (numero1 * numero2));
                    break;
                case 4:
                    if (numero2 != 0) {
                        System.out.println("Resultado de la Division: " + (numero1 / numero2));
                    } else {
                        System.out.println("Error: No se puede dividir por cero.");
                    }
                    break;
                default:
                    System.out.println("Opcion no válida, por favor intente de nuevo.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }
}
