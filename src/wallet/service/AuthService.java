package wallet.service;

public class AuthService {
    private boolean usuarioAutenticado;

    public AuthService(){
        this.usuarioAutenticado = false;
    }

    public boolean usuarioAutenticado(){
        return this.usuarioAutenticado;
    }

    public boolean iniciarSesion(String nombreUsuario, String contrasena) {
        if (nombreUsuario.equals("usuario") && contrasena.equals("contraseña")) {
            this.usuarioAutenticado = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean registrarUsuario(String nombreUsuario, String contrasena) {
        return true;
    }
}


