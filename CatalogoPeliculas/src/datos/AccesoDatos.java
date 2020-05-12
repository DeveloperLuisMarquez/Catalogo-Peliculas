package datos;

import domain.Pelicula;
import excepciones.*;
import java.util.List;

/*
Contiene las operaciones a ejecutar en el archivo de peliculas.txt
*/
public interface AccesoDatos{
    boolean existe(String nombre) throws AccesoDatosEx;
    
    List<Pelicula> listar(String nombreArchivo)throws LecturaDatosEx;
    
    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar)throws EscrituraDatosEx;
    
    String buscar(String nombreArchivo, String buscar)throws LecturaDatosEx;
    
    void crear(String nombreArchivo)throws AccesoDatosEx;
    
    void borrar(String nombreArchivo)throws AccesoDatosEx;
}
