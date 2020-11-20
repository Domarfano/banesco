/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papacalienteprincipal;
import java.io.*;
import java.util.*;
/**
 *
 * @author Zacarias
 */
public class ListaCirc {
     public void write() throws IOException {
        FileWriter file = null ;
        PrintWriter pw = null;

        try {                      //("C:/Users/Usuario/Documents/NetBeansProjects/PapaCaliente/jugadoresin.txt")
            file = new FileWriter("C:/Users/Zacarias/Documents/NetBeansProjects/PapaCaliente/jugadoresin.txt");
            pw = new PrintWriter(file);

            pw.println("Andrea");
            pw.println("Ana");
            pw.println("Patricia");
            pw.println("Luis");
            pw.println("Carlos");
            pw.println("Rafael");
            pw.println("");
            
        } catch (IOException e) {
            System.err.println("Ha ocurrido un error al escribir");
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e2) {
                System.err.println("Ha ocurrido un error: " + e2);
            }
        }

    }

    public void read() throws FileNotFoundException {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {             //("C:/Users/Usuario/Documents/NetBeansProjects/PapaCaliente/jugadoresin.txt")
            archivo = new File("C:/Users/Zacarias/Documents/NetBeansProjects/PapaCaliente/jugadoresin.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                random();
            }
        } catch (IOException ex) {
            System.err.println("Ha ocurrido un error:  " + ex);
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex2) {
                System.err.println("Ha ocurrido un error: " + ex2);
            }
        }
    }
}
