package Archivos;
import java.io.*; 
/**
* Esta clase denominada LeerArchivo tiene como objetivo leer los datos 
* presentes en un archivo de texto con extensión .txt
* @version 1.2/2020
*/
public class LeerArchivo { 
/**
* Método main que lee una archivo de texto y muestra su contenido 
* en pantalla
* @throws IOException Excepción que indica que no se pudo leer 
* el archivo
*/
public static void main(String[] args) throws Exception {
String nombreArchivo = “C:/prueba.txt”; /* Definición del 
archivo de texto a leer */
FileInputStream archivo; // Definición de flujo de datos
InputStreamReader conversor; // Definición del flujo de lectura
BufferedReader filtro; // Definición del buffer
String línea;
try {
/* Crea los objetos FileInputStream, BufferedReader y 
BufferedReader */
archivo = new FileInputStream(nombreArchivo);
conversor = new InputStreamReader(archivo);
filtro = new BufferedReader(conversor);
línea = filtro.readLine();
while (línea != null) {
System.out.println(línea); /* Imprime en pantalla una 
línea del archivo */
línea = filtro.readLine(); // Lee la siguiente línea
} 
filtro.close(); // Cierra el archivo
} catch (IOException e) { // En caso que se genere una excepción
System.out.println(“No se pudo leer el archivo.”);
}
}
}