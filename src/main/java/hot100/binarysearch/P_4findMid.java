package hot100.binarysearch;

/**
 * LeetCode 4. 寻找两个正序数组的中位数
 * 做法：在较短数组上二分「左半段的切分位置」，O(log min(m,n))
 */
public class P_4findMid {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };
        double ans = findMid(nums1, nums2);
        System.out.println(ans);
    }

    private static double findMid(int[] nums1, int[] nums2) {
        // 1. 保证 nums1 是更短的那个，只在 nums1 上二分
        if (nums1.length > nums2.length) {
            int[] tem = nums1;
            nums1 = nums2;
            nums2 = tem;
        }

        int m = nums1.length;
        int n = nums2.length;
        int half = (m + n + 1) / 2; // 左半段一共要这么多个数（奇偶统一）

        // 2. 在 nums1 上二分 i：i 表示 nums1「左半段」最后一个元素的下标
        //    i = -1 表示 nums1 左半为空；i = m-1 表示 nums1 几乎全部在左半
        //    开区间 (l, r) 最终 i = l
        int l = -1;
        int r = m;
        while (l + 1 < r) {
            // i,j 代表第一组有i+1, j+1个数
            int i = l + (r - l) / 2;
            // 3. 由 i 推出 j：j 是 nums2「左半段」最后一个元素的下标
            //    (i+1) + (j+1) = half  =>  j = half - i - 2
            int j = half - i - 2;

            // 4. 合法划分需满足：nums1[i] <= nums2[j+1] 且 nums2[j] <= nums1[i+1]
            //    这里只用第一条移动二分边界（i 还能更大 / 要缩小）
            //    i<0 时没有 nums1[i]，视为左半无 nums1，可尝试增大 i
            boolean left1LeRight2 = (i < 0) || (j + 1 >= n) || nums1[i] <= nums2[j + 1];
            if (left1LeRight2) {
                l = i; // i 偏小或刚好，答案在右半侧，尝试更大的 i
            } else {
                r = i; // nums1[i] 太大，左半从 nums1 拿多了
            }
        }

        // 5. 二分结束，i = l 为最终切分；再算一次 j
        int i = l;
        int j = half - i - 2;

        // 6. 左半最大值 cnt1 = max(nums1 左半末, nums2 左半末)，缺侧用极值代替
        int a1 = i >= 0 ? nums1[i] : Integer.MIN_VALUE;
        int b1 = j >= 0 ? nums2[j] : Integer.MIN_VALUE;
        // 7. 右半最小值 cnt2 = min(nums1 右半首, nums2 右半首)，缺侧用极值代替
        int a2 = i + 1 < m ? nums1[i + 1] : Integer.MAX_VALUE;
        int b2 = j + 1 < n ? nums2[j + 1] : Integer.MAX_VALUE;

        int cnt1 = Math.max(a1, b1);
        int cnt2 = Math.min(a2, b2);

        // 8. 总长度偶数：中位数 = (cnt1 + cnt2) / 2；奇数：就是 cnt1
        return (m + n) % 2 == 0 ? (cnt1 + cnt2) / 2.0 : cnt1;
    }
}
