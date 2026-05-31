package hot100.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import common.TreeNode;

public class P_108sortedTree {

    public static void main(String[] args) {
        int[] nums = { -10, -3, 0, 5, 9 };
        TreeNode ans = buildSortedTree(nums);
        StringBuffer sb = printer(ans);
        System.out.println(sb);
    }

    private static StringBuffer printer(TreeNode ans) {
        StringBuffer sb = new StringBuffer();
        List<Integer> res = new ArrayList<>();
        levelOrder(res, ans);
        sb.append('[');
        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i));
            if (i < res.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb;
    }

    private static void levelOrder(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            res.add(cur.val);
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
    }

    //中序遍历 先取数组中间点为根 然后分治左右子数组
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
