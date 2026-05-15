package hot100.math;

import java.util.Scanner;

public class P_55canJump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
    line = line.substring(1,line.length()-1);
    String[] parts = line.split(",");
    int[] nums = new int[parts.length];
    for (int i = 0; i < nums.length; i++) {
        nums[i] = Integer.parseInt(parts[i]);
    }
    boolean ans = canJump(nums);
    System.out.println(ans);
    }

    //i -> [i, i+nums[i]]范围 枚举元素， 更新右边界 判断是否能到达
    private static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if(maxReach<n-1) return false;
            maxReach = Math.max(maxReach, i+nums[i]);
            if (maxReach >= n-1) {
                return true;
            }
        }
        return true;
    }
    
}
