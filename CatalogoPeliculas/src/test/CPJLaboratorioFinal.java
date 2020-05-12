package test;

import java.util.Scanner;
import negocio.CatalogoPeliculas;
import negocio.CatalogoPeliculasImpl;

/**
 *
 * @author Luis Juarez
 * 
 */
public class CPJLaboratorioFinal {
    private static final Scanner input = new Scanner(System.in);
    private static int opcion = -1;
    private static final String nombreArchivo = "D:\\catalogoPeliculas\\catalogoTest.txt";
    private static final CatalogoPeliculas catalogoPelis = new CatalogoPeliculasImpl();
    
    public static void main(String[] args) {
        
        //Mientras la opcion elegida no sea 0 arrojaremos el menu.
        while(opcion != 0){
            try{
                System.out.println("Elige una opcion:\n1.- Iniciar un catalogo de peliculas."
                        +"\n2.- Agregar una pelicula." 
                        +"\n3.- Buscar una pelicula."
                        +"\n4.- Listar peliculas."
                        +"\n0.- Salir");
                opcion = Integer.parseInt(input.nextLine());
                
                //Switch case
                switch(opcion){
                    case 1:
                        catalogoPelis.iniciarArchivo(nombreArchivo);
                        break;
                    case 2:
                        System.out.println("Introduce el nombre de la pelicula: ");
                        String nombrePelicula = input.nextLine();
                        catalogoPelis.agregarPelicula(nombrePelicula, nombreArchivo);
                        break;
                    case 3:
                        System.out.println("Ingresa el nombre de la pelicula: ");
                        String buscar = input.nextLine();
                        catalogoPelis.buscarPelicula(nombreArchivo, buscar);
                        break;
                    case 4:
                        catalogoPelis.listarPeliculas(nombreArchivo);
                        break;
                    case 0:
                        System.out.println("Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");
            } catch (Exception e){
                System.out.println("Error!");
            }
        }
    }
}
