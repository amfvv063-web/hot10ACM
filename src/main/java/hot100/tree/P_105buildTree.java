package hot100.tree;

import common.TreeNode;
import common.TreeUtils;

public class P_105buildTree {
public static void main(String[] args) {
    int[] pre = { 3,9, 20, 15,7};
    int[] mid = {9,3,15,20,7};
    TreeNode root = buildTree(pre, mid);
    StringBuffer sb = TreeUtils.printerWithNull(root);
    System.out.println(sb);
}

private static TreeNode buildTree(int[] pre, int[] mid) {
   return dfs(pre, 0, pre.length -1 , mid, 0, mid.length-1);
}

//pre 根 左 右   mid 左 根 右
private static TreeNode dfs(int[] pre, int preL, int preR, int[] mid, int midL, int midR) {
    if (preL > preR) {
        return null;
    }
    int rootVal = pre[preL];
    int k = midL;
    while (rootVal != mid[k]) {
        k++;
    }
    int leftSize = k - midL;
    TreeNode root = new TreeNode(rootVal);
    root.left = dfs(pre, preL+1, preL+leftSize, mid, midL, k-1);
    root.right = dfs(pre, preL+leftSize+1, preR, mid, k+1, midR);
    return root;

}
}
