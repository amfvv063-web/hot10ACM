package hot100.dp;

public class P_198rob {
public static void main(String[] args) {
    int[] nums = {1,2,3,1};
    int ans = rob(nums);
    System.out.println(ans);
}

private static int rob(int[] nums) {
    //dfs(i) 到第i家 偷盗的最大金额 dfs(i) = dfs(i-2) + x or dfs(i-1)
    // f(i+2) = f(i) + x  or f(i+1)
    int n = nums.length;
    int[] f = new int[n+2];
    f[0] = f[1] = 0;
    for (int i = 0; i < n; i++) {
        f[i+2] = Math.max(f[i] + nums[i], f[i+1]);
    }
    return f[n+1];
}
}
