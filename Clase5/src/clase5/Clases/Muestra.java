/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase5.Clases;

import java.io.Serializable;

/**
 *
 * @author esteb
 */
public class Muestra implements Serializable{
    private int id; 
    private String nombre; 
    private int[][] patron; 

    public Muestra(int id, String nombre, int[][] patron) {
        this.id = id;
        this.nombre = nombre;
        this.patron = patron;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[][] getPatron() {
        return patron;
    }

    public void setPatron(int[][] patron) {
        this.patron = patron;
    }
    
    
    
}
