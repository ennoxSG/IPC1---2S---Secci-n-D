public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean disponible;

    // Constructor
    public Libro(String titulo, String autor, int anioPublicacion, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;
    }

    // Getters y Setters
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public boolean isDisponible() { return disponible; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    // Métodos para prestar y devolver libro
    public void prestarLibro() {
        if (disponible) {
            disponible = false;
            System.out.println("Libro prestado: " + titulo);
        } else {
            System.out.println("El libro ya está prestado: " + titulo);
        }
    }

    public void devolverLibro() {
        disponible = true;
        System.out.println("Libro devuelto: " + titulo);
    }
}

public class BibliotecaMain {
    public static void main(String[] args) {
        // Crear objetos Libro
        Libro libro1 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", 1967, true);
        Libro libro2 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 1605, true);

        // Mostrar detalles de los libros
        System.out.println("Libro: " + libro1.getTitulo() + ", Autor: " + libro1.getAutor() +
                ", Año: " + libro1.getAnioPublicacion() + ", Disponible: " + libro1.isDisponible());
        System.out.println("Libro: " + libro2.getTitulo() + ", Autor: " + libro2.getAutor() +
                ", Año: " + libro2.getAnioPublicacion() + ", Disponible: " + libro2.isDisponible());

        // Prestar y devolver libros
        libro1.prestarLibro();
        System.out.println("Disponible después de prestar: " + libro1.isDisponible());

        libro1.devolverLibro();
        System.out.println("Disponible después de devolver: " + libro1.isDisponible());
    }
}
