/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.General;
import Modelo.Hilo_control;
import Modelo.Hilo_tiempo;
import Modelo.Pintura;
import Modelo.Producto;
import Vistas.VtnTrabajo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author esteb
 */
public class Controladorv1 implements ActionListener {

    private VtnTrabajo ventana1;
    private General estructuras; 

    public Controladorv1(VtnTrabajo ventana1, General estructuras) {
        this.ventana1 = ventana1;
        this.estructuras = estructuras; 
        Inicializar();
    }

    private void Inicializar() {
        ventana1.setVisible(true);
        ventana1.getBtnIniciar().addActionListener(this);
    }

    private void iniciarProceso() {
        
        Producto prodSeleccionado = null; 
        for (Producto prd : estructuras.getProductos()) {
            if(prd.getCodigo().equals(ventana1.getCampoProducto())){
                prodSeleccionado = prd; 
                break; 
            }
        }
        
        if(prodSeleccionado == null){
            System.out.println("No se encontro el producto, ingrese otro");
            return; 
        }
        
        Pintura pintura = null; 
        for (Pintura pint : estructuras.getPinturas()) {
            if(pint.getColor().equals(prodSeleccionado.getColor())){
                pintura = pint; 
                break; 
            }
        }
        
        if(pintura == null){
            System.out.println("El color del producto no puede ser procesado");
            return; 
        }
        
        System.out.println("Llega hasta aqui");
        
        
        
        Hilo_tiempo hilo_time = new Hilo_tiempo(ventana1.getTxtTime()); 

        Hilo_control control = new Hilo_control(hilo_time, ventana1, pintura );
        control.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventana1.getBtnIniciar()) {
            iniciarProceso();
        }
    }

}
