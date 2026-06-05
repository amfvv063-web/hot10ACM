package hot100.dp;

import java.util.ArrayList;
import java.util.List;

public class P_131partition {

    public static void main(String[] args) {
        String s = "abb";
        List<List<String>> ans = partition(s);
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < ans.size(); i++) {
            sb.append("[");
            List<String> list = ans.get(i);
            for (int j = 0; j < list.size(); j++) {
                sb.append(list.get(j));
                if (j != list.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            if (i != ans.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    private static List<List<String>> partition(String s) {
        char[] words = s.toCharArray();
        List<List<String>> ans = new ArrayList<>();
        List<String> res = new ArrayList<>();
        dfs(0, 0, words, res, ans);
        return ans;
    }

    //从输入视角看 选/不选  dfs(i,j) 不选 -> dfs(i,j+1)  dfs(i,j) 选-> 加入res s[i,j] -> dfs(j+1, j+1) 下一段
    private static void dfs(int i, int j, char[] words, List<String> res, List<List<String>> ans) {
        if (j == words.length) {
            ans.add(new ArrayList<>(res));
            return;
        }

        // 不选逗号：当前段 [i,j] 再往后扩一位
        if (j < words.length - 1) {
            dfs(i, j + 1, words, res, ans);
        }

        // 选逗号：前面 word[i..j] 是回文，整段加入 res，下一段从 j+1 开始
        if (isPar(words, i, j)) {
            res.add(new String(words, i, j - i + 1));
            dfs(j + 1, j + 1, words, res, ans);
            res.remove(res.size() - 1);
        }
    }

    private static boolean isPar(char[] words, int i, int j) {
        // 判断 word[i..j] 是否是回文串
        while (i < j) {
            if (words[i++] != words[j--]) {
                return false;
            }
        }
        return true;
    }
}
