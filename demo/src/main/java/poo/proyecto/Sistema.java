package poo.proyecto;

import java.util.ArrayList;
import java.util.Date; // Importación necesaria para usar new Date()

public class Sistema {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Partido> partidos;
    private ArrayList<Compra> listaCompras;

    public Sistema() {
        this.usuarios = new ArrayList<>();
        this.partidos = new ArrayList<>();
        this.listaCompras = new ArrayList<>();
    }

    public void cargarDatosPrueba() {
        // 1. Crear un Aficionado a mano y agregarlo a "usuarios"
        Aficionado a1 = new Aficionado("A001", "0923456789", "Carlos", "Mendoza",
                 "cmendoza", "mundo2026", "carlos@email.com", Rol.AFICIONADO,
                 "0999999999", "Ecuador");
        usuarios.add(a1);

        // 2. Crear un Partido a mano (con precios de prueba) y agregarlo a "partidos"
        Partido p1 = new Partido("M001", "Ecuador", "Japon", new Date(),
                 "Azteca", "CDMX", 80000, 30000, 10000, 2000, "Fase de grupos",
                 45.0, 85.0, 150.0);
        partidos.add(p1);
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public ArrayList<Compra> getListaCompras() {
        return listaCompras;
    }

    public void agregarCompra(Compra compra) {
        this.listaCompras.add(compra);
    }

    public Usuario iniciarSesion(String usuario, String contrasena) {
        // 3 y 4. Recorre "usuarios" y compara credenciales
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario) && u.getContrasenia().equals(contrasena)) {
                // 5. Si coincide, retorna el usuario inmediatamente
                return u;
            }
        }
        // 6. Si termina el bucle sin encontrar nada, retorna null
        return null;
    }
}