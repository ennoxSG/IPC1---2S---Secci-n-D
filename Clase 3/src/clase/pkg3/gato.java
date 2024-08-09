/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase.pkg3;

import java.util.ArrayList;

/**
 *
 * @author esteb
 */
public class gato extends Animal {
    private ArrayList<String> juguetes; 

    public gato(String nombre, int edad, String sonido) {
        super(nombre, edad, sonido);
        this.juguetes = new ArrayList<>();
    }

    public ArrayList<String> getJuguetes() {
        return juguetes;
    }

    public void setJuguetes(ArrayList<String> juguetes) {
        this.juguetes = juguetes;
    }
    
    public void ImprimirJuguetes() {
        for (int i = 0; i < juguetes.size(); i++) {
            System.out.println(juguetes.get(i));
        }
    }
    
    
    
    
    
}
