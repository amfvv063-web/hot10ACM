package hot100.binarysearch;

public class P_33search {
public static void main(String[] args) {
    int[] nums = {4,5,6,7,0,1,2};
    int target = 0;
    int ans = search(nums, target);
    System.out.println(ans);
}
//先二分 找分段 然后 分段二分
private static int search(int[] nums, int target) {
    int i  = findMin(nums);
    int l = 0, r = nums.length-1;
    //第二段
    if (target <= nums[r]) {
        return lowerBound(nums,i,r,target);
    }
    //第一段
        return lowerBound(nums,l, i-1,target);
}

private static int lowerBound(int[] nums, int i, int j, int x) {
    int l = i-1;
    int r = j + 1;
    while (l+1<r) {
        int mid = l+(r -l)/2;
        if (nums[mid] < x ) {
            l = mid;
        }else{
            r = mid;
        }
    }
    if (nums[r] != x) {
        r = -1;
    }
    return r;
}

private static int findMin(int[] nums) {
    int l = -1, r = nums.length;
    while (l+1<r) {
        int mid = l + (r-l)/2;
        if (nums[mid] <= nums[r-1]) {
            r = mid;
        }else{
            l = mid;
        }
    }
    return r;
}
}
