package hot100.dp;

public class P_152maxProduct {
    public static void main(String[] args) {
        int[] nums = { 2, 3, -1, 4 };
        long ans = maxFind(nums);
        System.out.println(ans);
    }

    private static long maxFind(int[] nums) {
        // 存在三种情况 1.正*正 2.负*负 3.x值
        // dfs(i)表示 到第i元素 最大乘积 保存三种情况 max min x 
        // dfs(i) = dfs(i-1)*x , x
        int n = nums.length;
        int[] fMax = new int[n+1];
        int[] fMin = new int[n+1];
        
        fMax[0] = fMin[0] = 1;
        long ans = 1L;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            //保存 最大/最下  维护 正最大 负最大两种情况
            fMax[i+1] = Math.max(Math.max(fMax[i]*x, fMin[i] * x), x);
            fMin[i+1] = Math.min(Math.min(fMax[i] * x, fMin[i] * x), x);
            ans = Math.max(ans, fMax[i+1]);  
        }
        return ans;
        
    }
}
