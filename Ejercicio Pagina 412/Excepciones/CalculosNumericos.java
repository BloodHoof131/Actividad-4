package Excepciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculosNumericos extends JFrame implements ActionListener {

    JTextArea areaTexto;
    JTextField campoTexto;

    public CalculosNumericos() {

        setTitle("Cálculos Numéricos");
        setSize(550, 400);
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

        // Mensaje inicial
        areaTexto.append("Ingrese un valor numérico:\n> ");

        setVisible(true);
    }

    // Método logaritmo
    void calcularLogaritmoNeperiano(double valor) {

        try {

            if (valor < 0) {

                throw new ArithmeticException(
                    "El valor debe ser positivo"
                );
            }

            double resultado = Math.log(valor);

            areaTexto.append(
                "\nResultado del logaritmo = " + resultado + "\n"
            );

        } catch (ArithmeticException e) {

            areaTexto.append(
                "\nError: El valor debe ser positivo para calcular el logaritmo.\n"
            );
        }
    }

    // Método raíz cuadrada
    void calcularRaizCuadrada(double valor) {

        try {

            if (valor < 0) {

                throw new ArithmeticException(
                    "El valor debe ser positivo"
                );
            }

            double resultado = Math.sqrt(valor);

            areaTexto.append(
                "Resultado de la raíz cuadrada = " + resultado + "\n"
            );

        } catch (ArithmeticException e) {

            areaTexto.append(
                "Error: El valor debe ser positivo para calcular la raíz cuadrada.\n"
            );
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String entrada = campoTexto.getText();

        areaTexto.append(entrada + "\n");

        campoTexto.setText("");

        try {

            double valor = Double.parseDouble(entrada);

            calcularLogaritmoNeperiano(valor);

            calcularRaizCuadrada(valor);

            areaTexto.append("\nProceso finalizado.");

            campoTexto.setEditable(false);

        } catch (Exception ex) {

            areaTexto.append(
                "\nError: Debe ingresar un valor numérico válido.\n"
            );

            areaTexto.append("> ");
        }
    }

    // Método principal
    public static void main(String[] args) {

        new CalculosNumericos();
    }
}
