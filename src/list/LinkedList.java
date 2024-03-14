package list;

import java.util.Scanner;

public class LinkedList<T> implements SimpleList<T> {

    private ListNode<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }


    public int size() {
        return size;
    }

    public void clear() {
        this.head = null;
        this.size = 0;

    }


    public String insertAtNext(T data) {
        if (find (data)>=0){
            return "this password has been tried on your " + (find(data)+1) + " attempt";

        }

        ListNode<T> d = new ListNode<>(data);
        if (size == 0) {
            d.next = head;
            head = d;
            size++;
            return "this is your "+ (1)+ " attempt";
        } else {

            ListNode<T> temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }
                temp.next = d;
                size++;
                return "this is your " + (size) + " attempt";
            }

        }


    public int find(T data) {
        ListNode<T> temp = head;

        for (int i = 0; i < size; i++) {
            if (temp.getData().equals(data)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;

    }

    public String toString() {
        if (size == 0) {
            return "no attempts made";
        }
        String result = "";
        ListNode temp = head;

        for (int i = 0; i < size; i++) {
            result += "attempt number" + (i + 1) + " = " + temp.getData() + "\n";
            temp = temp.next;

        }
        return result;


    }


}
