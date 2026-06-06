package hot100.dp;

public class P_416canPartition {
    public static void main(String[] args) {
        int[] nums = { 1, 5, 11, 5 };
        boolean ans = isPartition(nums);
        System.out.println(ans);
    }

    private static boolean isPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        // 背包问题 容量 sum dfs(i, j) = 选 dfs(i-1, j-x) 不选 dfs(i-1, j);
        boolean[][] f = new boolean[n + 1][sum + 1];
        f[0][0] = true;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = 0; j <= sum; j++) {
                if (j - x < 0) {
                    //只能不选
                    f[i + 1][j] = f[i][j];
                } else {

                    //前面选了能实现 就选  不能实现就不选
                    if (f[i][j - x]) {
                        f[i + 1][j] = f[i][j - x];
                    } else {
                        f[i + 1][j] = f[i][j];
                    }

                }
            }
        }
        return f[n][sum];
    }
}
