package hot100.design;

public class P_240searchMatrix {
    public static void main(String[] args) {
     int[][]  matrix = {
        {1,4,7,11,15},
        {2,5,8,12,19},
        {3,6,9,16,22},
        {10,13,14,17,24},
        {18,21,23,26,30}
     };
     int target = 5;
    boolean ans = searchMatrix(matrix, target);
     System.out.println(ans);
    }

    // 数学问题  一直找右上角 大于右上角 一行排除 小于右上角 一列排除
    private static boolean searchMatrix(int[][] matrix, int target) {
        int  i = 0;
        int j = matrix[0].length-1;
        while (i<matrix.length && j>=0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
    
}
