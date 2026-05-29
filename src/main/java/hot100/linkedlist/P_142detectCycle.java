package hot100.linkedlist;

import common.ListNode;

public class P_142detectCycle {
public static void main(String[] args) {
    int[] nums = {3,2,0,-4};
    int pos = 1;
    ListNode head = buildChain(nums, pos);
    ListNode ans = findCycleNode(head);
    System.out.println(ans.val);

    
}

// 数学定理  (head, node) = a  (head,  point) = b   cycle = c
//  slow -> b fast -> 2b  2b - b = kc -> b = kc
//  b - a -> 入环口到相遇点距离 = kc - a  slow 走 a 步 = kc， 走完完整一圈到入环点
private static ListNode findCycleNode(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast!= null && fast.next.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow) {
            while (head != slow) {
                head = head.next;
                slow = slow.next;
            }
            return slow;
        }
    }
    return null;
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
