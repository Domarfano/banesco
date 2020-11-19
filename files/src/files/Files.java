/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class Files {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        readFile accediendo = new readFile();
       
        
        accediendo.read();
       
        
        
    }
    
}

class readFile{
    
    public void read() throws FileNotFoundException {
        lista listas = new lista();
        try (FileReader input = new FileReader("C:/Users/Zacarias/Desktop/Proyecto/jugadoresin.txt")) { //Direccion del archivo 
            int c = 0;
            
            while (c != -1){
                
                c = input.read();
                
                char letra = (char)c;
                listas.insertar(letra);
                listas.mostrarLista();
                listas.recorrerLista();
                listas.eliminar_jugador(letra);
             
                
                
                
            }
        }catch(IOException ex){
            System.out.println("No se ha encontrado el archivo "+ex);
        }
    }
}

class NodoLC {
    
        char dato;
        NodoLC  siguiente;
        
        NodoLC (char d){
            this.dato =d;
        }
        NodoLC(char d, NodoLC L){
            this.dato = d;
            this.siguiente = L;            
        }            
}


class lista {
    NodoLC ultimo;
    NodoLC aux;
    NodoLC L;
    NodoLC anterior;
    
    public lista(){        
        ultimo = null;        
    }
    public boolean estaVacia(){        
        return ultimo == null;
    }
    
    public lista insertar(char d){
        if(L == null){
            L = new NodoLC(d);
            L.siguiente = L;
        }else{
            aux = L;
            while(aux.siguiente != L)
                aux = aux.siguiente;
            aux.siguiente = new NodoLC(d, L);
        }
        ultimo = L;
        return this;
    }
    public void mostrarLista(){
        NodoLC auxiliar = ultimo.siguiente;
        String dat = "";
        
        while(auxiliar.siguiente != L){
            dat = dat+aux.dato+",";
            auxiliar = auxiliar.siguiente;
        }
        System.out.print(auxiliar.dato);       
    }
    
    public void recorrerLista(){
        if(!estaVacia()){
            NodoLC p = L;
            do{
                System.out.print(p.dato);
                p = p.siguiente;
            }while(p != L);
            System.out.println();
        }
    }

    public void eliminar_jugador(char d){
        if (!this.estaVacia()) {
            aux = L;
            NodoLC aux2 = aux;
            while (aux.siguiente !=L && aux.dato == d){
                aux2 = aux;
                aux=aux.siguiente;
            }
            if (aux.dato == d){
                if (aux == L && L.siguiente==L){
                    L = null;
                }else{
                    aux2.siguiente = aux.siguiente;
                }
                System.out.println("Quemado: " + aux.dato);
            }else{
                if (aux.siguiente == L){
                    System.out.println("no pudo se elimino al jugador: "+aux.dato);
                }
            }
        }else{
            System.out.println("Lista Vacia!!");
        }
    } 
}