package geneticAlgorithm;

public class Knapsack3 extends Knapsack{
	/*
	 * Knapsack3 constructor
	 * sets the cap, max values, weights, and values of this Knapsack Problem
	 */
	public Knapsack3() {
		this.cap = 1000;
		this.maxValue = 3103;
		int[] weights = {80, 82, 85, 70, 72, 70, 66, 50, 55, 25, 50, 55, 40, 48, 59, 32, 22,
				60, 30, 32, 40, 38, 35, 32, 25, 28, 30, 22, 50, 30, 45, 30, 60, 50, 20,
				65, 20, 25, 30, 10, 20, 25, 15, 10, 10, 10, 4, 4, 2, 1};
		this.weights = weights;
		int[] values = {220, 208, 198, 192, 180, 180, 165, 162, 160, 158, 155, 130, 125,
				122, 120, 118, 115, 110, 105, 101, 100, 100, 98, 96, 95, 90, 88, 82,
				80, 77, 75, 73, 72, 70, 69, 66, 65, 63, 60, 58, 56, 50, 30, 20, 15, 10, 8,
				5, 3, 1};
		this.values = values;
	}
}
