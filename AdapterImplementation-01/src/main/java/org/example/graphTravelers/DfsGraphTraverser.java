package org.example.graphTravelers;

import org.example.adapter.GraphAdapterInterface;

import java.util.*;

public class DfsGraphTraverser implements Traverser {

    private final GraphAdapterInterface graphAdapter;

    public DfsGraphTraverser(GraphAdapterInterface graphAdapter) {
        this.graphAdapter = graphAdapter;
    }

    @Override
    public List<Integer> traverse(Integer startVertex) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            Integer vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                result.add(vertex);

                // getNeighbors from the adapter
                List<Integer> neighbors = graphAdapter.getNeighbors(vertex);

                // push neighbors in reverse order to maintain ascending visit
                // so we pop in ascending order
                ListIterator<Integer> li = neighbors.listIterator(neighbors.size());
                while (li.hasPrevious()) {
                    Integer neighbor = li.previous();
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return result;
    }
}