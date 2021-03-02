package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphSearch {
    public static final void DFS(Graph graph, GraphNode s) {

        s.setVisited(true);

        System.out.println("visit node: " + s.getName());

        for (GraphNode node : graph.getAdjacencyNodes(s)) {
            if (!node.isVisited()) {
                DFS(graph, node);
            }
        }
    }

    public static final void BFS(Graph graph, GraphNode s) {
        Queue<GraphNode> queue = new LinkedList<>();

        queue.add(s);

        GraphNode u;

        while(!queue.isEmpty()) {
            u = queue.remove();
            System.out.println("visit node: " + u.getName());
            for (GraphNode v : graph.getAdjacencyNodes(u)) {
                if (!v.isVisited()) {
                    queue.add(v);
                }
            }
        }
    }
}