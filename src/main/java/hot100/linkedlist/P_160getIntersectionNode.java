package hot100.linkedlist;

import common.ListNode;

/**
 * LeetCode 160. 相交链表 — 本地输入构造（方式 A：main 写死）
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class P_160getIntersectionNode {

    public static void main(String[] args) {
        // 力扣官方示例：A = [4,1,8,4,5]，B = [5,6,1,8,4,5]，相交结点值为 8
        ListNode[] ab = buildIntersect(
                new int[] { 4, 1 },       // A 独有前缀
                new int[] { 5, 6, 1 },    // B 独有前缀
                new int[] { 8, 4, 5 }     // 公共后缀（两条链后半段是同一串节点）
        );
        ListNode listA = ab[0];
        ListNode listB = ab[1];
        
        ListNode ans = getIntersectition(listA, listB);
        System.out.println(ans.val);

    }

    private static ListNode getIntersectition(ListNode listA, ListNode listB) {
       ListNode A = listA;
       ListNode B = listB;
       while (A != B) {
        A = A != null ? A.next: listB;
        B = B != null ? B.next: listA;
       }
       return A;
    }

    /** 从数组建一条普通单链表，返回头结点。 */
    private static ListNode buildChain(int[] vals) {
        if (vals == null || vals.length == 0) {
            return null;
        }
        ListNode head = new ListNode(vals[0]);
        ListNode cur = head;
        for (int i = 1; i < vals.length; i++) {
            cur.next = new ListNode(vals[i]);
            cur = cur.next;
        }
        return head;
    }

    /**
     * 按力扣题意造「相交」的两条链：先建公共尾巴，再把 A、B 各自前缀的末尾接到同一 tail 上。
     *
     * @return [0]=listA 头，[1]=listB 头
     */
    private static ListNode[] buildIntersect(int[] headA, int[] headB, int[] commonTail) {
        ListNode tail = buildChain(commonTail);
        ListNode a = buildChain(headA);
        ListNode b = buildChain(headB);

        if (a != null) {
            ListNode p = a;
            while (p.next != null) {
                p = p.next;
            }
            p.next = tail; // A 末尾接到公共段
        }
        if (b != null) {
            ListNode q = b;
            while (q.next != null) {
                q = q.next;
            }
            q.next = tail; // B 末尾接到同一公共段（同一引用，才是「相交」）
        }
        return new ListNode[] { a, b };
    }
}
