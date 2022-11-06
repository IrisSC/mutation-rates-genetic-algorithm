package geneticAlgorithm;

public class KnapSack1 extends Knapsack{
	private int maxValue = 295;
	/*
	 * Knapsack1 constructor
	 * sets the cap, weights, and values of this Knapsack Problem
	 * will create 100 individuals for the population
	 */
	public KnapSack1() {
		this.cap = 269;
		int[] weight = {95, 4, 60, 32, 23, 72, 80, 62, 65, 46};
		this.weights = weight.clone();
		int[] value = {55, 10, 47, 5, 4, 50, 8, 61, 85, 87};
		this.values = value.clone();
		
		//create 100 individuals
	}
	
	/*
	 * Knapsack1 constructor
	 * sets the cap, weights, and values of this Knapsack Problem
	 * will create n individuals for the population
	 */
	public KnapSack1(int numIndividuals) {
		this.cap = 295;
		int[] weight = {95, 4, 60, 32, 23, 72, 80, 62, 65, 46};
		this.weights = weight.clone();
		int[] value = {55, 10, 47, 5, 4, 50, 8, 61, 85, 87};
		this.values = value.clone();
		
		//create n individuals
	}
	
	/*
	 * @return int
	 * 		the highest possible value a solution can hold
	 */
	public int getMaxPossibleValue() {
		return this.maxValue;
	}

	/*
	 * (non-Javadoc)
	 * @see geneticAlgorithm.Knapsack#fitness(geneticAlgorithm.Individual)
	 * @param Individual
	 * 		takes in an individual for this Knapsack Problem
	 * @return
	 * 		a fitness value of that individual
	 */
	@Override
	public int fitness(Individual in) {
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
