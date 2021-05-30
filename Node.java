package edu.bu.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {
	List<Edge> edges = new ArrayList<>();
	int nodeId;
	double lat;
	double lon;

	public void addEdge(Edge e) {
		if (edges == null)
			edges = new ArrayList<>();
		edges.add(e);
	}
	

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}
}
