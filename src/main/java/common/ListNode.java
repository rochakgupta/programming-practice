package common;

public class ListNode {

    private Integer data;

    private ListNode prev;

    private ListNode next;

    private ListNode(Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
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
