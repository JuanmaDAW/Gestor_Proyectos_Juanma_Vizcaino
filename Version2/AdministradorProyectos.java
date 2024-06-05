package VersionInicial;

import java.util.*;

public class AdministradorProyectos {
    private List<Proyecto> proyectos = new ArrayList<>();

    public boolean agregarProyecto(String nombre, String fechaInicio, String fechaFin, List<String> desarrolladores,
                                   String categoria, String descripcion) {
        if (proyectoExiste(nombre)) {
            return false; // Proyecto ya existe
        } else {
            Proyecto nuevoProyecto = new Proyecto(nombre, fechaInicio, fechaFin, desarrolladores, categoria, descripcion);
            proyectos.add(nuevoProyecto);
            return true; // Proyecto agregado correctamente
        }
    }

    private boolean proyectoExiste(String nombre) {
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
    
    public static void mostrarMenu() {
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

            System.out.println("Ingrese la categor�a del proyecto:");
            String categoria = scanner.nextLine();

            System.out.println("Ingrese una breve descripci�n del proyecto:");
            String descripcion = scanner.nextLine();

            if (administrador.agregarProyecto(nombre, fechaInicio, fechaFin, desarrolladores, categoria, descripcion)) {
                System.out.println("Proyecto '" + nombre + "' creado correctamente.");
            } else {
                System.out.println("�El proyecto ya existe!");
            }

            System.out.println("�Desea agregar otro proyecto? (s/n)");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }
        scanner.close();
    }
    
}
