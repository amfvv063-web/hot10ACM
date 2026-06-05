package hot100.dp;

public class P_70climbStairs {
public static void main(String[] args) {
    int n = 3;
    int ans = climb(n);
    System.out.println(ans);

}

private static int climb(int n) {
    // 1 or 2 选择  dfs(i) -> 爬到第i台阶有多少种方法  dfs(i) = dfs(i-1) + dfs(i - 2);
    //dfs(i+2) = dfs(i+1) + dfs(i)
    int[] f = new int[n+1];
    f[0] = f[1] = 1; // 没有台阶 1种方法
    for (int i = 0; i < n-1; i++) {
        f[i+2] = f[i] + f[i +1];
    }
    return f[n];
}
}
