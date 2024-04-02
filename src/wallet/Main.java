package wallet;

import wallet.service.AuthService;
import java.util.Scanner;
import wallet.model.Account;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private AuthService authService = new AuthService();

    private List<Account> cuentas = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.mostrarMenuPrincipal();
    }

    public void mostrarMenuPrincipal() {
        boolean salir = false;
        while (!salir) {
            System.out.println("Bienvenido a tu aplicación wallet");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            System.out.println("Por favor, seleccione una opción:");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer del scanner

            switch (opcion) {
                case 1:
                    iniciarSesion();
                    break;
                case 2:
                    registrarUsuario();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida, ingrese una opción válida");
                    break;
            }
        }
    }

    private void gestionarCuentas() {
        if (authService.usuarioAutenticado()) {
            boolean salir = false;
            while (!salir) {
                System.out.println("Gestión de cuentas");
                System.out.println("1. Ver cuentas");
                System.out.println("2. Agregar nueva cuenta");
                System.out.println("3. Eliminar cuenta");
                System.out.println("4. Volver al menú principal");
                System.out.println("Por favor, seleccione una opción:");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpia el buffer del scanner

                switch (opcion) {
                    case 1:
                        verCuentas();
                        break;
                    case 2:
                        agregarNuevaCuenta();
                        break;
                    case 3:
                        eliminarCuenta();
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida, ingrese una opción válida");
                        break;
                }
            }
        } else {
            System.out.println("Debe iniciar sesión para acceder a esta opción.");
        }
    }

    private void verCuentas() {
        System.out.println("Cuentas del usuario:");
        for (int i = 0; i < cuentas.size(); i++) {
            System.out.println((i + 1) + ". " + cuentas.get(i).getAccountName());
        }
    }

    private void agregarNuevaCuenta() {
        System.out.println("Agregar nueva cuenta");
        System.out.println("Ingrese el nombre de la cuenta:");
        String nombreCuenta = scanner.nextLine();
        System.out.println("Ingrese el saldo inicial:");
        double saldoInicial = scanner.nextDouble();
        scanner.nextLine(); // Limpia el buffer del scanner
        System.out.println("Ingrese la moneda:");
        String moneda = scanner.nextLine();

        Account nuevaCuenta = new Account(nombreCuenta, saldoInicial, moneda);
        cuentas.add(nuevaCuenta);
        System.out.println("La cuenta se agregó correctamente.");
    }

    private void eliminarCuenta() {
        System.out.println("Eliminar cuenta");
        System.out.println("Seleccione la cuenta que desea eliminar:");
        verCuentas();
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer del scanner
        if (opcion >= 1 && opcion <= cuentas.size()) {
            cuentas.remove(opcion - 1);
            System.out.println("La cuenta se eliminó correctamente.");
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private void iniciarSesion() {
        System.out.println("Inicio de sesión");
        System.out.println("Ingrese su nombre de usuario:");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contrasena = scanner.nextLine();

        // Lógica para verificar las credenciales e iniciar sesión
        boolean inicioSesionExitoso = authService.iniciarSesion(nombreUsuario, contrasena);

        if (inicioSesionExitoso) {
            System.out.println("Inicio de sesión exitoso. ¡Bienvenido!");
            // Aquí podrías agregar la lógica para lo que sucede después de iniciar sesión correctamente
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos. Inténtelo de nuevo.");
        }
    }

    private void registrarUsuario() {
        System.out.println("Registro de nuevo usuario");
        System.out.println("Ingrese un nombre de usuario:");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese una contraseña:");
        String contraseña = scanner.nextLine();

        // Llamar al método de AuthService para registrar al usuario
        boolean registroExitoso = authService.registrarUsuario(nombreUsuario, contraseña);

        if (registroExitoso) {
            System.out.println("Registro exitoso. ¡Bienvenido!");
            // Aquí podrías agregar la lógica para lo que sucede después de registrar al usuario correctamente
        } else {
            System.out.println("El nombre de usuario ya está en uso. Inténtelo de nuevo con un nombre de usuario diferente.");
        }
    }
}
