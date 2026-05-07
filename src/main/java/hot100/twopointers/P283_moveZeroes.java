package hot100.twopointers;

import java.util.Scanner;

public class P283_moveZeroes {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine().trim();
    if (line.isEmpty()) {
        line = new String(" ");
    }
    line = line.substring(1, line.length()-1);
    String[] parts = line.split(",");
    int []nums = new int[parts.length];
    for (int i = 0; i < nums.length; i++) {
    nums[i] = Integer.parseInt(parts[i]);
   }
   int [] ans = moveZeroes1(nums);
   print(ans);
}

private static void print(int[] ans) {
   StringBuilder sb = new StringBuilder();
   sb.append('[');
   for (int i = 0; i < ans.length; i++) {
    int x = ans[i];
    if (i < ans.length-1) {
        sb.append(x);
        sb.append(',');
    }else{
        sb.append(x);
    }
   }
   sb.append(']');
   System.out.println(sb);
}

//原地修改 栈
private static int[] moveZeroes(int[] nums) {
   int stackPrx = 0;
   for (int x : nums) {
    if (x != 0) {
        nums[stackPrx] = x;
        stackPrx++;
    }
   }
   for (int i = stackPrx; i < nums.length; i++) {
    nums[i] = 0;
   }
   return nums;
   }

 //双指针
private static int[] moveZeroes1(int[] nums){
    int l = 0;
   for (int r = 0; r < nums.length; r++) {
    if (nums[r] != 0) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        l++;
    }
   }
   return nums;
}   
}
