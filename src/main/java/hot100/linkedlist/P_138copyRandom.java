package hot100.linkedlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_138copyRandom {
    static class  Node {
        int val;
        Node next;
        Node random;
    public Node(int val){
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
    }
    public static void main(String[] args) {
        int[] vals = { 7, 13, 11, 10, 1 };
        int[] randomIdx = { -1, 0, 4, 2, 0 }; 
        Node head = buildRandomList(vals, randomIdx);
        Node copy = copyRandomList1(head); 
        printRandomList(copy);
    }

    //先用哈希表记录复制节点， 再遍历map把next和random加进去
    private static Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur!= null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur!= null) {
            Node copy = map.get(cur);
            copy.next = (cur.next!= null)? map.get(cur.next): null;
            copy.random = (cur.random != null) ?map.get(cur.random):null;
            cur = cur.next;
        }
        return map.get(head);
        
    }

    //交错插入 先在每个结点后面插入副本 再设置节点的next和random
    private static Node copyRandomList1(Node head){
        Node cur = head;
        //复制每个节点， 把新节点直接原节点的后面
        while (cur != null) {
            cur.next = new Node(cur.val, cur.next);
            cur = cur.next.next;
        }
        cur = head;
        //遍历交错链表中的原链表节点
        while (cur != null) {
            if (cur.random != null) {
                //复制节点的random 连接 原节点的random节点的副本
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;

        //拆链表
        Node dummy = new Node(0 );
        Node pre = dummy;
        while (cur!= null) {
            Node copy = cur.next;
            pre.next = copy;
            pre = pre.next;
            cur = cur.next.next;
        }
        return dummy.next;



    }

    /** randomIdx[i] = j 表示 nodes[i].random = nodes[j]；-1 表示 null */
private static Node buildRandomList(int[] vals, int[] randomIdx) {
    int n = vals.length;
    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) {
        nodes[i] = new Node(vals[i]);
    }
    // 1. 先连 next
    for (int i = 0; i < n - 1; i++) {
        nodes[i].next = nodes[i + 1];
    }
    // 2. 再连 random（必须指向已创建的 nodes[j]，不能 new 新结点）
    for (int i = 0; i < n; i++) {
        if (randomIdx[i] >= 0) {
            nodes[i].random = nodes[randomIdx[i]];
        }
    }
    return nodes[0];
}
private static void printRandomList(Node head) {
    Node cur = head;
    while (cur != null) {
        int r = (cur.random == null) ? -1 : cur.random.val;
        System.out.println(cur.val + " -> random: " + r);
        cur = cur.next;
    }
}
}
