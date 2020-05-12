package negocio;

import datos.AccesoDatos;
import datos.AccesoDatosImpl;
import domain.Pelicula;
import excepciones.AccesoDatosEx;
import excepciones.LecturaDatosEx;
import java.util.ArrayList;
import java.util.List;

public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    private final AccesoDatos datos;//Creamos un objeto de la interfaz AccesoDatos

    public CatalogoPeliculasImpl() {
        //Inicializamos el objeto de la interfaz AccesoDatos apuntando a alguna clase que la implemente para hacer uso de los metodos y atributos que contenga.
        this.datos = new AccesoDatosImpl();
    }

    //Implementacion de metodos.
    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(nombreArchivo);//Con ayuda del metodo existe de la clase AccesoDatosImpl vemos si vamos a anexar o escribir un nuevo archivo
            datos.escribir(pelicula, nombreArchivo, anexar);//Llamamos al metodo escribir y le pasamos los argumentos que recibe.
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos.");
            ex.printStackTrace();
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        List<Pelicula> peliculas = new ArrayList();//Creamos una coleccion ya que el metodo listar nos regresa una coleccion de tipo Pelicula
        try {//Ya que la funcion listar arroja una excepcion (LecturaDatosEx) la envolvemos en un try catch
            peliculas = datos.listar(nombreArchivo);//Llamamos al metodo listar y almacenamos la coleccion que regresa
            for (Pelicula pelicula : peliculas) {//Recorremos la coleccion
                System.out.println("Pelicula: " + pelicula);//Imprimimos en pantalla.
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de lectura de datos.");
            ex.printStackTrace();
        }

    }
    
    
    @Override
    public void buscarPelicula(String nombreArchivo, String nombrePelicula){
        try{
            String resultado;
            resultado = datos.buscar(nombreArchivo, nombrePelicula);
            System.out.println(resultado);
        }catch(LecturaDatosEx ex){
            System.out.println("Error de lectura de datos.");
            ex.printStackTrace();
        }
    }
    
    @Override
    public void iniciarArchivo(String nombreArchivo){
        try{
            if(datos.existe(nombreArchivo)){
                datos.borrar(nombreArchivo);
                datos.crear(nombreArchivo);
            }else{
                datos.crear(nombreArchivo);
            }
        }catch(AccesoDatosEx ex){
            System.out.println("Error de acceso a datos.");
            ex.printStackTrace();
        }
    }
    
}
