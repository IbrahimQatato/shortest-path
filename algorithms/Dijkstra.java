package edu.bu.datastructures.graphs.algorithms;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;

import edu.bu.datastructures.graphs.Edge;
import edu.bu.datastructures.graphs.Graph;

public class Dijkstra {
	Hashtable<Integer, SearchNode> visitedNodes = new Hashtable<Integer, SearchNode>();
	Hashtable<Integer, Integer> parents = new Hashtable<Integer, Integer>();
	Comparator<SearchNode> comparator = new Comparator<SearchNode>() {
		@Override
		public int compare(SearchNode o1, SearchNode o2) {
			return o1.cost - o2.cost;
		}
	};
	public Hashtable<Integer, SearchNode> getVisitedNodes() {
		return visitedNodes;
	}


	PriorityQueue<SearchNode> pQueue = new PriorityQueue<>(comparator);

	public int getShortPath(Graph graph, int source, int destianation) {
		SearchNode sourceSearchNode = new SearchNode(source, 0);
		pQueue.add(sourceSearchNode);
		visitedNodes.put(source, sourceSearchNode);
		while (!pQueue.isEmpty()) {
			SearchNode currnNode = pQueue.poll();
			if (visitedNodes.get(currnNode.nodeId) == null)
				visitedNodes.put(currnNode.nodeId, currnNode);
			if (currnNode.nodeId == destianation) {
				return currnNode.cost;
			}
			if (visitedNodes.get(currnNode.nodeId).isSettled())
				continue;
			visitedNodes.get(currnNode.nodeId).settled = true;
			List<Edge> edges = graph.getEdges(currnNode.nodeId);
			for (Edge edge : edges) {
				int newCost = (currnNode.cost + edge.getTime());
				int edgedestination = edge.getDestination();
				SearchNode EdgeSearchNode = visitedNodes.get(edgedestination);
				if(EdgeSearchNode == null ) {
					EdgeSearchNode = new SearchNode(edgedestination, newCost);
					EdgeSearchNode.parent = currnNode.nodeId;
				}
				if (newCost < EdgeSearchNode.cost) {
					EdgeSearchNode.cost = newCost;
					EdgeSearchNode.parent = currnNode.nodeId;
				}
				pQueue.add(EdgeSearchNode);
			}
		}

		return Integer.MAX_VALUE;
	}

}
