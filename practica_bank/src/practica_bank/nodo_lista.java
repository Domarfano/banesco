package practica_bank;

public class nodo_lista {
    int n_taquilla, transacciones, t_clientes, tiempo;
    double montoD, montoR;
    nodo_lista siguiente;
    boolean ocupado;
    pila registro;
    nodo_cola cli_actual;

    nodo_lista(int n) {
        siguiente = null;
        registro = new pila();
        transacciones = 0;
        t_clientes = 0;
        n_taquilla = n;
        montoD = 0;
        montoR = 0;
        tiempo = 0;
        ocupado = false;
        cli_actual = null;
    }

}

class lista {
    nodo_lista L, aux;

    lista() {
        L = null;
        for (int i = 1; i <= 1; i++) {
            llenar_lista(i);
        }
    }

    public void llenar_lista(int numero) {
        nodo_lista nuevo_nodo = new nodo_lista(numero);
        nuevo_nodo.n_taquilla = numero;

        if (L == null) {
            nuevo_nodo.siguiente = nuevo_nodo;
            L = nuevo_nodo;
        } else {
            aux = L;
            while (aux.siguiente != L) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo_nodo;
            nuevo_nodo.siguiente = L;
        }
    }

    public void mostrar() {
        aux = L;
        String dato = "";
        while (aux.siguiente != L) {
            dato = dato + String.valueOf(aux.n_taquilla) + ",";
            aux = aux.siguiente;
        }
        dato = dato + String.valueOf(aux.n_taquilla) + ",";
        System.out.println(dato);
    }

    public void decrementar(cola atendidos) {
        aux = L;

        do {
            System.out.print("Taquilla - ");
            if (aux.ocupado == true) {
                aux.tiempo = aux.tiempo - 30;
                if (aux.tiempo == 0) {
                    System.out.println("Sale el cliente  " + aux.cli_actual.info.numero);
                    aux.ocupado = false;
                    nodo_pila nuevo = new nodo_pila();
                    nuevo.info = aux.cli_actual.info;
                    aux.registro.apilar(nuevo);
                    atendidos.encolar(aux.cli_actual);
                    aux.cli_actual = null;
                } else {
                    int H = aux.tiempo / 60;
                    int M = aux.tiempo % 60;
                    System.out.print("Cliente " + aux.cli_actual.info.numero + " restan " + H + ":");
                    if (M < 30) {
                        System.out.print("0");
                    }
                    System.out.println(M);
                }
            } else {
                System.out.println("DISPONIBLE");
            }
            aux = aux.siguiente;
        } while (aux != L);
    }

    public void vaciar(cola atendidos) {
        aux = L;
        do {
            if (aux.ocupado == true) {
                System.out.print("Taquilla");
                aux.tiempo = 0;
                System.out.println("Sale el cliente " + aux.cli_actual.info.numero);
                aux.ocupado = false;
                nodo_pila nuevo = new nodo_pila();
                nuevo.info = aux.cli_actual.info;
                aux.registro.apilar(nuevo);
                atendidos.encolar(aux.cli_actual);
                aux.cli_actual = null;
            }
            aux = aux.siguiente;
        } while (aux != L);
    }

    public int determinar_tiempo(int transaccion) {
        int tiempo = 0;
        switch (transaccion) {
            case 1:
                tiempo = 240;
                break;
            case 2:
                tiempo = 180;
                break;
            case 3:
                tiempo = 90;
                break;
            case 4:
                tiempo = 300;
                break;
            case 5:
                tiempo = 120;
        }
        return tiempo;
    }

    public void pasarcliente(cola espera) {
        aux = L;
        do {
            if (aux.ocupado == false) {
                if (espera.front != null) {
                    aux.cli_actual = espera.desencolar();
                    aux.tiempo = determinar_tiempo(aux.cli_actual.info.transaccion);
                    System.out.println("El cliente " + aux.cli_actual.info.numero + " pasa a la taquilla ");
                    if (aux.cli_actual.info.transaccion == 1) {
                        aux.montoR += aux.cli_actual.info.monto;
                    }
                    if (aux.cli_actual.info.transaccion == 2) {
                        aux.montoD += aux.cli_actual.info.monto;
                    }
                    aux.transacciones++;
                    aux.t_clientes++;
                    aux.ocupado = true;
                } else {
                    System.out.println("No hay clientes en espera");
                }
            }
            aux = aux.siguiente;
        } while (aux != L);
    }

    public void depurar(pilaf todas) {
        aux = L;
        do {
            pila depo = new pila();
            nodo_pila actual = new nodo_pila();
            while (aux.registro.top != null) {
                actual = aux.registro.desapilar();
                System.out.println(actual.info.nombre);
                if (actual.info.transaccion == 2) {
                    depo.apilar(actual);
                } else {
                    nodo_pilaf nuevo = new nodo_pilaf();
                    nuevo.info = actual.info;
                    nuevo.n_taquilla = aux.n_taquilla;
                    todas.apilar(nuevo);
                }
            }
            while (depo.top != null) {
                actual = depo.desapilar();
                aux.registro.apilar(actual);
            }
            aux = aux.siguiente;
        } while (aux != L);
    }
}
