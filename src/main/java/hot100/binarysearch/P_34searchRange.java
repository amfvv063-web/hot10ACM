package hot100.binarysearch;

public class P_34searchRange {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int[] ans = search(nums, target);
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]);
            if (i < ans.length - 1)
                sb.append(',');
        }
        sb.append(']');
        System.out.println(sb);
    }
    // 第一个下标 >=x 第二个下标 >=x+1 -1
    private static int[] search(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if (nums[start] != target) {
            start = -1;
        }
        int end = lowerBound(nums, target + 1) - 1;
        if (nums[end] != target) {
            end = -1;
        }
        int[] ans = new int[2];
        ans[0] = start;
        ans[1] = end;
        return ans;
    }

    private static int lowerBound(int[] nums, int x) {
        int l = -1;
        int r = nums.length;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < x) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return r;
    }
}
