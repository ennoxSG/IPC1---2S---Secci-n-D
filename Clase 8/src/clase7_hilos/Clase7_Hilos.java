/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase7_hilos;

import Controlador.Controladorv1;
import Modelo.General;
import Modelo.Pintura;
import Modelo.Producto;
import Vistas.VtnTrabajo;
import java.util.ArrayList;

/**
 *
 * @author esteb
 */
public class Clase7_Hilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        General modelo_general = new General(); 
        
        ArrayList<Pintura> pinturas = new ArrayList(); 
        pinturas.add(new Pintura("verde", 3, 3.00));
        pinturas.add(new Pintura("negro", 25, 1.00));
        
        
        modelo_general.setPinturas(pinturas);
        
        //String nomnre, String codigo, String material, String color
        modelo_general.getProductos().add(new Producto("Carrito","P-01","plastico","verde"));
        
        
        
        
        
        VtnTrabajo vtn = new VtnTrabajo(); 
        Controladorv1 controlador1 = new Controladorv1(vtn,modelo_general); 
        
        
    }
    
}
