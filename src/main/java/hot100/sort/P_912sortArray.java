package hot100.sort;

import java.util.Random;

public class P_912sortArray {
public static void main(String[] args) {
    int[] nums = {5,2,3,1};
    int[] ans = sortQucik(nums, 0, nums.length-1);
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (int i = 0; i < ans.length; i++) {
        sb.append(ans[i]);
        if (i<ans.length-1) sb.append(',');
    }
    sb.append(']');
    System.out.println(sb);
}

//快排算法 分治+递归
private static int[] sortQucik(int[] nums, int l, int r) {
    if (l>=r) {
        return nums;
    }
    int i = parition(nums, l, r);
    sortQucik(nums, l, i-1);
    sortQucik(nums, i+1, r);
    return nums;
}

private static int parition(int[] nums, int l, int r) {
    int i = l + new Random().nextInt(r- l+1);
    int pivot = nums[i];
    swap(nums, i,l);
    i = l +1;
    int j = r;
    while (true) {
        while (i<=j && nums[i] < pivot) {
            i++;
        }
        while (i<=j && nums[j] > pivot) {
            j--;
        }
        if (i>j) {
            break;
        }
        swap(nums, i, j);
        i++;
        j--;
    }
    swap(nums, l, j);
    return j;
}

private static void swap(int[] nums, int i, int j) {
   int temp = nums[i];
   nums[i] = nums[j];
   nums[j] = temp;
}


}
