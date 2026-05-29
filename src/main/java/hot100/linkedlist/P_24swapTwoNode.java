package hot100.linkedlist;

import common.ListNode;

public class P_24swapTwoNode {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int k = 2;
        ListNode head = buildList(nums);
        ListNode ans = swapNode(head, k);
        StringBuffer sb = print(ans);
        System.out.println(sb);
    }

    private static ListNode swapNode(ListNode head, int k ) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy.next;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        cur = head;
        ListNode dum = dummy;
        while (n>=k) {
            n -=k;
            ListNode pre = null;
            for (int i = 0; i < k; i++) {
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            //要一直更新tail节点
            ListNode tail = dum.next;
            tail.next = cur;
            dum.next = pre;
            //把dum 更新为下一组反转链表的哨兵节点
            dum = tail;
        }
        return dummy.next;

    }

    private static StringBuffer print(ListNode ans) {
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        while (ans != null) {
            sb.append(ans.val);
            if (ans.next != null)
                sb.append(',');
            ans = ans.next;
        }
        sb.append(']');
        return sb;
    }

    private static ListNode buildList(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode next = new ListNode(nums[i]);
            cur.next = next;
            cur = cur.next;
        }
        return head;
    }
}
