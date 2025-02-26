

import java.time.LocalDateTime;

public class Transaccion {
    private String emisor;
    private String receptor;
    private double monto;
    private LocalDateTime fecha;
    private CATEGORIA categoria;

    public Transaccion(String emisor, String receptor, double monto, CATEGORIA categoria) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.monto = monto;
        this.categoria = categoria;
        this.fecha = LocalDateTime.now();
    }

    public String getEmisor() {
        return emisor;
    }

    public String getReceptor() {
        return receptor;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public CATEGORIA getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Transacción {" +
                "Emisor: '" + emisor + '\'' +
                ", Receptor: '" + receptor + '\'' +
                ", Monto: $" + monto +
                ", Fecha: " + fecha +
                ", Categoría: " + categoria +
                '}';
    }
}

