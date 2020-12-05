package practica_bank;

public class reloj {
     public int T;
    
    reloj(){
        T=0;
    }
    
    public void aumentar(lista banco, cola espera, cola atendido){
       int H,M; 
       T=T+30;
       H=T/60;
       M=T%60;
       if (M>0)
           System.out.println("Han transcurrido "+H+":"+M+" Minutos");
       else
           System.out.println("Han transcurrido "+H+":0"+M+" Minutos");
    
       banco.decrementar(atendido);
       espera.incrementar();
       banco.pasarcliente(espera);
    }
}
