package hot100.tree;

import java.util.ArrayDeque;
import java.util.Deque;

import common.TreeNode;

public class P_101isSymmetric {
public static void main(String[] args) {
    Integer[] data = {1,2,2,3,4,4,3};
    TreeNode root = buildTree(data);
    boolean ans = isSymmetric(root);
    System.out.println(ans);
}

//直接找根节点的左右儿子
private static boolean isSymmetric(TreeNode root) {
    
    if (root == null) {
        return true;
    }
    
    boolean ans = isMirror(root.left, root.right);
    return ans;
}



private static boolean isMirror(TreeNode a, TreeNode b) {
    if (a == null && b == null) {
        return true;
    }
    if (a == null || b == null) {
        return false;
    }
    if (a.val != b.val) {
        return false;
    }
    return isMirror(a.left, b.right) && isMirror(a.right, b.left);
    
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
