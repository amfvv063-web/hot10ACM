package hot100.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P_3lengthOfLongestString {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
    if (line.isEmpty()) {
        line = new String(" ");
    }
    line = line.substring(1, line.length()-1);
    int ans = lols(line);
    System.out.println(ans);
    
}

private static int lols(String line) {
    int ans = 0;
    int l = 0;
    char[] s = line.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    for (int r = 0; r < s.length; r++) {
        char c = s[r];
        map.merge(c, 1, Integer::sum);
        //向右不满足条件就缩左边
        while (map.get(c) > 1) {
            map.put(s[l], map.get(s[l])-1);
            l++;
        }
        ans = Math.max(ans, r - l +1);
        
    }
    return ans;
}
}
