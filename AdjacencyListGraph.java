package edu.bu.datastructures.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyListGraph implements Graph {
	Node[] nodes;

	public AdjacencyListGraph(int numberOfNodes) {
		nodes = new Node[numberOfNodes];
	}

	public void addEdge(int source, int destination, int time, double distance) {
		nodes[source].getEdges().add(new Edge(destination, time, distance));
		nodes[destination].getEdges().add(new Edge(source, time, distance));
	}

	public List<Edge> getEdges(int node) {
		return nodes[node] == null ? Collections.emptyList() : nodes[node].getEdges();

	}

	public Node[] getNodes() {
		return nodes;
	}

	@Override
	public int getNumberOfNodes() {
		return nodes.length;
	}
}
