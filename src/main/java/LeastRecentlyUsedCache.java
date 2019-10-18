import common.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LeastRecentlyUsedCache {

    private int capacity;

    private Map<Integer, LinkedListNode> map;

    private LinkedListNode head;

    public LeastRecentlyUsedCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        int value = -1;
        LinkedListNode node = map.get(key);
        if (node != null) {
            value = node.getValue();
            moveToFront(node);
        }
        return value;
    }

    private void moveToFront(LinkedListNode node) {
        if (node != head) {
            link(node.getPrev(), node.getNext());
            makeHead(node);
        }
    }

    private void link(LinkedListNode prev, LinkedListNode next) {
        if (prev != null) {
            prev.setNext(next);
        }
        if (next != null) {
            next.setPrev(prev);
        }
    }

    private void makeHead(LinkedListNode node) {
        if (head == null) {
            link(node, node);
        } else {
            link(head.getPrev(), node);
            link(node, head);
        }
        head = node;
    }

    public void put(int key, int value) {
        LinkedListNode node = map.get(key);
        if (node == null) {
            if (map.size() == capacity) {
                removeLast();
            }
            node = LinkedListNode.with(key, value);
            map.put(key, node);
            makeHead(node);
        } else {
            node.setValue(value);
            moveToFront(node);
        }
    }

    private void removeLast() {
        LinkedListNode tail = head.getPrev();
        map.remove(tail.getKey());
        if (map.isEmpty()) {
            head = null;
        } else {
            link(tail.getPrev(), tail.getNext());
        }
    }

    public List<Pair<Integer, Integer>> getCache() {
        List<Pair<Integer, Integer>> cache = new ArrayList<>();
        if (head != null) {
            LinkedListNode curr = head;
            do {
                cache.add(new Pair<>(curr.getKey(), curr.getValue()));
                curr = curr.getNext();
            } while (curr != head);
        }
        return cache;
    }

    public static class LinkedListNode {
        private int key;

        private int value;

        private LinkedListNode prev;

        private LinkedListNode next;

        private LinkedListNode() {
        }

        public static LinkedListNode with(int key, int value) {
            LinkedListNode node = new LinkedListNode();
            node.setKey(key);
            node.setValue(value);
            return node;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public LinkedListNode getPrev() {
            return prev;
        }

        public void setPrev(LinkedListNode prev) {
            this.prev = prev;
        }

        public LinkedListNode getNext() {
            return next;
        }

        public void setNext(LinkedListNode next) {
            this.next = next;
        }
    }
}