package poo.proyecto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Sistema sistema = new Sistema();
        sistema.cargarDatosPrueba(); // TEMPORAL: reemplazar por carga real de archivos

        System.out.println("===== INICIO DE SESIÓN =====");
        System.out.print("Usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = sc.nextLine();

        Usuario usuarioLogueado = sistema.iniciarSesion(usuario, contrasena);

        if (usuarioLogueado == null) {
            System.out.println("Credenciales incorrectas.");
            return;
        }

        if (usuarioLogueado instanceof Aficionado) {
            Aficionado aficionado = (Aficionado) usuarioLogueado;
            System.out.println("Bienvenido/a " + aficionado.getNombre());

            boolean salir = false;
            while (!salir) {
                System.out.println("\n1. Consultar partidos");
                System.out.println("2. Comprar entrada");
                System.out.println("3. Salir");
                System.out.print("Opción: ");
                String opcion = sc.nextLine();

                switch (opcion) {
                    case "1":
                        for (Partido p : sistema.getPartidos()) {
                            System.out.println(p);
                            System.out.println("---");
                        }
                        break;
                    case "2":
                        System.out.print("Código del partido: ");
                        String codigoPartido = sc.nextLine();
                        Partido partidoSeleccionado = null;
                        for (Partido p : sistema.getPartidos()) {
                            if (p.getCodigo().equals(codigoPartido)) {
                                partidoSeleccionado = p;
                                break;
                            }
                        }
                        if (partidoSeleccionado == null) {
                            System.out.println("Partido no encontrado.");
                            break;
                        }
                        System.out.print("Zona (GENERAL, PREFERENCIAL, VIP): ");
                        Zona zona = Zona.valueOf(sc.nextLine().toUpperCase());
                        System.out.print("Cantidad: ");
                        int cantidad = Integer.parseInt(sc.nextLine());
                        System.out.print("Número de tarjeta: ");
                        String numTarjeta = sc.nextLine();

                        Compra compra = aficionado.comprar(partidoSeleccionado, zona, cantidad, numTarjeta);
                        if (compra != null) {
                            sistema.agregarCompra(compra);
                            System.out.println("Compra registrada:");
                            System.out.println(compra);
                        } else {
                            System.out.println("No se pudo completar la compra (stock insuficiente).");
                        }
                        break;
                    case "3":
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            }
        } else {
            System.out.println("Login de Organizador aún no probado en esta versión.");
        }

        sc.close();
    }
}