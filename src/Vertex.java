public abstract class Vertex {

	protected int vertex;
	protected double weight;
	
	public Vertex() {
		this.vertex = 0;
		this.weight = 0.0;
	}
	
	public Vertex(int vertex, double weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
}
