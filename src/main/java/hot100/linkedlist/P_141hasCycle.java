package hot100.linkedlist;

import common.ListNode;

public class P_141hasCycle {
    public static void main(String[] args) {
        int[] nums = {3,2,0,-4};
        int pos = 1;
        ListNode head = buildChain(nums, pos);
        boolean ans = isCycle(head);
        System.out.println(ans);
    }

    private static boolean isCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null&& fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    private static ListNode buildChain(int[] nums, int pos) {
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        
        for (int i = 1; i < nums.length; i++) {
            ListNode nxt = new ListNode(nums[i]);
            cur.next = nxt;
            cur = cur.next;
        }
        if (pos>=0) {
            ListNode nxt = head;
            while (pos > 0) {
                nxt = nxt.next;
                pos--;
            }
            cur.next = nxt;
        }
        return head;
    }
}
