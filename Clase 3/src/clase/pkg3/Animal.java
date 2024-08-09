/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase.pkg3;

/**
 *
 * @author esteb
 */
public class Animal {
   
    // Atributo que almacena el nombre del animal.
    private String nombre;
    // Atributo que almacena la edad del animal.
    private int edad;

    // Atributo que almacena el sonido del animal.
    private String sonido;

    // Constructor de la clase Animal, que inicializa los atributos nombre, edad y sonido.
    public Animal(String nombre, int edad, String sonido) {
        this.nombre = nombre; // Inicializa el nombre del animal.
        this.edad = edad; // Inicializa la edad del animal.
        this.sonido = sonido; // Inicializa el sonido característico del animal.
    }

    // Método getter para obtener el nombre del animal.
    public String getNombre() {
        return nombre;
    }

    // Método setter para establecer el nombre del animal.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método getter para obtener la edad del animal.
    public int getEdad() {
        return edad;
    }

    // Método setter para establecer la edad del animal.
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método getter para obtener el sonido del animal.
    public String getSonido() {
        return sonido;
    }

    // Método setter para establecer el sonido del animal.
    public void setSonido(String sonido) {
        this.sonido = sonido;
    }

    // Método que imprime el sonido del animal.
    public void hacerSonido() {
        System.out.println("El animal hace: " + sonido);
    }
    
    
}
