/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase6;

import clase6.Clases.Estudiante;
import clase6.Clases.Muestra;
import clase6.Ventanas.Login;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author esteb
 */
public class Clase6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        // Creación de una lista de estudiantes utilizando la clase ArrayList
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        ArrayList<Muestra> muestras = new ArrayList<>();
        
        try (FileInputStream fileIn = new FileInputStream("muestras.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
            muestras = (ArrayList<Muestra>) in.readObject();
            System.out.println("Datos deserializados correctamente.");
        } catch (IOException | ClassNotFoundException i) {
            
            System.out.println("No se encuentra el archivo");
        }
        
        try (FileInputStream fileIn = new FileInputStream("estudiantes.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
            estudiantes = (ArrayList<Estudiante>) in.readObject();
            System.out.println("Datos deserializados correctamente.");
        } catch (IOException | ClassNotFoundException i) {
            
            System.out.println("No se encuentra el archivo");
        }
        
        //Si al momento de deserializar no hay elementos (lsita esta vacia) se añaden estos de ejemplo
        if (muestras.isEmpty()) {
            muestras.add(new Muestra("1", "Muestra 1", new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, "Ingreso"));
            muestras.add(new Muestra("2", "Muestra 2", new int[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}}, "Ingreso"));
        }
        
        
        // Verificar si ya se añadio un elemento a la lista
        boolean encontrado = false;
        for(Estudiante estudiante : estudiantes){
            if(estudiante.getCodigo().equals("125")){
                encontrado = true; 
                break; 
            }
        }
        if (!encontrado){
            estudiantes.add(new Estudiante("125", "Esteban","123", 2)); // Añadiendo un estudiante con nombre "Juan", contraseña "123", y ID de rol 2  
        }
        
        // Creación de un objeto de tipo Login, pasándole la lista de estudiantes como parámetro
        Login login = new Login(estudiantes, muestras);

        // Se hace visible la ventana de login para que el usuario pueda interactuar con ella
        login.setVisible(true);
                
        //Continuar con la ventana Login...

    }
    
    
    
    
}
