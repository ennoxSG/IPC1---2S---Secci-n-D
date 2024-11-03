public class CuentaBancaria {
    private String numeroCuenta;
    private String nombreTitular;
    private double saldo;

    // Constructor con parámetros
    public CuentaBancaria(String numeroCuenta, String nombreTitular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.nombreTitular = nombreTitular;
        this.saldo = saldo;
    }

    // Constructor sin parámetros
    public CuentaBancaria() {
        this.numeroCuenta = "Desconocido";
        this.nombreTitular = "Sin titular";
        this.saldo = 0.0;
    }

    // Método para depositar dinero
    public void depositar(double monto) {
        saldo += monto;
        System.out.println("Depósito realizado. Nuevo saldo: " + saldo);
    }

    // Método para retirar dinero
    public void retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiro realizado. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    // Método finalize para observar la eliminación del objeto
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Cuenta " + numeroCuenta + " eliminada de la memoria.");
    }

    // Getters
    public String getNumeroCuenta() { return numeroCuenta; }
    public String getNombreTitular() { return nombreTitular; }
    public double getSaldo() { return saldo; }
}

public class BancoMain {
    public static void main(String[] args) {
        // Crear cuenta con el constructor con parámetros
        CuentaBancaria cuenta1 = new CuentaBancaria("123456", "Juan Pérez", 1000.0);
        // Crear cuenta con el constructor sin parámetros
        CuentaBancaria cuenta2 = new CuentaBancaria();

        // Mostrar detalles de las cuentas
        System.out.println("Cuenta: " + cuenta1.getNumeroCuenta() + ", Titular: " + cuenta1.getNombreTitular() +
                ", Saldo: " + cuenta1.getSaldo());
        System.out.println("Cuenta: " + cuenta2.getNumeroCuenta() + ", Titular: " + cuenta2.getNombreTitular() +
                ", Saldo: " + cuenta2.getSaldo());

        // Realizar un depósito en la primera cuenta
        cuenta1.depositar(500.0);

        // Intentar un retiro en la segunda cuenta
        cuenta2.retirar(100.0);
    }
}
