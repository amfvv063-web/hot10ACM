package hot100.linkedlist;


public class P_206reverseList {
        static class  ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val, ListNode next){
            this.next = next;
            this.val = val;
        }

        public static void main(String[] args) {
            int[] nums = {1,2,3,4,5};
            ListNode head = createListNode(nums);
            ListNode res = reverseList(head);
            StringBuffer sb = new StringBuffer();
            sb.append('[');
            while (res != null) {
                sb.append(res.val);
                if (res.next != null) {
                    sb.append(',');
                }
                res = res.next;
            }
            sb.append(']');
            System.out.println(sb);
        }
        private static ListNode reverseList(ListNode head) {
            ListNode dummy = new ListNode(0, head);
            ListNode pre = null;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
        private static ListNode createListNode(int[] nums) {
            ListNode head = new ListNode(nums[0]);
            ListNode cur = head;
           for (int i = 1; i < nums.length; i++) {
            ListNode pos = new ListNode(nums[i]);
            cur.next = pos;
            cur = cur.next;
           }
           return head;
        }
        
    }
}
