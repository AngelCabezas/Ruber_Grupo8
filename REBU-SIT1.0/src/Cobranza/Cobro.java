package Cobranza;
public class Cobro {
    public int Monto;

    public Cobro( int Monto) {
        this.Monto = Monto;
    }

    public Cobro() {

        this.Monto = 0;
    }

    public int getMonto() {
        return Monto;
    }

    public void setMonto(int Monto) {
        this.Monto = Monto;
    }

    @Override
    public String toString() {
        return  "Monto=" + Monto + '}';
    }
    
}
