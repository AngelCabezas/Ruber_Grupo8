package Interfaz;

import Interfaz.Autentificar;
import Interfaz.ConexionDB;
import LogicaSistema.Conductor;
import LogicaSistema.Pasajero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InicioSesion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sesionIniciada = false;
        ConexionDB conexionsql = new ConexionDB();
        Connection conexion = conexionsql.conectar();
        Autentificar usuario = new Autentificar();

        System.out.println("REBU-SIT");
        System.out.println();

        int idUsuario = 0;
        
        // Menú principal
        int opcionMenuPrincipal;
        do {
            System.out.println("===== MENÚ PRINCIPAL =====");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Crear usuario");
            System.out.println("0. Salir");
 
         opcionMenuPrincipal = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcionMenuPrincipal) {
                case 1:
                    // Lógica para iniciar sesión
                    System.out.println("===== INICIO DE SESION =====");
                    System.out.println("Ingrese el nombre de usuario: ");
                    String Nombre_Usuario = scanner.nextLine();
                    System.out.println("Ingrese la contraseña: ");
                    String contrasenia = scanner.nextLine();

                    // Validar el usuario en la base de datos
                    boolean validaSesion = usuario.validarCliente(conexion, Nombre_Usuario, contrasenia);

                    if (validaSesion) {
                        try {
                            // Preparar la sentencia SQL de consulta
                            String sql = "SELECT ID_CEDULA FROM USUARIO WHERE NOMBUSUARIO = ? AND CONTRASENIA = ?";
                            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                                statement.setString(1, Nombre_Usuario);
                                statement.setString(2, contrasenia);
                                // Ejecutar la consulta SQL
                                ResultSet resultSet = statement.executeQuery();

                                // Verificar si se encontró el usuario y obtener su ID_USUARIO
                                if (resultSet.next()) {
                                    idUsuario = resultSet.getInt("ID_CEDULA");

                                }

                                // Cerrar el ResultSet y liberar recursos
                                resultSet.close();
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        sesionIniciada = true;
                    } else {
                        System.out.println("Usuario Incorrecto");
                    }
                    break;
                case 2:
                    System.out.println("===== REGISTRO DE USUARIO =====");

                    System.out.print("Ingrese su nombre de usuario: ");
                    String nombreUsuario = scanner.nextLine();

                    System.out.print("Ingrese su contraseña: ");
                    String nuevaContrasenia = scanner.nextLine();

                    System.out.print("Ingrese su correo electrónico: ");
                    String correoElectronico = scanner.nextLine();

                    usuario.setNombre_Usuario(nombreUsuario);
                    usuario.setContrasenia(nuevaContrasenia);
                    usuario.setCorreo(correoElectronico);
                    try {
                        // Preparar la sentencia SQL de inserción
                        String sql = "INSERT INTO USUARIO (CONTRASENIA, NOMBUSUARIO, CORRELECTRONICO) VALUES (?, ?, ?)";
                        PreparedStatement statement = conexion.prepareStatement(sql);
                        statement.setString(1, usuario.getContrasenia());
                        statement.setString(2, usuario.getNombre_Usuario());
                        statement.setString(3, usuario.getCorreo());

                        // Ejecutar la sentencia SQL de inserción
                        int filasInsertadas = statement.executeUpdate();

                        // Verificar si se insertó el usuario correctamente
                        if (filasInsertadas > 0) {
                            System.out.println("Usuario creado exitosamente.");
                            ResultSet generatedKeys = statement.getGeneratedKeys();
                            if (generatedKeys.next()) {
                                idUsuario = generatedKeys.getInt(1);
                            }
                        } else {
                            System.out.println("Error al crear el usuario.");
                        }

                        // liberar recursos
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    sesionIniciada = true;
                    break;
            }
            System.out.println();
        } 
         while (opcionMenuPrincipal != 0 && !sesionIniciada);
        
        if (sesionIniciada){
    
        int opcion;
        do {
            System.out.println("Menu de Opciones");
            System.out.println("ELIGE EL TIPO DE USUARIO QUE DESEAS SER ");
            System.out.println("1.- Pasajero ");
            System.out.println("2.- Conductor");
            System.out.println("3.- Salir");

            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

 

            switch (opcion) {
                case 1:{
                    int variable;
                    System.out.println("");
                    System.out.println("Has seleccionado la opción 1.");
                    System.out.println("");
                    System.out.println("----HAS ELEGIDO SER PASAJERO -----");
                    System.out.println("ELIGE EL TIPO DE SERVICIO QUE DESEAS SOLICITAR");
                    System.out.println("1.- Solicitar viaje");
                    variable = scanner.nextInt();

                    switch (variable) {
                        case 1: {
                            System.out.println("1.- Solicitar viaje");
                            Pasajero pasajero=new Pasajero();
                            pasajero.seleccionarPuntoLlegadaySalida();
                            pasajero.seleccionarRuta();
                            pasajero.confirmarViaje();

                            break;
                        }
                        /////
                    }
                    break;}
                case 2:{
                    System.out.println("");
                    System.out.println("Has seleccionado la opción 2.");
                    System.out.println("");
                    int variable2;
                    System.out.println("----- HAS ELEGIDO SER CONDUCTOR -----");
                    System.out.println("ELIGE EL TIPO DE SERVICIO QUE VAS A SOLICITAR");
                    System.out.println("1.- Ofrecer viaje");
                    variable2 = scanner.nextInt();

                    switch (variable2) {
                        case 1: {
                            System.out.println("1.- Ofrecer viaje");
                            Conductor conductor=new Conductor();
                            conductor.aceptarViaje();
                            break;
                        }
                       
                    }
                }
                ////
                case 3:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }

 

            System.out.println(); // Salto de línea para separar las iteraciones del menú
        } while (opcion != 4);

 

        scanner.close();
    }
}
        
        
      
        
    }