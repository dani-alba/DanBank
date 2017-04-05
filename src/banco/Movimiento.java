package banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento {

    private LocalDateTime fecha;
    private String dni;
    private double cantidad;
    private String descripcion;

    public Movimiento(LocalDateTime fecha, String dni, double cantidad, String descripccion) {
        this.fecha = fecha;
        this.dni = dni;
        this.cantidad = cantidad;
        this.descripcion = descripccion;
    }

    public Movimiento(String dni, double cantidad, String descripcion) {
        this.dni = dni;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.fecha = LocalDateTime.now();
    }

    public Movimiento(LocalDateTime fecha, String dni, double cantidad) {
        this.fecha = fecha;
        this.dni = dni;
        this.cantidad = cantidad;
    }

    public Movimiento(String dni, double cantidad) {
        this.dni = dni;
        this.cantidad = cantidad;
        this.fecha = LocalDateTime.now();
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getFechaFormateada() {
        DateTimeFormatter formateo = DateTimeFormatter.ofPattern("dd/MM/yyyy "
                + "-- HH:mm");
        return this.fecha.format(formateo);
    }

    public String getDni() {
        return dni;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        String mostrar, añadir;

        mostrar = "FECHA: " + this.getFechaFormateada()
                + " /- CANTIDAD: " + this.cantidad;

        if (this.descripcion.equalsIgnoreCase("") || this.descripcion == null) {
            añadir = " /- DESCRIPCION: -vacia-";
        } else {
            añadir = " /- DESCRIPCION: " + this.descripcion;
        }

        return mostrar + añadir;
    }

}
