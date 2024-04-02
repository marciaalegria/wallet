package wallet.model;

public class Usuario {
    //usuario debe tener id contraseña nombre apellido
    int id;
    String nombre;
    String contrasena;

    public Usuario() {

    }

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

    public void saludarUsuario(){
        //saludoar a usuario
        System.out.println("Bienvenido " + nombre );
    }
    public void permiteAcceso(int contrasena){
        //si contraseña ingresada es igual a contraseña debe permitir acceso
        if(contrasena == 4){
            System.out.println("ingreso exitoso");
        }
        else {
            System.out.println("ingreso denegado");
        }
    }
}
