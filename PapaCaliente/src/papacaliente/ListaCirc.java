/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papacaliente;

import java.io.*;

/**
 *
 * @author Zacarias
 */
public class ListaCirc {
    public void write() throws IOException {
        FileWriter file = null;
        PrintWriter pw = null;
        try {
            file = new FileWriter("C:/Users/Zacarias/Desktop/Proyecto/jugadoresin.txt");
            pw = new PrintWriter(file);

            pw.println("Andrea");
            pw.println("Ana");
            pw.println("Patricia");

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
    private Nodo ini;
    private Nodo ultimo;
    private int tam;
    
    public void Lista(){
        ini = null;
        ultimo = null;
        tam = 0;
    }
    
    public boolean isEmpty(){
        return ini == null;
    }
    
    public int getTam(){
        return tam;
    }
    
    public void insertFinal(char dato){
        Nodo nuevo = new Nodo();
        nuevo.setDato(dato);
        
        if(isEmpty()){
            ini = nuevo;
            ultimo = nuevo;
            ultimo.setSiguiente(ini);
        }else{
            ultimo.setSiguiente(nuevo);
            nuevo.setSiguiente(ini);
            ultimo = nuevo;
        }
        tam++;
    }
    
    public void insertIni(char dato){
        Nodo nuevo = new Nodo();
        nuevo.setDato(dato);
        
        if(isEmpty()){
            ini = nuevo;
            ultimo = nuevo;
            ultimo.setSiguiente(ini);
        }else{
            nuevo.setSiguiente(ini);
            ini = nuevo;
            ultimo.setSiguiente(ini);
        }
        tam++;
    }
    
    public char getDato(int posicion) throws IOException{
        if (posicion >= 0 && posicion < tam) {
            if (posicion == 0) {
                return (char) ini.getDato();
            }else{
                Nodo aux = ini;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                return (char) aux.getDato();
            }
        }else{
            throw new IOException("No existe dentro de la lista");
        }
    }
    
    public boolean search(int ref){
        Nodo aux = ini;
        boolean found = false;
        do{
            if (ref == aux.getDato()) {
                found = true;
            }else{
                aux = aux.getSiguiente();
            }
        }while(aux != ini && found !=true);
        return found;
    }
    
    public int getPosicion(int ref) throws IOException{
        if(search(ref)){
            Nodo aux = ini;
            int cont = 0;
            
            while(ref != aux.getDato()){
                cont++;
                aux = aux.getSiguiente();
            }
            return cont;
        }else{
            throw new IOException("No existe en la lista");
        }        
    }
    
    public void editRef(int ref, char dato){
        if (search(ref)) {
            Nodo aux = ini;
            
            while(aux.getDato() != ref){
                aux = aux.getSiguiente();
            }
            aux.setDato(dato);
        }
    }
    
    public void editPos(int posicion, char dato){
        if (posicion >= 0 && posicion < tam) {
            if (posicion == 0) {
                ini.setDato(dato);
            }else{
                Nodo aux = ini;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setDato(dato);
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
