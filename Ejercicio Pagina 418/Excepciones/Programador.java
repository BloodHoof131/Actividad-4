package Excepciones;
/**
* Esta clase denominada Programador modela un integrante de un 
* equipo de programadores que participará en una maratón de 
* programación. Un programador cuenta con un nombre y apellidos.
* @version 1.2/2020
*/
public class Programador {
String nombre; /* Atributo que identifica el nombre de un 
programador */
String apellidos; /* Atributo que identifica los apellidos de un 
programador */
/**
* Constructor de la clase Programador
* @param nombre Parámetro que define el nombre del programador
* @param apellidos Parámetro que define los apellidos del 
* programador
*/
Programador(String nombre, String apellidos) {
this.nombre = nombre;
this.apellidos = apellidos;
}
}