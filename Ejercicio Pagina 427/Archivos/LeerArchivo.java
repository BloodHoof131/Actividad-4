package Archivos;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerArchivo extends JFrame {

    JTextArea areaTexto;

    public LeerArchivo() {

        setTitle("Lectura de Archivo");

        setSize(600, 400);

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

        add(scroll, BorderLayout.CENTER);

        setVisible(true);

        leerArchivo();
    }

    // Método para leer archivo
    void leerArchivo() {

        String nombreArchivo =
            "/workspaces/Actividad-4/Ejercicio Pagina 427/LeerArchivo.txt";

        FileInputStream archivo;

        InputStreamReader conversor;

        BufferedReader filtro;

        String linea;

        try {

            areaTexto.append(
                "Leyendo archivo...\n\n"
            );

            archivo =
                new FileInputStream(nombreArchivo);

            conversor =
                new InputStreamReader(archivo);

            filtro =
                new BufferedReader(conversor);

            linea = filtro.readLine();

            while (linea != null) {

                areaTexto.append(linea + "\n");

                linea = filtro.readLine();
            }

            filtro.close();

            areaTexto.append(
                "\nLectura finalizada."
            );

        } catch (IOException e) {

            areaTexto.append(
                "No se pudo leer el archivo."
            );
        }
    }

    // Main
    public static void main(String[] args) {

        new LeerArchivo();
    }
}
