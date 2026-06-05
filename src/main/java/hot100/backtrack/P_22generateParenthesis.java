package hot100.backtrack;

import java.util.ArrayList;
import java.util.List;

public class P_22generateParenthesis {
public static void main(String[] args) {
    int n = 3;
    List<String> ans = gP(n);
    StringBuffer sb = new StringBuffer();
    sb.append("[");
    for (int i = 0; i < ans.size(); i++) {
        sb.append(ans.get(i));
        if (i != ans.size() - 1) {
            sb.append(", ");
        }
    }
    sb.append("]");
    System.out.println(sb);
}

private static List<String> gP(int n) {
    List<String> ans = new ArrayList<>();
    char[] res = new char[2*n];
    dfs(0,0,n,res, ans);
    return ans;

}

// 选与不选变�? 
private static void dfs(int i, int j, int n, char[] res, List<String> ans) {
    if ( j == n) {
        ans.add(new String(res));
        return;
    }

    //先�?    if (i<n) {
        res[i+j] = '(';
        dfs(i+1, j, n, res, ans);
    }
    //满足条件 再不�?    if (j < i) {
        res[i+j] = ')';
        dfs(i, j+1, n, res, ans);
    }
}

}
