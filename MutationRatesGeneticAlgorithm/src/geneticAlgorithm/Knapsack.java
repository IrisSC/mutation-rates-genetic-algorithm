package geneticAlgorithm;

public abstract class Knapsack {
	protected int cap;
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
	public abstract int fitness(Individual in);
	
}
