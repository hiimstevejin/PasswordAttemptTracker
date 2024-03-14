package list;

public class ListNode<T> {
    private T data;
    protected ListNode<T> next;

    public ListNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }
}
