/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author esteb
 */
public class Producto {
    private String nomnre; 
    private String codigo; 
    private String material; 
    private String color; 

    public Producto(String nomnre, String codigo, String material, String color) {
        this.nomnre = nomnre;
        this.codigo = codigo;
        this.material = material;
        this.color = color;
    }

    public String getNomnre() {
        return nomnre;
    }

    public void setNomnre(String nomnre) {
        this.nomnre = nomnre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
    
}
