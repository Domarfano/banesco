/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_bank;

/**
 *
 * @author Zacarias
 */
public class cola {  
    nodo_cola front, ultimo;
    int nro;

    cola() {
        front = null;
        ultimo = null;
        nro = 0;
    }

    void encolar(nodo_cola nuevo) {
        if (ultimo != null) {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        } else {
            front = nuevo;
            ultimo = nuevo;
        }
    }

    nodo_cola desencolar() {
        nodo_cola sal = new nodo_cola();
        if (front == null) {
            sal = null;
        } else {
            sal = front;
            front = front.siguiente;
            if (front != null) {
                front.anterior = null;
            } else {
                ultimo = null;
            }
            sal.siguiente = null;
        }
        return sal;
    }

    public void incrementar() {
        nodo_cola aux = front;
        while (aux != null) {
            aux.info.tiempo += 30;
            aux = aux.siguiente;
        }
    }

    int proximo() {
        nro++;
        return nro;
    }

    int cantidad() {
        int c = 0;
        nodo_cola aux = front;
        while (aux != null) {
            c++;
            aux = aux.siguiente;
        }
        return c;
    }

}
