package hot100.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P_560subarraySum {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
    line = line.substring(1, line.length()-1);
    String[] paStrings = line.split(",");
    int k = sc.nextInt();
    int[] nums = new int[paStrings.length];
    for (int i = 0; i < nums.length; i++) {
        nums[i] = Integer.parseInt(paStrings[i]);
    }
    int ans = subarraySum(nums, k);
    System.out.println(ans);
}

    private static int subarraySum(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        int[] s = new int[n+1];
        s[0] = 0;
       for (int i = 0; i < nums.length; i++) {
        int x = nums[i];
        s[i+1] =s[i] + x; 
       }
       //两数之和变种
       //k = s[r+1] -s[l]   s[l] = s[r+1] - k
       Map<Integer,Integer> cnt = new HashMap<>(n+1, 1);
      for (int x : s) {
        ans += cnt.getOrDefault(x-k, 0);
        cnt.merge(x, 1, Integer::sum);
      }
       return ans;
       

    }
}
