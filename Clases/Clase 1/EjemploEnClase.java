// Clase principal
public class EjemploClase1 {

    public static void main(String[] args) {
        
        // Parte 1: Declaraciones de variables primitivas
        int edad = 25;                   // Tipo primitivo: entero
        double altura = 1.70;            // Tipo primitivo: doble (punto flotante)
        char inicial = 'J';              // Tipo primitivo: carácter
        boolean esEstudiante = true;     // Tipo primitivo: booleano
        
        // Parte 2: Declaraciones de variables no primitivas
        String nombreCompleto = "Juan Pérez";  // Tipo no primitivo: String (clase)
        
        // Parte 3: Imprimir valores de variables
        System.out.println("Edad: " + edad);
        System.out.println("Altura: " + altura);
        System.out.println("Inicial: " + inicial);
        System.out.println("Es estudiante: " + esEstudiante);
        System.out.println("Nombre completo: " + nombreCompleto);
        
        // Parte 4: Casteo implícito
        int entero = 10;
        double decimal = entero; // Conversión implícita de int a double
        System.out.println("Casteo implícito:");
        System.out.println("Entero: " + entero);
        System.out.println("Decimal: " + decimal);
        
        // Parte 5: Casteo explícito
        double otroDecimal = 15.75;
        int otroEntero = (int) otroDecimal; // Conversión explícita de double a int
        System.out.println("Casteo explícito:");
        System.out.println("Otro Decimal: " + otroDecimal);
        System.out.println("Otro Entero: " + otroEntero);
        
        // Parte 6: Más ejemplos de casteo explícito
        char caracter = 'A';
        int asciiValue = (int) caracter; // Conversión explícita de char a int
        float flotante = 3.14f;
        int enteroDesdeFlotante = (int) flotante; // Conversión explícita de float a int
        long largo = 1234567890123456789L;
        int enteroDesdeLargo = (int) largo; // Conversión explícita de long a int (pérdida de precisión)
        System.out.println("Más ejemplos de casteo explícito:");
        System.out.println("Caracter a ASCII: " + asciiValue);
        System.out.println("Flotante a Entero: " + enteroDesdeFlotante);
        System.out.println("Largo a Entero: " + enteroDesdeLargo);
        
        // Parte 7: Conversión de String a otros tipos
        String strEntero = "123";
        int enteroDesdeString = Integer.parseInt(strEntero);
        String strDecimal = "3.14";
        double decimalDesdeString = Double.parseDouble(strDecimal);
        String strBooleano = "true";
        boolean booleanoDesdeString = Boolean.parseBoolean(strBooleano);
        System.out.println("Conversión de String a otros tipos:");
        System.out.println("String a int: " + enteroDesdeString);
        System.out.println("String a double: " + decimalDesdeString);
        System.out.println("String a boolean: " + booleanoDesdeString);
        
        // Parte 8: Operadores lógicos y estructura de control if
        int numero1 = 10;
        int numero2 = 5;
        int numero3 = 8;
        if (numero1 > numero2 && numero1 != numero3) {
            System.out.println("Condición 1: Verdadera");
        } else if (numero2 < numero3 || numero3 == 8) {
            System.out.println("Condición 2: Verdadera");
        } else {
            System.out.println("Ninguna condición es verdadera");
        }
        
        // Parte 9: Operadores aritméticos
        int resultadoSuma = numero1 + numero2;
        int resultadoResta = numero1 - numero2;
        int resultadoMultiplicacion = numero1 * numero2;
        int resultadoDivision = numero1 / numero2;
        int resultadoModulo = numero1 % numero2;
        System.out.println("Operadores Aritméticos:");
        System.out.println("Suma: " + resultadoSuma);
        System.out.println("Resta: " + resultadoResta);
        System.out.println("Multiplicación: " + resultadoMultiplicacion);
        System.out.println("División: " + resultadoDivision);
        System.out.println("Módulo: " + resultadoModulo);
        
        // Parte 10: Entrada del usuario y estructura de control switch
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        double primerNumero = scanner.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        double segundoNumero = scanner.nextDouble();
        System.out.println("Seleccione la operación:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Resultado de la Suma: " + (primerNumero + segundoNumero));
                break;
            case 2:
                System.out.println("Resultado de la Resta: " + (primerNumero - segundoNumero));
                break;
            case 3:
                System.out.println("Resultado de la Multiplicación: " + (primerNumero * segundoNumero));
                break;
            case 4:
                if (segundoNumero != 0) {
                    System.out.println("Resultado de la División: " + (primerNumero / segundoNumero));
                } else {
                    System.out.println("Error: No se puede dividir por cero.");
                }
                break;
            default:
                System.out.println("Opción no válida");
        }
        
        // Parte 11: Ciclo for
        System.out.println("Ciclo For:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteración " + i);
        }
        
        // Parte 12: Ciclo while
        System.out.println("Ciclo While:");
        int j = 1;
        while (j <= 5) {
            System.out.println("Iteración " + j);
            j++;
        }
        
        // Parte 13: Ciclo do-while
        System.out.println("Ciclo Do-While:");
        int k = 1;
        do {
            System.out.println("Iteración " + k);
            k++;
        } while (k <= 5);
        
    }
}
