/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papacaliente;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Zacarias
 */
public class PapaCaliente {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws IOException {
        ListaCirc list = new ListaCirc();
        list.write();
        Scanner lc = new Scanner(System.in);
        int op;

        System.out.println("En que sentiod jugaran?");
        System.out.println("(1) Horario");
        System.out.println("(2) Antiorario");
        op = lc.nextInt();
        if (op == 1) {
            System.out.println("LA PAPA CALIENTE EN SENTIDO HORARIO");
            System.out.println("");
            list.read();
                    
        } else {
            System.out.println("LA PAPA CALIENTE EN SENTIDO ANTIHORARIO");
            System.out.println("");
        }

    }
}

