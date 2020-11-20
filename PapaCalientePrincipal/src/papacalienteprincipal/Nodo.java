/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papacalienteprincipal;

/**
 *
 * @author Domarfano & Zacarias
 */
public class Nodo {
    String dato;
    Nodo siguiente;

    public void Nodo(String d) {
        this.dato = d;
    }

    public void Nodo(String d, Nodo L) {
        this.dato = d;
        this.siguiente = L;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
