package Graph;

public class GraphNode {
    private String name;
    private boolean isVisited;
    private NodeColor color = NodeColor.WHITE;
    private GraphNode parent;

    GraphNode(String name) {
        this.name = name;
        this.parent = null;
        this.isVisited = false;
    }

    public String getName() {
        return name;
    }

    public NodeColor getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(NodeColor color) {
        this.color = color;
    }

    public GraphNode getParent() {
        return parent;
    }

    public void setParent(GraphNode parent) {
        this.parent = parent;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }
}