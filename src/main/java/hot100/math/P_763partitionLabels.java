package hot100.math;

import java.util.ArrayList;
import java.util.List;

public class P_763partitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegd";
        List<Integer> ans = paertition(s);
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i));
            if (i < ans.size() - 1)
                sb.append(',');
        }
        sb.append(']');
        System.out.println(sb);

    }
    // step1 拿所有字母的最后下标
    private static List<Integer> paertition(String s) {
        char[] str = s.toCharArray();
        int[] last = new int[26];
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            last[c - 'a'] = Math.max(i, last[c - 'a']);
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
    // step2 找右边界 枚举和右边界重合，满足条件
        for (int i = 0; i < str.length; i++) {
            end = Math.max(end, last[str[i] - 'a']);
            if (end == i) {
                ans.add(end - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}
