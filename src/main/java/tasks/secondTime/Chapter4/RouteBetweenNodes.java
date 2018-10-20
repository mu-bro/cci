package tasks.secondTime.Chapter4;

import tasks.graphs.GraphNode;
import tasks.queues.Queue;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class RouteBetweenNodes {

    public static boolean findFast(GraphNode node1, GraphNode node2) throws ExecutionException, InterruptedException {
        if (node1.equals(node2)) return true;
        return breadthSearch(node1, node2);
    }

    private static boolean breadthSearch(GraphNode node1, GraphNode node2) {
        Set<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new Queue<>();
        queue.push(node1);
        queue.push(node2);

        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.pull();
            for (GraphNode node : currentNode.nodes) {
                if (visited.contains(node)) {
                    return true;
                }
                if (!node.visited) {
                    queue.push(node);
                    visit(node, visited);
                }
            }
            visit(currentNode, visited);
        }
        return false;
    }

    private static void visit(GraphNode node, Set<GraphNode> visited) {
        System.out.println(node.data);
        node.visited = true;
        visited.add(node);
    }

}
