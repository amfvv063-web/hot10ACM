package hot100.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import common.TreeNode;

public class P_226invertTree {
public static void main(String[] args) {
    Integer[] data = {4,2,7,1,3,6,9};

    // BFS层序遍历
    TreeNode root = buildTree(data);

    // 前序处理/后序处理  
    TreeNode ans = invertTree(root);

    //BFS层序遍历 输出
    StringBuffer sb = printer(ans);
    System.out.println(sb);
}

private static TreeNode invertTree(TreeNode root) {
    //根节点左右儿子交换指针
    //自下而上  后序遍历 左右 根处理
    //自上而下 前序遍历 根 左右处理
    if (root == null) {
        return null;
    }
    invertTree(root.left);
    invertTree(root.right);
    TreeNode tmp = root.right;
    root.right = root.left;
    root.left = tmp;
    return root;
}

private static StringBuffer printer(TreeNode ans) {
    StringBuffer sb = new StringBuffer();
    List<Integer> res = new ArrayList<>();
    levelOrder(res, ans);
    sb.append('[');
    for (int i = 0; i < res.size(); i++) {
        sb.append(res.get(i));
        if(i< res.size()-1)sb.append(',');
    }
    sb.append(']');
    return sb;
}

private static void levelOrder(List<Integer> res, TreeNode ans) {
    if (ans == null) {
        return;
    }
    Deque<TreeNode> q = new ArrayDeque<>();
    q.offer(ans);
    while (!q.isEmpty()) {
        TreeNode cur = q.poll();
        res.add(cur.val);
        if (cur.left!=null) {
            q.offer(cur.left);
        }
        if (cur.right!=null) {
            q.offer(cur.right);
        }
    }
}


private static TreeNode buildTree(Integer[] data) {
    TreeNode root = new TreeNode(data[0]);
    int i =1;
    Deque<TreeNode> q = new ArrayDeque<>();
    q.offer(root);
    while (i < data.length) {
        TreeNode cur = q.poll();
        if (i < data.length && data[i] != null) {
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
