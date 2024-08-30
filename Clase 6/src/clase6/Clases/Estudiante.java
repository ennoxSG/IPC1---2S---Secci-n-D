/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase6.Clases;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author esteb
 */
public class Estudiante implements Serializable {
    private String codigo; 
    private String nombre;
    private String password; 
    private int rol;   //rol 1 = admin, rol 2 = usuario
    private ArrayList<Muestra> muestras; 

    public Estudiante(String codigo, String nombre, String password, int rol) {
        this.codigo = codigo;
        this.nombre = nombre; 
        this.password = password;
        this.rol = rol;
        
        this.muestras = new ArrayList<>(); 
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Muestra> getMuestras() {
        return muestras;
    }

    public void setMuestras(ArrayList<Muestra> muestras) {
        this.muestras = muestras;
    }
    
    
    public void addMuestra(Muestra muestra) {
        this.muestras.add(muestra);
    }
}
