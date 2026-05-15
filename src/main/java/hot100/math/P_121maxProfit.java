package hot100.math;

public class P_121maxProfit {
public static void main(String[] args) {
    int[] nums = {7,6,4,3,1};
    int ans = maxPoint(nums);
    System.out.println(ans);
}

// 贪心思想 维护最小值 枚举最大值
private static int maxPoint(int[] nums) {
   int minC = nums[0];
   int ans = 0;
  for (int x : nums) {
    minC = Math.min(minC, x);
    ans = Math.max(x-minC, ans);
  }
  return ans;
}
}
