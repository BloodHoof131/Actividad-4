package Excepciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vendedor extends JFrame implements ActionListener {

    String nombre;
    String apellidos;
    int edad;

    JTextArea areaTexto;
    JTextField campoTexto;

    int paso = 0;

    public Vendedor() {

        setTitle("Registro de Vendedor");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Área de texto tipo consola
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Consolas", Font.PLAIN, 15));

        JScrollPane scroll = new JScrollPane(areaTexto);

        // Campo de entrada
        campoTexto = new JTextField();
        campoTexto.setFont(new Font("Consolas", Font.PLAIN, 15));

        // ENTER ejecuta
        campoTexto.addActionListener(this);

        add(scroll, BorderLayout.CENTER);
        add(campoTexto, BorderLayout.SOUTH);

        // Primera pregunta
        areaTexto.append("Ingrese el nombre del vendedor:\n> ");

        setVisible(true);
    }

    // Método imprimir
    void imprimir() {

        areaTexto.append("\n");
        areaTexto.append("===== DATOS DEL VENDEDOR =====\n");
        areaTexto.append("Nombre: " + nombre + "\n");
        areaTexto.append("Apellidos: " + apellidos + "\n");
        areaTexto.append("Edad: " + edad + "\n");
    }

    // Validar edad
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

    @Override
    public void actionPerformed(ActionEvent e) {

        String entrada = campoTexto.getText();

        // Mostrar lo que escribió el usuario
        areaTexto.append(entrada + "\n");

        // Limpiar campo
        campoTexto.setText("");

        // PASO 1 -> NOMBRE
        if (paso == 0) {

            nombre = entrada;

            areaTexto.append("\nIngrese los apellidos del vendedor:\n> ");

            paso++;
        }

        // PASO 2 -> APELLIDOS
        else if (paso == 1) {

            apellidos = entrada;

            areaTexto.append("\nIngrese la edad del vendedor:\n> ");

            paso++;
        }

        // PASO 3 -> EDAD
        else if (paso == 2) {

            try {

                edad = Integer.parseInt(entrada);

                verificarEdad(edad);

                imprimir();

                areaTexto.append("\nProceso finalizado.");

                // Bloquear escritura al terminar correctamente
                campoTexto.setEditable(false);

            } catch (IllegalArgumentException ex) {

                areaTexto.append(
                    "\nError: " + ex.getMessage()
                );

                areaTexto.append(
                    "\nIngrese nuevamente la edad:\n> "
                );

            } catch (Exception ex) {

                areaTexto.append(
                    "\nError: Debe ingresar un número válido."
                );

                areaTexto.append(
                    "\nIngrese nuevamente la edad:\n> "
                );
            }
        }
    }

    public static void main(String[] args) {

        new Vendedor();
    }
}
