package hot100.array;

import java.util.Scanner;

public class P_53maxSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        line = line.substring(1, line.length()-1);
        String[] paStrings = line.split(",");
        int[] nums = new int[paStrings.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(paStrings[i]);
        }
        int ans = maxSubArray(nums);
        System.out.println(ans);
    }
    //动态规划 选与不选
    private static int maxSubArray(int[] nums) {
        int n = nums.length;
        //选 dfs(i) = dfs(i-1) + nums[i] 不选 nums[i]
        int[]f = new int[n+1];
        f[0] = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            f[i+1] = Math.max(f[i] + nums[i], nums[i]);
            ans = Math.max(ans, f[i+1]);
        }
        return ans;
    }
    
    
}
