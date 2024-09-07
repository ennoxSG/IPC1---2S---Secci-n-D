/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 *
 * @author esteb
 */
public class Hilo_progreso extends Thread {
    private JProgressBar barraProgreso; 
    private int tiempoTotal; 
    private double progreso; 
    
    private volatile boolean ejecutar = true; 

    public Hilo_progreso(JProgressBar barraProgreso, int tiempoTotal) {
        this.barraProgreso = barraProgreso;
        this.tiempoTotal = tiempoTotal;
        this.progreso = 0;
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
        int segundos = 0; 
        double intervalo = 100/tiempoTotal; 
        
        while(isEjecutar() == true){
            try{
                segundos =+1; 
                progreso += intervalo; 
                
                if(segundos == tiempoTotal || progreso >= 100){
                    progreso = 100; 
                    detener(); 
                }
                
                
                SwingUtilities.invokeLater(() -> barraProgreso.setValue((int) progreso));
                Thread.sleep(1000); 
            }catch (InterruptedException e){
                e.printStackTrace();
            
            }
        
        
        }
    
    
    
    
    }
    
    
    
}
