package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CloneGraph {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        ArrayList<Node> a = new ArrayList<>();
        a.add(n2);
        a.add(n4);
        n1.neighbors = a;
        a = new ArrayList<>();
        a.add(n1);
        a.add(n3);
        n2.neighbors = a;
        a = new ArrayList<>();
        a.add(n2);
        a.add(n4);
        n3.neighbors = a;
        a = new ArrayList<>();
        a.add(n1);
        a.add(n3);
        n4.neighbors = a;
        CloneGraph cloneGraph = new CloneGraph();
        Node clone = cloneGraph.cloneGraph(n1);


    }
    private HashMap<Integer, Node> visits;

    public  Node cloneGraph(Node node) {
        if (node == null) return null;

        Node initial = new Node(node.val);
        visits = new HashMap<>();
        visits.put(initial.val, initial);

        visitNode(node, initial);
        return initial;

    }

    private void visitNode(Node realNode, Node cloneNode) {
        List<Node> neighborsClone = new ArrayList<>();
        for (Node xRealNode : realNode.neighbors) {
            Node xCloneNode;
            if (visits.containsKey(xRealNode.val)) {
                xCloneNode = visits.get(xRealNode.val);
            }
            else{
                xCloneNode = new Node(xRealNode.val);
                visits.put(xRealNode.val, xCloneNode);
                visitNode(xRealNode, xCloneNode);
            }
            neighborsClone.add(xCloneNode);

        }
        cloneNode.neighbors = neighborsClone;
    }


}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
