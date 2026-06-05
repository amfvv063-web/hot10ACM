package hot100.dp;

import java.util.Arrays;

public class P_322coinChange {
public static void main(String[] args) {
    int[] nums = {1,2,5};
    int amount = 11;
    int ans = coinNum(nums, amount);
    
    System.out.println(ans);
}

private static int coinNum(int[] nums, int amount) {
    // dfs(i, j) = 选 dfs(i, j- x), dfs(i-1, j)  不选 dfs(i-1, j)
    int[][] f = new int[nums.length+1][amount+1];
    Arrays.fill(f[0], Integer.MAX_VALUE);
    f[0][0] = 0;

    for (int i = 0; i < nums.length; i++) {
        int x = nums[i];
        for (int j = 0; j <= amount; j++) {
            if (j < x) {
                f[i + 1][j] = f[i][j];
            }else{
                f[i+1][j] = Math.min(f[i+1][j - x]+1,f[i][j] );
            }
        }
    }
    return f[nums.length][amount] == Integer.MAX_VALUE ? -1:f[nums.length][amount] ;
}
}
