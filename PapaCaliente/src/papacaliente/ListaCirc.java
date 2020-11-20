/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papacaliente;

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

        try {
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

        try {             
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
    public void read_inv()throws FileNotFoundException{
        LinkedList list = new LinkedList();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try{
            archivo = new File("C:/Users/Zacarias/Documents/NetBeansProjects/PapaCaliente/jugadoresin.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            String linea;
            while((linea = br.readLine()) != null){
                list.add(linea);
            }
            Iterator it = list.descendingIterator();
            while(it.hasNext())
                System.out.println(it.next());
            random();
        }catch(IOException e){
            System.err.println("Ha ocurrido un error: "+e);
        }
    }
       
    Nodo ini;
    Nodo ultimo;
    Nodo L;
    Nodo aux;

    
    public void Lista(){
        ultimo = null;
        L = null;
        aux = null;
    }
    
    public boolean isEmpty(){
        return ultimo == null;
    }
    
    public void quemado(int dato) throws IOException{
        FileWriter file1 = null;
        PrintWriter pw;
        if(!this.isEmpty()){
            aux = L;
            Nodo aux2 = aux;
            while(aux.siguiente != L && !aux.dato.equals(dato)){
                aux2 = aux;
                aux = aux.siguiente;
            }if(aux.dato.equals(dato)){
                if (aux == L && L.siguiente == L) {
                    L = null;
                }else{
                    aux2.siguiente = aux.siguiente;
                }
                System.out.println("Se quemo: " +aux.dato);
                try {
                    file1 = new FileWriter("C:/Users/Zacarias/Desktop/Proyecto/perdedoresout.txt");
                    pw = new PrintWriter(file1);
                    
                    pw.write(aux.dato);
                    pw.write("");
                    
                } catch (IOException er) {
                    System.err.println("Ha ocurrido un error: " + er);
                } finally {
                    try{
                        if (file1 != null) {
                            file1.close();
                        }
                    }catch(IOException e2) {
                    System.err.println("Ha ocurrido un error: " + e2); 
                    }
                }
            }
        }
    }
    void eliminar1(String dato){
        aux=L;
        Nodo aux2 = null;
        while(aux.siguiente!=null || aux.dato != dato){
            aux2=aux;
            aux=aux.siguiente;
        }
        if (aux.dato == dato){
            if (aux == L && aux.dato == dato) {
                L = L.siguiente;
            }else{
                aux2.siguiente = aux.siguiente;
            }
            System.out.println(dato + " jugador quemado");
        }else{
            System.out.println("valor no encontrado en la lista");
        }
    }
    
    public void random() throws IOException{
        int aleatorio, i;
        
        aleatorio = (int)(Math.random()*100);
        for (i = 0; i <= aleatorio; i++) {
        }
        quemado(i);
    }
    
}
