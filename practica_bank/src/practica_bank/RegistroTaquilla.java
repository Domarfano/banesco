package practica_bank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistroTaquilla {
    
     void guardar() throws IOException {
        String datos = "";
        Archivo arch = new Archivo();
        arch.crear("Clientes-pendientes.in", datos);
    }
    
     class Archivo {

    PrintWriter pf;
    FileReader fr;

    void crear(String nombre, String datos) throws IOException {
        pf = new PrintWriter(new FileWriter(nombre, true));
        pf.println(datos);
        pf.close();

    }

    void ListaTransacciones(String nombre) throws IOException {
        fr = new FileReader(nombre);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = new String[4];
            datos = linea.split("-");
            for (int i = 0; i <= datos.length - 1; i++) {
                System.out.println(datos[i]);
            }

        }
    }
}
     
}
