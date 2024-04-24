
public class Edge implements Comparable<Edge>{

	private String vertex1;
	private String vertex2;
	private String movie;
	private double weight;
	
	public Edge(String vertex1, String vertex2, String movie, double weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.movie = movie;
		this.weight = weight;
	}
	
	//public String getVertices(){
		//return new int[] {vertex1, vertex2};
	//}
	
	public String getMovie() {
		return this.movie;
	}
	
	public String getFrom() {
		return this.vertex1;
	}
	
	public String getTo() {
		return this.vertex2;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public String toString() {
		return vertex1 + " - " + vertex2 + " (" + movie + ")";
	}
	
	@Override
	// make sure out priority queue sorts from least to greatest based on edge weights
	public int compareTo(Edge otherEdge) {
		
		if(weight < otherEdge.weight) {
			return -1;
		}
		else if(weight > otherEdge.weight) {
			return 1;
		}
		else {
			return 0;
		}
	}
}