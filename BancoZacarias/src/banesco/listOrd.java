
package banesco;

import bancozacarias.cliente;
import bancozacarias.Nodo;

/**
 *
 * @author Patricia Zacarias
 */
public class listOrd {
    private Nodo cabeza;
    private Nodo aux;
    
    public boolean estaVacia(){
        return(this.cabeza == null);
    }
    public int tam(){
        int cont = 0;
        if(! estaVacia()){
            aux = cabeza;
        }while(aux != null){
            aux = aux.siguiente;
            cont ++;
        }
        return cont;
    }
    public String mostrarP(){
        String a="";
        Nodo aux1 = cabeza;
        if(! estaVacia()){
            while(aux1 != null){
                a = a+aux1.clave + "["+aux1.inf+"]" +"\n" ;
                aux1 = aux1.siguiente;
            }
        }else{
            System.out.println("LA LISTA ESTA VACIA");
        }
        return a;
    }
    public void insertIni(cliente inf, int clave){
        Nodo n = new Nodo(inf,clave);
        if(estaVacia()){
            cabeza=n;
        }else{
            if(clave < cabeza.clave){
                n.siguiente = cabeza;
                cabeza = n;
            }else{
                Nodo aux = cabeza;
                Nodo prev = cabeza;
                while(clave > aux.clave && aux.siguiente == null){
                    prev = aux;
                    aux = aux.siguiente;
                }
                if(clave > aux.clave && aux.siguiente == null){
                    aux.siguiente = n;
                }else{
                    if(clave != aux.clave){
                        n.siguiente = aux;
                        prev.siguiente = n;
                    }
                }
            }
        }
    }
    public void destroyList(){
        if(! estaVacia()){
            cabeza.siguiente = null;
            cabeza = null;
        }
    }
    public void destroyIni(){
        if(! estaVacia()){
            if(cabeza.siguiente != null){
                cabeza = cabeza.siguiente;
            }
        }
    }
    public void destroyFin(){
        Nodo aux = cabeza;
        while(aux.siguiente.siguiente != null){
            aux = aux.siguiente;
        }
    }
    public void destroyNodoClave(int clave){
        Nodo aux = cabeza;
        if(! estaVacia()){
            if(aux.siguiente == null && cabeza.clave == clave){
                destroyList();
            }else{
                if(aux.clave == clave){
                    destroyIni();
                }else{
                    while(aux.siguiente != null){
                        if(aux.siguiente.clave == clave){
                            Nodo destroy = aux.siguiente;
                            aux.siguiente = aux.siguiente.siguiente;
                            destroy.siguiente = null;
                            break;                            
                        }
                        aux = aux.siguiente;
                    }
                }
            }
        }else{
            System.out.println("LISTA VACIA: NO SE PUEDE ELIMINAR");
        }     
    }
    public Nodo search(int clave){
        Nodo aux = cabeza;
        if(! estaVacia()){
           if(aux.clave == clave){
               return aux;
           } while(aux.siguiente != null){
               if(aux.siguiente.clave == clave){
                   return aux.siguiente;
               }
               aux = aux.siguiente;
           }
        }
        return null;   
    }
    public Nodo get(int pos){
        Nodo aux = cabeza;
        int cont = 0;
        while(cont != pos){
            aux = aux.siguiente;
            cont ++;
        }
        return aux;
    }
    public void modificar(int clave, cliente infModificar){
        Nodo aux = search(clave);
        if(aux != null){
            aux.inf = infModificar;
        }   
    }
    public Nodo searchInf(String ced){
        Nodo aux = cabeza;
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
}
