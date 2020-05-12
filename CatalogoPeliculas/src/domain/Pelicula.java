package domain;
/*
Representa los objetos tipo Pelicula utilizados en la aplicacion
catalogo de peliculas.
*/
public class Pelicula {
    private String nombre;
    
    public Pelicula(){
        
    }
    
    public Pelicula(String nombre){
        this.nombre = nombre;
    }
    
    //Getters and Setters

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
}
