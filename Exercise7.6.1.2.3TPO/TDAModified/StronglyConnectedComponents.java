package org.adt.core.adt.implementation.dynamic.TDAModified;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StronglyConnectedComponents {
    private static void dfs(Map<Integer, List<Integer>> graph, int vertex, boolean[] visited, Map<Integer, List<Integer>> component) {
        visited[vertex] = true;
        component.put(vertex, graph.get(vertex));

        List<Integer> neighbors = graph.getOrDefault(vertex, new ArrayList<>());
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited, component);
            }
        }
    }

    private static Map<Integer, List<Integer>> transposeGraph(Map<Integer, List<Integer>> graph) {
        Map<Integer, List<Integer>> transposedGraph = new HashMap<>();

        for (int vertex : graph.keySet()) {
            for (int neighbor : graph.get(vertex)) {
                transposedGraph.putIfAbsent(neighbor, new ArrayList<>());
                transposedGraph.get(neighbor).add(vertex);
            }
        }

        return transposedGraph;
    }
}
