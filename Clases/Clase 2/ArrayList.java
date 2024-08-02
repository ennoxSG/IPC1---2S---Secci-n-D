import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear un ArrayList
        ArrayList<String> frutas = new ArrayList<>();

        // Agregar elementos al ArrayList
        frutas.add("Manzana");
        frutas.add("Banana");
        frutas.add("Cereza");

        // Imprimir el ArrayList
        System.out.println("Lista de frutas: " + frutas);

        // Obtener un elemento del ArrayList
        String primeraFruta = frutas.get(0);
        System.out.println("Primera fruta: " + primeraFruta);

        // Modificar un elemento del ArrayList
        frutas.set(1, "Mango");
        System.out.println("Lista de frutas despues de modificar: " + frutas);

        // Eliminar un elemento del ArrayList por indice
        frutas.remove(2);
        System.out.println("Lista de frutas despues de eliminar el tercer elemento: " + frutas);

        // Comprobar si el ArrayList contiene un elemento
        boolean contieneManzana = frutas.contains("Manzana");
        System.out.println("La lista contiene 'Manzana'? " + contieneManzana);

        // Obtener el tamaño del ArrayList
        int tamano = frutas.size();
        System.out.println("Tamano de la lista de frutas: " + tamano);

        // Recorrer el ArrayList
        System.out.println("Recorriendo la lista de frutas:");
        for (int i = 0; i < frutas.size(); i++) {
            System.out.println(frutas.get(i));
        }

        // Limpiar el ArrayList
        frutas.clear();
        System.out.println("Lista de frutas despues de limpiar: " + frutas);
    }
}
