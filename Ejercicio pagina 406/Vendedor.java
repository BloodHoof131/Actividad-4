package Excepciones;
import java.util.*;
/**
* Esta clase denominada Vendedor modela un vendedor que tiene 
* como atributos un nombre, apellidos y una edad. 
* @version 1.2/2020
*/
public class Vendedor {
String nombre; // Atributo que identifica el nombre de un vendedor
String apellidos; // Atributo que identifica los apellidos de un vendedor
int edad; // Atributo que identifica la edad de un vendedor
/**
* Constructor de la clase Vendedor
* @param nombre Parámetro que define el nombre de un vendedor
* @param nombre Parámetro que define la edad de un vendedor
*/
Vendedor(String nombre, String apellidos) {
this.nombre = nombre;
this.apellidos = apellidos;
}
/**
* Método que muestra en pantalla los datos de un vendedor
*/
void imprimir() {
System.out.println(“Nombre del vendedor = “ + nombre);
System.out.println(“Apellidos del vendedor = “ + apellidos);
System.out.println(“Edad del vendedor = “ + edad);
}
/**
* Método que verifica que la edad de un vendedor es apropiada; si 
* no lo es, se generan las excepciones correspondientes
* @throws IllegalArgumentException Excepción de argumento ilegal 
* cuyo valor debe ser mayor que 18, ni negativo, ni mayor a 120
*/
void verificarEdad(int edad) {
if (edad < 18) { /* El vendedor debe tener una edad mayor de 18 
años */
// Se genera una excepción de argumento ilegal
throw new IllegalArgumentException(“El vendedor debe ser 
mayor de 18 años.”);
} if (edad >= 0 && edad < 120) { /* El vendedor debe tener una 
edad entre 0 y 120 */
this.edad = edad;
} else throw new IllegalArgumentException(“La edad no puede 
ser negativa ni mayor a 120.”);
/* En cualquier otro caso se genera una excepción de argumento 
ilegal */
}
/**
* Método que solicita por teclado el nombre, apellidos y edad de un 
* vendedor. Luego, se verifica la edad. Si la edad no es correcta, se 
* generan las excepciones correspondientes.
*/
public static void main(String[] args) { 
Scanner teclado = new Scanner(System.in);
System.out.println(“Nombre del vendedor = “);
String n = teclado.next();
System.out.println(“Apellidos del vendedor = “);
String a = teclado.next();
Vendedor vendedor = new Vendedor(n, a);
System.out.println(“Edad del vendedor = “);
int e = teclado.nextInt();
vendedor.verificarEdad(e);
vendedor.imprimir();
}
}