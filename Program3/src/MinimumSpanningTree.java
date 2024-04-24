import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumSpanningTree {

	public void kruskalsAlgorithm(UndirectedGraph graph) {
		
		HashSet<Edge> mst = new HashSet<Edge>();
		//ccm = connected component marker (used to detect cycles)
		
		HashMap<String, String> ccm = new HashMap<String, String>(); //We set this HashMap to begin with the same value and key
		for(Edge entry: graph.getEdges()) {
			ccm.put(entry.getFrom(), entry.getFrom());
		}
		
		PriorityQueue<Edge> edgeQueue = new PriorityQueue<Edge>();
		for(Edge edge: graph.getEdges()) {
			edgeQueue.add(edge);
		}
		
		while(!edgeQueue.isEmpty()) {
            
			Edge check = edgeQueue.poll();
            
            String oldMarker = find(ccm, check.getFrom()); //The first actor being stored
            String newMarker = find(ccm, check.getTo()); //The second actor being stored
            
            if(!oldMarker.equals(newMarker)) {
                mst.add(check);
                // Union: Merge the connected components of the two vertices
                ccm.put(oldMarker, newMarker);
            }
        }

		System.out.println("Edges in MST:");
		System.out.println("---------------------");
		int i = 1;
		for(Edge edge: mst) {
			System.out.println(i + ": " + edge);
			i++;
		}
		
		HashSet<String> uniqueMovies = new HashSet<>();
        for (Edge edge : mst) {
            uniqueMovies.add(edge.getMovie()); // Assuming the weight represents the movie
        }
        
        int j = 1;
        System.out.println("\nList of movies to watch that covers all 30 Actors:");
        System.out.println("---------------------");
        for (String movie : uniqueMovies) {
            System.out.println(j + ": " + movie);
            j++;
        }
		
	}

	private String find(HashMap<String, String> ccm, String actor) {
        if(!ccm.get(actor).equals(actor)) {
            // Path compression: Make each node point directly to the root
            ccm.put(actor, find(ccm, ccm.get(actor)));
        }
        return ccm.get(actor);
    }
}