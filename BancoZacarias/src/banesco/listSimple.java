
package banesco;

import bancozacarias.cliente;
import bancozacarias.Nodo;

/**
 *
 * @author Zacarias
 */
public class listSimple {
    private Nodo nodo;
    
    public listSimple(){
        this.nodo = null;
    }
    public boolean estaVacia(){
        if(nodo == null){
            return true;
        }else{
            return false;
        }
    }
    public void insert(cliente inf){
        Nodo n = new Nodo(inf);
        if(estaVacia()){
            nodo = n;
        }else{
            Nodo aux = nodo;
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(n);
        }
    }
    public void insertIni(cliente inf){
        if(! estaVacia()){
            Nodo n = new Nodo(inf);
            n.setSiguiente(nodo);
            nodo = n;
        }
    }
    public void destroyList(){
        if(! estaVacia()){
            nodo.setSiguiente(null);
            nodo = null;
        }
    }
    public String pres(){
        String text ="";
        Nodo aux = nodo;
        while(aux != null){
            text += aux.getInf()+"\n";
            System.out.println(text+"\n");
            aux = aux.getSiguiente();
        }
        return text;
    }
    public void showpt(){
        Nodo aux = nodo;
        while(aux != null){
            System.out.println(aux.getInf());
            aux = aux.getSiguiente();
        } 
    }
        public void destroyIni(){
        if(! estaVacia()){
            nodo = nodo.getSiguiente();
        }
    }
    public void insertFin(cliente inf){
        if(! estaVacia()){
            Nodo n = new Nodo(inf);
            Nodo aux = nodo;
            while(aux.getSiguiente()!= null){
                aux=aux.getSiguiente();
            }
            aux.setSiguiente(n);
            n.setSiguiente(null);
        }
    }
    public void destroyFin(){
        if(! estaVacia()){
            Nodo aux = nodo;
            while(aux.getSiguiente().getSiguiente()!=null){
                aux=aux.getSiguiente();
            }
            aux.setSiguiente(null);
        }
    }
    public int tam(){
        Nodo aux = nodo;
        int cont =  0;
        if(! estaVacia()){
            cont ++;
            while(aux.siguiente != null){
                cont ++;
                aux = aux.siguiente;
            }
        }
        return cont;
    }
    public void insertBetNodos(cliente inf,int posicion){
        if(! estaVacia()){
            Nodo n = new Nodo(inf);
            Nodo aux = nodo;
            Nodo aux2 = aux;
            int pos_recorrido = 0;
            if(posicion == 0){
                insertIni(inf);
            }if(posicion == tam()){
                insertFin(inf);
            }if(posicion > 0 && posicion < tam()){
                while(pos_recorrido != posicion ){
                aux2 = aux;
                aux = aux.getSiguiente();    
                pos_recorrido ++;
                }
                n.setSiguiente(aux);
                aux2.setSiguiente(n);
            }
        }
    }
    public void destroyBetNodos(int posicion){
        if(! estaVacia()){
            Nodo aux = nodo;
            Nodo aux2 = aux;
            int pos_recorrido = 0;
            if(posicion == 0){
                destroyIni();
            }else{
                if(posicion == tam()){
                    destroyFin();
                }else{
                    if(posicion > 0 && posicion < tam()){
                        while(pos_recorrido != posicion){
                            aux2 = aux;
                            aux = aux.getSiguiente();
                            pos_recorrido ++;
                        }
                        aux2.setSiguiente(aux.getSiguiente());
                    }
                }
            }
        }
    }
        public void search(int posicion){
        Nodo aux = nodo;
        int recorrido = 0;
        if(! estaVacia()){
            if(posicion == 0){
                System.out.println("EL VALOR DE LA POSICION ES "+ posicion +" yYLOS DATOS SON:: "+ aux.inf);
            }else{
                if (posicion == tam()){
                    while (aux != null){                        
                        aux = aux.siguiente;
                    }
                    System.out.println("EL VALOR DE LA POSICION " + posicion + " ES:" + aux.inf);
                }else{
                    if(posicion > 0 & posicion < tam()) {
                        while(recorrido != (posicion - 1)){
                            aux = aux.getSiguiente();
                            recorrido++;
                        }
                        System.out.println("EL VALOR DE LA POSICION " + posicion + " ES:" + aux.siguiente.inf);
                        aux.siguiente = aux.siguiente.siguiente;
                    }
                }
            }
        }   
    }
    public Nodo searchNodoIndice(int indice){
        Nodo aux = nodo;
	int tamano = 0;
	while(aux!= null){
            if(tamano==indice){
                return aux;
            }
            aux = aux.siguiente;
	    tamano ++;
	}
        return null;
    }
    public Nodo get(int pos){
        Nodo aux = nodo;
        int cont = 0;
        while(cont != pos){
            aux = aux.getSiguiente();
            cont ++;
        }
        return aux;
    }
    public void modificar(int posicion, cliente nInf){
        if(! estaVacia()){
            Nodo aux=nodo;
            int pos_recorrido = 0;
            while(pos_recorrido != posicion){
                aux = aux.siguiente;
                pos_recorrido ++;
            }
            aux.inf = nInf;
        }
    }   
}