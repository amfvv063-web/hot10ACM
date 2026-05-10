package hot100.array;

import java.util.Scanner;

public class P_189rotate {
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
    int[] ans = rotate1(nums, k);
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

//简单的数学问题
private static int[] rotate(int[] nums, int k) {
    // m = n + k+1
    // i= k+1 % n
    int[] ans = new int[nums.length];
    int pre = k+1;
   for (int i = 0; i < ans.length; i++) {
    ans[i] = nums[(pre++)%nums.length];
   }
   nums = ans;
    return ans;
}

//原地修改， 三次反转， 全部反转， 前k反转， n-k反转
private static int[] rotate1(int[] nums, int k){
    int n = nums.length;
    
    k %= n;
    reverse(nums, 0, n-1);
    reverse(nums, 0, k-1);
    reverse(nums, k, n-1);

    return nums;
}

private static void reverse(int[] nums, int l, int r) {
    while (l< r ) {
        int temp = nums[l];
        nums[l++] = nums[r];
        nums[r--] = temp;
    }
}

}
