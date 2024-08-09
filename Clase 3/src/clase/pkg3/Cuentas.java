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
    
    // Atributo que define el nombre del titular de la cuenta.
    private String titular;

    // Atributo que almacena el saldo actual de la cuenta.
    private double saldo;

    // Constructor de la clase Cuentas que inicializa el nombre del titular y el saldo inicial de la cuenta.
    public Cuentas(String titular, double saldo) {
        this.titular = titular; // Inicializa el nombre del titular.
        this.saldo = saldo; // Inicializa el saldo de la cuenta.
    }

    // Método para depositar una cantidad en la cuenta.
    public void depositar(double cantidad) {
        if (cantidad > 0) { // Verifica que la cantidad a depositar sea positiva.
            saldo += cantidad; // Aumenta el saldo de la cuenta en la cantidad especificada.
            System.out.println("Depósito realizado. Saldo actual: " + saldo);
        } else {
            System.out.println("Cantidad inválida"); // Mensaje de error si la cantidad es negativa o cero.
        }
    }

    // Método para retirar una cantidad de la cuenta.
    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) { // Verifica que la cantidad a retirar sea positiva y no exceda el saldo disponible.
            saldo -= cantidad; // Disminuye el saldo de la cuenta en la cantidad especificada.
            System.out.println("Retiro realizado. Saldo actual: " + saldo);
        } else {
            System.out.println("Cantidad inválida o saldo insuficiente."); // Mensaje de error si la cantidad es inválida o el saldo es insuficiente.
        }
    }

    // Método getter para obtener el nombre del titular de la cuenta.
    public String getTitular() {
        return titular;
    }

    // Método setter para establecer el nombre del titular de la cuenta.
    public void setTitular(String titular) {
        this.titular = titular;
    }

    // Método getter para obtener el saldo actual de la cuenta.
    public double getSaldo() {
        return saldo;
    }

    // Método setter para establecer el saldo de la cuenta.
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
}
