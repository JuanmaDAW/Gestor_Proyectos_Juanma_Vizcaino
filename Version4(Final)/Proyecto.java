package Gestion_Proyectos;

import java.io.*;

public class Proyecto implements Serializable  {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String categoria;
	private String lider_pro;
	private String estado;
	private double presupuesto;

	// Constructor parametrizado
	public Proyecto(int id, String nombre, String categoria, String lider_pro,  String estado, double presupuesto) {
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.lider_pro = lider_pro;
		this.estado = estado;
		this.presupuesto = presupuesto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLider_pro() {
		return lider_pro;
	}

	public void setLider_pro(String lider_pro) {
		this.lider_pro = lider_pro;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	@Override
	public String toString() {
		return String.format("%-5s %-18s %-25s %-10s %-15s %-10s", id, nombre, categoria, lider_pro, estado, presupuesto);
	}


	// Escribe los datos del proyecto en un DataOutputStream
	public void escribir(DataOutputStream fich) throws IOException {
		fich.writeInt(id);
		fich.writeUTF(nombre);
		fich.writeUTF(categoria);
		fich.writeUTF(lider_pro);
		fich.writeUTF(estado);
		fich.writeDouble(presupuesto);
	}

	// Lee los datos del proyecto desde un DataInputStream
	public void leer(DataInputStream fich) throws IOException {
		id = fich.readInt();
		nombre = fich.readUTF();
		categoria = fich.readUTF();
		lider_pro = fich.readUTF();
		estado = fich.readUTF();
		presupuesto = fich.readDouble();
	}
}
