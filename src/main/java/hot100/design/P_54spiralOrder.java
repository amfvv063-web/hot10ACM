package hot100.design;

import java.util.ArrayList;
import java.util.List;

public class P_54spiralOrder {
    private static final int[][] DIRS = {{0,1}, {1, 0},{0, -1}, {-1,0}};
public static void main(String[] args) {
    int[][] matrix = {
        {1,2,3},
        {4,5,6},
        {7,8,9}
    };
    List<Integer> ans = spiralOrder(matrix);
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (int i = 0; i < ans.size(); i++) {
        sb.append(ans.get(i));
        if (i<ans.size()-1) {
            sb.append(',');
        }
    }
    sb.append(']');
    System.out.println(sb);
}

// 类似于DFS标记法 di是方向标记，出界或者已访问就右转
private static List<Integer> spiralOrder(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int size = m*n;
    List<Integer> ans = new ArrayList<>(size);
    int i = 0, j = 0;
    int di = 0;
    for (int k = 0; k < size; k++) {
        ans.add(matrix[i][j]);
        matrix[i][j] = -1;
        int x = i +DIRS[di][0];
        int y = j + DIRS[di][1];
        //先拿到下一步 判断是否需要转向
        if (x<0||x>=m||y<0||y>=n||matrix[x][y] == -1) {
            di = (di+1)%4;
        }
        i += DIRS[di][0];
        j += DIRS[di][1];
    }
    return ans;
}
}
