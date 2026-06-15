package hot100.dp;

public class P_72minDistance {
public static void main(String[] args) {
    String word1 = "horse";
    String word2 = "ros";
    int ans = findD(word1, word2);
    System.out.println(ans);
}

private static int findD(String word1, String word2) {
    char[] s1 = word1.toCharArray();
    char[] s2 = word2.toCharArray();
    int m = s1.length;
    int n = s2.length;
    //dfs(i, j) -> s[i] = s[j] = dfs(i- 1. j-1)
    // -> s[i] != s[j]  删 dfs(i-1, j) 插入 dfs(i, j-1) 替 dfs(i-1, j-1);
    int[][] f = new int[m+1][n+1];

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            // 满足条件 选
            if (s1[i] == s2[j]) {
                f[i+1][j+1] = f[i][j];
            }else{
                f[i+1][j+1] = Math.min(Math.min(f[i][j], f[i+1][j]), f[i][j+1]) +1;
            }
        }
    }
    return f[m][n];

}
}
