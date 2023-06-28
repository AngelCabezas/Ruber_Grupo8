package Cobranza;
/**
 * @author WINDOWS
 */
public class Recibo {
    int monto;
    String nombreUsuario;

    public Recibo(int monto, String nombreUsuario) {
        this.monto = monto;
        this.nombreUsuario = nombreUsuario;
    }

    public Recibo() {
        this.monto = 0;
        this.nombreUsuario = "";
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String toString() {
        return "Recibo{" + "monto=" + monto + ", nombreUsuario=" + nombreUsuario + '}';
    }
    
}
