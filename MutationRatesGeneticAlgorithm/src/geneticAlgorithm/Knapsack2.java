package geneticAlgorithm;

public class Knapsack2 extends Knapsack{
	
	/*
	 * Knapsack1 constructor
	 * sets the cap, weights, and values of this Knapsack Problem
	 */
	public Knapsack2() {
		this.cap = 878;
		int[] weights = {92, 4, 43, 83, 84, 68, 92, 82, 6, 44, 32, 18, 56, 83, 25, 96, 70, 48,
				14, 58};
		this.weights = weights;
		int[] values = {44, 46, 90, 72, 91, 40, 75, 35, 8, 54, 78, 40, 77, 15, 61, 17, 75,
				29, 75, 63};
		this.values = values;
	}

	@Override
	public int fitness(Individual in) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
