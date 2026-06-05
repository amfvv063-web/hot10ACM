package hot100.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class P_17letterCombinations {
    private static String[] map = new String[]{" ", " ", "abc", "def","ghi", "jkl", "mno", "pqrs","tuv","wxyz"};
public static void main(String[] args) {
    String data = "23";
    List<String> ans = lettetTran(data);
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

private static List<String> lettetTran(String data) {
    //全排�?    //dfs(i) dfs(i+1) ..
    int n = data.length();
    if (n == 0) {
        return List.of();
    }
    List<String> ans = new ArrayList<>();
    char[] res = new char[n];
    dfs(0, ans, res, data.toCharArray());
    return ans;
}
//step1 遍历第一个集�? 遍历�?dfs(i+1) 可以加第二个集合 
private static void dfs(int i, List<String> ans, char[] res, char[] datas) {
    if (i == datas.length) {
        ans.add(new String(res));
        return;
    }
    String letters = map[datas[i] - '0'];
    for (char c : letters.toCharArray()) {
        res[i] = c;
        dfs(i+1, ans, res, datas); 
    }

}
}
