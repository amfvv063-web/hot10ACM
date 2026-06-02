package hot100.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import common.TreeNode;
import common.TreeUtils;

public class P_102leverOrder {

    public static void main(String[] args) {
        Integer[] data = { 3, 9, 20, null, null, 15, 7 };
        TreeNode root = TreeUtils.buildTree(data);
        List<List<Integer>> ans = leverOder(root);
        StringBuffer sb = printer(ans);
        System.out.println(sb);
    }

    private static StringBuffer printer(List<List<Integer>> ans) {
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        for (List<Integer> res : ans) {
            sb.append('[');
            for (int i = 0; i < res.size(); i++) {
                sb.append(res.get(i));
                if(i<res.size()-1) sb.append(',');
            }
            sb.append(']'); 
            sb.append(' ');
        }
        return sb;
    }

    private static List<List<Integer>> leverOder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> res = new ArrayList<>(n);
            while (n > 0) {
                TreeNode cur = q.poll();
                res.add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);

                }
                if (cur.right != null) {
                    q.offer(cur.right);

                }
                n--;
            }
            ans.add(res);

        }
        return ans;
    }
}
