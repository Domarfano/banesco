
package matrices;

import java.util.Scanner;

/**
 *
 * @author Zacarias
 */
public class Matrices {
    public static Scanner t = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner m = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("TRABAJAREMOS CON MATRICES");
            System.out.println("¿QUE QUIERES HACER?");
            System.out.println("1. OPERACIONES ARITMETICA CON MATRICES");
            System.out.println("2. VALIDAR MATRIZ IDENTIDAD");
            System.out.println("3. DETERMINAR SI HAY UNA MATRIZ TRIANGULAR INFERIOR");
            System.out.println("4. NO HACER NADA");
            System.out.println("");
            System.out.println("USTED SELECCIONO:");
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
                    System.out.println("VALIDAR MATRIZ IDENTIDAD 4X4");
                    System.out.println("INGRESE DATOS");
                    
                    int mt[][] = new int[4][4];
                    
                    ingreso(mt);
                    
                    System.out.println("LA MATRIZ 4x4 ES:");
                    
                    mz(mt);
                    
                    System.out.println("VALIDANDO");
                    validar(mt);
                    break;
                case 3:
                    System.out.println("IDENTIFICAR MATRIZ TRIANGULAR INFERIOR");
                    mzTrian();
                    break;
                case 4:
                    System.out.println("BYE BYE");
                    salir = true;
                    break;
                default:
                    System.out.println("");
                    System.out.println("¡¡¡ ERROR !!! ");
                    System.out.println("ELIJA SABIAMENTE ENTRE LAS OPCIONES");
                    System.out.println("SOLO PUEDE INGRESAR UN NUMERO DEL MENU");
                    System.out.println("\n");
            }
        }
    }
    public static void ingreso(int[][]mt){
        for (int i = 0; i < mt.length; i++) {
            for (int j = 0; j < mt.length; j++) {
                mt[i][j] = t.nextInt();
            }
        }
        System.out.println("");
    }
    public static void mz(int[][]mt){
        for (int i = 0; i < mt.length; i++) {
            for (int j = 0; j < mt.length; j++) {
                System.out.print(mt[i][j]+ "  ");
            }
            System.out.println();
        }
        System.out.println("");
    }
    public static void validar(int[][]mt){
        if(mt[0][0]==1 && mt[1][1]==1 && mt[2][2]==1 && mt[3][3]==1) {
            if(mt[0][1]==0 && mt[0][2]==0 && mt[0][3]==0) {                
                if(mt[1][0]==0 && mt[1][2]==0 && mt[1][3]==0){
                    if(mt[2][0]==0 && mt[2][1]==0 && mt[2][3]==0){
                        if(mt[3][0]==0 && mt[3][1]==0 && mt[3][2]==0){
                        }else{
                            System.out.println("UNO DE LOS DATOS NO ES CERO");
                        }
                    }else{
                        System.out.println("UPS... NO ES IDENTIDAD");
                    }
                }else{
                    System.out.println("QUE TRISTE..");
                    System.out.println("LA MATRIZ NO TIENE IDENTIDAD...");
                }
            }else{
                System.out.println("LO SIENTO PERO NO ES IDENTIDAD");
            }
            System.out.println("¡¡¡ LO LOGRAMOS !!!");
            System.out.println("ES IDENTIDAD");
            System.out.println("\n");
        }else{                
            System.out.println("NO ES IDENTIDAD");
        }
    }
    public static void mzTrian(){
        int tm = 0;
        int sm = 0;
        
        System.out.println("INGRESE LAS DIMENSIONES DE LA MATRIZ: ");
        tm = t.nextInt();
        int mz[][] = new int[tm][tm];
       
        System.out.println("INGRESE LOS DATOS DE LA MATRIZ: ");
        for (int i = 0; i < tm; i++) {
            for (int j = 0; j < tm; j++) {
                System.out.println("Columa ("+ (i + 1)+") Fila ("+ (j + 1)+")");
                mz[i][j] = t.nextInt();
            }
            System.out.println("");
        }
        for (int i = 0; i < mz.length; i++) {
            for (int j = 0; j < mz.length; j++) {
                System.out.print(mz[i][j] + "  ");
            }
            System.out.println();
        }
        for (int j = 1; j < tm; j++) {
            for (int i = 0; i < tm; i++) {
                if (i < j) {
                    sm += mz[i][j];
                }
            }
        }
        if (sm == 0) {
            System.out.println("");
            System.out.println("¡¡¡VAYA SUERTE!!!");
            System.out.println("ES UNA MATRIZ TRIANGULAR INFERIOR");
        }else{
            System.out.println("EL SR. MURPHY DICE QUE PARA LA PROXIMA");
            System.out.println("NO ES UNA MATRIZ TRIANGULAR INFERIOR");
        }
        System.out.println("");
    }   
}
