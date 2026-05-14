package hot100.design;

import java.util.Scanner;

public class P_73setZero {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    int[][] matrix = new int[m][n];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            matrix[i][j] = sc.nextInt();
        }
    }
    
    setZero(matrix);
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < m; i++) {
        sb.append('[');
        for (int j = 0; j < n; j++) {
            if (j>0) {
                sb.append(' ');
            }
            sb.append(matrix[i][j]);
        }
        sb.append(']');
        sb.append('\n');
    }
    sb.append("]");
    System.out.println(sb);
}

private static void setZero(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean[][] vist = new boolean[m][n];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == 0){
                int x = 0;
                int y = 0;
                while (x<m) {
                    vist[x++][j] = true;
                }
                while (y<n) {
                    vist[i][y++] = true;
                }
            }
        }
    }
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (vist[i][j]) {
                matrix[i][j] = 0;
            }
        }
    }
    return;
}
}
