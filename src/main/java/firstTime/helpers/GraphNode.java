package firstTime.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GraphNode {
    private String data;
    private List<GraphNode> nodes = new ArrayList<>();

    public GraphNode(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }
    public List<GraphNode> getNodes() {
        return nodes;
    }

    public void addNode(GraphNode node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "data='" + data + '\'' +
                ", nodes=" + String.join(" , ", nodes.stream().map(GraphNode::getData).collect(Collectors.toList())) +
                '}';
    }
}
