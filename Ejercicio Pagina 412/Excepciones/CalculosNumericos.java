package Excepciones;
import java.util.*;
/**
* Esta clase denominada CálculosNuméricos permite realizar dos 
* cálculos matemáticos: calcular el logaritmo neperiano de un valor y 
* calcular la raíz cuadrada de un valor.
* @version 1.2/2020
*/
public class CálculosNuméricos {
/**
* Método que calcula el logaritmo neperiano de un valor numérico. 
* Si el valor pasado como parámetro no es correcto se genera la 
* excepción correspondiente
* @param valor Parámetro que define el valor al cual se le calculará 
* el logaritmo neperiano
* @throws ArithmeticException Excepción aritmética que indica 
* que el número debe ser positivo
* @throws InputMismatchException Excepción que indica que el 
* valor ingresado debe ser numérico
*/
static void calcularLogaritmoNeperiano(double valor) {
try {
if (valor < 0) {
// Si el valor es negativo, se genera una excepción aritmética
throw new ArithmeticException(“El valor debe ser un 
número positivo”);
}
// Si el valor es positivo, se calcula el algoritmo neperiano
double resultado = Math.log(valor); 
System.out.println(“Resultado = “ + resultado);
} catch (ArithmeticException e) {
/* Si ocurre una excepción aritmética, se muestra un mensaje 
de error */
System.out.println(“El valor debe ser un número positivo para 
calcular el logaritmo”);
} catch (InputMismatchException e) {
/* Si el valor a calcular no es numérico, se muestra un mensaje 
de error */
System.out.println(“El valor debe ser numérico para calcular 
el logaritmo”);
}
}
/**
* Método que calcula la raíz cuadrada de un valor numérico. Si el 
* valor pasado como parámetro no es correcto se genera la 
* excepción correspondiente
* @param valor Parámetro que define el valor al cual se le calculará 
* la raíz cuadrada
* @throws ArithmeticException Excepción aritmética que indica 
* que el número debe ser positivo
* @throws InputMismatchException Excepción que indica que el 
* valor ingresado debe ser numérico
*/
static void calcularRaízCuadrada(double valor) {
try {
if (valor < 0) {
// Si el valor es negativo, se genera una excepción aritmética
throw new ArithmeticException(“El valor debe ser un 
número positivo”);
}
double resultado = Math.sqrt(valor); /* Si el valor es positivo, 
se calcula la raíz cuadrada */
System.out.println(“Resultado = “ + resultado);
} catch (ArithmeticException e) {
/* Si ocurre una excepción aritmética, se muestra un mensaje 
de error */
System.out.println(“El valor debe ser un número positivo para 
calcular la raíz cuadrada”);
} catch (InputMismatchException e) {
/* Si el valor a calcular no es numérico, se muestra un mensaje 
de error */
System.out.println(“El valor debe ser numérico para calcular 
la raíz cuadrada”);
}
}
/**
* Método main que solicita un valor numérico por teclado. Para 
* dicho valor se calcula el logaritmo neperiano y la raíz cuadrada. Si 
* el valor ingresado no es correcto, se generan las excepciones 
* correspondientes.
*/
public static void main(String args[]) {
System.out.print(“Valor numérico = “);
Scanner teclado = new Scanner(System.in);
double valor = teclado.nextDouble();
calcularLogaritmoNeperiano(valor);
calcularRaízCuadrada(valor);
}
}