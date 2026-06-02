package hot100.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import common.TreeNode;
import common.TreeUtils;

public class P_199rightSideView {
public static void main(String[] args) {
    Integer[] data = {1,2,3,null,5,null,4};
    TreeNode root = TreeUtils.buildTree(data);
    List<Integer> ans  = rightView(root);
    StringBuffer sb = TreeUtils.formatList(ans);
    System.out.println(sb);
}

//BFS层序 找最后一个
private static List<Integer> rightView(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> q = new ArrayDeque<>();
    q.offer(root);
    while (!q.isEmpty()) {
        int size = q.size();
        while (size>0) {
        TreeNode cur = q.poll();
        if (cur.left!= null) {
            q.offer(cur.left);
        }
        if (cur.right!= null) {
            q.offer(cur.right);
        }
        if (size == 1) {
            ans.add(cur.val);
        }
        size--;
        }
    }
    return ans;
    
}

//深度+ 前序 根+先右后左
private static List<Integer> rightView1(TreeNode root){
List<Integer> ans = new ArrayList<>();
int depth = 0;
dfs(root, ans,depth );
return ans;
}

private static void dfs(TreeNode root, List<Integer> ans, int depth) {
    if (root == null) {
        return;
    }
    if (depth == ans.size()) {
        ans.add(root.val);
    }
    dfs(root.right, ans, depth+1);
    dfs(root.left, ans, depth+1);
}

}
