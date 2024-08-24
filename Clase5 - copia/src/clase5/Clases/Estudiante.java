/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase5.Clases;

/**
 *
 * @author esteb
 */
public class Estudiante {
    private String codigo; 
    private String nombre;
    private String password; 
    private int rol;   //rol 1 = admin, rol 2 = usuario

    public Estudiante(String codigo, String nombre, String password, int rol) {
        this.codigo = codigo;
        this.nombre = nombre; 
        this.password = password;
        this.rol = rol;
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
    
    
    
    
    
    
    
    
    
    
    
}
