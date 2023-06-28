package LogicaSistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Conductor extends Usuario {

    private int numLicencia;
    private boolean disponibilidad;

    public Conductor(int numLicencia, boolean disponibilidad, String nomUsuario, int telefono, int cedula, String correoElectronico) {
        super(nomUsuario, telefono, cedula, correoElectronico);
        this.numLicencia = numLicencia;
        this.disponibilidad = disponibilidad;
    }

    public Conductor() {
    }

    public int getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(int numLicencia) {
        this.numLicencia = numLicencia;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    Scanner scanner = new Scanner(System.in);

    public String nombreConductor() {
        String nombreAleatorio = ConductorAleatorio();
        return nombreAleatorio;
    }

    public String cedulaConductor() {
        String cadenaAleatoria = CedulaAleatoria();
        return cadenaAleatoria;
    }

    private String salidaLlegada() {
        String puntoSalidaLlegada = puntoSalidaLlegadaAleatorio();
        return puntoSalidaLlegada;
    }

    public void aceptarViaje() {
        System.out.println("");
        System.out.println("BUSCANDO POSIBLES VIAJES");
        System.out.println("");
        try {
            Thread.sleep(4000); // Pausa la ejecución durante 3 segundos (3000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("");
        System.out.println("Existe un viaje con punto de partida y llegada en:");
        String puntoSalidaLlegada = puntoSalidaLlegadaAleatorio();
        System.out.println(puntoSalidaLlegada);
        try {
            Thread.sleep(2000); // Pausa la ejecución durante 3 segundos (3000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Aceptar viaje:");
        System.out.println("1-->SI");
        System.out.println("2-->NO");
        int opcion = Integer.parseInt(scanner.nextLine());
        if (opcion == 1) {
            System.out.println("");
            System.out.println("Dirigete al punto de partida ");
            try {
                Thread.sleep(2000); // Pausa la ejecución durante 3 segundos (3000 milisegundos)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Deseas continuar con el viaje:");
            System.out.println("1-->SI");
            System.out.println("2-->NO");
            int op = Integer.parseInt(scanner.nextLine());
            if (op == 2) {
                cancelarViaje();
            } else {
                System.out.println("Recoge el pasajero ");
            }
            try {
                Thread.sleep(2000); // Pausa la ejecución durante 3 segundos (3000 milisegundos)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
            cobrar();
            try {
                Thread.sleep(2000); // Pausa la ejecución durante 3 segundos (3000 milisegundos)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Viaje finalizado");
        } else {
            aceptarViaje();
        }

    }

    public void cancelarViaje() {
        System.out.println("Tienes una multa:");
        aceptarViaje();
    }

    public void cobrar() {
        System.out.println("Es  momento de cobrar");
    }

    private static String puntoSalidaLlegadaAleatorio() {
        List<String> salidaLlegada = new ArrayList<>();
        salidaLlegada.add("EPN ---> Alameda");
        salidaLlegada.add("UCE ---> Condado");
        salidaLlegada.add("Marin ---> Floresta");
        salidaLlegada.add("Carlos Andrade Marin ---> Calderon");
        salidaLlegada.add("San Luis Shopin ---> Terminal Quitumbe");

        Random random = new Random();
        int indiceAleatorio = random.nextInt(salidaLlegada.size());
        return salidaLlegada.get(indiceAleatorio);
    }

    private static String ConductorAleatorio() {
        List<String> nombres = new ArrayList<>();
        nombres.add("Juan");
        nombres.add("María");
        nombres.add("Pedro");
        nombres.add("Luisa");
        nombres.add("Carlos");

        Random random = new Random();
        int indiceAleatorio = random.nextInt(nombres.size());
        return nombres.get(indiceAleatorio);
    }

    private static String CedulaAleatoria() {
        StringBuilder cadena = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 9; i++) {
            int numeroAleatorio = random.nextInt(10); // Genera un número aleatorio entre 0 y 9
            cadena.append(numeroAleatorio);
        }

        return cadena.toString();
    }

}
