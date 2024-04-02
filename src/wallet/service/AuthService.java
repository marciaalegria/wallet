package wallet.service;

public class AuthService {
    private boolean usuarioAutenticado;

    public AuthService(){
        this.usuarioAutenticado = false;
    }
    // Método para iniciar sesión
    public boolean iniciarSesion(String nombreUsuario, String contraseña) {
        // Aquí iría la lógica para verificar las credenciales
        // Por ahora, simplemente devolvemos true para simular un inicio de sesión exitoso
        this.usuarioAutenticado = true;
        return this.usuarioAutenticado;
    }

    public boolean usuarioAutenticado(){
        return this.usuarioAutenticado;
    }

    // Método para registrar un nuevo usuario
    public boolean registrarUsuario(String nombreUsuario, String contraseña) {
        // Aquí iría la lógica para registrar al usuario
        // Por ahora, simplemente devolvemos true para simular un registro exitoso
        return true;
    }
}

