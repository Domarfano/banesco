
package bancozacarias;

/**
 *
 * @author Patricia Zacarias
 */
public class Nododoble {
    public cliente inf;
    public Nododoble siguiente;
    public Nododoble prev;
    
    public Nododoble (cliente inf){
        this.inf = inf;
        siguiente = null;
        prev = null;
    }
}
