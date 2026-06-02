package hot100.tree;

import common.TreeNode;
import common.TreeUtils;

public class P_230KtheSmallest {
    private int ans;
    private static int k;
    public static void main(String[] args) {
        Integer[] data = {3,1,4,null,2};
        k = 3;
        TreeNode root = TreeUtils.buildTree(data);
        int ans = findKtheSmallest(root, k);
        System.out.println(ans);
    }

    private static int findKtheSmallest(TreeNode root, int k) {
        P_230KtheSmallest.k = k;
        return dfs(root);
    }

    //中序遍历+ 计数
    private static int dfs(TreeNode root) {
        if (root == null || k <=0){
            return -1;
        }
        int lRes = dfs(root.left); // 左
        if (lRes != -1) { //如果左边找到了就直接返回， 不用走右边
            return lRes;
        }
        if (--k == 0) {
            return root.val;
        }
        return dfs(root.right); //右边
    }
}
