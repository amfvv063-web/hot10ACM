package hot100.tree;

import common.TreeNode;
import common.TreeUtils;

public class P_108sortedTree {

    public static void main(String[] args) {
        int[] nums = { -10, -3, 0, 5, 9 };
        TreeNode ans = buildSortedTree(nums);
        System.out.println(TreeUtils.printer(ans));
    }

    /** 有序数组 → 平衡 BST，区间 [i, j) */
    private static TreeNode buildSortedTree(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

    private static TreeNode dfs(int[] nums, int i, int j) {
        if (i == j) {
            return null;
        }
        int m = (i + j) / 2;
        return new TreeNode(nums[m], dfs(nums, i, m), dfs(nums, m + 1, j));
    }
}
