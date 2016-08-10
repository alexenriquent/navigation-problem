import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {
	
	public static void main(String[] args) throws IOException {

		String envPath = "/Users/Richardricmn/Downloads/example1/exEnv1.txt";
		String queryPath = "/Users/Richardricmn/Downloads/example1/exQueries1.txt";

		try {
			IO envFile = new IO(envPath);
			IO queryFile = new IO(queryPath);
			
			String envLines[] = envFile.readFile();
			String queryLines[] = queryFile.readFile();
			
			int matrixSize = Integer.parseInt(envLines[0]);			
			double adjacencyMatrix[][] = new double[matrixSize][matrixSize];
			
			for (int i = 1; i < queryLines.length; i++) {
				String[] splitStr = queryLines[i].split(" ");
				for (int j = 0; j < splitStr.length; j++) {
					System.out.print(splitStr[j] + " ");
				}
				System.out.println("");
			}
			
			System.out.println("");
			
			for (int i = 1; i < envLines.length; i++) {
				String[] splitStr = envLines[i].split(" ");
				for (int j = 0; j < splitStr.length; j++) {
					adjacencyMatrix[i-1][j] = Double.parseDouble(splitStr[j]);
				}
			}
			
			for (int i = 0; i < matrixSize; i++) {
				for (int j = 0; j < matrixSize; j++) {
					System.out.print(adjacencyMatrix[i][j] + " ");
				}
				System.out.println("");
			}
			
			for (int i = 0; i < matrixSize; i++) {
				for (int j = 0; j < matrixSize; j++) {
					if (i == j) {
						adjacencyMatrix[i][j] = 0.0;
					} else if (adjacencyMatrix[i][j] == 0.0) {
						adjacencyMatrix[i][j] = Double.MAX_VALUE;
					}
				}
			}
			
			System.out.println("");
			
			UniformCost uniformCost = new UniformCost(matrixSize);
			List<Integer> UCPath = uniformCost.search(adjacencyMatrix, 0, 7);
			String UCOutput = "";
			
			for (int item : UCPath) {
	        	UCOutput += item + "-";
	        }
			
			System.out.println(UCOutput.substring(0, UCOutput.length() - 1));
			
			Map<Integer, Double> h1 = new HashMap<Integer, Double>();
			h1.put(1,  0.0);
	        h1.put(2, 70.0);
	        h1.put(3, 50.0);
	        h1.put(4, 0.0);
	        h1.put(5, 0.0);
	        h1.put(6, 0.0);
	        h1.put(7, 0.0);
	        h1.put(8, 0.0);
	        
	        Map<Integer, Double> e1 = new HashMap<Integer, Double>();
	        e1.put(2, 70.0);
	        e1.put(3, 50.0);
	        
	        Map<Integer, Double> h2 = new HashMap<Integer, Double>();
	        h2.put(1, 0.0);
	        h2.put(2, 0.0);
	        h2.put(3, 0.0);
	        h2.put(4, 0.0);
	        h2.put(5, 0.0);
	        h2.put(6, 20.0);
	        h2.put(7, 30.0);
	        h2.put(8, 0.0);
	        
	        Map<Integer, Double> e2 = new HashMap<Integer, Double>();
	        e2.put(6, 20.0);
	        e2.put(7, 30.0);
	        
	        Map<Integer, Double> h3 = new HashMap<Integer, Double>();
	        h3.put(1, 0.0);
	        h3.put(2, 0.0);
	        h3.put(3, 0.0);
	        h3.put(4, 15.0);
	        h3.put(5, 15.0);
	        h3.put(6, 0.0);
	        h3.put(7, 0.0);
	        h3.put(8, 0.0);
	        
	        Map<Integer, Double> e3 = new HashMap<Integer, Double>();
	        e3.put(4, 15.0);
	        e3.put(5, 15.0);
	        
	        Map<Integer, Double> h4 = new HashMap<Integer, Double>();
	        h4.put(1, 0.0);
	        h4.put(2, 0.0);
	        h4.put(3, 15.0);
	        h4.put(4, 0.0);
	        h4.put(5, 0.0);
	        h4.put(6, 0.0);
	        h4.put(7, 0.0);
	        h4.put(8, 40.0);
	        
	        Map<Integer, Double> e4 = new HashMap<Integer, Double>();
	        e4.put(3, 15.0);
	        e4.put(8, 40.0);
	        
	        Map<Integer, Double> h5 = new HashMap<Integer, Double>();
	        h5.put(1, 0.0);
	        h5.put(2, 0.0);
	        h5.put(3, 0.0);
	        h5.put(4, 0.0);
	        h5.put(5, 0.0);
	        h5.put(6, 0.0);
	        h5.put(7, 0.0);
	        h5.put(8, 40.0);
	        
	        Map<Integer, Double> e5 = new HashMap<Integer, Double>();
	        e5.put(8, 40.0);
	        
	        Map<Integer, Double> h6 = new HashMap<Integer, Double>();
	        h6.put(1, 0.0);
	        h6.put(2, 0.0);
	        h6.put(3, 0.0);
	        h6.put(4, 10.0);
	        h6.put(5, 0.0);
	        h6.put(6, 0.0);
	        h6.put(7, 0.0);
	        h6.put(8, 60.0);
	        
	        Map<Integer, Double> e6 = new HashMap<Integer, Double>();
	        e6.put(4, 10.0);
	        e6.put(8, 60.0);
	        
	        Map<Integer, Double> h7 = new HashMap<Integer, Double>();
	        h7.put(1, 0.0);
	        h7.put(2, 0.0);
	        h7.put(3, 0.0);
	        h7.put(4, 0.0);
	        h7.put(5, 0.0);
	        h7.put(6, 0.0);
	        h7.put(7, 0.0);
	        h7.put(8, 0.0);
	        
	        Map<Integer, Double> h8 = new HashMap<Integer, Double>();
	        h8.put(1, 0.0);
	        h8.put(2, 0.0);
	        h8.put(3, 0.0);
	        h8.put(4, 0.0);
	        h8.put(5, 0.0);
	        h8.put(6, 0.0);
	        h8.put(7, 0.0);
	        h8.put(8, 0.0);
	        
	        AStarVertex v1 = new AStarVertex(1, h1, e1);
	        AStarVertex v2 = new AStarVertex(2, h2, e2);
	        AStarVertex v3 = new AStarVertex(3, h3, e3);
	        AStarVertex v4 = new AStarVertex(4, h4, e4);
	        AStarVertex v5 = new AStarVertex(5, h5, e5);
	        AStarVertex v6 = new AStarVertex(6, h6, e6);
	        AStarVertex v7 = new AStarVertex(7, h7, new HashMap<Integer, Double>());
	        AStarVertex v8 = new AStarVertex(8, h8, new HashMap<Integer, Double>());
	        
	        AStarGraph graph = new AStarGraph();
	        graph.addVertex(v1);
	        graph.addVertex(v2);
	        graph.addVertex(v3);
	        graph.addVertex(v4);
	        graph.addVertex(v5);
	        graph.addVertex(v6);
	        graph.addVertex(v7);
	        graph.addVertex(v8);
	        
	        AStar aStar = new AStar(graph);
	        
	        List<Integer> aStarPath = aStar.search(1, 8);
	        String aStarOutput = "";
	        
	        for (int item : aStarPath) {
	        	aStarOutput += item + "-";
	        }
	        
	        System.out.println(aStarOutput.substring(0, aStarOutput.length() - 1));
					
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
