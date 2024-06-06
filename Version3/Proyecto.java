
import java.io.*;
public class Proyecto {
	
	public int id_pro;
	public static int id_siguiente = 1;
	public String nombre_pro;
	public String categoria;
	public String lider;
	
	public Proyecto(String nombre_pro, String categoria, String lider) {
		this.nombre_pro = nombre_pro;
		this.categoria = categoria;
		this.lider = lider;
		id_pro = id_siguiente;
		id_siguiente++;
	}
	
	public void escribir(DataOutputStream fich) throws IOException {
		fich.writeInt(id_pro);
		fich.writeUTF(nombre_pro);
		fich.writeUTF(categoria);
		fich.writeUTF(lider);
	}
	
	public void leer(DataInputStream fich) throws IOException {
		id_pro = fich.readInt();
		nombre_pro = fich.readUTF();
		categoria = fich.readUTF();
		lider = fich.readUTF();
	}
	
	public void mostrarProyectos() {
		System.out.println('\n');
		System.out.println("-ID de Proyecto: " + id_pro);
		System.out.println("-Nombre_pro: " + nombre_pro);
		System.out.println("-Categoria: " + categoria);
		System.out.println("-Lider de Proyecto: " + lider);
	}
	
	public int consultarID() {
		return id_pro;
	}
	
	public String consultarNombreProyecto() {
		return nombre_pro;
	}
	
	public String consultarCategoria() {
		return categoria;
	}
	
	public String consultarLider() {
		return lider;
	}
}


