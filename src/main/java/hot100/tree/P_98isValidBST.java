package hot100.tree;

import common.TreeNode;
import common.TreeUtils;

public class P_98isValidBST {
    private static int pre;
    public static void main(String[] args) {
        Integer[] data = {2,1,3};
        TreeNode root = TreeUtils.buildTree(data);
        boolean ans = isValid(root);
        System.out.println(ans);
    }

    //前序 先做根判断 
    private static boolean isValid(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE ,Integer.MAX_VALUE);
    }

    private static boolean dfs(TreeNode root, int minValue, int maxValue) {
       if (root == null) {
        return true;
       }
       if (root.val<=minValue || root.val >= maxValue) {
        return false;
       }
       return dfs(root.left, minValue, root.val) && dfs(root.right , root.val, maxValue);
    }

    //中序 左 根 右 完成递增
    private static boolean isValid1(TreeNode root){
        pre = Integer.MIN_VALUE;
        return dfs1(root);
    }

    private static boolean dfs1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if(!dfs1(root.left)){
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return dfs1(root.right);
    }
}
