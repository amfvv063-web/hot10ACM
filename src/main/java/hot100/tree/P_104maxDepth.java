package hot100.tree;

import common.TreeNode;
import common.TreeUtils;

public class P_104maxDepth {

    public static void main(String[] args) {
        Integer[] nums = { 3, 9, 20, null, null, 15, 7 };
        TreeNode root = TreeUtils.buildTree(nums);
        System.out.println(maxDepth(root));
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
