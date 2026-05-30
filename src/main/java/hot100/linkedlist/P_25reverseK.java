package hot100.linkedlist;

import common.ListNode;

public class P_25reverseK {
public static void main(String[] args) {
    int[] nums = {1,2,3,4,5};
    int k = 3;
    ListNode head = buildList(nums);
    ListNode ans = reverseK(head, k);
    StringBuffer sb = print(ans);
    System.out.println(sb);
}

private static ListNode reverseK(ListNode head, int k) {
    int n = 0;
    ListNode cur = head;
    while (cur!= null) {
        n++;
        cur = cur.next;
    }
    ListNode dummy = new ListNode(0, head);
    ListNode dum = dummy;
    cur = head;
    while (n>=k) {
        n -= k;
        ListNode pre = null;
        for (int i = 0; i < k; i++) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        ListNode tail = dum.next;
        dum.next = pre;
        tail.next = cur;
        dum = tail;
    }
    
    return dummy.next;
    
}

private static ListNode buildList(int[] nums) {
    ListNode head = new ListNode(nums[0]);
    ListNode pre = head;
    for (int i = 1 ; i < nums.length; i++) {
        ListNode cur = new ListNode(nums[i]);
        head.next = cur;
        head = cur;
    }
    return pre;
}

private static StringBuffer print(ListNode ans) {
    StringBuffer sb = new StringBuffer();
    sb.append('[');
    while (ans != null) {
     sb.append(ans.val);
     if(ans.next!=null) sb.append(',');
     ans = ans.next;
    }
    sb.append(']');
    return sb;
 }
}
