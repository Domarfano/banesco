
package banesco;

import bancozacarias.cliente;
import bancozacarias.Nodo;

/**
 *
 * @author Patricia Zacarias
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
    public void destroy(String inf){
        Nodo aux = cabeza;
        if(cabeza.siguiente == cabeza && cabeza.inf.getFullnombres().equals(inf)){
            cabeza.siguiente = null;
            cabeza = null;
        }else{
            if(aux.inf.getFullnombres().equals(inf)){
                destroycabeza();
            }else{
                while(aux.siguiente != cabeza){
                    if(aux.siguiente.inf.getFullnombres().equals(inf)){
                        Nodo destroy = aux.siguiente;
                        aux.siguiente = aux.siguiente.siguiente;
                        destroy.siguiente = null;
                        break;
                    }
                    aux = aux.siguiente;
                }
            }
        }
    }
    public void destroycabeza(){
        if(! estaVacia()){
            Nodo aux = cabeza;
            while(aux.siguiente != cabeza){
                aux = aux.siguiente;
                cabeza = cabeza.siguiente;
                aux.siguiente = cabeza;
            }
        }
        cabeza.siguiente = null;
        cabeza = null;
    }
    public void imprimir(){
        String text = "";
        if(! estaVacia()){
            Nodo aux = cabeza;
            System.out.println(aux.getInf());
            while(aux.getSiguiente() != cabeza){
                aux = aux.getSiguiente();
                System.out.println(aux.getInf());
            }
        }
    }
    public String pres(){
        String text ="";
        if(! estaVacia()){
            Nodo aux = cabeza;
            text+= aux.inf+"\n";
            System.out.println(text+"\n");
            while(aux.siguiente != cabeza){
                aux = aux.siguiente;
                text+= aux.inf+"\n";
                System.out.println(text+"\n");
            }  
        }
        return text;
    }
    public void search(String nombre){
        if(! estaVacia()){
            Nodo aux=cabeza;
            if(aux.inf.getFullnombres().equals(nombre)){
                System.out.println("DATOS DEL ELEMENTO ENCONTRADO: "+aux.inf.getFullnombres()+"  "+aux.inf.getFullapellidos());
            }else{
                while(aux.siguiente!=cabeza){
                    if(aux.siguiente.inf.getFullnombres().equals(nombre)){
                        System.out.println("DATOS DEL ELEMENTO ENCONTRADO: "+aux.siguiente.inf.getFullnombres()+"  "+aux.siguiente.inf.getFullapellidos());
                        break;
                    }  
                    aux=aux.siguiente;
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
    public void modificar(String nombre,String Nnombre){
        if(! estaVacia()){
            Nodo aux = cabeza;
            if(aux.inf.getFullnombres().equals(nombre)){
                aux.inf.setFullnombres(Nnombre);
            }else{
                while(aux.siguiente != cabeza){
                    if(aux.siguiente.inf.getFullnombres().equals(nombre)){
                        aux.inf.setFullnombres(Nnombre);
                        break;
                    }
                    aux = aux.siguiente;
                }
            }
        }
    }
    public int tam(){
        Nodo aux = cabeza;
        int cont = 0;
        if(! estaVacia()){
            cont ++;
            while(aux.siguiente !=  cabeza){
                cont ++;
                aux = aux.siguiente;
            }  
        }
        return cont;
    }
    public Nodo get(int pos){
        Nodo aux = cabeza;
        int cont = 0;
        while(cont != pos){
            aux = aux.getSiguiente();
            cont ++;
        }
        return aux;
    }        
}
