package geneticAlgorithm;

public class Knapsack7 extends Knapsack{

	public Knapsack7() {
		this.cap = 978;
		this.maxValue = 4219;
		int [] weights = {64, 97, 61, 52, 13, 94, 8, 88, 19, 16, 88, 32, 67, 58, 55, 17,
				28, 43, 11, 10, 61, 58, 54, 84, 92, 82, 68, 95, 16, 10};
		this.weights = weights;
		int [] values = {174, 189, 24, 187, 297, 188, 143, 66, 148, 104, 96, 101, 86, 175,
				219, 35, 224, 109, 102, 16, 247, 94, 14, 195, 184, 111, 175, 193, 156, 29};
		this.values = values;
	}
	
}
