package VersionInicial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsaProyectos {
    public static void main(String[] args) {
        AdministradorProyectos administrador = new AdministradorProyectos();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Ingrese el nombre del nuevo proyecto:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese la fecha de inicio (dd/mm/aaaa):");
            String fechaInicio = scanner.nextLine();

            System.out.println("Ingrese la fecha de fin (dd/mm/aaaa):");
            String fechaFin = scanner.nextLine();

            List<String> desarrolladores = new ArrayList<>();
            System.out.println("Ingrese el nombre de los desarrolladores (separados por coma):");
            String[] devs = scanner.nextLine().split(",");
            for (String dev : devs) {
                desarrolladores.add(dev.trim());
            }

            System.out.println("Ingrese la categoría del proyecto:");
            String categoria = scanner.nextLine();

            System.out.println("Ingrese una breve descripción del proyecto:");
            String descripcion = scanner.nextLine();

            if (administrador.agregarProyecto(nombre, fechaInicio, fechaFin, desarrolladores, categoria, descripcion)) {
                System.out.println("Proyecto '" + nombre + "' creado correctamente.");
            } else {
                System.out.println("¡El proyecto ya existe!");
            }

            System.out.println("¿Desea agregar otro proyecto? (s/n)");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }
        scanner.close();
    }
}

