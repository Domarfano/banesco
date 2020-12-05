package practica_bank;
import java.io.*;

public class archivo {
    File archi, archi2;
    String Nombre, Nombre2;
    BufferedWriter bx, bx2;
    PrintWriter h, h2;

    BufferedReader Entrada;
    PrintWriter pf;

    public archivo() throws IOException {
        Nombre = "C:\\Users\\Zacarias\\Documents\\NetBeansProjects\\practica_bank/Taquilla.log";
        archi = new File(Nombre);
        bx = new BufferedWriter(new FileWriter(archi));
        h = new PrintWriter(bx);
        
        Nombre2 = "C:\\Users\\Zacarias\\Documents\\NetBeansProjects\\practica_bank/Clientes-pendientes.in.log";
        archi2 = new File(Nombre2);
        bx2 = new BufferedWriter(new FileWriter(archi2));
        h2 = new PrintWriter(bx2);
    }
    


    public void cerrar() throws IOException {
        h.close();
        bx.close();
        h2.close();
        bx2.close();
    }

    String tipo(int valor) {
        String t = "";
        switch (valor) {
            case 1:
                t = "Retiro";
                break;
            case 2:
                t = "Deposito";
                break;
            case 3:
                t = "Consulta";
                break;
            case 4:
                t = "Actualizacion";
                break;
            case 5:
                t = "Pago";
        }
        return t;
    }

    void escribir_taquillas(lista banco) {
        h.println(" TAQUILLA DEL BANCO ");
        banco.aux = banco.L;
        nodo_pila x = new nodo_pila();
        do {
            h.println("Taquilla");
            h.println("   Transacciones: " + banco.aux.transacciones);
            h.println("   Total depositos: " + banco.aux.montoD);
            h.println("   Total retiros: " + banco.aux.montoR);
            h.println("   Total clientes: " + banco.aux.t_clientes);

            if (banco.aux.registro.top != null) {
                h.println("   DEPOSITOS");
            }
            while (banco.aux.registro.top != null) {
                x = banco.aux.registro.desapilar();
                h.println("    - " + x.info.nombre + ": " + tipo(x.info.transaccion) + "(Bs. " + x.info.monto + ")");
            }
            h.println("");
            h.println("");
            banco.aux = banco.aux.siguiente;
        } while (banco.aux != banco.L);
    }

    void escribir_cola(cola col) {
        nodo_cola x = new nodo_cola();
        h.println("");
        h.println("");
        while (col.front != null) {
            
            h.println(" CLIENTES ATENDIDOS ");
            h.println("");
            
            x = col.desencolar();
            h.print("- " + x.info.nombre + ": " + tipo(x.info.transaccion) + "(Bs. " + x.info.monto);
            int H = x.info.tiempo / 60;
            int M = x.info.tiempo % 60;
            if (M < 30) {
                h.println("). Tiempo espera: " + H + ":0" + M);
            } else {
                h.println("). Tiempo espera: " + H + ":" + M);
            }
        }
    }

    void escribir_pila(pilaf pil) {
        nodo_pilaf x = new nodo_pilaf();
        h.println("");
        h.println("");
  
        while (pil.top != null) {
            
            h.println(" TRANSACCIONES ");
            h.println("");
           
            x = pil.desapilar();
            h.print("- " + x.info.nombre + ": " + tipo(x.info.transaccion) + "(Bs. " + x.info.monto + ")");
        }
    }
}
