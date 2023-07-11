package Lesson_3;


/**
 * List
 */
public class List {
    Node head;

    public void push(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    public Integer pop() {
        Integer result = null;
        if (head != null) {
            result = head.value;
            head = head.next;
        } return result;
    }

    public void revertR() {
        if (head == null && head.next != null) revertR(head.next, head);
    }
    private void revertR(Node current, Node previous) {
        if (current.next == null) head = current;
        else revertR(current.next, current)
        current.next = previous;
        previous.next = null;
    }
    /**
     * Node
     */
    public class Node {
    
        int value;
        Node next;
    }
}