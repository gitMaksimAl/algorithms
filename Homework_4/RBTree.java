package Homework_4;

import java.util.ArrayList;
import java.util.List;

public class RBTree<T extends Comparable<T>> {
    
    private RBNode _root;

    public boolean contains(T value) {
        RBNode currentNode = _root;
        while (currentNode != null) {
            if (currentNode._value.compareTo(value) == 0) return true;
            if (currentNode._value.compareTo(value) > 0)
                currentNode = currentNode._left;
            else currentNode = currentNode._right;
        }
        return false;
    }

    public void add(T value) {
        if (_root == null) {
            _root = new RBNode(value);
            _root._color = Color.Black;
        }
        else if (addNode(_root, value) == null)
            System.err.println("Can`t add this value.");
    }

    private RBNode addNode(RBNode node, T value) {
        if (node._value.compareTo(value) == 0) return null;
        if (node._value.compareTo(value) > 0) {
            if (node._left != null) {
                addNode(node._left, value);
                node._left = balance(node._left);
                return node._left;
            } else {
                node._left = new RBNode(value);
                node._left._color = Color.Red;
                return node._left;
            }
        } else {
            if (node._right != null) {
                addNode(node._right, value);
                node._right = balance(node._right);
                return node._right;
            } else {
                node._right = new RBNode(value);
                node._right._color = Color.Red;
                return node._right;
            }
        }
    }

    public RBNode balance(RBNode start) {
        RBNode balancedNode = start;
        boolean needBalance;
        do {
            needBalance = false;
            if ((balancedNode._right != null && balancedNode._right._color == Color.Red)
                && (balancedNode._left != null && balancedNode._left._color == Color.Black)) {
                needBalance = true;
                balancedNode = leftSwap(balancedNode);
            }
            if ((balancedNode._left != null && balancedNode._left._color == Color.Red)
                && (balancedNode._left._left != null && balancedNode._left._left._color == Color.Red)) {
                needBalance = true;
                balancedNode = rightSwap(balancedNode);
            }
            if ((balancedNode._left != null && balancedNode._left._color == Color.Red)
                && (balancedNode._right != null && balancedNode._right._color == Color.Red)) {
                needBalance = true;
                colorSwap(balancedNode);
            }
        } while (needBalance);
        return balancedNode;

    }

    private RBNode leftSwap(RBNode grandFather){
        RBNode father = grandFather._right;
        RBNode between = father._left;
        father._left = grandFather;
        grandFather._right = between;
        father._color = grandFather._color;
        grandFather._color = Color.Red;
        return father;
    }

    private RBNode rightSwap(RBNode grandFather){
        RBNode father = grandFather._left;
        RBNode between = father._right;
        father._right = grandFather;
        grandFather._left = between;
        father._color = grandFather._color;
        grandFather._color = Color.Red;
        return father;
    }

    private void colorSwap(RBNode node) {
        node._left._color = Color.Black;
        node._right._color = Color.Black;
        node._color = Color.Red;
    }

    /*
     * Print a tree. Uses a breadth-first tree traversal algorithm.
     * Needs visualization of node connections.
     */
    public void print() {
        List<RBNode> line = new ArrayList<>();
        System.out.print("\t");
        line.add(_root);
        while (line.size() > 0) {
            for (RBNode rbNode : line) {
                System.out.print(rbNode);
                System.out.print(' ');
            }
            List<RBNode> nextLine = new ArrayList<>();
            for (RBNode node: line) {
                if (node._left != null) nextLine.add(node._left);
                if (node._right != null) nextLine.add(node._right);
                line = nextLine;
            }
            System.out.println();
        }
    }

    /**
     * RBNode
     */
    public class RBNode {
    
        T _value;
        private Color _color;
        private RBNode _left;
        private RBNode _right;
    
        public RBNode() {this._color = Color.Red;}
        public RBNode(T value) {
            this._value = value;
            this._color = Color.Red;
            this._left = null;
            this._right  = null;
        }

        @Override
        public String toString() {
            return String.format(" %s:%s \t",
                _color == Color.Black ? "Black" : "Red",
                _value.toString());
            
        }
    }

    enum Color {Red, Black}
}
