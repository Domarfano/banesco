
package practica_bank;
import java.io.*;

public class Practica_bank {

    public static void main(String[] args) throws IOException {
        String green = "\033[32m";
        String yellow = "\033[33m";
        String blue = "\033[34m";
        String white = "\033[37m";
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader entrada = new BufferedReader(is);
        lista banco= new lista();
        cola espera,atendido;
        espera=new cola();
        atendido=new cola();
        pilaf todas=new pilaf();
        reloj R= new reloj();
        int resp;
        System.out.println(green+"-----------------------------------");
        System.out.println(green+"---"+white+" BIENVENIDO AL BANCO BANESCO "+green+"---");
        System.out.println(yellow+     "Se ha aperturado el banco");
        do
        {
            System.out.println("¿Han llegado nuevos clientes?"+green+" 1 = Si / 2 = Avanzar 30 Seg.");
            do{
                resp = Integer.parseInt(entrada.readLine());
            }while((resp!=1)&&(resp!=2));
            
           
            if (resp==1){
                do
                {
                    cliente cli = new cliente();
                    cli.llenar(espera.proximo());
                    espera.encolar(new nodo_cola(cli));
                    System.out.println(white+"Hay "+ (espera.cantidad()) + " clientes en cola");
                    System.out.println(white+"¿Han llegado nuevos clientes? "+green+" 1 = Si /2=Avanzar 30 Seg.");
                    do{
                        resp = Integer.parseInt(entrada.readLine());
                    }while((resp!=1)&&(resp!=2));
                }while (resp==1);
                
            }
         
            R.aumentar(banco,espera,atendido);

            System.out.println(green+"¿Desea cerrar el banco? 1 = Si / 2 = No");
            do{
                resp = Integer.parseInt(entrada.readLine());
            }while((resp!=1)&&(resp!=2));
            
            if (resp==1){
                //"C:\\Users\\Zacarias\\Documents\\NetBeansProjects\\practica_bank/Clientes-pendientes.in.txt"
                File ClientesP = new File ("C:\\Users\\Usuarios\\Documents\\NetBeansProjects\\practica_bank/Clientes-pendientes.in.txt");
                System.out.println(yellow+"Clientes que quedaron en cola ");
                nodo_cola x = new nodo_cola();
                while (espera.front!=null){
                    x = espera.desencolar();
                    System.out.print("    - " + x.info.nombre);
                }

                banco.vaciar(atendido);
                banco.depurar(todas);
                archivo ax = new archivo();
                ax.escribir_taquillas(banco);
                ax.escribir_pila(todas);
                ax.escribir_cola(atendido);          
                ax.cerrar();
                break;
            }
            
        }while(true);
    }
    
}
