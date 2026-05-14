package hot100.design;

public class P_48rotate {
public static void main(String[] args) {
    int[][] matrix = {
        {1,2,3},
        {4,5,6},
        {7,8,9}
    };
    rotate(matrix);
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (int i = 0; i < matrix.length; i++) {
        sb.append('[');
        for (int j = 0; j < matrix[0].length; j++) {
            sb.append(matrix[i][j]);
            if(j < matrix[0].length-1) sb.append(',');
        }
        sb.append(']');
    }
    sb.append(']');
    System.out.println(sb);
}
// step1.转置  step2.行反转
private static void rotate(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    //转置
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }

    //行反转
    for (int[] row : matrix) {
        for (int j = 0; j < n/2; j++) {
            int t = n-1;
            int temp = row[j];
            row[j]= row[t];
            row[t] = temp;
            t--;
        }
    }
    return;

}
}
