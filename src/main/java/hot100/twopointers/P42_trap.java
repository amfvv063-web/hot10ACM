package hot100.twopointers;

import java.util.Scanner;

public class P42_trap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        line = line.substring(1, line.length() - 1);
        String[] parts = line.split(",");
        int[] nums = new int[parts.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        int ans = trap(nums);
        System.out.println(ans);
    }

    //前后缀分解 维护
    private static int trap(int[] nums) {
        int n = nums.length;
        int[]lMax = new int[n];
        int[]rMax = new int[n];
        int lmax =nums[0], rmax = nums[n-1];
       for (int i = 0; i < nums.length; i++) {
        lmax = Math.max(nums[i], lmax);
            lMax[i] = lmax;
       }
       for (int j = nums.length - 1; j >= 0; j--) {
        rmax = Math.max(rmax, nums[j]);
        rMax[j] = rmax;
       }

       int ans = 0;
       for (int i = 0; i < nums.length; i++) {
        ans+= Math.min(lMax[i], rMax[i]) - nums[i];
       }
       return ans;
        
    }

    //相向双指针维护边界
    private static int trap1(int[] nums){
        int n = nums.length;
        int lMax =0, rMax = 0;
        int ans = 0;
        int l = 0, r= n-1;
        while (l<r) {
            lMax = Math.max(lMax, nums[l]);
            rMax = Math.max(rMax, nums[r]);
            if (lMax < rMax) {
                ans += lMax - nums[l];
                l++;
            }else{
                ans += rMax - nums[r];
                r--;
            }
        }
        return ans;
    }
    
    
}
