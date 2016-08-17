public abstract class Vertex {

	private int vertex;
	private double weight;
	
	public Vertex() {
		this.vertex = 0;
		this.weight = 0.0;
	}
	
	public Vertex(int vertex, double weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
	
	public int getVertex() {
		return vertex;
	}
	
	public double getWeight() {
		return weight;
	}
}
