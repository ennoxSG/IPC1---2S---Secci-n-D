/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase.pkg3;

/**
 *
 * @author esteb
 */
public class perro extends Animal {
    
    private String raza; 
    private boolean TieneCollar; 
    
    public perro(String raza, boolean TieneCollar, String nombre, int edad, String sonido ) {
        super(nombre, edad, sonido);
        this.raza = raza;
        this.TieneCollar = TieneCollar; 
        
       
        
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public boolean isTieneCollar() {
        return TieneCollar;
    }

    public void setTieneCollar(boolean TieneCollar) {
        this.TieneCollar = TieneCollar;
    }
    
    public void perseguirCola() {
        System.out.println("El perro persigue su cola.");
    }
    
}
