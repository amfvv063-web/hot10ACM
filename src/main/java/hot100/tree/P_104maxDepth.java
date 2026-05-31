package hot100.tree;

import java.util.ArrayDeque;
import java.util.Deque;

import common.TreeNode;

public class P_104maxDepth {
    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = buildTree(nums);
        int ans = maxDepth(root);
        System.out.println(ans);
    }

    //DFS 遍历求长度
    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private static TreeNode buildTree(Integer[] nums) {
        TreeNode root  = new TreeNode(nums[0]);
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int i = 1;
        while (i < nums.length) {
            TreeNode cur = q.poll();
            //左孩子
            if (i < nums.length && nums[i] != null) {
                cur.left = new TreeNode(nums[i]);
                q.offer(cur.left);
            }
            i++;

            //右孩子
            if (i<nums.length && nums[i] != null) {
                cur.right = new TreeNode(nums[i]);
                q.offer(cur.right);
            }
            i++;
        }
        return root;
        
    }
}
