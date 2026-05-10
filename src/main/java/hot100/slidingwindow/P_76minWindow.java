package hot100.slidingwindow;

import java.util.Scanner;

public class P_76minWindow {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    String p = sc.nextLine();
    s = s.substring(1, s.length()-1);
    p = p.substring(1, p.length()-1);
    String ans = minWindow(s, p);
    System.out.println(ans);
}

//建立cover函数，用于判断s字串是否覆盖p字串
//用ansleft, ansright 来维持最小字串的左右下标
//l, r用来维护滑动窗口
private static String minWindow(String s, String p) {
    int[] sM = new int[128];
    int[] pM = new int[128];
    for (int i = 0; i < p.length(); i++) {
        char c = p.charAt(i);
        pM[c]++;
    }
    char[] strs = s.toCharArray();
    int l = 0;
    int ansLeft = -1;
    int ansRight = s.length();
    for (int r = 0; r < strs.length; r++) {
        sM[strs[r]]++;
        while (isConver(sM, pM)) {
            if (r - l< ansRight - ansLeft ) {
                ansLeft = l;
                ansRight = r;
            }
            sM[strs[l]]--;
            l++;
        }
    }
    return ansLeft<0 ? "": s.substring(ansLeft, ansRight+1);
}

private static boolean isConver(int[] sM, int[] pM) {
    for (int i = 'A'; i <= 'Z'; i++) {
        if(sM[i] < pM[i]){
            return false;
        }
    }
    for (int i = 'a'; i <= 'z'; i++) {
        if(sM[i] < pM[i]){
            return false;
        }
    }
    return true;
}
}
