package org.example.adapter;

import java.util.List;

public interface GraphAdapterInterface {
    void addVertex(Integer vertex);
    void addEdge(String edgeLabel, Integer source, Integer target);
    List<Integer> getNeighbors(Integer vertex);
}
