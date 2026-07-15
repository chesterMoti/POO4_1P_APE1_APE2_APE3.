package poo.proyecto;
import java.util.Date;

public class Aficionado extends Usuario{
    private String celular;
    private String paisFavorito;

    public Aficionado(String codigoUnico, String cedula,String nombre, String apellido, String usuario, String contrasenia, String correo, Rol rol,String celular,String paisFavorito){
        super(codigoUnico, cedula, nombre, apellido, usuario, contrasenia, correo, rol);
        this.celular=celular;
        this.paisFavorito=paisFavorito;
    }

    public Compra comprar(Partido partido, Zona zona, int cantidad, String numTarjeta) {
        // 7. Validar disponibilidad: si no hay stock suficiente, aborta y retorna null
        if (!partido.verificarDisponibilidad(zona, cantidad)) {
            return null;
        }

        // 8. Calcular el total a pagar
        double total = partido.getPrecio(zona) * cantidad;

        // 9. Reducir el cupo en el partido para la zona especificada
        partido.reducirCupo(zona, cantidad);

        // 10. Crear la instancia de Compra con los datos generados
        Compra nuevaCompra = new Compra(new Date(), cantidad, this.getCodigoUnico(),
                                        TipoCompra.ENTRADA, partido.getCodigo(), total, zona);

        // 11. Retornar la compra generada exitosamente
        return nuevaCompra;
    }

    public String getCelular(){
        return celular;
    }
    public void setCelular(String celular){
        this.celular=celular;
    }
    public String getPaisFavorito(){
        return paisFavorito;
    }
    public void setPaisFavorito(String paisFavorito){
        this.paisFavorito=paisFavorito;
    }

    public String toString(){
        return super.toString() +"\nCelular: "+celular+"\nPais Favorito: "+paisFavorito;
    }

    @Override
    public void consultarEntradas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultarEntradas'");
    }
    
}
