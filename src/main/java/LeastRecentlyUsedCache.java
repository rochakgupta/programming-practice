import common.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LeastRecentlyUsedCache {

    private int capacity;

    private Map<Integer, ListNode> map;

    private ListNode head;

    public LeastRecentlyUsedCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        int value = -1;
        ListNode node = map.get(key);
        if (node != null) {
            value = node.getValue();
            moveToFront(node);
        }
        return value;
    }

    private void moveToFront(ListNode node) {
        if (node != head) {
            link(node.getPrev(), node.getNext());
            makeHead(node);
        }
    }

    private void link(ListNode prev, ListNode next) {
        if (prev != null) {
            prev.setNext(next);
        }
        if (next != null) {
            next.setPrev(prev);
        }
    }

    private void makeHead(ListNode node) {
        if (head == null) {
            link(node, node);
        } else {
            link(head.getPrev(), node);
            link(node, head);
        }
        head = node;
    }

    public void put(int key, int value) {
        ListNode node = map.get(key);
        if (node == null) {
            if (map.size() == capacity) {
                removeLast();
            }
            node = new ListNode(key, value);
            map.put(key, node);
            makeHead(node);
        } else {
            node.setValue(value);
            moveToFront(node);
        }
    }

    private void removeLast() {
        ListNode tail = head.getPrev();
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
            ListNode curr = head;
            do {
                cache.add(new Pair<>(curr.getKey(), curr.getValue()));
                curr = curr.getNext();
            } while (curr != head);
        }
        return cache;
    }

    public static class ListNode {

        private int key;

        private int value;

        private ListNode prev;

        private ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public ListNode getPrev() {
            return prev;
        }

        public void setPrev(ListNode prev) {
            this.prev = prev;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}