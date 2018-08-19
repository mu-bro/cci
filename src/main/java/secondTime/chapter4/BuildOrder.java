package secondTime.chapter4;

import firstTime.helpers.GraphNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BuildOrder {

    public static String find(String[] nodes, String[][] dependencies) {
        List<GraphNode> graphNodes = new ArrayList<>();
        for (String node : nodes) {
            graphNodes.add(new GraphNode(node));
        }

        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            addDependency(graphNodes, first, second);
        }

        StringBuilder result = new StringBuilder();

        buildOrder(graphNodes, result);

        return result.toString();
    }

    private static void buildOrder(List<GraphNode> graphNodes, StringBuilder result) {
        if (graphNodes.isEmpty()) return;

        List<GraphNode> nodes = new ArrayList<>(graphNodes);
        List<GraphNode> nodesToRemove = new ArrayList<>();
        for (GraphNode node : nodes) {
            if (node.getNodes().isEmpty()) {
                result.append(node.getData());
                graphNodes.remove(node);
                nodesToRemove.add(node);
            }
        }
        for (GraphNode node : nodesToRemove) {
            removeDependencies(graphNodes, node);
        }
        buildOrder(graphNodes, result);
    }

    private static void removeDependencies(List<GraphNode> graphNodes, GraphNode nodeToRemove) {
        for (GraphNode node : graphNodes) {
            if (node.getNodes().contains(nodeToRemove)) {
                node.getNodes().remove(nodeToRemove);
            }
        }
    }

    private static void addDependency(List<GraphNode> graphNodes, String first, String second) {
        GraphNode firstNode = new GraphNode(null);
        for (GraphNode node : graphNodes) {
            if (node.getData().equals(first)) {
                firstNode = node;
                break;
            }
        }
        for (GraphNode node : graphNodes) {
            if (node.getData().equals(second)) {
                node.addNode(firstNode);
                break;
            }
        }
    }
}
