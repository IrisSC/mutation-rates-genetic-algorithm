package geneticAlgorithm;

public class Knapsack1 extends Knapsack{
	/*
	 * Knapsack1 constructor
	 * sets the cap, weights, and values of this Knapsack Problem
	 */
	public Knapsack1() {
		this.cap = 269;
		this.maxValue = 295;
		int[] weight = {95, 4, 60, 32, 23, 72, 80, 62, 65, 46};
		this.weights = weight.clone();
		int[] value = {55, 10, 47, 5, 4, 50, 8, 61, 85, 87};
		this.values = value.clone();
	}
}
