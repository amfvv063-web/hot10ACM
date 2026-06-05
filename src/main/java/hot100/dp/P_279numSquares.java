package hot100.dp;

import java.util.Arrays;

public class P_279numSquares {
public static void main(String[] args) {
    int n = 12;
    int ans = numFind(n);
    System.out.println(ans);
}

private static int numFind(int n) {
    int target = (int) Math.sqrt(n);
    // 背包问题 容量(n) dfs(i, n) =  选 min{dfs(i, target - x) +1, dfs(i-1, target)} or dfs(i-1, target) 
    // dfs(i, target) 前i个数 恰好== target的个数
    // f[i][j] = 1. 不选 f[i-1][j] 2.选 f[i-1][j] or f[i][j - i^i] + 1 次数加1
    // f[0][0] = 0 f[0][j] = Max
    int[][] f = new int[target+1][n+1];
    Arrays.fill(f[0], Integer.MAX_VALUE);
    f[0][0] = 0;
    for (int i = 1; i <= target; i++) {
        for (int j = 0; j <= n; j++) {
            if (j < i * i) {
                //只能不选
                f[i][j] = f[i-1][j];
            }else{
                f[i][j] = Math.min(f[i-1][j], f[i][j - i*i]+1);
            }

        }
    }
    
    return f[target][n];
}
}
