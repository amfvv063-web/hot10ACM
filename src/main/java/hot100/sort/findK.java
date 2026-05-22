package hot100.sort;

import java.util.Random;

public class findK {
    private static  Random rand = new Random();
public static void main(String[] args) {
    int[] nums = {3,2,1,5,6,4};
    int k = 2;
    int ans = findKth(nums, k);
    System.out.println(ans);
}

private static int findKth(int[] nums, int k) {
    int n = nums.length;
    int kIndex = n - k;
    int l = 0;
    int r = n-1;
    while (true) {
        int i = portition(nums, l, r);
        if (i == kIndex) {
            return nums[i];
        }else if (i > kIndex) {
            r = i-1;
        }else{
            l = i+1;
        }
    }
}

private static int portition(int[] nums, int l, int r) {
    int i = l + rand.nextInt(r - l + 1);
    int part = nums[i];
    swap(l, i, nums);
    i = l+1;
    int j = r;
    while (true) {
        while (i<=j && nums[l] < part) {
            l++;
        }
        while (i<=j && nums[r] > part) {
            r--;
        }
        if (i>j) {
            break;
        }
        swap(i, j, nums);
        i++;
        j--;
    }
    swap(l, j, nums);
    return j;
}

private static void swap(int i, int j, int[] nums) {
   int temp = nums[i];
   nums[i] = nums[j];
   nums[j] = temp;
}
}
