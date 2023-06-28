package Cobranza;
/**
 * @author WINDOWS
 */
public class Pago {
    int monto;

    public Pago( int monto) {
        this.monto = monto;
    }

    public Pago() {
        this.monto = 0;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Pago{" + " monto=" + monto + '}';
    }
    
}