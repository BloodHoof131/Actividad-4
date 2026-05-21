package Excepciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipoMaratonProgramacion
        extends JFrame
        implements ActionListener {

    // Atributos
    String nombreEquipo;
    String universidad;
    String lenguajeProgramacion;

    Programador[] programadores;

    int tamañoEquipo;

    JTextArea areaTexto;
    JTextField campoTexto;

    int paso = 0;

    String nombreProgramador;
    String apellidosProgramador;

    // Constructor interfaz
    public EquipoMaratonProgramacion() {

        setTitle("Equipo Maratón de Programación");

        setSize(650, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Área de texto
        areaTexto = new JTextArea();

        areaTexto.setEditable(false);

        areaTexto.setFont(
            new Font("Consolas", Font.PLAIN, 15)
        );

        JScrollPane scroll =
            new JScrollPane(areaTexto);

        // Campo de entrada
        campoTexto = new JTextField();

        campoTexto.setFont(
            new Font("Consolas", Font.PLAIN, 15)
        );

        campoTexto.addActionListener(this);

        add(scroll, BorderLayout.CENTER);

        add(campoTexto, BorderLayout.SOUTH);

        // Primera pregunta
        areaTexto.append(
            "Nombre del equipo:\n> "
        );

        setVisible(true);
    }

    // Constructor del equipo
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

    // Verificar si está lleno
    boolean estaLleno() {

        return tamañoEquipo == programadores.length;
    }

    // Añadir programador
    void añadir(Programador programador)
            throws Exception {

        if (estaLleno()) {

            throw new Exception(
                "El equipo está completo."
            );
        }

        programadores[tamañoEquipo] = programador;

        tamañoEquipo++;
    }

    // Validar campo
    static void validarCampo(String campo)
            throws Exception {

        for (int j = 0; j < campo.length(); j++) {

            char c = campo.charAt(j);

            if (Character.isDigit(c)) {

                throw new Exception(
                    "El nombre no puede tener números."
                );
            }
        }

        if (campo.length() > 20) {

            throw new Exception(
                "La longitud no puede superar 20 caracteres."
            );
        }
    }

    // Acción ENTER
    @Override
    public void actionPerformed(ActionEvent e) {

        String entrada = campoTexto.getText();

        areaTexto.append(entrada + "\n");

        campoTexto.setText("");

        try {

            // PASO 1 -> NOMBRE EQUIPO
            if (paso == 0) {

                nombreEquipo = entrada;

                areaTexto.append(
                    "\nUniversidad:\n> "
                );

                paso++;
            }

            // PASO 2 -> UNIVERSIDAD
            else if (paso == 1) {

                universidad = entrada;

                areaTexto.append(
                    "\nLenguaje de programación:\n> "
                );

                paso++;
            }

            // PASO 3 -> LENGUAJE
            else if (paso == 2) {

                lenguajeProgramacion = entrada;

                programadores =
                    new Programador[3];

                tamañoEquipo = 0;

                areaTexto.append(
                    "\n=== DATOS DE LOS INTEGRANTES ===\n"
                );

                areaTexto.append(
                    "\nNombre del integrante 1:\n> "
                );

                paso++;
            }

            // NOMBRE PROGRAMADOR
            else if (
                paso == 3 ||
                paso == 5 ||
                paso == 7
            ) {

                validarCampo(entrada);

                nombreProgramador = entrada;

                areaTexto.append(
                    "\nApellidos del integrante:\n> "
                );

                paso++;
            }

            // APELLIDOS PROGRAMADOR
            else if (
                paso == 4 ||
                paso == 6 ||
                paso == 8
            ) {

                validarCampo(entrada);

                apellidosProgramador = entrada;

                Programador programador =
                    new Programador(
                        nombreProgramador,
                        apellidosProgramador
                    );

                añadir(programador);

                if (tamañoEquipo < 3) {

                    areaTexto.append(
                        "\nNombre del integrante "
                        + (tamañoEquipo + 1)
                        + ":\n> "
                    );

                } else {

                    areaTexto.append(
                        "\nEquipo registrado correctamente."
                    );

                    campoTexto.setEditable(false);
                }

                paso++;
            }

        } catch (Exception ex) {

            areaTexto.append(
                "\nError: "
                + ex.getMessage()
                + "\n> "
            );
        }
    }

    // Main
    public static void main(String[] args) {

        new EquipoMaratonProgramacion();
    }
}
