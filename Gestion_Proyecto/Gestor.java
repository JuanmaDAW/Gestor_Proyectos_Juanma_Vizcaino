package Gestion_Proyecto;

import java.io.*;
import java.util.Scanner;

import GestionV2.LeeyEscribe;
import GestionV2.Proyecto;

public class Gestor {
    public static String ruta = "C:\\Users\\Juanma01\\Desktop\\Aplicacion_Personal\\Proyectos\\proyectos.txt";

	
	    public static void main(String[] args) throws IOException {
	    	boolean salir= false;
	    	Scanner sc = new Scanner(System.in);
	    	
	    	System.out.println("Bienvenido al Gestor de Proyectos");
	    	
	    	do {
	    		System.out.println();
	    		System.out.println("1.-Añadir\n" + "2.-Borrar\n" + "3.-Listar\n" + "0.-Salir");
	    		int opci = sc.nextInt();
	    		
	    		switch (opci) {
				case 0:
			        System.out.println("¡Hasta Pronto!");
			        salir = true;
				break;
				case 1:
			        crearYEscribirProyectos(ruta);
				break;
				case 2:
					System.out.println("Borrado");
				break;
				case 3:
					leerProyectosDesdeArchivo();
				break;
				default:
					System.out.println("Elige una opción válida");
					break;
				}	
	    	}while(!salir);
	    	
	        guardarProyectosEnArchivo();
	        leerProyectosDesdeArchivo();
	    }

	    public static void guardarProyectosEnArchivo() throws IOException {
	        DataOutputStream fsalida = null;

	        try {
	            // Se crea el flujo de salida
	            fsalida = new DataOutputStream(new FileOutputStream(ruta));

	            // Se crean proyectos por defecto y se graban en el archivo
	            Proyecto proyecto1 = new Proyecto("Brainstorm", "Inteligencia Artificial", "Marco");
	            proyecto1.escribir(fsalida);
	            Proyecto proyecto2 = new Proyecto("Conecta", "Big Data", "Lidia");
	            proyecto2.escribir(fsalida);
	            Proyecto proyecto3 = new Proyecto("Shield", "Ciberseguridad", "Roberto");
	            proyecto3.escribir(fsalida);
	            
	            
	            

	            // Cerramos el archivo de salida
	            System.out.println("Tamaño del archivo de salida: " + fsalida.size());
	            fsalida.flush(); // Garantiza que se envía lo último que quedaba en el flujo

	        } finally {
	            if (fsalida != null) {
	                fsalida.close(); // Cierra el flujo de salida
	            }
	        }
	    }

	    public static void leerProyectosDesdeArchivo() throws IOException {
	        DataInputStream fentrada = null;

	        try {
	            // Se reabre el archivo, para leer la información guardada
	            fentrada = new DataInputStream(new FileInputStream(ruta));

	            // Leer y mostrar proyectos
	            while (fentrada.available() > 0) {
	                Proyecto proyecto = new Proyecto("", "", ""); // Se necesita un constructor vacío o por defecto
	                proyecto.leer(fentrada);
	                proyecto.mostrarProyectos();
	            }

	        } 
	        catch(IOException e) {
	        	System.err.println("No hay proyectos disponibles");
	        }
	        
	        finally {
	            if (fentrada != null) {
	                fentrada.close(); // Cierra el flujo de entrada
	            }
	        }
	    }
	    
	    public static void crearYEscribirProyectos(String ruta) throws IOException {
	        Proyecto proyecto;
	    	Scanner sc = new Scanner(System.in);
	        
	        // Pedimos los datos de los proyectos por consola
            String nombre = "";
            boolean nombreValido = false;

            while (!nombreValido) {
                System.out.println("Ingrese el nombre del nuevo proyecto:");
                nombre = sc.nextLine();

                if (!nombre.isBlank()) {
                	nombreValido = true; // Establecer como verdadero para salir del bucle
                } 
                
                else {
                    System.err.println("El nombre del proyecto no puede estar vacío.");

                }
            }
            
            String categoria = "";
            boolean categoriaValida = false;

            
            while (!categoriaValida) {
                System.out.println("Ingrese la categoria:");
                categoria = sc.nextLine();

                if (!categoria.isBlank()) {
                	categoriaValida = true; // Establecer como verdadero para salir del bucle
                } 
                
                else {
                    System.err.println("La categoria no puede estar vacía.");

                }
            }
            
            
            String lider = "";
            boolean liderValida = false;

            
            while (!liderValida) {
                System.out.println("Ingrese el lider:");
                lider = sc.nextLine();

                if (!lider.isBlank()) {
                	liderValida = true;
                } 
                
                else {
                    System.err.println("El lider no puede estar vacío.");

                }
            }
	        
	        proyecto = new Proyecto(nombre, categoria, lider);
	        LeeyEscribe.escribirProyecto(ruta, proyecto);

	    }
	}


