package hot100.linkedlist;

import common.ListNode;

public class P_148sortList {

    public static void main(String[] args) {
        int[] nums = {4,2,1,3};
        ListNode head = buildList(nums);
        ListNode ans = sortList(head);
        StringBuffer sb = print(ans);
        System.out.println(sb);
    }

    //分治+排序  先递归找中间节点找到最小 然后排序链
    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head2 = midNode(head);
        head = sortList(head);
        head2 = sortList(head2);
        return mergeList(head, head2);
    }


    private static ListNode mergeList(ListNode list, ListNode list1) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null && list != null) {
            if (list1.val < list.val) {
                cur.next = list1;
                 list1= list1.next;
            }else{
                cur.next = list;
                list = list.next;    
            }
            cur =cur.next;
        }
            if (list != null) {
                cur.next = list;
            }else{
                cur.next = list1;
            }
            return dummy.next;
        }

    private static ListNode midNode(ListNode head) {
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
        
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
