package poo.proyecto;
public class Usuario{
    protected String codigoUnico;
    protected String cedula;
    protected String nombre;
    protected String apellido;
    protected String usuario;
    protected String contrasenia;
    protected String correo;
    protected Rol rol;

    public Usuario(String codigoUnico, String cedula,String nombre, String apellido, String usuario, String contraseña, String correo, Rol rol){
        this.codigoUnico= codigoUnico;
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido= apellido;
        this.usuario=usuario;
        this.contrasenia=contraseña;
        this.correo=correo;
        this.rol=rol;
    }

    public String getCodigoUnico(){
        return codigoUnico;
    }
    public void setCodigoUnico(String codigoUnico){
        this.codigoUnico=codigoUnico;
    }
    public String getCedula(){
        return cedula;
    }
    public void setCedula(String cedula){
        this.cedula=cedula;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    public String getContraseña(){
        return contrasenia;
    }
    public void setContraseña(String contraseña){
        this.contrasenia=contraseña;
    }
    public String getCorreo(){
        return correo;
    }
    public void setCorreo(String correo){
        this.correo= correo;
    }
    public Rol getRol(){
        return rol;
    }
    public void setRol(Rol rol){
        this.rol=rol;
    }
    
    public String toString(){
        return "Codigo unico: "+codigoUnico+"\nCedula: "+cedula+"\nNombre: "+nombre+"\nApellido"+apellido+"\nUsuario: "+usuario+"\nContrasenia: "+contrasenia+"\nCorreo: "+correo+"\nRol: "+rol;
    }




}

