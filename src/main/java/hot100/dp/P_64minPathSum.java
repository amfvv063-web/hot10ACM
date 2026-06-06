package hot100.dp;

import java.util.Arrays;

public class P_64minPathSum {

    public static void main(String[] args) {
        int[][] nums = {
            {1,3,1},
            {1,5,1},
            {4,2,1},
        };
        int ans = findMinNums(nums);
        System.out.println(ans);
    }

    private static int findMinNums(int[][] nums) {
       // dfs(i, j) = Math.min{dfs(i-1, j), dfs(i, j-1)} + x
       int m = nums.length;
       int n = nums[0].length;
       int[][] f = new int[m+1][n+1];
       // f[1][1] = (0,0) f[0], f[][0] = 出界
       Arrays.fill(f[0], Integer.MAX_VALUE/2);
       for (int i = 0; i < f.length; i++) {
        f[i][0] = Integer.MAX_VALUE/2;
       }
       f[1][0] = 0;
       for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            int x = nums[i][j];
            f[i+1][j+1] = Math.min(f[i+1][j],f[i][j+1]) + x;
        }
       }
       return f[m][n];
    }
}\
