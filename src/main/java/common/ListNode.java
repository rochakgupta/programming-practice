package common;

public class ListNode<T> {

    private T data;

    private ListNode<T> prev;

    private ListNode<T> next;

    private ListNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public ListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(ListNode<T> prev) {
        this.prev = prev;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}
