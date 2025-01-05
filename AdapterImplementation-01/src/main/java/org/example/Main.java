package org.example;

import org.example.adapter.GraphAdapterInterface;
import org.example.adapter.JungGraphAdapter;
import org.example.graphTravelers.BfsGraphTraverser;
import org.example.graphTravelers.DfsGraphTraverser;
import org.example.graphTravelers.Traverser;

import java.util.List;

public class main {
    public static void main(String[] args) {

        // Create an adapter for JUNG
        GraphAdapterInterface graphAdapter = new JungGraphAdapter();

        // Add vertices via adapter
        graphAdapter.addVertex(1);
        graphAdapter.addVertex(2);
        graphAdapter.addVertex(3);
        graphAdapter.addVertex(4);
        graphAdapter.addVertex(5);

        // Add edges via adapter
        graphAdapter.addEdge("E1", 1, 2);
        graphAdapter.addEdge("E2", 1, 3);
        graphAdapter.addEdge("E3", 2, 4);
        graphAdapter.addEdge("E4", 3, 5);
        graphAdapter.addEdge("E5", 4, 5);

        // Create BFS and DFS Traversers
        Traverser bfsTraverser = new BfsGraphTraverser(graphAdapter);
        Traverser dfsTraverser = new DfsGraphTraverser(graphAdapter);

        // Perform traversals
        List<Integer> bfsResult = bfsTraverser.traverse(1);
        List<Integer> dfsResult = dfsTraverser.traverse(1);

        // Print results
        System.out.println("DFS Result starting at 1: " + dfsResult);
        System.out.println("BFS Result starting at 1: " + bfsResult);
    }
}
