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
	 * @param Individual
	 * 		This is the individual that whos fitness is being caluclated
	 * @return int
	 * 		The fitness value of the individual. If the Individual goes over the cap
	 * the fitness value is zero
	 */
	/*public int fitness(Individual in) {
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
	*/
	
	/*
	 * @param Individual
	 * 		This is the individual that whos fitness is being caluclated
	 * @return int
	 * 		The fitness value of the individual. If the Individual goes over the cap
	 * the fitness value is zero
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
			return totValue - (10*(totWeight - this.cap));
		}
		else {
			return totValue;
		}
	}
	
	/*
	 * @param Individual
	 * 		The individual that we are checking is valid
	 * @return boolean
	 * 		true if the individual represents a valid solution, false if it does not
	 */
	public boolean isValid(Individual in) {
		
		int totWeight = 0;
		
		//adds the weight of all the items in the knapsack
		for(int i = 0; i < in.getSolutionChromosome().length; i++) {
			int gene = in.getSolutionChromosome()[i];
			if(gene == 1) {
				totWeight = totWeight + this.weights[i];
			}
			//if the weight is greater then the cap return false (not valid solution)
			if(totWeight > this.cap) {
				return false;
			}
		}
		
		return true;
	}
	
}
