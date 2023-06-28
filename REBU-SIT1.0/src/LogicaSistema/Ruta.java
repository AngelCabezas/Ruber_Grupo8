package LogicaSistema;

import java.util.ArrayList;
import java.util.Random;

public class Ruta {
    private String distancia;
    private int costo;

    public Ruta(String distancia, int costo) {
        this.distancia = distancia;
        this.costo = costo;
    }

    public Ruta() {
    }
    

    public String getDistancia() {
        return distancia;
    }

    public int getCosto() {
        return costo;
    }

    public void calcularRutaExpres() {
        Ruta ruta1 = generarRutaAleatoria();
        Ruta ruta2 = generarRutaAleatoria();

        System.out.println("1-Ruta Express: " + ruta1.getDistancia() + ", Costo: " + ruta1.getCosto());
        float costoR2 = (float) (ruta1.getCosto() - 1.99);
        System.out.println("2-Ruta Normal: " + ruta2.getDistancia() + ", Costo: " + costoR2);
    }

    private static Ruta generarRutaAleatoria() {
        Random random = new Random();
        int longitudRuta = random.nextInt(10) + 3; // Genera una longitud aleatoria entre 1 y 10
        StringBuilder ruta = new StringBuilder();

        for (int i = 0; i < longitudRuta; i++) {
            char direccion = (char) (random.nextInt(4) + 'A'); // Genera una dirección aleatoria (A, B, C, D)
            ruta.append(direccion);
        }

        int numero = random.nextInt(9) + 1; // Genera un número aleatorio del 1 al 9

        return new Ruta(ruta.toString(), numero);
    }
    
    
    
    
}
