/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase.pkg3;

/**
 *
 * @author esteb
 */
public class Cuentas {

    
    private String titular; 
    private double saldo; 

    public Cuentas(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }  
    
    
    public void depositar(double cantidad){
        if(cantidad > 0){
            saldo += cantidad; 
            System.out.println("Desposito realizado. Saldo actual: " + saldo);
            
        }else{
            System.out.println("Cantidad invalida");
        }
    
    }
    
    public void retirar(double cantidad){
        if(cantidad > 0 && cantidad <= saldo){
            saldo -= cantidad; 
            System.out.println("Retiro realizado. Saldo actual: " + saldo);
            
        }else{
            System.out.println("Cantidad invalida o saldo insuficiente.");
        }
    
    }
       
    
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
    
    
}
