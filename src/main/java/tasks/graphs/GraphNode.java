package tasks.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GraphNode {
    public boolean visited;
    public String data;
    public List<GraphNode> nodes;
    public GraphNode() {
        nodes = new ArrayList<GraphNode>();
    }
    public GraphNode(String data) {
        this();
        this.data = data;
    }
    public void add(String data) {
        nodes.add(new GraphNode(data));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(nodes.stream().map(GraphNode::toString).collect(Collectors.joining(", ")));
        if (!nodes.isEmpty()) {
            result.insert(0, "{");
            result.append("}");
        }
        return data + result.toString();
    }
}
