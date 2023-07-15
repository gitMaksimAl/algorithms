package Lesson_4;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    
    Node root;
    
    public boolean contains(int value) {
        if (root != null) return (depthSearchR(root, value) != null);
        else return false;
    }

    public Node breadthSearch(int value) {
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0) {
            List<Node> nextLine = new ArrayList<>();
            for (Node node : line) {
                if (node.value == value) return node;
                nextLine.addAll(node.children);
            }
            line = nextLine;
        }
        return null;
    }

    private Node depthSearchR(Node node, int value) {
        if (node.value == value) return node;
        else {
            for (Node child: node.children) {
                Node result = depthSearchR(child, value);
                if (result != null) return result;
            }
        }
        return null;
    }
    /**
     * NOde
     */
    public class Node {
    
        int value;
        List<Node> children;
    }
}
