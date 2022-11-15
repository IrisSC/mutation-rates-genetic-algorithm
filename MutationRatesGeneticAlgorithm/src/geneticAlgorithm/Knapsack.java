package geneticAlgorithm;

public abstract class Knapsack {
	protected int cap;
	protected int maxValue;
	protected int[] values;
	protected int[] weights;
	
	/*
	 * @returns the cap/max weight of the knapsack
	 */
	public int getCap() {
		return this.cap;
	}
	
	/*
	 * @returns the values for all the items in the knapsack
	 */
	public int[] getValues() {
		return this.values;
	}
	
	/*
	 * @returns the weights for all the items in the knapsack
	 */
	public int[] getWeights() {
		return this.weights;
	}
	
	/*
	 * @return int
	 * 		the highest possible value a solution can hold
	 */
	public int getMaxPossibleValue() {
		return this.maxValue;
	}
	
	/*
	 * @param int cap
	 * 		This method sets the cap to be a new value
	 */
	public void setCap(int cap) {
		this.cap = cap;
	}
	
	/*
	 * @param int[] values
	 * 		This method sets the values of the items
	 */
	public void setValues(int[] values) {
		this.values = values;
	}
	
	/*
	 * @param int[] weights
	 * 		This method sets the weights of the items
	 */
	public void setWeights(int[] weights) {
		this.weights = weights;
	}
	
	/*
	 * Each knapsack problem will have different weights and values
	 */
	public int fitness(Individual in) {
		if(weights.length != in.solutionChromosome.length) {
			return -10;
		}
		//integers to hold the total weight and value of the individual
		int totWeight = 0;
		int totValue = 0;
		
		//iterate through each gene to get the value and weight
		for(int i = 0; i < in.getSolutionChromosome().length; i++) {
			int gene = in.getSolutionChromosome()[i];
			if(gene == 1) {
				totWeight = totWeight + this.weights[i];
				totValue = totValue + this.values[i];
			}
		}
		if(totWeight > this.cap) {
			return 0;
		}
		else {
			return totValue;
		}
	}
	
}
