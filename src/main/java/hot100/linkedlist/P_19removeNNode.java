package hot100.linkedlist;

import common.ListNode;

public class P_19removeNNode {
public static void main(String[] args) {
    int[] nums = {1,2,3,4,5};
    int n = 2;
    ListNode head = buildList(nums);
    ListNode ans = removeNnode(head, n);
    StringBuffer sb = print(ans);
    System.out.println(sb);
}
private static ListNode removeNnode(ListNode head, int n) {
    int m = 0;
    ListNode cur = head;
    while (cur != null) {
        cur = cur.next;
        m++;
    }
    int k = m - n-1;
    cur = head;
    while (k>0) {
        cur = cur.next;
        k--;
    }
    ListNode nxt = cur.next.next;
    cur.next = nxt;
    return head;

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
