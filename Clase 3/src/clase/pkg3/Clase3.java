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
        
        ArrayList<Cuentas> cuentas = new ArrayList<>();
        cuentas.add(new Cuentas("Esteban" , 100));
        cuentas.add(new Cuentas("Emerson" , 1000));
        cuentas.add(new Cuentas("Ayeser" , 500));
        
        for (Cuentas cuenta : cuentas){
            System.out.println("Tituar: " + cuenta.getTitular() + " , Saldo: " + cuenta.getSaldo());
        }
        
        cuentas.get(0).depositar(500.0);
        cuentas.get(1).retirar(300.0);
        
        System.out.println("Despues de realizar las operaciones: ");
        for (Cuentas cuenta : cuentas){
            System.out.println("Tituar: " + cuenta.getTitular() + " , Saldo: " + cuenta.getSaldo());
        }
        
        
        cuentas.get(2).retirar(600.0);
        
        
        System.out.println("------------------------------");
        
        perro wiskas = new perro(  "Labrador", true, "Wiskas", 4, "guau");
        gato minimo = new gato("Minino", 13, "miau");
        
        
        System.out.println("Acciones para: " + wiskas.getNombre());
        wiskas.hacerSonido(); 
        wiskas.perseguirCola();
        
        
        if(minimo.getJuguetes().isEmpty()){
            System.out.println("El ArrayList de juguetes esta vacio");
        }
        
        minimo.getJuguetes().add("pelota"); 
        minimo.getJuguetes().add("raton"); 
        
        minimo.ImprimirJuguetes();
        
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
