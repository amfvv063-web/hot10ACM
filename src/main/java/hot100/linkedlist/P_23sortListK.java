package hot100.linkedlist;

import java.util.List;

import common.ListNode;

public class P_23sortListK {
public static void main(String[] args) {
    int[][] nums = {
        {1,4,5},
        {1,3,4},
        {2,6}
    };
    ListNode[] links = new ListNode[nums.length];
    for (int i = 0; i < links.length; i++) {
        links[i] = buildList(nums[i]);
    }
    ListNode ans = mergeKlinks(links);
    StringBuffer sb = print(ans);
    System.out.println(sb);
}

//分治， 递归+升序合并
// 长集合 左右分别分治， 合并链表， 和148题思想一样， 从拆节点变成拆集合；
private static ListNode mergeKlinks(ListNode[] links) {
    return mergeKlink(links, 0, links.length);
}

private static ListNode mergeKlink(ListNode[] links, int i, int j) {
    int m = j - i;
    if (m == 0) {
        return null;
    }
    if (m == 1) {
        return links[i];
    }

    ListNode a = mergeKlink(links, i, i+m/2);
    ListNode b = mergeKlink(links, i+m/2, j);
    return mergeList(a, b);
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
