package Excepciones;

import java.util.Scanner;

public class EquipoMaratonProgramacion {

    // Atributos
    String nombreEquipo;
    String universidad;
    String lenguajeProgramacion;
    Programador[] programadores;
    int tamañoEquipo;

    // Constructor
    EquipoMaratonProgramacion(
            String nombreEquipo,
            String universidad,
            String lenguajeProgramacion) {

        this.nombreEquipo = nombreEquipo;
        this.universidad = universidad;
        this.lenguajeProgramacion = lenguajeProgramacion;

        tamañoEquipo = 0;

        programadores = new Programador[3];
    }

    // Verifica si el equipo está lleno
    boolean estaLleno() {

        return tamañoEquipo == programadores.length;
    }

    // Añadir programador
    void añadir(Programador programador) throws Exception {

        if (estaLleno()) {

            throw new Exception(
                "El equipo está completo. No se pudo agregar programador."
            );
        }

        programadores[tamañoEquipo] = programador;

        tamañoEquipo++;
    }

    // Validar campos
    static void validarCampo(String campo) throws Exception {

        for (int j = 0; j < campo.length(); j++) {

            char c = campo.charAt(j);

            if (Character.isDigit(c)) {

                throw new Exception(
                    "El nombre no puede tener dígitos."
                );
            }
        }

        if (campo.length() > 20) {

            throw new Exception(
                "La longitud no debe ser superior a 20 caracteres."
            );
        }
    }

    // Método principal
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        try {

            System.out.println("Nombre del equipo = ");
            String nombre = teclado.next();

            System.out.println("Universidad = ");
            String universidad = teclado.next();

            System.out.println("Lenguaje de programación = ");
            String lenguaje = teclado.next();

            EquipoMaratonProgramacion equipo =
                new EquipoMaratonProgramacion(
                    nombre,
                    universidad,
                    lenguaje
                );

            System.out.println("Datos de los integrantes del equipo");

            for (int i = 0; i < 3; i++) {

                System.out.println("Nombre del integrante = ");
                String nombreProgramador = teclado.next();

                validarCampo(nombreProgramador);

                System.out.println("Apellidos del integrante = ");
                String apellidosProgramador = teclado.next();

                validarCampo(apellidosProgramador);

                Programador programador =
                    new Programador(
                        nombreProgramador,
                        apellidosProgramador
                    );

                equipo.añadir(programador);
            }

            System.out.println("Equipo registrado correctamente.");

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        } finally {

            teclado.close();
        }
    }
}