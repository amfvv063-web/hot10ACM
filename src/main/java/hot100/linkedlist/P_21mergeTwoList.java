package hot100.linkedlist;

import common.ListNode;

public class P_21mergeTwoList {
    public static void main(String[] args) {
        int[] nums1 = {1,2,4};
        int[] nums2 = {1,3,4};
        ListNode head1 = buildList(nums1);
        ListNode head2 = buildList(nums2);
        ListNode ans = merageList(head1, head2);
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        while (ans != null) {
            sb.append(ans.val);
            if (ans.next != null) {
                sb.append(',');
            }
            ans = ans.next;
        }
        sb.append(']');
        System.out.println(sb);

    }
    private static ListNode merageList(ListNode head1, ListNode head2) {
        ListNode pos1 = head1;
        ListNode pos2 = head2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (pos1!= null &&  pos2!= null) {
            if (pos1.val <= pos2.val) {
                cur.next = pos1;
                pos1 = pos1.next;
            }else{
                cur.next = pos2;
                pos2 = pos2.next;
            }
            cur = cur.next;
        }
        if (pos1 == null) {
            cur.next = pos2;
        }else{
            cur.next = pos1;
        }

        return dummy.next;
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
