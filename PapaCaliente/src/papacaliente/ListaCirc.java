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
            file = new FileWriter("C:/Users/Zacarias/Desktop/Proyecto/jugadoresin.txt");
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

        try {             //(FileReader input = new FileReader("C:/Users/Zacarias/Desktop/Proyecto/jugadoresin.txt")) {
            archivo = new File("C:/Users/Zacarias/Desktop/Proyecto/jugadoresin.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
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
            archivo = new File("C:/Users/Zacarias/Desktop/Proyecto/jugadoresin.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            String linea;
            while((linea = br.readLine()) != null){
                list.add(linea);
            }
            Iterator it = list.descendingIterator();
            while(it.hasNext())
                System.out.println(it.next());
        }catch(IOException e){
            System.err.println("Ha ocurrido un error: "+e);
        }
    }
    
    
    
    
    
    Nodo ini;
    Nodo ultimo;
    Nodo L;
    Nodo aux;
    int tam;
    
    public void Lista(){
        ultimo = null;
        L = null;
        aux = null;
        tam = 0;
    }
    
    public boolean isEmpty(){
        return ultimo == null;
    }
    
    public int getTam(){
        return tam;
    }
    
    public void insertFinal(String dato){
        Nodo nuevo = new Nodo();
        nuevo.setDato(dato);
        
        if(isEmpty()){
            ultimo = nuevo;
            ultimo.setSiguiente(L);
        }else{
            ultimo.setSiguiente(nuevo);
            nuevo.setSiguiente(L);
            ultimo = nuevo;
        }
        tam++;
    }
    
    public void insertIni(String dato){
        Nodo nuevo = new Nodo();
        nuevo.setDato(dato);
        
        if(isEmpty()){
            L = nuevo;
            ultimo = nuevo;
            ultimo.setSiguiente(L);
        }else{
            nuevo.setSiguiente(L);
            L = nuevo;
            ultimo.setSiguiente(L);
        }
        tam++;
    }
    
    public String getDato(int posicion) throws IOException{
        if (posicion >= 0 && posicion < tam) {
            if (posicion == 0) {
                return (String) L.getDato();
            }else{
                Nodo aux = L;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                return (String) aux.getDato();
            }
        }else{
            throw new IOException("No existe dentro de la lista");
        }
    }
    
    public void search(String dato){
        if (!this.isEmpty()) {
            aux = L;
            Nodo aux2 = aux;
            while(aux.getSiguiente() != L && !aux.dato.equals(dato)){
                aux2 = aux;
                aux = aux.siguiente;
            }if (aux.dato.equals(dato)) {
                System.out.println(aux.dato + "El jugador existe en la lista");
            }else{
                if (aux.siguiente == L) {
                    System.out.println("No se encontro en la busqueda");
                }
            }
        }else{
            System.out.println("La lista esta vacia");
        }
    }
    public void update(String dato){
        if (!this.isEmpty()) {
            aux = L;
            Nodo aux2 = aux;
            while(aux.siguiente != L && !aux.dato.equals(dato)){
                aux2 = aux;
                aux = aux.siguiente;
            }if (aux.dato.equals(dato)) {
                String jug = aux.dato;
                aux.dato = dato;
                System.out.println(jug + "Sale y entra: " + aux.dato);
            }else{
                if (aux.siguiente == L) {
                    System.out.println("No hay compatibilidad en la busqueda");
                }
            }
        }else{
            System.out.println("La lista esta vacia");
        }
    }
    
    public void quemado(String dato) throws IOException{
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
    void inverso(String dato){
        if (L == null) {
            aux = L;
            Nodo aux2 = aux;
            while(aux.siguiente != null)
                aux = aux.siguiente;
            while(aux.siguiente != L && !aux.dato.equals(dato))
                aux = aux.siguiente;
            if (aux.dato.equals(dato)) {
                System.out.println("Lista inversa: " + dato);
            }else{
                if (aux.siguiente == null) {
                    System.out.println("No hubo coincidencias");
                }
            }
        }
        
    }
    public void removePos(int posicion){
        if (posicion >= 0 && posicion < tam) {
            if (posicion == 0) {
                ini = ini.getSiguiente();
                ultimo.setSiguiente(ini);
            }else{
                Nodo aux = ini;
                for (int i = 0; i < posicion-1; i++) {
                    aux= aux.getSiguiente();
                }
                if (aux.getSiguiente() == ultimo) {
                    aux.setSiguiente(ini);
                    ultimo = aux;
                }else{
                    Nodo siguiente = aux.getSiguiente();
                    aux.setSiguiente(siguiente.getSiguiente());
                }
            }
            tam--;
        }
    }
    
    public void listar(){
        if (!isEmpty()) {
            Nodo aux = ini;
            
            int i = 0;
            System.out.println("");
            
            do{
                System.out.print(i +".[ "+ aux.getDato() + "]" + "->");
                aux = aux.getSiguiente();
                i++;
            }while(aux != ini);
        }
    }
}
