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
        do{
            System.out.println("\nEn que sentido jugaran?");
            System.out.println("(1) Horario");
            System.out.println("(2) Antiorario");
            System.out.println("(3) Escape");
            System.out.println("\n");
            op = lc.nextInt();
            switch(op){
                case 1:
                    System.out.println("\nLA PAPA CALIENTE EN SENTIDO HORARIO");
                    System.out.println("");
                    list.read();
                break;    
                case 2:
                    System.out.println("\nLA PAPA CALIENTE EN SENTIDO ANTIHORARIO");
                    System.out.println("");
                    list.read_inv();
                break;
                case 3:
                    System.out.println("Bye Bye");
                break;
            }
        }while(op != 3);
    }

    public void recorrer() throws FileNotFoundException{
        ListaCirc list = new ListaCirc();
        
    }
    
    void recorrer_inv(String dato)throws FileNotFoundException{
        ListaCirc list = new ListaCirc(); 
        
        
    }
    
    
}

