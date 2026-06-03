package hot100.tree;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;
import common.TreeUtils;

public class P_437pathSum {
    
public static void main(String[] args) {
    Integer[] data = {10,5,-3,3,2,null, 11,3,-2,null,1};
    TreeNode root = TreeUtils.buildTree(data);
    int targetSum = 8;
    int ans = pathFind(root, targetSum);
    System.out.println(ans);
}

private static int pathFind(TreeNode root, int targetSum) {
    Map<Long, Integer> cnt = new HashMap<>();
    cnt.put(0L, 1);
    return dfs(root, 0L, targetSum, cnt);
}

//前缀和  s[right+1] - s[left] = sum(left, right) ->  cur - prev = target -> prev = cur - target
private static int dfs(TreeNode root, long cur, int targetSum, Map<Long, Integer> cnt) {
    if (root == null) {
        return 0;
    }
    cur += root.val;
    //cur - sum 统计的是起点的个数
    int ans = cnt.getOrDefault(cur - targetSum, 0);
    cnt.merge(cur, 1, Integer::sum);
    ans += dfs(root.left, cur, targetSum, cnt);
    ans += dfs(root.right, cur, targetSum, cnt);

    //遍历完的叶子节点返回时 要注销该节点
    cnt.merge(cur, -1, Integer::sum);
    return ans;
}
}
