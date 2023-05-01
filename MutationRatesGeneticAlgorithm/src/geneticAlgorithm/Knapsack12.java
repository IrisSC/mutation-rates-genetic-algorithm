package geneticAlgorithm;

public class Knapsack12 extends Knapsack{
	public Knapsack12() {
		this.cap = 100;
		this.maxValue = -1;
		int [] weights = {101, 20, 0, 50, 20, 20, 50, 20, 0, 20};
		this.weights = weights;
		int [] values = {2, 100, 0, 10, 20, 150, 5, 125, 0, 50};
		this.values = values;
	}
}
