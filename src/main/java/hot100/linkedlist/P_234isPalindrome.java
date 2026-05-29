package hot100.linkedlist;

public class P_234isPalindrome {
    static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(){};
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
        // 1 2 3 2 1
    }
    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        ListNode head = buildList(nums);
        boolean ans = isPalind(head);
        System.out.println(ans);
    }
    private static boolean isPalind(ListNode head) {
        int m = 0;
        ListNode cur = head;
        while (cur!= null) {
            cur = cur.next;
            m++;
        }
        m /= 2;
        cur = head;
        while (m > 0) {
            cur = cur.next;
            m--;
        }

        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        while (pre!= null) {
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;

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
