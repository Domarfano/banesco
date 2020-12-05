/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_bank;
import java.io.*;
import java.util.*;

/**
 *
 * @author Zacarias
 */
public class nodo_cola {
    cliente info;
    public nodo_cola siguiente,anterior; 
   
    nodo_cola (cliente c){
        siguiente=null;
        anterior=null;
        info= c;
    }

    public nodo_cola (){
        siguiente = null;
        anterior = null;
        info = new cliente();
    }
}

class cliente{
    String green = "\033[32m";
    String yellow = "\033[33m";
    String blue = "\033[34m";
    String white = "\033[37m";
    String red = "\033[31m";
    String nombre;
    int numero, tiempo, transaccion;
    double monto;

    cliente (){
        tiempo=0;
    }
    
    public void llenar (int num) throws IOException{
       
        String nombreFile = "C:\\Users\\Zacarias\\Documents\\NetBeansProjects\\practica_bank/Clientesin.txt";
        BufferedReader br = null;
        File f = new File ("C:\\Users\\Zacarias\\Documents\\NetBeansProjects\\practica_bank/operaciones.txt");
        int o = 0;
        try (Scanner oper = new Scanner(f)) {
           
            br = new BufferedReader(new FileReader(nombreFile));
            String texto = br.readLine();
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader entrada = new BufferedReader(is);            
            numero = num;
  
            while (texto != null) {
                System.out.println("\n"+yellow+"CLIENTE NUMERO #" + numero);
                System.out.println(yellow+"Nombre: " +texto);
                System.out.println(yellow+"Cedula: " +br.readLine());
                nombre = texto.concat(texto);
                System.out.println("\n"+white+"---- MENU DE TRANSACCION ----");
                System.out.println(white+"    1. Retiro        (4 min.)");
                System.out.println(white+"    2. Deposito      (3 min.)");
                System.out.println(white+"    3. Consulta      (1.5 min.)");
                System.out.println(white+"    4. Actualizacion (5 min.)");
                System.out.println(white+"    5. Pago          (2 min.)");
                texto = br.readLine();
                numero++;
                do {
                    System.out.println("\n"+white+"Seleccione la operacion a realizar: ");
                    o = oper.nextInt();
                    System.out.println(white+"Usted selecciono --> " +o);
                    transaccion = o;
                    if(transaccion == 1){
                        System.out.println(white+"Se realizara un Retiro (4 min)");
                    }else{
                        if(transaccion == 2){
                            System.out.println(white+"Se realizara un Deposito (3 min)");
                        }else{
                            if(transaccion ==3){
                                System.out.println(white+"Se realizara una Consulta (1.5 min");
                            }else{
                                if (transaccion == 4) {
                                    System.out.println(white+"Se realizara una Actualizacion (5min");
                                }else{
                                    if (transaccion == 5) {
                                        System.out.println(white+"Se realizara un pago (2 min");
                                    }else{
                                        System.out.println("");
                                    }
                                }
                            }
                        }
                    }if ((transaccion < 1 || transaccion > 5 )){
                        System.err.println("Ingrese un digito valido");
                    }
                } while ((transaccion < 1) || (transaccion > 5));               
                System.out.println("\n"+white+"Indique el monto de la transaccion:");
                System.out.println(white+"¡¡¡¡ RECORDAR !!!!");
                System.out.println(white+"El limite de transacciones del banco Banesco es de:");
                System.out.println(white+"200000000 (Doscientos Millones de Bolivares Soberanos)");
                do {
                    monto = Math.random()*100+1;
                    System.out.println(white+"El monto es de Bs. "+yellow+""+monto);
                    
                } while (monto <= 0);
                tiempo = 0;        
            }
        }catch(FileNotFoundException e){
            System.out.println("Error: Fichero no encontrado");
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println("Error: No se pudo leer el Fichero");
            System.out.println(e.getMessage());
        }finally{
            try{
                if(br != null)
                    br.close();
            }catch(IOException e){
                System.out.println("Error: No se pudo cerrar el Fichero");
                System.out.println(e.getMessage());
            }
        }
        
      
    }
   
}
