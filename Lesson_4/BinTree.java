package Lesson_4;

public class BinTree {
    
    private Node _root;

    public boolean add(int value) {
        if (_root == null) {
            _root = new Node(value);
            _root._color = Color.Black;
            return true;
        }
        if (addNode(_root, value) != null) return true;
        else return false;
    }

    private Node addNode(Node node, int value) {
        if (node._value == value) return null;
        if (node._value > value) {
            if (node._left == null) {
                node._left = new Node(value);
                return node._left;
            } else return addNode(node._left, value);
        } else {
            if (node._rigth == null) {
                node._rigth = new Node(value);
                return node._rigth;
            } else return addNode(node._rigth, value);
        }
    }

    public boolean contains(int value) {
        Node currNode = _root;
        while (currNode != null) {
            if (currNode._value == value) return true;
            if (currNode._value > value) currNode = currNode._left;
            else currNode = currNode._rigth;
        }
        return false;
    }
    /**
     * Node
     */
    public class Node {
    
        private int _value;
        private Node _left;
        private Node _rigth;
        private Color _color;
    
        public Node() {_color = Color.Red;}
        public Node(int value) {this._value = value; this._color = Color.Red;}
    }
    enum Color{Red, Black}
}
