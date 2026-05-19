package Excepciones;

import java.util.Scanner;

public class Vendedor {

    String nombre;
    String apellidos;
    int edad;

    // Constructor
    Vendedor(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    // Método para imprimir datos
    void imprimir() {
        System.out.println("Nombre del vendedor = " + nombre);
        System.out.println("Apellidos del vendedor = " + apellidos);
        System.out.println("Edad del vendedor = " + edad);
    }

    // Método para verificar la edad
    void verificarEdad(int edad) {

        if (edad < 18) {

            throw new IllegalArgumentException(
                "El vendedor debe ser mayor de 18 años."
            );
        }

        if (edad >= 0 && edad < 120) {

            this.edad = edad;

        } else {

            throw new IllegalArgumentException(
                "La edad no puede ser negativa ni mayor a 120."
            );
        }
    }

    // Método principal
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Nombre del vendedor = ");
        String n = teclado.next();

        System.out.println("Apellidos del vendedor = ");
        String a = teclado.next();

        Vendedor vendedor = new Vendedor(n, a);

        System.out.println("Edad del vendedor = ");
        int e = teclado.nextInt();

        vendedor.verificarEdad(e);

        vendedor.imprimir();

        teclado.close();
    }
}