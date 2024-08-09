/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase.pkg3;

import java.util.ArrayList;

/**
 *
 * @author esteb
 */
public class Clase3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Crear un ArrayList para almacenar objetos de la clase Cuentas.
        ArrayList<Cuentas> cuentas = new ArrayList<>();

        // Agregar nuevas cuentas al ArrayList.
        cuentas.add(new Cuentas("Esteban", 100)); // Añade una cuenta con titular "Esteban" y saldo 100.
        cuentas.add(new Cuentas("Emerson", 1000)); // Añade una cuenta con titular "Emerson" y saldo 1000.
        cuentas.add(new Cuentas("Ayeser", 500)); // Añade una cuenta con titular "Ayeser" y saldo 500.

        // Recorrer el ArrayList e imprimir los detalles de cada cuenta.
        for (Cuentas cuenta : cuentas) {
            System.out.println("Titular: " + cuenta.getTitular() + " , Saldo: " + cuenta.getSaldo());
        }

        // Realizar operaciones de depósito y retiro en las cuentas.
        cuentas.get(0).depositar(500.0); // Deposita 500 en la cuenta de Esteban.
        cuentas.get(1).retirar(300.0); // Retira 300 de la cuenta de Emerson.

        System.out.println("Después de realizar las operaciones:");

        // Imprimir nuevamente los detalles de cada cuenta después de las operaciones.
        for (Cuentas cuenta : cuentas) {
            System.out.println("Titular: " + cuenta.getTitular() + " , Saldo: " + cuenta.getSaldo());
        }

        // Intentar retirar una cantidad mayor al saldo disponible en la cuenta de Ayeser.
        cuentas.get(2).retirar(600.0); // Esto debería mostrar un mensaje de error por saldo insuficiente.

        System.out.println("------------------------------");

        // Crear objetos de las clases Perro y Gato.
        Perro wiskas = new Perro("Labrador", true, "Wiskas", 4, "guau"); // Crea un perro llamado "Wiskas".
        Gato minimo = new Gato("Minino", 13, "miau"); // Crea un gato llamado "Minino".

        // Realizar acciones con el perro Wiskas.
        System.out.println("Acciones para: " + wiskas.getNombre());
        wiskas.hacerSonido(); // El perro hace su sonido (guau).
        wiskas.perseguirCola(); // El perro persigue su cola.

        // Verificar si el ArrayList de juguetes del gato Minimo está vacío.
        if (minimo.getJuguetes().isEmpty()) {
            System.out.println("El ArrayList de juguetes está vacío");
        }

        // Añadir juguetes al ArrayList de Minimo.
        minimo.getJuguetes().add("pelota"); // Añade una "pelota" a la lista de juguetes.
        minimo.getJuguetes().add("raton"); // Añade un "ratón" a la lista de juguetes.

        // Imprimir los juguetes del gato Minimo.
        minimo.imprimirJuguetes();
        System.out.println("-----------------");
        System.out.println("Ejemplo de Arraylist");
        
        // Creación de un ArrayList para almacenar objetos de la clase "perro"
        ArrayList<perro> perros = new ArrayList<>(); 

        // Agregando el perro "wiskas" al ArrayList
        perros.add(wiskas);

        // Accediendo al primer perro en el ArrayList
        perro primerPerro = perros.get(0);
        System.out.println(primerPerro.getNombre());

        // Verificando si el ArrayList de perros contiene al perro "wiskas"
        if (perros.contains(wiskas)) {
            System.out.println("El ArrayList de perros contiene a Wiskas");
        }

        // Obteniendo la cantidad de perros en el ArrayList
        int cantidadDePerros = perros.size();
        System.out.println("Cantidad de perros en el ArrayList: " + cantidadDePerros);

        // Removiendo el perro "wiskas" del ArrayList
        perros.remove(wiskas);

        // Verificando si el ArrayList de perros está vacío después de remover
        if (perros.isEmpty()) {
            System.out.println("El ArrayList de perros esta vacio despues de remover a Wiskas");
        }

        // Limpiando completamente el ArrayList de perros
        perros.clear();
        System.out.println("El ArrayList de perros ha sido limpiado");

        
        perros.add(new perro("Golden Retriever", false, "Max", 3, "woof"));
        perro max = new perro("Bulldog", true, "Rocky", 5, "bark");
        perros.add(max);
        
        // Iterando a través de todos los perros en el ArrayList
        System.out.println("Listado de perros en el ArrayList:");
        for (perro p : perros) {
            System.out.println("Nombre: " + p.getNombre() + ", Raza: " + p.getRaza());
        }
        
        
    }
    
}
