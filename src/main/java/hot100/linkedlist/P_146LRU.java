package hot100.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class P_146LRU {
    private class Node {
        int value, key;
        Node next, prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 增加节点 dummy x cur
    // 删除节点 dummy x cur

    private int capacity;
    private final Node dummy = new Node(0, 0);
    private final Map<Integer, Node> ketToMap = new HashMap<>();

    public P_146LRU(int capacity) {
        this.capacity = capacity;
        dummy.next = dummy;
        dummy.prev = dummy;
    }

    // 拿到 key 的 node 放到最上面
    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1: node.value;
    }

    // 放入一个节点 1.如果存在，修改 value 并放到最上面 2.如果没存在，建立节点，放到上面 3.超出容量，把最下面的节点删除
    public void put(int key, int value) {
        //1.如果存在
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            return;
        }
        //2.如果不存在
        node = new Node(key, value);
        ketToMap.put(key, node);
        putFront(node);
        if (ketToMap.size() > capacity) {
            Node backOne = dummy.prev;
            ketToMap.remove(backOne.key);
            remove(backOne);
        }
    }

    //删除一个节点
    private void remove(Node x) {
       Node pre = x.prev;
       Node nxt = x.next;
       pre.next = nxt;
       nxt.prev = pre;
    }

    //添加一个节点
    //先把节点插入dummy后面
    //在调整前后节点的指针
    private Node getNode(int key) {
        if (!ketToMap.containsKey(key)) {
            return null;
        }
        Node node = ketToMap.get(key);
        remove(node);
        putFront(node);
        return node;
    }

    private void putFront(Node node) {
        node.prev = dummy;
        node.next = dummy.next;
        node.prev.next = node;
        node.next.prev = node;
    }

    public static void main(String[] args) {
        P_146LRU cache = new P_146LRU(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
