package org.dzmitry.kapachou.graph.bfs;

import lombok.Data;

import java.util.*;

public class ClassicAlgorithm {

    @Data
    public static class Graph {
        private int vertices;
        private Map<Integer, List<Integer>> nodes = new HashMap<>();

        public void addEdge(int src, int dest) {
            nodes.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
            nodes.computeIfAbsent(dest, k -> new ArrayList<>()).add(src);
        }
    }

    public static void main(String[] args) {
        var graph = initGraph();
        bfs(100, graph);
    }

    // find sum by bfs walking through the graph
    public static void bfs(int root, Graph graph) {
        long sum = 0;
        final Set<Integer> visited = new HashSet<>();
        final Queue<Integer> queue = new LinkedList<>();

        queue.offer(root);
        visited.add(root);
        sum += root;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node);
            for (int neighbor : graph.getNodes().get(node)) {
                if (!visited.contains(neighbor)) {
                    sum += neighbor;
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        System.out.println(sum);
    }

    public static Graph initGraph() {
        Graph g = new Graph();
        g.addEdge(100, 200);
        g.addEdge(100, 300);
        g.addEdge(200, 400);
        g.addEdge(400, 500);
        return g;
    }
}
