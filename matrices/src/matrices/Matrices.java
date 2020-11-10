
package matrices;

import java.util.Scanner;

/**
 *
 * @author Zacarias
 */
public class Matrices {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner m= new Scanner(System.in);
        boolean salir = false;
        int opcion;
        
        while(!salir){
            System.out.println("1. Operaciones aritmeticas con Matrices");
            System.out.println("2. Rellenar datos de una Matriz");
            System.out.println("3. Validar Matriz identidad");
            System.out.println("4. Determinar Matriz Triangular Inferior");
            System.out.println("5. Escape");
            System.out.println("Usted selecciono:");
            opcion = m.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("OPERACIONES CON MATRICES");
                    int M_1[][] = new int[2][3];
                    int M_2[][] = new int[2][3];
                    int M_1M_2[][] = new int[2][3];
                    int M_3[][] = new int[3][2];
                    int M_result[][]= new int[2][2];

                    for (int i = 0; i < M_1.length; i++) {
                        for (int j = 0; j < M_1.length; j++) {
                            M_1[i][j] = (int) (Math.random() * 6);
                        }
                    }
                    for (int i = 0; i < M_2.length; i++) {
                        for (int j = 0; j < M_2.length; j++) {
                            M_2[i][j] = (int) (Math.random() * 6);
                        }
                    }
                    for (int i = 0; i < M_1.length; i++) {
                        for (int j = 0; j < M_2.length; j++) {
                            M_1M_2[i][j] = M_1[i][j] + M_2[i][j];
                        }
                    }
                    for (int i = 0; i < M_1.length; i++) {
                        for (int j = 0; j < M_1.length; j++) {
                            System.out.print("[" + M_1[i][j] + "]");
                        }
                        if (i == 2) {
                            System.out.print("  +  ");
                        } else {
                            System.out.print("     ");
                        }
                        for (int j = 0; j < M_2.length; j++) {
                            System.out.print("[" + M_2[i][j] + "]");
                        }
                        if (i == 2) {
                            System.out.print("  =  ");
                        } else {
                            System.out.print("     ");
                        }
                        for (int j = 0; j < M_1M_2.length; j++) {
                            System.out.print("[" + M_1M_2[i][j] + "]");
                        }
                        System.out.println("");
                    }
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 2; j++) {
                            M_3[i][j] = (int)(Math.random()*6);
                        }                        
                    }

                    System.out.println("\n");
                    break;
                case 2:
                    System.out.println("RELLENAR UNA MATRIZ");;
                    break;
                case 3:
                    System.out.println("VALIDAR MATRIZ");;
                    break;
                case 4:
                    System.out.println("IDENTIFICAR MATRIZ");;
                    break;
                case 5:
                    System.out.println("BYE BYE");
                    salir = true;
                    break;
                default:
                    System.out.println("");
                    System.out.println("¡¡¡ ERROR !!! ");
                    System.out.println("ELIJA SABIAMENTE ENTRE LAS OPCIONES");
                    System.out.println("SOLO PUEDE INGRESAR UN NUMEO DEL MENU");
                    System.out.println("\n");
            }
        }
    }
}
