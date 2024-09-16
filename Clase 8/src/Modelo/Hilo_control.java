/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vistas.VtnTrabajo;
import javax.swing.SwingUtilities;

/**
 *
 * @author esteb
 */
public class Hilo_control extends Thread {
    private Hilo_tiempo h4;
    private Pintura pintura;
    private int cantidad; 
    private VtnTrabajo ventana1; 
    
    private volatile boolean ejecutar = true;

    public Hilo_control(Hilo_tiempo h4, VtnTrabajo vtn, Pintura pintura, int cantidad) {
        this.h4 = h4;
        this.pintura = pintura; 
        this.ventana1 = vtn; 
        this.cantidad = cantidad; 
    }
    
    public void detener(){
        setEjecutar(false);
    }

    public boolean isEjecutar() {
        return ejecutar;
    }

    public void setEjecutar(boolean ejecutar) {
        this.ejecutar = ejecutar;
    }
    
    @Override
    public void run(){
        try {
            
            h4.start(); 
            double costo_total = 0; 
            
            for (int i = 0; i < cantidad; i++) {
                
                SwingUtilities.invokeLater(() -> ventana1.getBart1().setValue(0));
                SwingUtilities.invokeLater(() -> ventana1.getBart2().setValue( 0));
                SwingUtilities.invokeLater(() -> ventana1.getBart3().setValue(0));
                
                //Parametros que recibe: JProgressBar barraProgreso, int tiempoTotal, double costo
                Hilo_progreso hilo_trabajo = new Hilo_progreso(ventana1.getBart1(), 5, 3);
                Hilo_progreso hilo_pintura = new Hilo_progreso(ventana1.getBart2(), pintura.getTiempo(), pintura.getCosto());
                Hilo_progreso hilo_empaquetado = new Hilo_progreso(ventana1.getBart3(), 10, 2);
                
                hilo_trabajo.start(); 
                hilo_trabajo.join();
                System.out.println("Coto de trabajo " + hilo_trabajo.getCostototal());
                costo_total = costo_total + hilo_trabajo.getCostototal(); 

                hilo_pintura.start(); 
                hilo_pintura.join();
                System.out.println("Coto de pintura " +hilo_pintura.getCostototal()); 
                costo_total = costo_total + hilo_pintura.getCostototal(); 
                

                hilo_empaquetado.start(); 
                hilo_empaquetado.join();
                System.out.println("Coto de empaquetado " +hilo_empaquetado.getCostototal()); 
                costo_total = costo_total + hilo_empaquetado.getCostototal(); 
            }
            
            h4.detener();
            System.out.println("Costo total: " + costo_total);
        
        } catch (InterruptedException e){
            e.printStackTrace();    
        }
    
    
    
    }
    
    
    
    
    
    
    
}
