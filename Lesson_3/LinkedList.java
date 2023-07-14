package Lesson_3;
import java.lang.Comparable;

public class LinkedList <T extends Comparable<T>>{

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

    public void remove(T value) {
        if (root != null) {
            if (root._value == value) {
            root = root._next;
            size--;
            } else {
                Node curNode = root;
                while (curNode._next != null) {
                    if (curNode._next._value == value) {
                        curNode._next = curNode._next._next;
                        size--;
                        break;
                    } curNode = curNode._next;
                }
            }
        }
    }

/*From lesson
    public boolean remove(int value) {
        if (root == null) return false;
        if (root._value == value) {
            root = root._next;
            size--;
            return true;
        }
        Node curNode = root;
        while (curNode._next != null) {
            if (curNode._next._value == value) {
                curNode._next = curNode._next._next;
                size--;
                return true;
            } curNode = curNode._next;
        }
        return false;
    }
*/

    public void removeAt(int index) {
        if (index == 0) {
            root = root._next;
            size--;
        } else if (index > 0 && index < size) {
            Node curNode = root;
            for (int i = 1; i != index; i++) curNode = curNode._next;
            curNode._next = curNode._next._next;
            size--;
        } else System.err.println("Index out of bound.");
    }

    public T getValue(int index) {
        return getNode(index)._value;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node curNode = root;
        for (int i = 0; i < index; i++) curNode = curNode._next;
        return curNode;

    }

    public void addAt(int index, T value) {
        Node curNode = new Node(value);
        if (index == 0) {
            curNode._next = root;
            root = curNode;
            size++;
        } else {
            Node previousNode = getNode(index - 1);
            curNode._next = previousNode._next;
            previousNode._next = curNode;
            size++;
        }
    }

    public void quickSort() {
        quickSortR(0, size - 1);
    }

    private int quickSort(int start, int end) {
        int left = start;
        int rigth = end;
        T pivot = getValue((left + rigth) / 2);
        while (left <= rigth) {
            while (getValue(left).compareTo(pivot) < 0) left++;
            while (getValue(rigth).compareTo(pivot) > 0) rigth--;
            if (left <= rigth) {
                swapValue(left, rigth);
                left++;
                rigth--;
            }
        }
        return left;
    }

    private void quickSortR(int start, int end) {
        if (start >= end) return;
        int rigthStart = quickSort(start, end);
        quickSortR(start, rigthStart - 1);
        quickSortR(rigthStart, end);
   }

    public int getSize() {return size;}

    public void clear() {root = null; size = 0;}

    public void swapValue(int index1, int index2) {
        Node node1 = getNode(index1);
        Node node2 = getNode(index2);
        T temp = node1._value;
        node1._value = node2._value;
        node2._value = temp;
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

    private class Node {

        T _value;
        Node _next = null;

        Node() {}
        Node(T value) {this._value = value;}
        Node(T value, Node node) {this._value = value; this._next = node;}
    }
}
