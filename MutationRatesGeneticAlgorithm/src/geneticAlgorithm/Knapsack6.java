package geneticAlgorithm;

public class Knapsack6 extends Knapsack{
	
	public Knapsack6() {
		this.cap = 978;
		this.maxValue = 4219;
		int [] weights = {23, 77, 11, 77, 28, 36, 77, 32, 21, 58,
				35, 65, 70, 18, 63, 65, 79, 76, 66, 56,
				30, 30, 42, 31, 86, 79, 48, 101, 37, 20};
		this.weights = weights;
		int [] values = {303, 293, 125, 109, 128, 49, 132, 92, 206, 238,
				91, 276, 235, 211,287, 81, 273, 147, 239, 84,
				88, 239, 283, 38, 25, 171, 254, 19, 103, 17};
		this.values = values;
	}

}
