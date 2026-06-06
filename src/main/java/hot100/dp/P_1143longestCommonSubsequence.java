package hot100.dp;

public class P_1143longestCommonSubsequence {
    public static void main(String[] args) {
        String t1 = "abcde";
        String t2 = "ace";
        int ans = findMax(t1, t2);
        System.out.println(ans);
    }

    private static int findMax(String t1, String t2) {
        // dfs(i, j) t1 前i个 t2 前j个满足 LCS  选 dfs(i-1, j-1) + 1 不选 dfs(i, j)
        int m = t1.length(), n = t2.length();
        int[][] f = new int[m + 1][n + 1];
        char[] t1s = t1.toCharArray();
        char[] t2s = t2.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 只能不选
                if (t1s[i] != t2s[j]) {
                    f[i + 1][j + 1] = Math.max(f[i + 1][j], f[i][j + 1]);
                } else {
                    // 满足条件 选
                    f[i + 1][j + 1] = f[i][j] + 1;
                }
            }
        }
        return f[m][n];
    }
}
