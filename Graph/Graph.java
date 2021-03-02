package Graph;

import java.util.HashMap;
import java.util.LinkedList;

class Graph {
    private HashMap<GraphNode, LinkedList<GraphNode>> adjacencyMap;
    
    private boolean isDirected;

    Graph(boolean isDirected) {
        this.adjacencyMap = new HashMap<>();
        this.isDirected = isDirected;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public HashMap<GraphNode, LinkedList<GraphNode>> getAdjacencyMap() {
        return adjacencyMap;
    }

    void insert(GraphNode source, GraphNode target) {
        // 若先前不存在這兩點，則新加bucket
        if (!adjacencyMap.keySet().contains(source)) {
            adjacencyMap.put(source, null);
        }
        if (!adjacencyMap.keySet().contains(target)) {
            adjacencyMap.put(target, null);
        }

        // 取得source對應之list
        LinkedList<GraphNode> list = adjacencyMap.get(source);

        // 若source對應之list為null，則assign一個空的物件
        if (list == null) {
            list = new LinkedList<GraphNode>();
        }

        // 加入target node到對source node之list中
        list.add(target);
        adjacencyMap.put(source, list);

        if (!isDirected) {
            list = adjacencyMap.get(target);
            if (list == null) {
                list = new LinkedList<GraphNode>();
            }
            list.add(source);
            adjacencyMap.put(target, list);
        }
    }

    LinkedList<GraphNode> getAdjacencyNodes(GraphNode source) {
        LinkedList<GraphNode> node = adjacencyMap.get(source);
        if (node == null) {
            return new LinkedList<GraphNode>();
        } else {
            return node;
        }
    }
}