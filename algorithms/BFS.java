package edu.bu.datastructures.graphs.algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import edu.bu.datastructures.graphs.Edge;
import edu.bu.datastructures.graphs.Graph;

public class BFS {
	boolean[] visitedNodes;
	Integer[] parents;

	public void doBFS(Graph g, int source, int destination) {
		visitedNodes = new boolean[g.getNumberOfNodes()];
		parents = new Integer[g.getNumberOfNodes()];
		bfs(g, source);
		String pathString = generatePathString(source, destination);
		System.out.printf("path from %d to %d is %s\n", source, destination, pathString);
		System.out.printf("path from %d to every other node can be found here  %s\n", source, getIndexItemStr());
	}

	private void bfs(Graph g, int source) {
		Queue<Integer> pendingNeighbors = new LinkedList<>();
		pendingNeighbors.add(source);
		while (!pendingNeighbors.isEmpty()) {
			Integer currentNode = pendingNeighbors.remove();
			visitedNodes[currentNode] = true;
			List<Edge> outgoingEdges = g.getEdges(currentNode);
			for (Edge edge : outgoingEdges) {
				if (!visitedNodes[edge.getDestination()]) {
					visitedNodes[edge.getDestination()] = true;
					pendingNeighbors.add(edge.getDestination());
					parents[edge.getDestination()] = currentNode;
				}
			}
		}
	}

	private String getIndexItemStr() {
		String strRepresentation = "";
		for (int i = 0; i < parents.length; i++) {
			strRepresentation = strRepresentation + "  " + i + "[" + parents[i] + "]";
		}
		return strRepresentation;
	}

	private String generatePathString(int source, int destination) {
		if (parents[destination] == null)
			return "not found";
		String pathString = "";
		Stack<Integer> stack = new Stack();
		int currNode = destination;
		while (currNode != source && parents[currNode] != null) {
			stack.push(currNode);
			currNode = parents[currNode];
		}
		stack.push(source);
		while (!stack.isEmpty()) {
			pathString = pathString + " -> " + stack.pop();
		}
		return pathString;
	}
}
