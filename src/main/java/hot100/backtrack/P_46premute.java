package hot100.backtrack;

import java.util.ArrayList;
import java.util.List;

public class P_46premute {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> ans = preMiser(nums);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < ans.size(); i++) {
            sb.append("[");
            List<Integer> list = ans.get(i);
            for (int j = 0; j < list.size(); j++) {
                sb.append(list.get(j));
                if (j != list.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            if (i != ans.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    //回溯类型 全排�?dfs枚举
    private static List<List<Integer>> preMiser(int[] nums) {
        // path记录  已选数�? s 记录未选数�?        // dfs  s 枚举 path[i] 要填的数字x  构造排�?=i的部�?-> 构�?>= i+1的部�?剩下�?s - x
        // dfs(i, s) = dfs(i+1, s - x1)
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] onPath = new boolean[n];
        dfs(0, nums, ans, path, onPath);
        return ans;
    }

    /**
     * 回溯：按「位置」填排列，每个位置从 nums 里选一个还没用过的数�?     *
     * @param i       当前要填的是 path 的第几个位置�? ~ n-1），也等�?path.size()
     * @param nums    原数组，下标 j 对应数字 nums[j]
     * @param ans     收集所有完整排�?     * @param path    当前正在构造的一条路径（一条排列的前缀），全程共用一个对象，�?add/remove 回溯
     * @param onPath  onPath[j]==true 表示 nums[j] 已在 path 里，不能重复�?     *
     * 记忆口诀：�?�?递归下一�?�?撤销（onPath �?path 都要恢复�?     */
    private static void dfs(int i, int[] nums, List<List<Integer>> ans, List<Integer> path,
            boolean[] onPath) {
        // 【终止】i == n：n 个位置都填满了，path 是一条完整排�?        if (i == nums.length) {
            // 必须 new 拷贝！不能直�?ans.add(path)，否�?ans 里全是同一引用，最后会变成空或同一个排�?            ans.add(new ArrayList<>(path));
            return;
        }

        // 【枚举】第 i 个位置可以填谁？遍历每个下标 j，相当于「候选数�?nums[j]�?        for (int j = 0; j < nums.length; j++) {
            if (!onPath[j]) { // 剪枝：nums[j] 还没用过才能选（全排列不能重复用同一个元素）

                // ---------- 1. 选择（做选择，进入更深层�?---------
                path.add(nums[j]);   // �?i 格填�?nums[j]，path 长度变为 i+1
                onPath[j] = true;    // 标记 nums[j] 已占�?
                // ---------- 2. 探索（递归填第 i+1 格）----------
                dfs(i + 1, nums, ans, path, onPath);

                // ---------- 3. 撤销（回到本层，换下一�?j 试试�?---------
                // 顺序与选择相反：先恢复标记，再删掉 path 末尾（刚加的那个数）
                onPath[j] = false;
                path.remove(path.size() - 1);
            }
        }
        // 本层 for 结束：第 i 格所有可能都试完，return 到上一层，由上一层继续撤销或换分支
    }
}
