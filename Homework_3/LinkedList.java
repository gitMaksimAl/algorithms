package Homework_3;


/*
 * Singli linked list simple implementation. You can reverse his.
 */
public class LinkedList <T extends Comparable<T>>{

    /**
     * Node of linked list.
     */
    private Node root = null;
    private int size = 0;

    public void add(T value) {
        if (root == null) {
            root = new Node(value);
            size++;
        } else {
            Node currentNode = root;
            while (currentNode._next != null) currentNode = currentNode._next;
            currentNode._next = new Node(value);
            size++;
        }
    }

    public void swapValue(int index1, int index2) {
        Node node1 = getNode(index1);
        Node node2 = getNode(index2);
        T temp = node1._value;
        node1._value = node2._value;
        node2._value = temp;
    }

    public Node getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node curNode = root;
        for (int i = 0; i < index; i++) curNode = curNode._next;
        return curNode;
    }

    public void revert() {
        if (root != null && size != 1) revertR(root._next, root);
    }

    private void revertR(Node current, Node previous) {
        if (current._next == null) root = current;
        else revertR(current._next, current);
        current._next = previous;
        previous._next = null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node node;
        if (root != null) {
            node = root;
            for (; node._next != null; node = node._next) {
                builder.append(node._value);
                builder.append(',');
                builder.append(' ');
            }
            builder.append(node._value);
        }
        builder.append(']');
        return builder.toString();
    }

    public class Node {
        private T _value;
        Node _next = null;
        
        Node() {}
        Node(T value) {this._value = value;}
        Node(T value, Node next) {this._value = value; this._next = next;}
    }
}
