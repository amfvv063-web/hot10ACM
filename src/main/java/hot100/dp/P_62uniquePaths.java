package hot100.dp;

import java.util.Arrays;

public class P_62uniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        int ans = findNumofPath(m, n);
        System.out.println(ans);
    }

    private static int findNumofPath(int m, int n) {
        // dfs(i, j) = dfs(i-1, j) + dfs(i, j-1)
        //0,0 -> 2,6
        // dfs(-1, 0) / dfs(0, -1)  ->  出界 -1
        int[][] f = new int[m+1][n+1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0){
                    f[1][1] = 1;
                }else{
                    f[i+1][j+1] = f[i][j+1] + f[i+1][j];
                }
                
            }
        }
        return f[m][n];
    }
}
