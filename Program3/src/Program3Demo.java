// Working with partner Teddy Vander Wall

import java.util.LinkedList;
import java.util.Scanner;

public class Program3Demo {

	public static void main(String[] args) {
		
		UndirectedGraph graph = new UndirectedGraph();
		
		graph.Load();
		graph.addToList();
		
		Scanner menu = new Scanner(System.in);
		
		int menu_choice = 0;
		
		while(menu_choice != 4) {
			System.out.println("Enter your choice:");
			System.out.println("1: Print out MST Information");
			System.out.println("2: Find Shortest Path from one Actor to another");
			System.out.println("3: Your Custom Method [You will describe your method here]");
			System.out.println("4: Exit");
			//read input
			menu_choice = menu.nextInt();
			
			if(menu_choice == 1) {
				MinimumSpanningTree mst = new MinimumSpanningTree();
				mst.kruskalsAlgorithm(graph);
			}
			else if(menu_choice == 2) {
				ShortestPath sp = new ShortestPath();
				Scanner choice = new Scanner(System.in);
				System.out.println("Enter starting actor: ");
				String actor1 = choice.nextLine();
				System.out.println("Enter destination actor: ");
				String actor2 = choice.nextLine();
				sp.computeShortestPath(graph, actor1);
				if(!(graph.getAdjList().containsKey(actor1) && graph.getAdjList().containsKey(actor2))) {
			        System.out.println("Path does not exist to " + actor2);
				}
				else {
					LinkedList<Edge> shortestPath = sp.getPathTo(actor2);
					int i = 0;
			        for(Edge e: shortestPath) {
			        	System.out.println(e.getFrom() + " acted with " + e.getTo() + " in " + e.getMovie());
			        	i++;
			        }
			        System.out.println("Number of hops: " + i);
				}
			}
			else if(menu_choice == 3) {
				System.out.println("Custom method");
			}
			else if(menu_choice == 4) {
				break;
			}
			else {
				System.out.println("Menu choice invalid, try again");
			}
		}
		
		menu.close();
		
	}
}