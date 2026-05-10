package hot100.array;

import java.util.Scanner;

public class P_238productExceptSelf {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
        line = line.substring(1, line.length()-1);
        String[] paStrings = line.split(",");
        int[] nums = new int[paStrings.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(paStrings[i]);
        }
        int[] ans = producet1(nums);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]);
            if (i<ans.length-1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb);
}
 
//原始做法 时间(n^2)
private static int[] producet(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    for (int i = 0; i < nums.length; i++) {
        int l = 0;
        int r = n-1;
        int res = 1;
        while (l<i) {
            res *= nums[l++];
        }
        while (r>i) {
            res *= nums[r--];
        }
        ans[i] = res;
    }
    return ans;
}

//前后缀分解 时间O(n)
private static int[] producet1(int[] nums){
    int n = nums.length;
    int[] ans = new int[n];
    int[] pre = new int[n];
    int[] suf = new int[n];
    pre[0] = suf[n-1] = 1;
    //pre[i] suf[i] 与前缀和一样 i前所有元素的乘和
    for (int i = 1; i < nums.length; i++) {
        pre[i] = pre[i-1] * nums[i-1]; 
    }
    for (int j = nums.length - 2; j >= 0; j--) {
        suf[j] = suf[j+1] * nums[j+1];
    }

    for (int i = 0; i < ans.length; i++) {
        ans[i] = pre[i]*suf[i];
    }
    return ans;
}
}
