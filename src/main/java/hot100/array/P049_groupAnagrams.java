package hot100.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * LeetCode 49. 字母异位词分组 — ACM 自订题面
 *
 * <p>输入：一行，若干字符串，空格分隔（不写 n）。空行表示无字符串。
 *
 * <p>输出：<strong>一行</strong>，形如 LeetCode 控制台那种嵌套列表字符串：{@code [["a","b"],["c"]]}。字符串用双引号；组内、组间顺序经排序后固定，便于对拍。
 *
 * <p>样例输入：{@code eat tea tan ate nat bat}
 *
 * <p>样例输出：{@code [["ate","eat","tea"],["bat"],["nat","tan"]]}
 */
public class P049_groupAnagrams {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.hasNextLine() ? sc.nextLine().trim() : "";

        String[] strs;
        if (line.isEmpty()) {
            strs = new String[0];
        } else {
            strs = line.split("\\s+");
        }

        List<List<String>> groups = groupAnagrams(strs);
        printGroups(groups);
    }


    /** 核心分组 */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 单行输出：{@code [["a","b"],["c"]]} 形式；无分组时输出 {@code []}。
     */
    static void printGroups(List<List<String>> groups) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < groups.size(); i++) {
            if (0<i) {
                sb.append(',');
            }
            List<String> strs = groups.get(i);
            sb.append('[');
            for (int j = 0; j < strs.size(); j++) {
                // if (j > 0) {
                //     sb.append(',');
                // }
                sb.append(strs.get(j));
                }
                sb.append(']');
            }
            sb.append(']');
            System.out.println(sb);
        }
        
    

}
