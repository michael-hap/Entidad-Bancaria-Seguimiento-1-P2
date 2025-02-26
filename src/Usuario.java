
import java.util.*;

public class Usuario {
    private static List<String> identificacionesRegistradas = new ArrayList<>();
    private String nombre;
    private String direccion;
    private String numeroIdentificacion;
    private String correo;
    private String contrasena;
    private Billetera billetera;

    public Usuario(String nombre, String direccion, String numeroIdentificacion, String correo, String contrasena)throws UsuarioExcepcion, BilleteraExcepcion {
        if (identificacionesRegistradas.contains(numeroIdentificacion)) {
            throw new UsuarioExcepcion("El usuario con identificación " + numeroIdentificacion + " ya está registrado.");
        }
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.correo = correo;
        this.contrasena = contrasena;
        this.billetera = new Billetera();
        identificacionesRegistradas.add(numeroIdentificacion);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Billetera getBilletera() {
        return billetera;
    }

    public void setBilletera(Billetera billetera) {
        this.billetera = billetera;
    }

    public static void eliminarUsuario(String numeroIdentificacion) throws UsuarioExcepcion {
        if (identificacionesRegistradas.contains(numeroIdentificacion)) {
            identificacionesRegistradas.remove(numeroIdentificacion);
        } else {
            throw new UsuarioExcepcion("No se encontró el usuario con identificación: " + numeroIdentificacion);
        }
    }

    public void actualizarDatos(String nombre, String direccion, String correo, String contrasena) throws UsuarioExcepcion {
        if (nombre == null || nombre.isEmpty() || direccion == null || direccion.isEmpty() || correo == null || correo.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            throw new UsuarioExcepcion("Todos los campos deben ser válidos y no estar vacíos.");
        }
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.contrasena = contrasena;
    }
}
