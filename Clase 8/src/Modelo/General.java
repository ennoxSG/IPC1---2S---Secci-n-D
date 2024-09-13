/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author esteb
 */
public class General {
    private ArrayList<Producto> productos; 
    private ArrayList<Pintura> pinturas; 

    public General() {
        productos = new ArrayList(); 
        pinturas = new ArrayList(); 
        
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Pintura> getPinturas() {
        return pinturas;
    }

    public void setPinturas(ArrayList<Pintura> pinturas) {
        this.pinturas = pinturas;
    }
    
    
    
    
    
    
}
