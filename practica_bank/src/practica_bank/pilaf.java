package practica_bank;

public class pilaf {
    public nodo_pilaf top;
    
    public pilaf() {
        top = null;
    }

    void apilar(nodo_pilaf nuevo) {
        if (top == null) {
            top = nuevo;
        } else {
            nuevo.siguiente = top;
            top = nuevo;
        }

    }

    public nodo_pilaf desapilar() {
        nodo_pilaf saliente = new nodo_pilaf();
        if (top == null) {
            saliente = null;
        } else {
            saliente = top;
            top = top.siguiente;
        }
        return saliente;
    }
}
