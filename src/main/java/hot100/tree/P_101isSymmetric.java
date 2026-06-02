package hot100.tree;

import common.TreeNode;
import common.TreeUtils;

public class P_101isSymmetric {

    public static void main(String[] args) {
        Integer[] data = { 1, 2, 2, 3, 4, 4, 3 };
        TreeNode root = TreeUtils.buildTree(data);
        System.out.println(isSymmetric(root));
    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
}
