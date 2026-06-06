package hot100.dp;

public class P_300lengthOfLIS {
    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        int ans = lentestFind(nums);
        System.out.println(ans);
    }

    //枚举选哪个 不属于背包问题
    private static int lentestFind(int[] nums) {
        // 枚举 nums[i] 作为Lis 末尾元素
        // 枚举 nums[j] 作为lis 倒数第二个元素
        // dfs(i) = max(dfs(j))+1
        int n = nums.length;
        int[] f = new int[n];
        //f[i]  以nums[i] 结尾的最长递增子序列长度
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];

            for (int j = 0; j < i; j++) {
                int y = nums[j];
                if (y < x) {
                    f[i] = Math.max(f[i], f[j]);
                }
            }
            ans = Math.max(ans, ++f[i]);
        }
        return ans;
    }
}
