package hot100.dp;

import java.util.Arrays;
import java.util.List;

public class P_139wordBreak {
public static void main(String[] args) {
    String s = "leetcode";
    List<String> wordDict = Arrays.asList("leet", "code");
    boolean ans = wordBreak(s, wordDict);
    System.out.println(ans);
}

private static boolean wordBreak(String s, List<String> wordDict) {
    // dfs(i, j)  前i个元素拼j 正不正确     选 dfs(i, j - i)  不选 dfs(i-1, j)
    boolean[][] f = new boolean[wordDict.size()+1][s.length()+1];
    f[0][0] = true;
    for (int i = 0; i < wordDict.size(); i++) {
        String w = wordDict.get(i);
        int len = w.length();
        for (int j = 0; j <= s.length(); j++) {
            if (j < len) {
                f[i+1][j] = f[i][j];  //只能不选
            }else{
                // 如果前面选了 && 匹配 选
                if (f[i+1][j - len] && s.substring(j - len, j).equals(w)) {
                    f[i+1][j] = true;
                }else{
                    //不选
                    f[i+1][j] = f[i][j];
                }
            }
            
        }
    }
    return f[wordDict.size()][s.length()];
}


}
