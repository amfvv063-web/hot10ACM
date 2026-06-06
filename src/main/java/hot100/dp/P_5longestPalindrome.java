package hot100.dp;

public class P_5longestPalindrome {
    public static void main(String[] args) {
         String s = "babad";
    String ans = findMaxPail(s);
    System.out.println(ans);
    }

    //中心扩展法  考虑两种情况 1.奇回文串 2.偶回文串 
    // 遍历i 从i 到左右 统计距离  统计两种情况的左右指针 找到最大的
    private static String findMaxPail(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int ansLeft = 0;
        int ansRight = 0;

        //奇回文串
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;
            while (l>=0 && r<n && str[l] == str[r]) {
                l--;
                r++;
            }
            // s[l+1, r-1] 回文串
            if (r - 1 -l - 1 + 1 > ansRight - ansLeft+1) {
                ansLeft = l +1;
                ansRight = r - 1;
            }
        }

        //偶回文串
        for (int i = 0; i < n-1; i++) {
            if (str[i] == str[i+1]) {
                int l = i;
                int r = i+1;
                while (l>=0 && r<n && str[l] == str[r]) {
                    l--;
                    r++;
                }
                //判断是否更新指针
                if (r-1-l-1+1 > ansRight - ansLeft + 1) {
                    ansLeft = l+1;
                    ansRight = r - 1;
                }
            }
        }
        return s.substring(ansLeft, ansRight+1);
    }
   
    
}
