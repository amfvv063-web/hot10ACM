package hot100.tree;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;
import common.TreeUtils;

public class P_94inorderTraversal {

    public static void main(String[] args) {
        Integer[] data = { 1, null, 2, 3 };
        TreeNode root = TreeUtils.buildTree(data);
        List<Integer> ans = midFind(root);
        System.out.println(TreeUtils.formatList(ans));
    }

    private static List<Integer> midFind(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, root);
        return ans;
    }

    private static void dfs(List<Integer> ans, TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(ans, node.left);
        ans.add(node.val);
        dfs(ans, node.right);
    }
}
