/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author esteb
 */
public class Hilo_control extends Thread {
    private Hilo_progreso h1; 
    private Hilo_progreso h2;
    private Hilo_progreso h3;
    
    private volatile boolean ejecutar = true;

    public Hilo_control(Hilo_progreso h1, Hilo_progreso h2, Hilo_progreso h3) {
        this.h1 = h1;
        this.h2 = h2;
        this.h3 = h3;
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
            h1.start(); 
            h1.join();
            
            h2.start(); 
            h2.join();
            
            h3.start(); 
            h3.join();
        
        } catch (InterruptedException e){
            e.printStackTrace();    
        }
    
    
    
    }
    
    
    
    
    
    
    
}
