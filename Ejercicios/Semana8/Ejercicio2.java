abstract class Figura {
    protected String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularArea();

    public void mostrarNombre() {
        System.out.println("Figura: " + nombre);
    }
}

interface PerimetroCalculable {
    double calcularPerimetro();
}

class Cuadrado extends Figura implements PerimetroCalculable {
    private double lado;

    public Cuadrado(String nombre, double lado) {
        super(nombre);
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }
}

class Circulo extends Figura implements PerimetroCalculable {
    private double radio;

    public Circulo(String nombre, double radio) {
        super(nombre);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}

public class FigurasMain {
    public static void main(String[] args) {
        Cuadrado cuadrado = new Cuadrado("Cuadrado", 5.0);
        Circulo circulo = new Circulo("Círculo", 3.0);

        cuadrado.mostrarNombre();
        System.out.println("Área: " + cuadrado.calcularArea());
        System.out.println("Perímetro: " + cuadrado.calcularPerimetro());

        circulo.mostrarNombre();
        System.out.println("Área: " + circulo.calcularArea());
        System.out.println("Perímetro: " + circulo.calcularPerimetro());
    }
}
