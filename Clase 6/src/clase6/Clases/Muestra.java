/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase6.Clases;

import java.io.Serializable;

/**
 *
 * @author esteb
 */
public class Muestra implements Serializable{
    private String id; 
    private String nombre; 
    private int[][] patron; 
    private String estado;

    public Muestra(String id, String nombre, int[][] patron, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.patron = patron;
        this.estado = estado; 
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
    
}
