package Lesson_3;


/**
 * List
 */
public class List {
    Node head;
    Node tail;

    public void push(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }

    public Integer pick() {
        Integer result = null;
        if (tail != null) {
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
        } return result;
    }
    public Integer pop() {
        Integer result = null;
        if (head != null) {
            result = head.value;
            head = head.next;
        } return result;
    }

    public void revert() {
        if (head != null && head.next != null) revertR(head.next, head);
    }
    private void revertR(Node current, Node previous) {
        if (current.next == null) head = current;
        else revertR(current.next, current);
        current.next = previous;
        previous.next = null;
    }
    /**
     * Node
     */
    public class Node {
    
        int value;
        Node next;
        Node previous;
    }
}