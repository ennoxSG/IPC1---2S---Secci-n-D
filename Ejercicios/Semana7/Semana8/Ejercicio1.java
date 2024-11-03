public class Producto {
    private String nombre;
    private double precio;
    private static int totalProductos = 0;

    // Constructor
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        totalProductos++;
    }

    // Método de instancia
    public void mostrarInfo() {
        System.out.println("Producto: " + nombre + ", Precio: " + precio);
    }

    // Método estático
    public static void mostrarTotalProductos() {
        System.out.println("Total de productos creados: " + totalProductos);
    }
}

public class TiendaMain {
    public static void main(String[] args) {
        Producto producto1 = new Producto("Laptop", 1500.0);
        Producto producto2 = new Producto("Smartphone", 800.0);
        Producto producto3 = new Producto("Tablet", 300.0);

        producto1.mostrarInfo();
        producto2.mostrarInfo();
        producto3.mostrarInfo();

        Producto.mostrarTotalProductos();
    }
}
