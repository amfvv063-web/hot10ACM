package hot100.linkedlist;

import common.ListNode;

public class P_2addTwo {
    public static void main(String[] args) {
        int[] nums1 = {9,9,9,9};
        int[] nums2 = {9,9,9,9,9,9,9};
        ListNode head1 = buildList(nums1);
        ListNode head2 = buildList(nums2);
        ListNode ans = addTwo(head1, head2);
        StringBuffer sb = print(ans);
        System.out.println(sb);

    }
    private static ListNode addTwo(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int cont = 0;
       while (head1!= null || head2 != null) {
        int x = head1 == null ? 0: head1.val;
        int y = head2 == null ? 0: head2.val;
        int sum = x+y+cont;
        cont = sum/10;
        int digit = sum%10;
        ListNode nxt = new ListNode(digit);
        cur.next = nxt;
        cur = cur.next;
        if(head1 != null) head1 = head1.next;
        if(head2 != null) head2 = head2.next;
       }
       if (cont != 0) {
        ListNode nxt = new ListNode(cont);
        cur.next = nxt;
        cur = cur.next;
       }
       return dummy.next;
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
