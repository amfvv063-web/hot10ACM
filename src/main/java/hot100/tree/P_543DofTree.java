package hot100.tree;

import java.util.ArrayDeque;
import java.util.Deque;

import common.TreeNode;

public class P_543DofTree {
    private static int ans;
    public static void main(String[] args) {
        Integer[] data = {1,2,3,4,5};
        TreeNode root = buildTree(data);
        maxDiamer(root);
        System.out.println(ans);
    }

    private static int maxDiamer(TreeNode root) {
        dfs(root);
        return ans;
    }

    private  static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int len = dfs(node.left);
        int ren = dfs(node.right);
        // 如果左儿子 右儿子都存在 ans = 2 正好和层数数对上 不用-1
        ans = Math.max(ans, len + ren);
        return Math.max(len, ren) + 1;
        
    }

    private static TreeNode buildTree(Integer[] data) {
        TreeNode root = new TreeNode(data[0]);
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int i = 1;
        while (i< data.length) {
            TreeNode cur = q.poll();
            if (i<data.length && data[i] != null) {
                cur.left = new TreeNode(data[i]);
                q.offer(cur.left);
            }
            i++;
            if (i<data.length && data[i] != null) {
                cur.right = new TreeNode(data[i]);
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }
}
