
package bancozacarias;

/**
 *
 * @author Zacarias
 */
public class Nodo {
    public cliente inf;
    public Nodo siguiente;
    public int clave;
    
    public Nodo (cliente inf){
        this.inf = inf;
        siguiente = null;
    }
    public Nodo (cliente inf, int clave){
        this.inf = inf;
        this.clave = clave;
        siguiente = null;
    }
    public Object getInf (){
        return inf;
    }
    public void setInf (cliente inf){
        this.inf = inf;
    }
    public Nodo getSiguiente(){
        return siguiente;
    }
    public void setSiguiente (Nodo siguiente){
        this.siguiente = siguiente;
    }
}
