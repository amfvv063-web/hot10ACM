package hot100.array;

import java.util.Scanner;

public class P_41firstMissingPostive {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
        line = line.substring(1, line.length()-1);
        String[] paStrings = line.split(",");
        int[] nums = new int[paStrings.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(paStrings[i]);
        }
        int ans = firstMissing(nums);
        System.out.println(ans);
}

// 该元素要放入下标为自己-1的位置 如果没有就交换 
// 在[1, n]范围内， 如果 值nums[i] != nums[nums[i]-1] 就交换， 如果有重复 两者也相等
//结果有两种情况， [1,n]都满足，那就n+1,如果不满足， 就找那个错误位置
private static int firstMissing(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < nums.length; i++) {
        while (nums[i] >=1 && nums[i] <=n && nums[nums[i] - 1] != nums[i]) {
            int j = nums[i] - 1;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
   for (int i = 0; i < nums.length; i++) {
    if (nums[i] != i+1){
        return i+1;
    }
   }
   return n+1;
}
}
