package hot100.twopointers;

import java.util.Scanner;

public class P11_maxArea {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine().trim();
    line = line.substring(1, line.length()-1);
    String[] parts = line.split(",");
    int[] nums = new int[parts.length];
    for (int i = 0; i < nums.length; i++) {
        nums[i] = Integer.parseInt(parts[i]);
    }
    int ans = maxArea(nums);
    System.out.println(ans);
}

//贪心想法 想要获得最大 移动短的边界
private static int maxArea(int[] nums) {
    int l = 0, r = nums.length-1, ans = 0;
    while (l<r) {
        int x = nums[l];
        int y = nums[r];
        int c = r - l;
        ans = Math.max(ans, Math.min(x, y) * c);
        if (x<y) {
            l++;
        }else{
            r--;
        }

    }
    return ans;
}
}

