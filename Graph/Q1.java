package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Q1 {
    public static void main(String[] args) {
        Graph g = new Graph(false);
        GraphNode a = new GraphNode("A");
        GraphNode b = new GraphNode("B");
        GraphNode c = new GraphNode("C");
        GraphNode d = new GraphNode("D");
        GraphNode e = new GraphNode("E");

        g.insert(a, b);
        g.insert(a, c);
        g.insert(b, c);
        g.insert(b, d);
        g.insert(b, e);

        System.out.println(hasRoute(g, a, e));
    }

    // 此問題可藉由 BFS 或 DFS 來解
    // BFS : 當問題的解越靠近root，則採用BFS
    // DFS : 當圖圖
    static boolean hasRoute(Graph g, GraphNode n1, GraphNode n2) {
        for (GraphNode v : g.getAdjacencyMap().keySet()) {
            v.setColor(NodeColor.WHITE);
        }
        n1.setColor(NodeColor.GRAY);
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(n1);

        GraphNode u;
        while(!queue.isEmpty()) {
            u = queue.remove();

            if (u != null) {
                for (GraphNode v : g.getAdjacencyNodes(u)) {
                    if (n2.equals(v)) {
                        return true;
                    } else if (v.getColor() == NodeColor.WHITE) {
                        v.setColor(NodeColor.GRAY);
                        queue.add(v);
                    }
                }
            }

            u.setColor(NodeColor.BLACK);
        }

        return false;
    }
}
