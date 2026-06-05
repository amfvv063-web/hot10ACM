package hot100.backtrack;

import java.util.ArrayList;
import java.util.List;

public class P_78subSets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> ans = subset(nums);
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
        System.out.println(sb);
    }

    private static List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        //é€‰ä¸ä¸é€?dfs(i) = dfs(i -1) + nums(i) or dfs(i-1);
        //f(i+1) = f(i) + nums(i) or f(i)
        dfs(0, nums, ans, res);
        return ans;
    }

    private static void dfs(int i, int[] nums, List<List<Integer>> ans, List<Integer> res) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }

        //ä¸é€?        dfs(i + 1, nums, ans, res);

        //é€?        res.add(nums[i]);
        dfs(i + 1, nums, ans, res);
        res.remove(res.size() - 1);
    }
}
