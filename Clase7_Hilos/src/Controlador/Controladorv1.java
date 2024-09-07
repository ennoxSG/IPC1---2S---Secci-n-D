/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Hilo_control;
import Modelo.Hilo_progreso;
import Vistas.VtnTrabajo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author esteb
 */
public class Controladorv1 implements ActionListener {

    private VtnTrabajo ventana1;

    public Controladorv1(VtnTrabajo ventana1) {
        this.ventana1 = ventana1;
        Inicializar();
    }

    private void Inicializar() {
        ventana1.setVisible(true);
        ventana1.getBtnIniciar().addActionListener(this);
    }

    private void iniciarProceso() {
        Hilo_progreso hilo1 = new Hilo_progreso(ventana1.getBart1(), 5);

        Hilo_progreso hilo2 = new Hilo_progreso(ventana1.getBart2(), 6);

        Hilo_progreso hilo3 = new Hilo_progreso(ventana1.getBart3(), 7);

        Hilo_control control = new Hilo_control(hilo1, hilo2, hilo3);
        control.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventana1.getBtnIniciar()) {
            iniciarProceso();
        }
    }

}
