package hot100.tree;

import common.TreeNode;
import common.TreeUtils;

public class P_543DofTree {

    private static int ans;

    public static void main(String[] args) {
        Integer[] data = { 1, 2, 3, 4, 5 };
        TreeNode root = TreeUtils.buildTree(data);
        System.out.println(maxDiamer(root));
    }

    private static int maxDiamer(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int len = dfs(node.left);
        int ren = dfs(node.right);
        ans = Math.max(ans, len + ren);
        return Math.max(len, ren) + 1;
    }
}
