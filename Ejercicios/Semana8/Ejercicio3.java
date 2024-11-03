import java.io.*;

class Usuario implements Serializable {
    private String nombre;
    private String email;
    private int edad;

    public Usuario(String nombre, String email, int edad) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Email: " + email + ", Edad: " + edad;
    }
}

public class UsuarioMain {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Carlos", "carlos@correo.com", 25);

        // Serializar el objeto
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuario.ser"))) {
            out.writeObject(usuario);
            System.out.println("Objeto serializado.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserializar el objeto
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("usuario.ser"))) {
            Usuario usuarioDeserializado = (Usuario) in.readObject();
            System.out.println("Objeto deserializado: " + usuarioDeserializado);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
