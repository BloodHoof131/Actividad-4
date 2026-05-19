package Excepciones;
/**
* Esta clase denominada PruebaExcepciones lanza diferentes 
* excepciones en situaciones específicas del programa. Los mensajes 
* que se muestran en pantalla ayudan a identificar la porción de código 
* que se ejecutó o no.
* @version 1.2/2020
*/
public class PruebaExcepciones {
/**
* Método main con dos bloques try que generan excepciones que 
* deben ser gestionadas
* @throws ArithmeticException Excepción aritmética de división 
* por cero
* @throws Exception Excepción general
*/
public static void main(String args[]) {
// Primer bloque try
try {
System.out.println(“Ingresando al primer try”);
double cociente = 10000/0; // Se lanza una excepción
System.out.println(“Después de la división”); /* Esta 
instrucción nunca será ejecutada */
} catch (ArithmeticException e) { // Se captura la excepción
System.out.println(“División por cero”); /* Se imprime en 
pantalla este mensaje */
} finally {
/* La sentencia finally siempre se ejecuta, ocurra o no una 
excepción */
System.out.println(“Ingresando al primer finally”);
}
// Segundo bloque try
try {
System.out.println(“Ingresando al segundo try”);
Object objeto = null;
objeto.toString(); // Se lanza una excepción
/* Esta instrucción nunca será ejecutada porque se lanzó una 
excepción */
System.out.println(“Imprimiendo objeto”);
} catch (ArithmeticException e) { /* La excepción lanzada no es 
de este tipo */
System.out.println(“División por cero”);
} catch (Exception e) { // Se captura la excepción
System.out.println(“Ocurrió una excepción”); /* Se imprime 
en pantalla este mensaje */
} finally {
/* La sentencia finally siempre se ejecuta, ocurra o no una 
excepción */
System.out.println(“Ingresando al segundo finally”);
}
}
}