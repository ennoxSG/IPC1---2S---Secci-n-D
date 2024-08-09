/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase.pkg3;

/**
 *
 * @author esteb
 */

// Clase que representa a un perro, heredando de una clase padre que define características generales de un animal
public class perro extends Animal {
    
    private String raza;   // Atributo que define la raza del perro.
    private boolean TieneCollar;  // Atributo que indica si el perro tiene collar (true si tiene, false si no tiene).
    
    // Constructor de la clase Perro, que inicializa los atributos raza, TieneCollar, y los atributos de la clase padre.
    public perro(String raza, boolean TieneCollar, String nombre, int edad, String sonido ) {
        super(nombre, edad, sonido);  // Llamada al constructor de la clase padre para inicializar nombre, edad y sonido.
        this.raza = raza;           // Inicializa la raza del perro.
        this.TieneCollar = TieneCollar;     // Inicializa si el perro tiene o no collar.   
    }

    // Método getter para obtener la raza del perro.
    public String getRaza() {
        return raza;
    }

    // Método setter para establecer la raza del perro.
    public void setRaza(String raza) {
        this.raza = raza;
    }

    // Método getter para saber si el perro tiene collar.
    public boolean isTieneCollar() {
        return TieneCollar;
    }

    // Método setter para establecer si el perro tiene collar.
    public void setTieneCollar(boolean TieneCollar) {
        this.TieneCollar = TieneCollar;
    }
    
    // Método que simula la acción de un perro persiguiendo su cola.
    public void perseguirCola() {
        System.out.println("El perro persigue su cola.");
    }
    
}
