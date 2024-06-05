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
}
