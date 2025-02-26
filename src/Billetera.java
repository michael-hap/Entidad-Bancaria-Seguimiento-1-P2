
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Billetera {
    private static List<String> billeterasRegistradas = new ArrayList<>();
    private String numeroBilletera;
    private double saldo;
    private List<Transaccion> transacciones;

    public Billetera() throws BilleteraExcepcion {
        this.numeroBilletera = generarNumeroBilletera();
        this.saldo = 0;
        this.transacciones = new ArrayList<>();
    }

    // Generar un número de billetera de 10 dígitos y validar que no esté en uso
    private String generarNumeroBilletera() throws BilleteraExcepcion {
        Random random = new Random();
        StringBuilder numero = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            numero.append(random.nextInt(10));
        }
        String nuevoNumero = numero.toString();
        if (billeterasRegistradas.contains(nuevoNumero)) {
            throw new BilleteraExcepcion("Número de billetera ya existe: " + nuevoNumero);
        }
        billeterasRegistradas.add(nuevoNumero);
        return nuevoNumero;
    }



    // Recargar saldo en la billetera
    public void recargar(double monto) {
        if (monto > 0) {
            saldo += monto;
        } else {
            throw new IllegalArgumentException("El monto de recarga debe ser positivo.");
        }
    }

    // Transferir dinero a otra billetera
    public void transferir(Billetera destinatario, double monto, CATEGORIA categoria) {
        double costoTransferencia = 200;
        if (saldo >= monto + costoTransferencia) {
            saldo -= (monto + costoTransferencia);
            destinatario.recargar(monto);

            // Registrar la transacción en ambas billeteras
            Transaccion transaccion = new Transaccion(this.numeroBilletera, destinatario.getNumeroBilletera(), monto, categoria);
            this.registrarTransaccion(transaccion);
            destinatario.registrarTransaccion(transaccion);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente para realizar la transferencia.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumeroBilletera() {
        return numeroBilletera;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void registrarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }

    public static Billetera obtenerBilletera(String numeroBilletera) throws BilleteraExcepcion {
        if (billeterasRegistradas.contains(numeroBilletera)) {
            return new Billetera(); // En un escenario real, se debería obtener la billetera real.
        } else {
            throw new BilleteraExcepcion("No se encontró la billetera con número: " + numeroBilletera);
        }
    }
}

