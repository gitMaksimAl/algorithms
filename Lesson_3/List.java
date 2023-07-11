package Lesson_3;


/**
 * List
 */
public class List {
    Node head;
    Node tail;

    public void add(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void add(int value, Node node) {
        Node next = node.next;
        Node currentNode = new Node();
        currentNode.value = value;
        node.next = currentNode;
        currentNode.previous = node;
        if (next == null) tail = currentNode;
        else {
            next.previous = currentNode;
            currentNode.next = next;
        }
    }

    public void del(Node node) {
        Node previous = node.previous;
        Node next = node.next;
        if (previous == null) {
            next.previous = null;
            head = next;
        } else {
            if (next == null) {
                previous.next = null;
                tail = previous;
            } else {
                previous.next = next;
                next.previous = previous;
            }
        }
    }

    public void revert() {
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.previous = next;
            currentNode.next = previous;
            if (previous == null) tail = currentNode;
            if (next == null) head = currentNode;
            currentNode = next;
        }
    }

    public Node find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) return currentNode;
            currentNode = currentNode.next;
        }
        return null;
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