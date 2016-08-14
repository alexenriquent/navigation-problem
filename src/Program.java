import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Paths;

public class Program {
	
	public static void main(String[] args) throws IOException {

		String envPath = Paths.get(".").toAbsolutePath().normalize().toString() + "/test/exEnv1.txt";
		String queryPath = Paths.get(".").toAbsolutePath().normalize().toString() + "/test/exQueries1.txt";
		String outputPath = Paths.get(".").toAbsolutePath().normalize().toString() + "/test/output.txt";
		List<String> output = new ArrayList<String>();
		
		try {
			IO file = new IO();
			
			String envData[] = file.readFile(envPath);
			String queryData[] = file.readFile(queryPath);
			
			int matrixSize = Integer.parseInt(envData[0]);			
			double adjacencyMatrix[][] = parseMatrix(matrixSize, envData);
			
			for (int i = 1; i < queryData.length; i++) {
				String[] splitStr = queryData[i].split(" ");
				String query = splitStr[0];
				int source = Integer.parseInt(splitStr[1]) - 1;
				int destination = Integer.parseInt(splitStr[2]) - 1;
				switch (query) {
				case "Uniform":	
					UniformCostGraph matrix = new UniformCostGraph(adjacencyMatrix, matrixSize);
					UniformCost uniformCost = new UniformCost(matrix, matrixSize, source, destination);
					List<Integer> UCPath = uniformCost.search();
					String UCOutput = parseOutput(UCPath);
					output.add(UCOutput);
					System.out.println(UCOutput);
					break;
				case "A*":
					AStarGraph graph = new AStarGraph(adjacencyMatrix, matrixSize);
					AStar aStar = new AStar(graph, source, destination);
					List<Integer> aStarPath = aStar.search();
			        String aStarOutput = parseOutput(aStarPath);
			        output.add(aStarOutput);   
			        System.out.println(aStarOutput);
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			IO file = new IO();
			file.writeLines(outputPath, output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static double[][] parseMatrix(int size, String data[]) {
		double matrix[][] = new double[size][size];
		
		for (int i = 1; i < data.length; i++) {
			String[] splitStr = data[i].split(" ");
			for (int j = 0; j < splitStr.length; j++) {
				matrix[i-1][j] = Double.parseDouble(splitStr[j]);
			}
		}
		
		return matrix;
	}
	
	public static String parseOutput(List<Integer> path) {
		String output = "";
		
		for (int item : path) {
        	output += item + "-";
        }
		
		return output.substring(0, output.length() - 1);
	}
}
