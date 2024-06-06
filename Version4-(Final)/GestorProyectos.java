package Gestion_Proyectos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

public class GestorProyectos implements Serializable {
	/* Responsabilidad:  Gestionar proyectos basado en el CRUD, con volcado y recuperación de datos
	 * en un fichero serializable
	 * 
	 * Descripción: Aplicación final de la asigntaura de Programación del IES Ágora, curso 23/24
	 * 
	 * Autor: Juanma Vizcaíno Barquero
	 * 
	 * Fecha Inicio: 15/05/2024
	 * Fecha Final: 6/06/2024
	 */
	

	private static final long serialVersionUID = 1L;
	private static Map<Integer, Proyecto> proyectos = new HashMap<>();
	private int idSiguiente = 1;

	static String categorias[] = { "Big Data", "I.Artificial", "Ciberseguridad", "Desarrollo Web" };
	static String estados[] = { "Pendiente", "En proceso", "Finalizado" };
	static String lideres[] = { "Marco", "Lidia", "Juanma", "Dani" };

	// Ruta en windows
	private static final String ruta = "C:\\Users\\Juanma01\\Desktop\\Aplicacion_Personal\\Proyectos\\proyectos.ser";

	// Ruta en linux
	// private static final String ruta =
	// "/home/user/lista-proyectos/proyectos.dat";

	public GestorProyectos() {
		cargarProyectos();
	}

	private boolean nombreExiste(String nombre) {
		for (Proyecto proyecto : proyectos.values()) {
			if (proyecto.getNombre().equalsIgnoreCase(nombre)) {
				return true;
			}
		}
		return false;
	}

	// Crear y guardar proyectos en el HashMap
	public void crearProyecto(String nombre, String lider_pro, String categoria, String estado, double presupuesto) {
		if (nombreExiste(nombre)) {
			System.out.println("El nombre del proyecto ya existe. Por favor, elija otro nombre.");
			return;
		}
		Proyecto proyecto = new Proyecto(idSiguiente, nombre, lider_pro, categoria, estado, presupuesto);
		proyectos.put(idSiguiente, proyecto);
		idSiguiente++;
		guardarProyectos();
		if (proyectos.containsKey(idSiguiente)) {
			if (proyectos.containsKey(idSiguiente)) {
				for (Proyecto proyecto1 : proyectos.values()) {
					proyecto1.toString();
				}
			}

		}
		System.out.println("Proyecto creado: " + proyecto);
	}
	
	
	// Listar proyectos
	public void listarProyectos() {
		System.out.println();
		cargarProyectos();
		if (proyectos.isEmpty()) {
			System.out.println("No hay proyectos registrados.");
		} else {
			System.out.printf("%-5s %-18s %-25s %-10s %-15s %-10s",  "ID",  "Nombre", "Categoria", "Lider", "Estado", "Presupuesto\n");
			System.out.println("------------------------------------------------------------------------------------------");
			for (Proyecto proyecto : proyectos.values()) {
				System.out.println(proyecto);
			}
		}
	}
	
	
	// Modificar proyectos
	public void editarProyecto() {
		System.out.print("ID del proyecto a editar: ");
		Scanner sc2 = new Scanner(System.in);
		int id = sc2.nextInt();
		
		if (proyectos.containsKey(id)) {
				for (Proyecto proyecto : proyectos.values()) {
					Scanner atributosSc = new Scanner(System.in);
					
					System.out.println("Nombre: ");
					String nombre = atributosSc.nextLine();
					proyecto.setNombre(nombre);
					
					System.out.println("Categoría: ");
					String categoria = atributosSc.nextLine();
					proyecto.setCategoria(categoria);
					
					System.out.println("Lider: ");
					String lider = atributosSc.nextLine();
					proyecto.setLider_pro(lider);
					
					System.out.println("Estado: ");
					String estado = atributosSc.nextLine();
					proyecto.setEstado(estado);
					
					System.out.println("Presupuesto: ");
					double presupuesto = atributosSc.nextDouble();
					proyecto.setPresupuesto(presupuesto);
					
				}
				guardarProyectos();
		} else {
			System.out.println("No se encontró el proyecto con ID: " + id);
		}
	}
	
	// Eliminar proyectos
	public void borrarProyecto() {
		System.out.print("ID del proyecto a borrar: \n");
		Scanner sc = new Scanner(System.in);
		
		if(sc.hasNextInt()) {
		int id = sc.nextInt();
		if (proyectos.containsKey(id)) {
			
			System.out.println("¿Estás seguro? s/n");
			Scanner sc3 = new Scanner(System.in);
			String respuesta = sc3.nextLine();
			respuesta.toLowerCase();
			
			if(respuesta.contains("n")) {
				
			} else {
				Proyecto eliminado = proyectos.remove(id);
				guardarProyectos();
				System.out.println("Proyecto eliminado: " + eliminado);
			}
			
			
		} else {
			System.out.println("No se encontró el proyecto con ID: " + id);
			
		}
		} else System.out.println("El campo ID solo admite enteros");
	}
	
	
	public void filtrar() {
		System.out.println("Opciones: [ 1.-ID, 2.-Nombre, 3.-Categoria, 4.-Lider, 5.-Estado, 6.-Presupuesto, 7.-Salir ]");
		Scanner sc = new Scanner(System.in);
		int opci = sc.nextInt();
		
		switch (opci) {
		case 1: {
			System.out.print("ID: ");
			int idAux = sc.nextInt();
			int cont = 0;
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.printf("%-5s %-18s %-25s %-10s %-15s %-10s",  "ID",  "Nombre", "Categoria", "Lider", "Estado", "Presupuesto\n");
			System.out.println("------------------------------------------------------------------------------------------");
			
			for (Proyecto proyecto : proyectos.values()) {
				if (proyecto.getId() == idAux) {
					System.out.println(proyecto);
					cont ++;
				}
			}
			
			if(cont <= 0) {
				System.out.println("No hay coincidencias");		
			}
			
			break;
		}
		case 2: {
			 System.out.print("Nombre: ");
             String nombreAux = sc.next();
             int cont = 0;
             
 			System.out.println("------------------------------------------------------------------------------------------");
             System.out.printf("%-5s %-18s %-25s %-10s %-15s %-10s",  "ID",  "Nombre", "Categoria", "Lider", "Estado", "Presupuesto\n");
 			System.out.println("------------------------------------------------------------------------------------------");

             
             for (Proyecto proyecto : proyectos.values()) {
                 if (proyecto.getNombre().toLowerCase().contains(nombreAux.toLowerCase())) {
                     System.out.println(proyecto);
                     cont++;
                 }
             }
             
             if (cont <= 0) {
                 System.out.println("No hay coincidencias");        
             }
			
			break;
		}
		case 3: {
			System.out.print("Categoría: ");
            String categAux = sc.next();
            int cont = 0;
            
			System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("%-5s %-18s %-25s %-10s %-15s %-10s",  "ID",  "Nombre", "Categoria", "Lider", "Estado", "Presupuesto\n");
			System.out.println("------------------------------------------------------------------------------------------");

            
            for (Proyecto proyecto : proyectos.values()) {
                if (proyecto.getCategoria().toLowerCase().contains(categAux.toLowerCase())) {
                    System.out.println(proyecto);
                    cont++;
                }
            }
            
            if (cont <= 0) {
                System.out.println("No hay coincidencias");        
            };
		}
		case 4: {
			
			System.out.print("Lider: ");
			String liderAux = sc.nextLine();
			
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.printf("%-5s %-18s %-25s %-10s %-15s %-10s",  "ID",  "Nombre", "Categoria", "Lider", "Estado", "Presupuesto\n");
			System.out.println("------------------------------------------------------------------------------------------");

			
		int cont = 0;
			
			for (Proyecto proyecto : proyectos.values()) {
				if (proyecto.getLider_pro() == liderAux) {
					System.out.println(proyecto);
					cont ++;
				}
			}
			
			if(cont <= 0) {
				System.out.println("No hay coincidencias");		
			}
	
			break;
		}
		case 5: {
			
			System.out.print("Estado: ");
			String estadoAux = sc.next();
		int cont = 0;
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.printf("%-5s %-18s %-25s %-10s %-15s %-10s",  "ID",  "Nombre", "Categoria", "Lider", "Estado", "Presupuesto\n");
		System.out.println("------------------------------------------------------------------------------------------");

			
			for (Proyecto proyecto : proyectos.values()) {
				if (proyecto.getEstado().contains(estadoAux)) {
					System.out.println(proyecto);
					cont ++;
				}
			}
			
			if(cont <= 0) {
				System.out.println("No hay coincidencias");		
			}
	
			break;
		}
		case 6: {
			
			System.out.print("Presupuesto: ");
			double presuAux = sc.nextDouble();
			
		int cont = 0;
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.printf("%-5s %-18s %-25s %-10s %-15s %-10s",  "ID",  "Nombre", "Categoria", "Lider", "Estado", "Presupuesto\n");
		System.out.println("------------------------------------------------------------------------------------------");

			
			for (Proyecto proyecto : proyectos.values()) {
				if (proyecto.getPresupuesto() == presuAux) {
					System.out.println(proyecto);
					cont ++;
				}
			}
			
			if(cont <= 0) {
				System.out.println("No hay coincidencias");		
			}
	
			break;
		}

		default:
			System.out.println("Introduce una opción válida");
			break;
		}
		
	}
	

	
	

	// Guardar proyectos en un archivo binario
	private void guardarProyectos() {
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(ruta))) {
			dos.writeInt(proyectos.size());
			for (Proyecto proyecto : proyectos.values()) {
				proyecto.escribir(dos);
			}
		} catch (IOException e) {
			System.out.println("Error al guardar los proyectos: " + e.getMessage());
		}
	}
	
	

	// Método para cargar proyectos desde un archivo binario
	private void cargarProyectos() {
		try (DataInputStream dis = new DataInputStream(new FileInputStream(ruta))) {
			proyectos.clear();
			int numProyectos = dis.readInt();
			for (int i = 0; i < numProyectos; i++) {
				Proyecto proyecto = new Proyecto(i, null, null, null, null, 0.0);
				proyecto.leer(dis);
				proyectos.put(proyecto.getId(), proyecto);
				idSiguiente = Math.max(idSiguiente, proyecto.getId() + 1);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado. Se creará un nuevo archivo al guardar.");
		} catch (IOException e) {
			/* System.out.println("Error al cargar los proyectos: " + e.getMessage()); */
		}
	}
	
	public static void mostrarMenu() {
		GestorProyectos gestor = new GestorProyectos();
		Scanner sc = new Scanner(System.in);
		boolean salir = false;

		while (!salir) {
			System.out.println("\nMenú:");
			System.out.println("1. Crear Nuevo Proyecto");
			System.out.println("2. Listar Proyecto");
			System.out.println("3. Modificar Proyecto");
			System.out.println("4. Borrar Proyecto");
			System.out.println("5. Filtrar por campo");
			System.out.println("6. Salir");
			System.out.print("Seleccione una opción: ");
			int opci = sc.nextInt();
			sc.nextLine(); // Limpiar el buffer
			

			switch (opci) {
			
			case 1:  // Opción 1, Crear un nuevo proyecto
				String nombre;
				String categoria;
				String lider;
				String estado;
				double presupuesto = 0.0;

				
				// Nombre del proyecto con scanner
				do {
					System.out.print("Nombre del proyecto: ");
					nombre = sc.nextLine();
					if (gestor.nombreExiste(nombre)) {
						System.out.println("El nombre del proyecto ya existe. Por favor, elija otro nombre.");
					}
				} while (gestor.nombreExiste(nombre));
				
				
				// Categoria del proyecto con scanner
				boolean categoriaValida = false;
				do {
					String mostrarCateg = "Categoría: " + String.join(", ", categorias);
			        System.out.println(mostrarCateg);
			        categoria = sc.nextLine();
					
					if (categoria.contains("Big Data") || categoria.contains("I.Artificial") || categoria.contains("Ciberseguridad") || categoria.contains("Desarrollo Web")) {
						categoriaValida = true;
					} else {
						System.out.println("Elija una categoría existente");
					}
					
				} while (!categoriaValida);
				
				// Lider del proyecto con scanner
				boolean liderValido = false;
				do {
			        String mostrarLider = "Lider: [" + String.join(", ", lideres) + "]";
			        System.out.println(mostrarLider);
					lider = sc.nextLine();
					
					if (lider.contains("Marco") || lider.contains("Lidia") || lider.contains("Juanma") || lider.contains("Dani")) {
						liderValido = true;
					} else {
						System.out.println("Elija un lider existente");
					}
					
				} while (!liderValido);
				
				
				// Estado del proyecto con scanner
				boolean estadoValido = false;
				do {
			        String mostrarEstado = "Estado: [" + String.join(", ", estados) + "]";
			        System.out.println(mostrarEstado);
			        estado = sc.nextLine();
					
					if (estado.contains("Pendiente") || estado.contains("En proceso") || estado.contains("Finalizado")) {
						estadoValido = true;
					} else {
						System.out.println("Elija un estado existente");
					}
					
				} while (!estadoValido);
				
				
				
				
				// Presupuesto del proyecto con scanner
				
				boolean presupuestoValido = false;
				do {
					System.out.print("Presupuesto: ");
					
			    	if(sc.hasNextDouble()) {
						 presupuesto = sc.nextDouble();
						 presupuestoValido = true;
					} else {
						System.out.println("Introduce un número decimal o entero");
						sc.next();
					}
					
				} while (!presupuestoValido);

				gestor.crearProyecto(nombre, categoria, lider, estado, presupuesto);
				break;
				
				
			case 2:  // Opción 2, Listar los proyectos
				gestor.listarProyectos();
				break;

			case 3:  // Opción 3, Modificar proyectos
				gestor.editarProyecto();
				break;

			case 4:  // Opción 4, Borrar proyectos
				gestor.borrarProyecto();
				break;
				
				
			case 5: // Opción 5, Filtrar por campos
		        gestor.filtrar();
				break;
				
			case 6:  // Opción 6, Salir
				System.out.println("¡Hasta Pronto!");
				salir = true;
				break;
				
			default:
				System.out.println("Opción no válida.");
				break;
			}
		}

		sc.close();
	}

	
	// Main
	public static void main(String[] args) {
		mostrarMenu();
		
	}
}
