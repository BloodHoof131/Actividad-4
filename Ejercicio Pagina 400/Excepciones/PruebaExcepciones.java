package Excepciones;

import javax.swing.*;
import java.awt.*;

public class PruebaExcepciones extends JFrame {

    JTextArea areaTexto;

    public PruebaExcepciones() {

        // Configuración de la ventana
        setTitle("Manejo de Excepciones");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Área de texto
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Arial", Font.PLAIN, 14));

        // Scroll
        JScrollPane scroll = new JScrollPane(areaTexto);

        // Agregar componente
        add(scroll);

        // Mostrar ventana
        setVisible(true);

        // Ejecutar excepciones automáticamente
        ejecutarExcepciones();
    }

    public void ejecutarExcepciones() {

        // PRIMER TRY
        try {

            areaTexto.append("Ingresando al primer try\n");

            double cociente = 10000 / 0;

            areaTexto.append("Después de la división\n");

        } catch (ArithmeticException e) {

            areaTexto.append("División por cero\n");

        } finally {

            areaTexto.append("Ingresando al primer finally\n\n");
        }

        // SEGUNDO TRY
        try {

            areaTexto.append("Ingresando al segundo try\n");

            Object objeto = null;

            objeto.toString();

            areaTexto.append("Imprimiendo objeto\n");

        } catch (ArithmeticException e) {

            areaTexto.append("División por cero\n");

        } catch (Exception e) {

            areaTexto.append("Ocurrió una excepción\n");

        } finally {

            areaTexto.append("Ingresando al segundo finally\n");
        }
    }

    public static void main(String[] args) {

        new PruebaExcepciones();
    }
}
