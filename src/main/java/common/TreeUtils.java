package common;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 本地练习：层序数组建树 + 层序遍历打印（力扣常见格式）。
 *
 * <p>建树：{@code Integer[]} 层序序列，{@code null} 表示空结点，如 {@code {1,null,2,3}}。
 * <p>打印：{@link #printer(TreeNode)} 输出 {@code [1,2,3]} 单层序（不含 null）。
 * <p>{@link #printerWithNull(TreeNode)} 输出力扣层序格式，如 {@code [1,2,null,3,null,4]}。
 */
public final class TreeUtils {

    private TreeUtils() {}

    /** 力扣层序数组 → 二叉树。空数组或首元素为 null 时返回 null。 */
    public static TreeNode buildTree(Integer[] data) {
        if (data == null || data.length == 0 || data[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(data[0]);
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int i = 1;
        while (i < data.length) {
            TreeNode cur = q.poll();
            if (i < data.length && data[i] != null) {
                cur.left = new TreeNode(data[i]);
                q.offer(cur.left);
            }
            i++;
            if (i < data.length && data[i] != null) {
                cur.right = new TreeNode(data[i]);
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    /** 层序遍历，只收集非 null 结点值。 */
    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            res.add(cur.val);
            if (cur.left!= null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
        return res;
    }

    /** 层序结果格式化为 {@code [1,2,3]}。 */
    public static StringBuffer printer(TreeNode root) {
        return formatList(levelOrder(root));
    }

    /**
     * 力扣层序序列化（含 null），与 {@link #buildTree(Integer[])} 互逆。
     * 例如右斜树：{@code [1,2,null,3,null,4,null,5,null,6]}。
     */
    public static List<Integer> levelOrderWithNull(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                res.add(null);
            } else {
                res.add(cur.val);
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        while (!res.isEmpty() && res.get(res.size() - 1) == null) {
            res.remove(res.size() - 1);
        }
        return res;
    }

    /** 层序含 null，格式 {@code [1,2,null,3]}。 */
    public static StringBuffer printerWithNull(TreeNode root) {
        return formatListWithNull(levelOrderWithNull(root));
    }

    /** 整数列表格式化为 {@code [1,2,3]}（不含 null 元素）。 */
    public static StringBuffer formatList(List<Integer> vals) {
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        for (int i = 0; i < vals.size(); i++) {
            sb.append(vals.get(i));
            if (i < vals.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb;
    }

    /** 整数列表格式化为 {@code [1,2,null,3]}，元素可为 null。 */
    public static StringBuffer formatListWithNull(List<Integer> vals) {
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        for (int i = 0; i < vals.size(); i++) {
            Integer v = vals.get(i);
            if (v == null) {
                sb.append("null");
            } else {
                sb.append(v);
            }
            if (i < vals.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb;
    }
}
