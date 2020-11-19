/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papacaliente;

/**
 *
 * @author Zacarias
 */
public class Nodo {

    private char dato;
    private Nodo siguiente;

    public void Nodo(char d) {
        this.dato = d;
    }

    public void Nodo(char d, Nodo L) {
        this.dato = d;
        this.siguiente = L;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
