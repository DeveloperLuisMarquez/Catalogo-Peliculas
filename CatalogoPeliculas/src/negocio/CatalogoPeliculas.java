
package negocio;
/*
Contiene las operaciones para catalogo de peliculas.
*/
public interface CatalogoPeliculas {
    void agregarPelicula(String nombrePelicula, String nombreArchivo);
    
    void listarPeliculas(String nombreArchivo);
    
    void buscarPelicula(String nombreArchivo, String nombrePelicula);
    
    void iniciarArchivo(String nombreArchivo);
}
