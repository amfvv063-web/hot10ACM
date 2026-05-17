package hot100.binarysearch;

public class P_153findMind {
public static void main(String[] args) {
    int[] nums = {3,4,5,1,2};
    int ans = findMin(nums);
    System.out.println( ans);
}

private static int findMin(int[] nums) {
   int l = -1, r = nums.length;
   while (l+1<r) {
    int target = nums[r-1];
    int mid = l + (r-l)/2;
    if (nums[mid] > target) {
        l = mid;
    }else{
        r = mid;
    }
   }
   return nums[r];
}
}
