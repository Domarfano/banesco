
package banesco;

import bancozacarias.cliente;
import bancozacarias.Nododoble;

/**
 *
 * @author Patricia Zacarias
 */
public class lista2ble {
    private Nododoble cabeza;
    private Nododoble aux;
    
    public lista2ble(){
        cabeza = null;        
    }
    public boolean estaVacia(){
        return(this.cabeza==null);
    }
    public void insertCabeza(cliente inf){
        Nododoble n = new Nododoble(inf);
        if(estaVacia()){
            cabeza = n;
        }
    }
    public void insertIni(cliente inf){
        Nododoble n = new Nododoble(inf);
        if(! estaVacia()){
            n.siguiente = cabeza;
            cabeza.prev = n;
            cabeza = n;
        }        
    }
    public void insertFin(cliente inf){
        Nododoble n = new Nododoble(inf);
        Nododoble aux = cabeza;
        if(estaVacia()){
            insertCabeza(inf);
        }else{
            while(aux.siguiente != null){
                aux = aux.siguiente;                
            }
            aux.siguiente = n;
            aux.prev = aux;
        }
    }
    public void insertPos(cliente inf, int pos){
        Nododoble n = new Nododoble(inf);
        if(pos == 0){
            if(cabeza == null){
                insertCabeza(inf);
            }
            else{
                insertIni(inf);
            }           
        }else{
            if(pos == tam()){
                insertFin(inf);
            }else{
                if(pos > 0 && pos < tam()){
                    Nododoble aux = cabeza;
                    int recorrido = 1;
                    while(recorrido != pos){
                        aux = aux.siguiente;
                        recorrido ++;
                    }
                    n.siguiente = aux.siguiente;
                    aux.siguiente.prev = n;
                    aux.siguiente = n;
                    n.prev = aux;
                }
            }
        }
    }
    public void destroyIni(){
        if(! estaVacia()){
            if(cabeza.siguiente != null){
                cabeza = cabeza.siguiente;
                cabeza.prev = null;
            }
        }
    }
    public void destroyFin(){
        Nododoble aux = cabeza;
        while(aux.siguiente.siguiente != null){
            aux = aux.siguiente;
        }
        aux.siguiente = null;
    }
    public void destroy(int pos){
        Nododoble aux = cabeza;
        int posicion = 1;
        if(! estaVacia()){
            if(pos == 1){
                destroyIni();
            }else{
                if(pos == tam()){
                    destroyFin();
                }else{
                    if(pos > 0 && pos < tam()){
                        while(posicion != pos){
                            aux = aux.siguiente;
                            posicion ++;
                        }
                        aux.prev.siguiente = aux.siguiente;
                        aux.siguiente.prev = aux.prev;
                        aux.siguiente = null;
                        aux.prev = null;
                    }
                }
            }
        }
    }
    public int tam(){
        int cont = 0;
        Nododoble aux = cabeza;
        if(! estaVacia()){
            while(aux != null){
                aux = aux.siguiente;
                cont ++;
            }
        }
            return cont;
    }
    public Nododoble search(String ced){
        Nododoble aux = cabeza;
        if(! estaVacia()){
            if(aux.inf.getCedula().equals(ced)){
                return aux;
            }while(aux.siguiente != null){
                if(aux.siguiente.inf.getCedula().equals(ced)){
                    return aux.siguiente;
                }
                aux = aux.siguiente;
            }
        }
        return null;
    }   
    public Nododoble get(int pos){
        Nododoble aux = cabeza;
        int cont = 0;
        while(cont != pos){
            aux = aux.siguiente;
            cont ++;
        }
        return aux;
    }
    public void modificar(String ced, cliente infModificar){
        Nododoble aux = search(ced);
        if(aux != null){
            aux.inf = infModificar;
        }
    }
    public void mostrarP(){
        Nododoble aux = cabeza;
        if(! estaVacia()){
            while(aux != null){
                System.out.println("["+aux.inf+"]");
                aux = aux.siguiente;
            }
        }else{
            System.out.println("LA LISTA ESTA VACIA");
        }
    }
    public String read(){
        String a ="";
        Nododoble aux1 = cabeza;
        if(! estaVacia()){
            while(aux1 != null){
                a = a+ ("["+aux1.inf+"]" +"\n");
            }
        }else{
            System.out.println("LA LISTA ESTA VACIA");
        }
        return a;
    }
}
