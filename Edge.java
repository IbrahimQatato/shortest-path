package edu.bu.datastructures.graphs;

public class Edge {
	int destination;
	int time;
	double distance;

	public Edge(int destination, int time, double distance) {
		this.destination = destination;
		this.time = time;
		this.distance = distance;
	}

	public double getDistance() {
		return distance;
	}


	@Override
	public String toString() {
		return "Edge [destination=" + destination + ", time=" + time + ", distance=" + distance + "]";
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getDestination() {
		return destination;
	}
}
