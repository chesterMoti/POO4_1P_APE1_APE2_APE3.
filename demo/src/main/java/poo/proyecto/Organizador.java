package poo.proyecto;

public class Organizador extends Usuario{
    private String empresaOrganizadora;
    private String cargo;

    public Organizador(String codigoUnico, String cedula,String nombre, String apellido, String usuario, String contrasenia, String correo, Rol rol, String empresaOrganizadora, String cargo){
        super(codigoUnico, cedula, nombre, apellido, usuario, contrasenia, correo, rol);
        this.empresaOrganizadora=empresaOrganizadora;
        this.cargo=cargo;
    }
    
    public String getEmpresaOrganizadora(){
        return empresaOrganizadora;
    }
    public void setEmpresaOrganizadora(String empresaOrganizadora){
        this.empresaOrganizadora=empresaOrganizadora;

    }
    public String getCargo(){
        return cargo;
    }
    public void setCargo(String cargo){
        this.cargo=cargo;
    }

    public String toString(){
        return super.toString() +"\nEmpresa Organizadora: "+empresaOrganizadora+"\nCargo: "+cargo;
    }
}

