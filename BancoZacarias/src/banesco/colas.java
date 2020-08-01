
package banesco;

import bancozacarias.cliente;

/**
 *
 * @author Zacarias
 */
public class colas {
    public cliente inf;
    public colas siguiente;
    private colas top;
    private colas last;
    
    public colas (cliente inf){
        this.inf = inf;
        this.siguiente = null;
    }
    public colas(){
        top = last = null;
    }
    public boolean estaVacia(){
        return (this.top==null);
    }
    public void encolar(cliente in){
        colas temp = new colas(in);
        if (estaVacia()){
            top = last = temp;
        }else{
            last.siguiente = temp;
            last = temp;
        }
        System.out.println("INGRESADO:  " + last.inf);
    }
    public void desencolar(){
        if(estaVacia()){
            System.out.println("ERROR:  NO SE PUDO DESENCOLAR");
        }else{
            top = top.siguiente;  
        }
    }
    public void mostrarP(){
        colas aux = top;
        System.out.println("\n COLA: ");
        while(aux!=null){
            System.out.println(aux.inf);
            aux = aux.siguiente;
        }
    }
    public int tam(){
        colas aux = top;
        int cont = 0;
        while(aux!=null){
            cont ++;
            aux = aux.siguiente;
        }
        return cont;
    }
    public colas get(int pos){
        colas aux = top;
        int cont = 0;
        while(cont!=pos){
            aux = aux.siguiente;
            cont ++;
        }
        return aux;        
    }
    public String pres(){
       String text ="";
       colas aux = top;
       while(aux!=null){
           text += aux.inf+"\n";
           System.out.println(text+"\n");
           aux = aux.siguiente;
       }
       return text;
    }        
}
