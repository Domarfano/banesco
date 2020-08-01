
package banesco;

import bancozacarias.cliente;
import bancozacarias.Nodo;

/**
 *
 * @author Zacarias
 */
public class listCirc {
    private Nodo cabeza;
    
    public listCirc(){
        this.cabeza = null;
    }
    public boolean estaVacia(){
        if(cabeza == null){
            return true;
        }else{
            return false;
        }
    }
    public void insertElem(cliente inf){
        Nodo n = new Nodo(inf);
        if(estaVacia()){
            cabeza = n;
            cabeza.siguiente = cabeza;
        }else{
            n.siguiente = cabeza.siguiente;
            cabeza.siguiente = n;
        }
    }
    
    
    
    
    
}
