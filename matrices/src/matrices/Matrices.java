
package matrices;

import java.util.Scanner;

/**
 *
 * @author Zacarias
 */
public class Matrices {
    
    public static void main(String[] args) {
        Scanner m = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("1. Operaciones aritmeticas con Matrices");
            System.out.println("2. Rellenar datos de una Matriz");
            System.out.println("3. Validar Matriz identidad");
            System.out.println("4. Determinar Matriz Triangular Inferior");
            System.out.println("5. Escape");
            System.out.println("Usted selecciono:");
            opcion = m.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("OPERACIONES CON MATRICES");
                    int[][]M_1 = {{8,2},{9,3}};
                    int[][]M_2 = {{5,3},{6,8}};
                    int M_suma[][] = new int[2][2];
                    int[][] M_3 = {{3,2,3},{2,9,1}};                 
                    int fM_suma = M_suma.length;
                    int cM_suma = M_suma[0].length;
                    int fM_3 = M_3.length;
                    int cM_3 = M_3[0].length;
                    
                    for (int i = 0; i < M_1.length; i++) {
                        for (int j = 0; j < M_2.length; j++) {
                            M_suma[i][j] = M_1[i][j] + M_2[i][j];
                        }
                    }
                    for(int i = 0; i < M_1.length; i++) {
                        for (int j = 0; j < M_1.length; j++) {
                            System.out.print("[" + M_1[i][j] + "]");
                        }
                        if (i == 1) {
                            System.out.print("  +  ");
                        } else {
                            System.out.print("     ");
                        }
                        for (int j = 0; j < M_2.length; j++) {
                            System.out.print("[" + M_2[i][j] + "]");
                        }
                        if (i == 1) {
                            System.out.print("  =  ");
                        } else {
                            System.out.print("     ");
                        }
                        for (int j = 0; j < M_suma.length; j++) {
                            System.out.print("[" + M_suma[i][j] + "]");
                        }
                        System.out.println("\n");
                    }
                    int[][] result = new int[fM_suma][cM_3];
                    for (int i = 0; i < fM_suma; i++) {
                        for (int j = 0; j < cM_3; j++) {
                            for (int k = 0; k < cM_suma; k++) {
                                result[i][j] += M_suma[i][k] * M_3[k][j];
                            }
                        }
                    }
                    System.out.println("EL RESULTADO DE (M_1 + M_2) * M_3 ES:");
                    for (int[] fila : result) {
                        for (int columna : fila) {
                            System.out.print("[" + columna + " ]");
                        }
                        System.out.println("");
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
