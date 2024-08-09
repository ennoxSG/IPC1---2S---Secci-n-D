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
   
    private String nombre; 
    private int edad; 
    private String sonido; 
    
    public Animal(String nombre, int edad, String sonido) {
        this.nombre = nombre;
        this.edad = edad;
        this.sonido = sonido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }
    
    public void hacerSonido(){
        System.out.println("El animal hace: " + sonido);
    }
    
    
}
