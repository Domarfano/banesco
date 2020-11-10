
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
        int M_1[][] = new int [4][4];
        int M_2[][] = new int [4][4];
        int M_1M_2 [][] = new int [4][4];
        int M_3 [][] = new int[][];
        
        for (int i = 0; i < M_1.length; i++) {
            for (int j = 0; j < M_1.length; j++) {
                M_1[i][j] = (int)(Math.random()*6);
            }            
        }
        for (int i = 0; i < M_2.length; i++) {
            for (int j = 0; j < M_2.length; j++) {
                M_2[i][j] = (int)(Math.random()*6);
            }            
        }
        for (int i = 0; i < M_1.length; i++) {
            for (int j = 0; j < M_2.length; j++) {
                M_1M_2[i][j] = M_1[i][j] + M_2[i][j];            
            }
        }
    }
}
