package poo.proyecto;

public class Aficionado extends Usuario{
    private String celular;
    private String paisFavorito;

    public Aficionado(String codigoUnico, String cedula,String nombre, String apellido, String usuario, String contrasenia, String correo, Rol rol,String celular,String paisFavorito){
        super(codigoUnico, cedula, nombre, apellido, usuario, contrasenia, correo, rol);
        this.celular=celular;
        this.paisFavorito=paisFavorito;
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
    
}
