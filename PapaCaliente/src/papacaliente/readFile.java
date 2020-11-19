/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papacaliente;

import java.io.*;

/**
 *
 * @author Zacarias
 */
public class readFile {
    public void write() throws IOException{
        FileWriter file = null;
        PrintWriter pw = null;
        try{
            file = new FileWriter("C:/Users/Zacarias/Desktop/Proyecto/jugadoresin.txt");
            pw = new PrintWriter(file);
            
            pw.println("Andrea");
            pw.println("Ana");
            pw.println("Patricia");
            pw.println("Marco");
            pw.println("Luis");
            pw.println("Rafael");
            


        }catch(IOException e){
            System.err.println("Ha ocurrido un error al escribir");
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e2) {
                System.err.println("Ha ocurrido un error: "+e2);
            }
        }    
    }
    
    
    
    public void read() throws FileNotFoundException {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try{             //(FileReader input = new FileReader("C:/Users/Zacarias/Desktop/Proyecto/jugadoresin.txt")) {
            archivo = new File("C:/Users/Zacarias/Desktop/Proyecto/jugadoresin.txt") ;
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            String linea;
            while((linea = br.readLine())!= null)
                System.out.println(linea);
        }catch(IOException ex){
            System.err.println("Ha ocurrido un error:  "+ex);
        }finally{
            try{
                if (fr != null) {
                    fr.close();
                }
            }catch(IOException ex2){
                System.err.println("Ha ocurrido un error: "+ex2);
            }
        }
    }
     
}
