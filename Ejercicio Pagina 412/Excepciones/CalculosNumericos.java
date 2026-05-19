package Excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculosNumericos {

    // Método para calcular logaritmo neperiano
    static void calcularLogaritmoNeperiano(double valor) {

        try {

            if (valor < 0) {

                throw new ArithmeticException(
                    "El valor debe ser un número positivo"
                );
            }

            double resultado = Math.log(valor);

            System.out.println("Resultado del logaritmo = " + resultado);

        } catch (ArithmeticException e) {

            System.out.println(
                "El valor debe ser un número positivo para calcular el logaritmo"
            );

        } catch (InputMismatchException e) {

            System.out.println(
                "El valor debe ser numérico para calcular el logaritmo"
            );
        }
    }

    // Método para calcular raíz cuadrada
    static void calcularRaizCuadrada(double valor) {

        try {

            if (valor < 0) {

                throw new ArithmeticException(
                    "El valor debe ser un número positivo"
                );
            }

            double resultado = Math.sqrt(valor);

            System.out.println("Resultado de la raíz cuadrada = " + resultado);

        } catch (ArithmeticException e) {

            System.out.println(
                "El valor debe ser un número positivo para calcular la raíz cuadrada"
            );

        } catch (InputMismatchException e) {

            System.out.println(
                "El valor debe ser numérico para calcular la raíz cuadrada"
            );
        }
    }

    // Método principal
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        try {

            System.out.print("Valor numérico = ");

            double valor = teclado.nextDouble();

            calcularLogaritmoNeperiano(valor);

            calcularRaizCuadrada(valor);

        } catch (InputMismatchException e) {

            System.out.println("Debe ingresar un valor numérico válido.");

        } finally {

            teclado.close();
        }
    }
}