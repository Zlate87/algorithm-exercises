package com.zlate87;

import java.util.*;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by Zlatko on 11/12/2014.
 */
public class ShortestPath {

  public static void main(String[] args) {
    Map<String, Node> nodes = new HashMap<String, Node>();
    addNode(nodes, "A");
    addNode(nodes, "B");
    addNode(nodes, "C");
    addNode(nodes, "D");
    addNode(nodes, "E");
    addNode(nodes, "Z");
    addEdge(nodes, "A", "B", 1, true);
    addEdge(nodes, "A", "D", 8, true);
    addEdge(nodes, "A", "Z", 7, true);
    addEdge(nodes, "B", "C", 1, true);
    addEdge(nodes, "C", "D", 4, true);
    addEdge(nodes, "C", "E", 1, true);
    addEdge(nodes, "D", "E", 1, true);
    addEdge(nodes, "E", "Z", 1, true);

    Node start = nodes.get("A");
    Node end = nodes.get("D");
    System.out.println(findShortestPath(start, end));
    printPath(end);
  }

  private static void printPath(Node node) {
    System.out.println(String.format("id: %s, weight %s", node.id, node.weight));
    if (node.previousNode != null) {
      printPath(node.previousNode);
    }
  }

  private static void addEdge(Map<String, Node> nodes, String nodeId, String nextNodeId, int weight,
                              boolean alsoOppositeDirection) {
    Edge edge = new Edge();
    edge.next = nodes.get(nextNodeId);
    edge.weight = weight;
    nodes.get(nodeId).edges.add(edge);
    if (alsoOppositeDirection) {
      addEdge(nodes, nextNodeId, nodeId, weight, false);
    }
  }

  private static void addNode(Map<String, Node> nodes, String id) {
    Node node = new Node();
    node.id = id;
    node.weight = -1;
    node.edges = new ArrayList<Edge>();
    nodes.put(id, node);
  }

  public static int findShortestPath(Node start, Node end) {
    Queue<Node> queue = new LinkedTransferQueue<Node>();
    start.weight = 0;
    queue.add(start);

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      for (Edge edge : node.edges) {
        Node next = edge.next;
        if (next.weight == -1 || next.weight > node.weight + edge.weight) {
          next.weight = node.weight + edge.weight;
          next.previousNode = node;
          queue.add(next);
        }
      }
    }

    return end.weight;
  }

  private static class Edge {
    Node next;
    int weight;
  }

  private static class Node {
    String id;
    List<Edge> edges;
    int weight = -1;
    Node previousNode;
  }
}
