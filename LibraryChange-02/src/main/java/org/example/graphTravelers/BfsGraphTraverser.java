package org.example.graphTravelers;

import org.example.adapter.GraphAdapterInterface;

import java.util.*;

public class BfsGraphTraverser implements Traverser {

    private final GraphAdapterInterface graphAdapter;

    public BfsGraphTraverser(GraphAdapterInterface graphAdapter) {
        this.graphAdapter = graphAdapter;
    }

    @Override
    public List<Integer> traverse(Integer startVertex) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            result.add(vertex);

            // getNeighbors from the adapter
            List<Integer> neighbors = graphAdapter.getNeighbors(vertex);

            for (Integer neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return result;
    }
}