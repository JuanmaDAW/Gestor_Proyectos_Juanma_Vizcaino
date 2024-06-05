package VersionInicial;

import java.util.List;

class Proyecto {
    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    private List<String> desarrolladores;
    private String categoria;
    private String descripcion;

    public Proyecto(String nombre, String fechaInicio, String fechaFin, List<String> desarrolladores,
                    String categoria, String descripcion) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.desarrolladores = desarrolladores;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public List<String> getDesarrolladores() {
        return desarrolladores;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
