/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase4;

import clase4.Clases.Estudiante;
import clase4.Ventanas.Login;
import java.util.ArrayList;

/**
 *
 * @author esteb
 */
public class Clase4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Creación de una lista de estudiantes utilizando la clase ArrayList
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        // Se añaden tres objetos de tipo Estudiante a la lista 'estudiantes'
        estudiantes.add(new Estudiante("Paco", "123", 1)); // Añadiendo un estudiante con nombre "Paco", contraseña "123", y ID de rol 1
        estudiantes.add(new Estudiante("Perez", "123", 1)); // Añadiendo un estudiante con nombre "Perez", contraseña "123", y ID de rol 1
        estudiantes.add(new Estudiante("Juan", "123", 2)); // Añadiendo un estudiante con nombre "Juan", contraseña "123", y ID de rol 2

        // Creación de un objeto de tipo Login, pasándole la lista de estudiantes como parámetro
        Login login = new Login(estudiantes);

        // Se hace visible la ventana de login para que el usuario pueda interactuar con ella
        login.setVisible(true);
        
        //Continuar con la ventana Login...

        
        
    }
    
}
