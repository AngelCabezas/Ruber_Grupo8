
package LogicaSistema;

import java.util.Scanner;

public class Usuario {
    private String nombre;
    private int telefono;
    private int cedula;
    private String correoElectronico;

    public Usuario() {
    }

    
    public Usuario(String nombre, int telefono, int cedula, String correoElectronico) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    
}
