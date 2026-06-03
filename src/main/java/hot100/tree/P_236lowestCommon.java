package hot100.tree;

import common.TreeNode;
import common.TreeUtils;

public class P_236lowestCommon {

    public static void main(String[] args) {
        Integer[] data = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
        int p = 5;
        int q = 1;
        TreeNode root = TreeUtils.buildTree(data);
        Integer ans = lowestFind(root, p, q);
        System.out.println(ans);
    }

    //后序遍历， 先找root的左右根, 1.左右都能找到 返回root 2.左找到,右找不到， 返回左返回值 3.右找到，左找不到返回右返回值
    private static Integer lowestFind(TreeNode root, int p, int q) {
        //截止条件 如果找到p/q的话，就返回该root 如果q/p在该p/q的子树， 那公共祖先肯定是这个
        if (root == null) {
            return null;
        }
        if (root.val == p || root.val == q) {
            return root.val;
        }
        Integer left = lowestFind(root.left, p, q);
        Integer right = lowestFind(root.right, p, q);

        if (left != null && right != null) {
            return root.val;
        }
        return left != null ? left : right;
    }
}
