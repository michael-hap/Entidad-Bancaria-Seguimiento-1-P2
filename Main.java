//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            // Crear usuarios
            Usuario usuario1 = new Usuario("Juan Perez", "Calle 123", "1234567890", "juan@example.com", "password");
            System.out.println("Usuario 1 creado con éxito.");

            // Intentar crear un usuario con el mismo número de identificación
            Usuario usuario2 = new Usuario("Ana Gomez", "Calle 456", "1234567890", "ana@example.com", "password");
            System.out.println("Usuario 2 creado con éxito.");

        } catch (UsuarioExcepcion | BilleteraExcepcion e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Eliminar usuario
            Usuario.eliminarUsuario("1234567890");
            System.out.println("Usuario eliminado con éxito.");

            // Intentar eliminar un usuario inexistente
            Usuario.eliminarUsuario("0000000000");
        } catch (UsuarioExcepcion e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Obtener billetera válida
            Billetera billetera = Billetera.obtenerBilletera("1234567890");
            System.out.println("Billetera obtenida: " + billetera.getNumeroBilletera());

            // Intentar obtener una billetera inexistente
            Billetera.obtenerBilletera("0000000000");
        } catch (BilleteraExcepcion e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
