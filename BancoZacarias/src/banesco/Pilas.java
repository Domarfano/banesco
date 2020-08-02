
package banesco;

import bancozacarias.cliente;

/**
 *
 * @author Zacarias
 */
public class Pilas {
    private cliente inf;
    private Pilas siguiente;
    public Pilas top = null;
    
    public Pilas(){
        inf = null;
        siguiente = null;
    }
    public void setInf(cliente inf) {
        this.inf = inf;
    }
    public cliente getInf(){
        return inf;
    }  
    public boolean estaVacia(){
        return (top == null);
    }
    public void apilar(cliente o){
        Pilas aux = new Pilas();
        aux.inf = o;
        aux.siguiente = top;
        top = aux;
        System.out.println( "AGREGADO( "+top.getInf()+" )" );
    }
    public void desapilar(){
        if(estaVacia()){
            System.out.println("NO HAY ELEMENTOS EN LA PILA");
        }else{
            System.out.println( "eliminado( "+top.getInf()+" )");
            top = top.siguiente;
        }
    }
    public void mostrarP(){
        Pilas aux;
        aux = top;
        System.out.println("ELEMENTOS:");
        while(aux != null){
            if(aux.siguiente != null){
                System.out.println(aux.inf);
            }else{
                System.out.println(aux.inf);
            }
            aux = aux.siguiente;
        }
    }
    public Object verTope(){
        if(estaVacia()){
            return null;
        }else{
            return(top.inf);
        }
    }    
    public int tam(){
        Pilas aux = top;
        int cont = 0;
        while(aux!= null){
            cont ++;
            aux = aux.siguiente;
        }
        return cont;
    }
    public Pilas get(int pos){
        Pilas aux = top;
        int cont =0;
        while(cont != pos){
            aux = aux.siguiente;
            cont ++;
        }
        return aux;
    }
    public String pres(){
        String text="";
        Pilas aux= top;
        while(aux!=null){
            text += aux.inf+"\n";
            System.out.println(text+"\n");
            aux = aux.siguiente;
        }
        return text;
    }
}
