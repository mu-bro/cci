package tasks.secondTime.Chapter4;

import tasks.graphs.Graph;
import tasks.graphs.GraphNode;
import tasks.queues.Queue;

public class GraphTraverse {

    private static StringBuilder output = new StringBuilder();

    public static String breadthFirstTraverse(Graph graph) {
        output = new StringBuilder();
        Queue<GraphNode> queue = new Queue<>();
        GraphNode root = graph.root;
        queue.push(root);
        visit(root);
        root.visited = true;

        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.pull();
            for (GraphNode node : currentNode.nodes) {
                if (!node.visited) {
                    node.visited = true;
                    queue.push(node);
                    visit(node);
                }
            }
        }

        return output.toString();
    }

    public static String depthFirstTraverse(Graph graph) {
        output = new StringBuilder();
        GraphNode root = graph.root;
        root.visited = true;
        depthFirstTraverse(root);
        visit(root);
        return output.toString();
    }

    public static void depthFirstTraverse(GraphNode currentNode) {
        for (GraphNode node : currentNode.nodes) {
            if (!node.visited) {
                node.visited = true;
                depthFirstTraverse(node);
            }
        }
        currentNode.visited = true;
                visit(currentNode);
    }

    private static void visit(GraphNode node) {
        output.append(node.data);
        System.out.println(node.data);
    }
}
