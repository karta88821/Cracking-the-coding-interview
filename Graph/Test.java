package Graph;

public class Test {
    public static void main(String[] args) {
        Graph graph = new Graph(false);
        GraphNode a = new GraphNode("A");
        GraphNode b = new GraphNode("B");
        GraphNode c = new GraphNode("C");
        GraphNode d = new GraphNode("D");
        GraphNode e = new GraphNode("E");
        GraphNode f = new GraphNode("F");
        GraphNode g = new GraphNode("G");
        graph.insert(a, b);
        graph.insert(b, c);
        graph.insert(c, f);
        graph.insert(c, d);
        graph.insert(d, g);
        graph.insert(a, d);

        GraphSearch.DFS(graph, a);
    }
}
