package hot100.tree;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;
import common.TreeUtils;

public class P_114flatten {

    public static void main(String[] args) {
        Integer[] data = { 1, 2, 5, 3, 4, null, 6 };
        TreeNode root = TreeUtils.buildTree(data);
        List<Integer> seq = tranLinks(root);
        TreeNode res = buildRightSkew(seq);
        System.out.println(TreeUtils.printerWithNull(res));
    }

    /** 按前序序列建一条只向右的链，用于本地查看展平结果 */
    private static TreeNode buildRightSkew(List<Integer> vals) {
        if (vals.isEmpty()) {
            return null;
        }
        TreeNode head = new TreeNode(vals.get(0));
        TreeNode cur = head;
        for (int i = 1; i < vals.size(); i++) {
            cur.right = new TreeNode(vals.get(i));
            cur = cur.right;
        }
        return head;
    }

    private static List<Integer> tranLinks(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private static void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        dfs(root.left, ans);
        dfs(root.right, ans);
    }
}
