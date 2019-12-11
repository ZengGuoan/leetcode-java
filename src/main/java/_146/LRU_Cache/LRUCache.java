package _146.LRU_Cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, Node> valueMap;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.valueMap = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key) {
        Node node = valueMap.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (!valueMap.containsKey(key)) {
            if (valueMap.size() == capacity) {
                valueMap.remove(tail.pre.key);
                removeNode(tail.pre);
            }
            Node node = new Node();
            node.key = key;
            node.value = value;
            addNode(node);
            valueMap.put(key, node);
        } else {
            Node node = valueMap.get(key);
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 注意点：要先删掉当前的node，再添加node，防止node指向自己
     *
     * @param node
     */
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addNode(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    class Node {
        int key;
        int value;
        Node pre;
        Node next;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 10 /* 缓存容量 */ );
        cache.get(10);
        cache.put(10, 13);
        cache.put(3, 17);
        cache.put(6, 11);
        cache.put(10, 5);
        cache.put(9, 10);
        cache.get(13);
        cache.put(2, 19);
        cache.get(2);
        cache.get(3);
        cache.put(5, 25);
        cache.get(8);
        cache.put(9, 22);
        cache.put(5, 5);
        cache.put(1, 30);
        cache.get(11);
        cache.put(9, 12);
        cache.get(7);
        cache.get(5);
        cache.get(8);
        cache.get(9);
        cache.put(4, 30);
        cache.put(9, 3);
        cache.get(9);
        cache.get(10);
        cache.get(10);
        cache.put(6, 14);
        cache.put(3, 1);
        cache.get(3);
        cache.put(10, 11);
        cache.get(8);
        cache.put(2, 14);
        cache.get(1);
        cache.get(5);
        cache.get(4);
        cache.put(11, 4);
        cache.put(12, 24);
        cache.put(5, 18);
        cache.get(13);
        cache.put(7, 23);
        cache.get(8);
        cache.get(12);
        cache.put(3, 27);
        cache.put(2, 12);
        cache.get(5);
        cache.put(2, 9);
        cache.put(13, 4);
        cache.put(8, 18);
        cache.put(1, 7);
        cache.get(6);
        cache.put(9, 29);
        cache.put(8, 21);
        cache.get(5);
        cache.put(6, 30);
        cache.put(1, 12);
        cache.get(10);
        cache.put(4, 15);
        cache.put(7, 22);
        cache.put(11, 26);
        cache.put(8, 17);
        cache.put(9, 29);
        cache.get(5);
        cache.put(3, 4);
        cache.put(11, 30);
        cache.get(12);
        cache.put(4, 29);
        cache.get(3);
        cache.get(9);
        cache.get(6);
        cache.put(3, 4);
        cache.get(1);
        cache.get(10);
        cache.put(3, 29);
        cache.put(10, 28);
        cache.put(1, 20);
        cache.put(11, 13);
        cache.get(3);
        cache.put(3, 12);
        cache.put(3, 8);
        cache.put(10, 9);
        cache.put(3, 26);
        cache.get(8);
        cache.get(7);
        cache.get(5);
        cache.put(13, 17);
        cache.put(2, 27);
        cache.put(11, 15);
        cache.get(12);
        cache.put(9, 19);
        cache.put(2, 15);
        cache.put(3, 16);
        cache.get(1);
        cache.put(12, 17);
        cache.put(9, 1);
        cache.put(6, 19);
        cache.get(4);
        cache.get(5);
        cache.get(5);
        cache.put(8, 1);
        cache.put(11, 7);
        cache.put(5, 2);
        cache.put(9, 28);
        cache.get(1);
        cache.put(2, 2);
        cache.put(7, 4);
        cache.put(4, 22);
        cache.put(7, 24);
        cache.put(9, 26);
        cache.put(13, 28);
        cache.put(11, 26);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */