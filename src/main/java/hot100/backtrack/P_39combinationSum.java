package hot100.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_39combinationSum {

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;
        List<List<Integer>> ans = cobSum(nums, target);
        StringBuffer sb = new StringBuffer();
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

    private static List<List<Integer>> cobSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(0, target, nums, ans, res);
        //dfs(i, left)  �?dfs(i, left-x) 不�?dfs(i+1, left)
        return ans;
        
    }

    //完全背包的选与不�? 容量-背包大小 �?容量减少 不�?容量不变 边界出口 == 容量 �?
    private static void dfs(int i, int target, int[] nums, List<List<Integer>> ans, List<Integer> res) {
        if (target == 0) {
            ans.add(new ArrayList<>(res));
            return;
        }

        if (i == nums.length || target < 0) {
            return;
        }

        //不�?        dfs(i+1, target, nums, ans, res);

        //�?        res.add(nums[i]);
        dfs(i, target - nums[i], nums, ans, res);
        res.remove(res.size()-1);
    }
}
