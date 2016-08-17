import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class AStar extends AbstractSearchAlgorithm<AStarGraph> {
	
	private Map<Integer, Integer> path;
	private Queue<AStarVertex> openSet;
	private Set<AStarVertex> closedSet;
	public static final int CAPACITY = 11;
	
	public AStar(AStarGraph graph, int source, int destination) {
		super(graph, source, destination);
		this.path = new HashMap<Integer, Integer>();
		this.openSet = new PriorityQueue<AStarVertex>(CAPACITY, new AStarVertex());
		this.closedSet = new HashSet<AStarVertex>();
	}
	
	public List<Integer> search() {
		AStarVertex rootVertex = this.getGraph().getVertex(this.getSource());		
		rootVertex.setHeuristic(0.0, this.getDestination());
		openSet.add(rootVertex);
		
		while (!openSet.isEmpty()) {
			AStarVertex currentVertex = openSet.poll();
			
			if (currentVertex.getVertex() == this.getDestination()) {
				List<Integer> returnPath = new ArrayList<Integer>();
				returnPath.add(this.getDestination());
				while (path.containsKey(this.getDestination())) {
					this.setDestination(path.get(this.getDestination()));
					returnPath.add(this.getDestination());
				}
				return result(returnPath);
			}
			
			closedSet.add(currentVertex);
			for (Entry<Integer, Double> entry: currentVertex.getEdges().entrySet()) {
				AStarVertex adjacentVertex = this.getGraph().getVertex(entry.getKey());

				if (closedSet.contains(adjacentVertex)) {
					continue;
				}			
				if ((entry.getValue() + currentVertex.getG()) < adjacentVertex.getG()) {
					adjacentVertex.setHeuristic((entry.getValue() + currentVertex.getG()), this.getDestination());
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
