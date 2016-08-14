public class UniformCostGraph {

	private double graph[][];
	
	public UniformCostGraph() {
		this.graph = null;
	}
	
	public UniformCostGraph(double graph[][], int size) {
		this.graph = setGraph(graph, size);
	}
	
	public double[][] getGraph() {
		return graph;
	}
	
	private double[][] setGraph(double graph[][], int size) {
    	double matrix[][] = cloneGraph(graph, size);		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j) {
					matrix[i][j] = 0.0;
				} else if (matrix[i][j] == 0.0) {
					matrix[i][j] = Double.MAX_VALUE;
				}
			}
		}
		return matrix;
    }
    
    private double[][] cloneGraph(double graph[][], int size) {
    	double matrix[][] = new double[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = graph[i][j];
			}
		}
		return matrix;
    }
}
