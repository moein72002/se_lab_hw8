package org.example.adapter;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class JGraphTAdapter implements GraphAdapterInterface {
    private final Graph<Integer, DefaultEdge> jGraphTGraph;

    public JGraphTAdapter() {
        this.jGraphTGraph = new SimpleGraph<>(DefaultEdge.class);
    }

    @Override
    public void addVertex(Integer vertex) {
        jGraphTGraph.addVertex(vertex);
    }

    @Override
    public void addEdge(String edgeLabel, Integer source, Integer target) {
        jGraphTGraph.addEdge(source, target);
    }

    @Override
    public List<Integer> getNeighbors(Integer vertex) {
        Set<DefaultEdge> edges = jGraphTGraph.edgesOf(vertex);
        List<Integer> neighbors = new ArrayList<>();
        for (DefaultEdge edge : edges) {
            Integer source = jGraphTGraph.getEdgeSource(edge);
            Integer target = jGraphTGraph.getEdgeTarget(edge);
        }

        Integer neighbor = source.equals(vertex) ? target : source;
        neighbors.add(neighbor);
        neighbors.sort(Comparator.naturalOrder());
        return neighbors;
    }
}