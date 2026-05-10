package hot100.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class P_438findAnagrams {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    s = s.substring(1, s.length()-1);
    String p = sc.nextLine();
    p = p.substring(1, p.length()-1);
    List<Integer> ans = findAnagrams(s, p);
    StringBuilder sb = new StringBuilder();
    for (Integer x : ans) {
        sb.append(x);
    }
    System.out.println(ans);

}

//滑动窗口 用一个数组滑动
private static List<Integer> findAnagrams(String s, String p) {
    int[] cnt = new int[26];
    int k = p.length();
    for (int i = 0; i < p.length(); i++) {
        char c = p.charAt(i);
        cnt[c - 'a']++;
    }
    char[] str = s.toCharArray();
    int l = 0;
    List<Integer> ans = new ArrayList<>();
    for (int r = 0; r < str.length; r++) {
        char c = str[r];
        cnt[c-'a']--;
    
        while(cnt[c-'a']<0) {
            cnt[str[l] - 'a']++;
            l++;
        }
        if (r-l+1 == k) {
            ans.add(l);
        }
    }
    return ans;
}
}
