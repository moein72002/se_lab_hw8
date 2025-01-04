package org.example.adapter;

import edu.uci.ics.jung.graph.SparseMultigraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class JungGraphAdapter implements GraphAdapterInterface {

    private final SparseMultigraph<Integer, String> jungGraph;

    public JungGraphAdapter() {
        this.jungGraph = new SparseMultigraph<>();
    }

    @Override
    public void addVertex(Integer vertex) {
        jungGraph.addVertex(vertex);
    }

    @Override
    public void addEdge(String edgeLabel, Integer source, Integer target) {
        jungGraph.addEdge(edgeLabel, source, target);
    }

    @Override
    public List<Integer> getNeighbors(Integer vertex) {
        // Return the neighbors in sorted order for deterministic results
        List<Integer> neighbors = new ArrayList<>(jungGraph.getNeighbors(vertex));
        neighbors.sort(Comparator.naturalOrder());
        return neighbors;
    }
}
