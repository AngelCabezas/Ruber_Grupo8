package LogicaSistema;

import java.util.Random;
import java.util.Scanner;

public class Pasajero extends Usuario {

    private int numDeViajesRealizadosP;

    public Pasajero(int numDeViajesRealizadosP, String nomUsuario, int telefono, int cedula, String correoElectronico) {
        super(nomUsuario, telefono, cedula, correoElectronico);
        this.numDeViajesRealizadosP = numDeViajesRealizadosP;
    }

    public Pasajero() {
    }

    public int getNumDeViajesRealizadosP() {
        return numDeViajesRealizadosP;
    }

    public void setNumDeViajesRealizadosP(int numDeViajesRealizadosP) {
        this.numDeViajesRealizadosP = numDeViajesRealizadosP;
    }
    Scanner scanner = new Scanner(System.in);

    public void seleccionarPuntoLlegadaySalida() {
        System.out.println("Ingrese su punto de partida:");
        String Salida = scanner.nextLine();
        System.out.println("Ingrese su punto de Llegada:");
        String Llegada = scanner.nextLine();

        System.out.println("su punto de partida es: " + Salida + " su punto de Llegada es:" + Llegada);
        try {
            Thread.sleep(1000); // Pausa la ejecución durante 3 segundos (3000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void seleccionarRuta() {
        System.out.println("");
        System.out.println("SELECCIONA UNA RUTA:");
        Ruta ruta = new Ruta();
        ruta.calcularRutaExpres();
        System.out.println("");
        int opcion = Integer.parseInt(scanner.nextLine());
        if (opcion == 1) {
            System.out.println("has escogido la ruta Express ");
            System.out.println("");
            System.out.println("Buscando CONDUCTOR");
            //---------------------------
            try {
                Thread.sleep(4000); // Pausa la ejecución durante 3 segundos (3000 milisegundos)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //---------------------------
            Conductor conductor = new Conductor();
            System.out.println("su conductor se llama:" + conductor.nombreConductor());
            System.out.println("con C.I:" + conductor.cedulaConductor());
            System.out.println("");

            try {
                Thread.sleep(3000); // Pausa la ejecución durante 3 segundos (3000 milisegundos)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            confirmarViaje();
        } else {
            System.out.println("has escogido la ruta Normal ");
            System.out.println("");
            System.out.println("Buscando CONDUCTOR");
        }
        //---------------------------
        try {
            Thread.sleep(1000); // Pausa la ejecución durante 3 segundos (3000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //---------------------------
        Conductor conductor = new Conductor();
        System.out.println("su conductor se llama:" + conductor.nombreConductor());
        System.out.println("con C.I:" + conductor.cedulaConductor());
        System.out.println("");
        //--------------------------
        try {
            Thread.sleep(3000); // Pausa la ejecución durante 3 segundos (3000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        confirmarViaje();
    }

    public void confirmarViaje() {
        if (solicitarViaje()) {
            System.out.println("Su viaje se realiza con normalidad");
            pagar();
        } else {
            System.out.println("En busca de un nuevo conductor");
            seleccionarRuta();
        }
    }

    public boolean solicitarViaje() {
        System.out.println("¿La persona que llego es la misma registrada en el sistema?");
        System.out.println("1.- Si ");
        System.out.println("2.- No");
        int opcion = Integer.parseInt(scanner.nextLine());
        if (opcion == 1) {
            System.out.println("Finalizacion de viaje ");
            return true;
        } else {
            return false;
        }
    }

    public void pagar() {
        System.out.println("Gracias por la confianza ");
        System.exit(0);

    }

}
