package wallet.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private static List<Usuario> usuariosRegistrados = new ArrayList<>();
    private int id;
    private String nombre;
    private String contrasena;

    public Usuario(int id, String nombre, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public static boolean registrarUsuario(String nombre, String contrasena) {
        // Verifica si ya existe un usuario con el mismo nombre
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getNombre().equals(nombre)) {
                System.out.println("Ya existe un usuario con este nombre.");
                return false;
            }
        }

        // Crea y agrega el usuario a la lista de usuarios registrados
        Usuario nuevoUsuario = new Usuario(usuariosRegistrados.size() + 1, nombre, contrasena);
        usuariosRegistrados.add(nuevoUsuario);
        System.out.println("Registro exitoso. ¡Bienvenido!");
        return true;
    }

    public static boolean iniciarSesion(String nombre, String contrasena) {
        // Busca el usuario en la lista de usuarios registrados
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getNombre().equals(nombre) && usuario.getContrasena().equals(contrasena)) {
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido!");
                return true;
            }
        }
        // Si no se encuentra el usuario, muestra un error
        System.out.println("Nombre de usuario o contraseña incorrectos. Inténtelo de nuevo.");
        return false;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
