package hot100.math;

public class P_45jump {
public static void main(String[] args) {
    int[] nums = {2,3,1,1,4};
    int ans = jump(nums);
    System.out.println(ans);
}

private static int jump(int[] nums) {
    int n = nums.length;
    // [i, i+ nums[i]]
    int maxReach = 0;
    int ans = 0;
    int curend = 0;
    // 记录能到的最远距离  默认走到右边界， 到边界更新能到的最大边界 统计更新次数
    for (int i = 0; i < nums.length-1;i++) {
        maxReach = Math.max(maxReach, i+nums[i]);
        if (i==curend) {
            curend = maxReach;
            ans++;
        }
    
    }
    return ans;
}
}
