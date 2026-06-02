package hot100.tree;

import common.TreeNode;
import common.TreeUtils;

public class P_226invertTree {

    public static void main(String[] args) {
        Integer[] data = { 4, 2, 7, 1, 3, 6, 9 };
        TreeNode root = TreeUtils.buildTree(data);
        TreeNode ans = invertTree(root);
        System.out.println(TreeUtils.printer(ans));
    }

    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        return root;
    }
}
