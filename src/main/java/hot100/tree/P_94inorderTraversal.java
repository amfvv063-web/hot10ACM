package hot100.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class P_94inorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode(int val){
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Integer[] data = {1, null, 2, 3};
        TreeNode root = buildTree(data );
        List<Integer> ans = midFind(root);
        StringBuffer sb = printer(ans);
        System.out.println(sb);
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

        dfs(ans, node.left);    //左
        ans.add(node.val);      //根
        dfs(ans, node.right);   //右
    }

    private static StringBuffer printer(List<Integer> ans) {
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i));
            if (i< ans.size()-1)sb.append(',');
        }
        sb.append(']');
        return sb;
    }

    private static TreeNode buildTree(Integer[] data) {
        if (data ==null || data.length == 0|| data[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(data[0]);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int i = 1;
        while (i < data.length) {
            TreeNode cur = q.poll();
            //左孩子
            if (i<data.length && data[i] != null) {
                cur.left = new TreeNode(data[i]);
                q.offer(cur.left);
            }
            i++;
            //右孩子
            if (i<data.length && data[i] != null) {
                cur.right = new TreeNode(data[i]);
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }
}
