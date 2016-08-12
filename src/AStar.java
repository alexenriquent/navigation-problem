import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class AStar {
	
	public static final int CAPACITY = 11;
	
	public List<Integer> search(AStarGraph graph, int source, int destination) {
		Map<Integer, Integer> path = new HashMap<Integer, Integer>();
		Queue<AStarVertex> openSet = new PriorityQueue<AStarVertex>(CAPACITY, new AStarVertex());
		Set<AStarVertex> closedSet = new HashSet<AStarVertex>();
		AStarVertex rootVertex = graph.getVertex(source);		
		rootVertex.setG(0.0);
		rootVertex.setH(destination);
		rootVertex.setF();
		openSet.add(rootVertex);
		
		while (!openSet.isEmpty()) {
			AStarVertex currentVertex = openSet.poll();
			
			if (currentVertex.getVertex() == destination) {
				List<Integer> returnPath = new ArrayList<Integer>();
				returnPath.add(destination);
				while (path.containsKey(destination)) {
					destination = path.get(destination);
					returnPath.add(destination);
				}
				return result(returnPath);
			}
			
			closedSet.add(currentVertex);
			
			for (Map.Entry<Integer, Double> entry: currentVertex.getEdges().entrySet()) {
				AStarVertex adjacentVertex = graph.getVertex(entry.getKey());

				if (closedSet.contains(adjacentVertex)) {
					continue;
				}			
				if ((entry.getValue() + currentVertex.getG()) < adjacentVertex.getG()) {
					adjacentVertex.setG(entry.getValue() + currentVertex.getG());
					adjacentVertex.setH(destination);
					adjacentVertex.setF();
					path.put(adjacentVertex.getVertex(), currentVertex.getVertex());
					if (!openSet.contains(adjacentVertex)) {
						openSet.add(adjacentVertex);
					}
				}
			}
		}
		return null;
	}
	
	private List<Integer> result(List<Integer> path) {
		Collections.reverse(path);
		Iterator<Integer> iterator = path.iterator();
		List<Integer> optimalPath = new ArrayList<Integer>();
		while (iterator.hasNext()) {
			optimalPath.add((iterator.next() + 1));
		}
		return optimalPath;
	}
}
