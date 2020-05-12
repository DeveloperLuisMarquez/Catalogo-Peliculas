package datos;

import domain.Pelicula;
import excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatosImpl implements AccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);//Creamos el archivo
        return archivo.exists();//Retornamos booleano dependiendo si existe o no.
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));//Creamos un objeto para poder leer el archivo
            String linea = null;//Creamos variable para almacenar cada linea del archivo
            linea = entrada.readLine();//Leemos las lineas y las asignamos a la variable
            while (linea != null) {//Mientras que no haya lineas en blanco
                Pelicula pelicula = new Pelicula(linea);//Creamos un objeto Pelicula con el nombre de la linea que leemos
                peliculas.add(pelicula);//Agregamos el objeto pelicula a una coleccion
                linea = entrada.readLine();//Pasamos a leer la siguiente linea.
            }
            entrada.close();//Cuando salga del ciclo cerramos.
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return peliculas;//Devolvemos la coleccion de peliculas.
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {
        File archivo = new File(nombreArchivo);//Creamos el archivo
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));//Objeto para escribir en el archivo lineas no solo char
            salida.println(pelicula.toString());//Agregamos la pelicula como texto con ayuda del metodo toString
            salida.close();//Cerramos para que se agregue la Pelicula
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public String buscar(String nombreArchivo, String buscar) {
        String result = "No se encontro coincidencia.";//Resultado a regresar si no encuentra la pelicula
        File archivo = new File(nombreArchivo);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));//Objeto para leer lineas del archivo y no char
            String linea = null;
            int indice = 0;//Contador para poder ver en que indice encontro la pelicula
            linea = entrada.readLine();
            while (linea != null) {
                if (linea.equals(buscar)) {//Conndicional: si la linea leida es igual a la busqueda
                    result = "Pelicula " + linea + " encontrada en el indice: " + indice;//String a retornar si hay match
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public void crear(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);//Creamos el archivo
            salida.close();//Con ayuda del metodo close cerramos para que se cree el archivo en el disco duro.
            System.out.println("Se creo el archivo correctamente!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        archivo.delete();//Con ayuda del metodo delete borramos el archivo.
        System.out.println("Se ah borrado el archivo correctamente.");
    }
}
