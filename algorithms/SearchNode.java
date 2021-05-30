package edu.bu.datastructures.graphs.algorithms;

public class SearchNode {
	int nodeId;
	int cost;
	int parent;
	boolean settled;

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public boolean isSettled() {
		return settled;
	}

	public void setSettled(boolean settled) {
		this.settled = settled;
	}

	public SearchNode(int nodeId, int cost) {
		this.nodeId = nodeId;
		this.cost = cost;
	}
}
