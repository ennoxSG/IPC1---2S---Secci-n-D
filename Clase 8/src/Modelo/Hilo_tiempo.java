/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.swing.JLabel;

/**
 *
 * @author esteb
 */
public class Hilo_tiempo extends Thread {
    private volatile boolean ejecutar = true; 
    private JLabel txt; 

    public Hilo_tiempo(JLabel txt) {
        this.txt = txt;
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
        
        while(ejecutar){
            try{
                
                Thread.sleep(1000); // 1 seg 
                segundos++; 
                
                int minutos = segundos / 60; 
                int seg = segundos % 60; 
                
                txt.setText(String.format("%02d:%02d", minutos, seg));   //1 -> 01  
                System.out.printf("Tiempo transcurrido: %02d:%02d  \n", minutos, seg); 
            }catch (InterruptedException e){
                e.printStackTrace();
            
            }
        
        
        }
    
    
    
    
    }
    
    
    
    
}
