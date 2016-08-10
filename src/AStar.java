import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class AStar {
	
	public static final int CAPACITY = 11;

	private AStarGraph graph;
	
	public AStar(AStarGraph graph) {
		this.graph = graph;
	}
	
	public List<Integer> search(int source, int destination) {
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
				return path(path, destination);
			}
			
			closedSet.add(currentVertex);
			
			for (Map.Entry<Integer, Double> entry: currentVertex.getEdges().entrySet()) {
				AStarVertex adjacentVertex = graph.getVertex(entry.getKey());
				
				if (closedSet.contains(adjacentVertex)) {
					continue;
				}
				
				double distance = entry.getValue();
				double g = distance + currentVertex.getG();
				
				if (g < adjacentVertex.getG()) {
					adjacentVertex.setG(g);
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
	
	private List<Integer> path(Map<Integer, Integer> path, int destination) {
		List<Integer> pathList = new ArrayList<Integer>();
		pathList.add(destination);
		while (path.containsKey(destination)) {
			destination = path.get(destination);
			pathList.add(destination);
		}
		Collections.reverse(pathList);
		return pathList;
	}
}
