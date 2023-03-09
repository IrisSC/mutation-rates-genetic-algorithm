package geneticAlgorithm;

import java.util.List;

public class IndivGlobalGeneSpecMutate extends Individual{
	
	protected static double[] mutationRates;
	
	/*
	 * Constructor: creates random solution and the mutation rates to all be the same
	 */
	public IndivGlobalGeneSpecMutate(int solutionLength, double initalMutationRate) {
		super(solutionLength);

		this.mutationRates = new double[solutionLength];
		for(int i = 0; i < this.mutationRates.length; i++) {
			this.mutationRates[i] = initalMutationRate;
		}
	}
	
	/*
	 * Constructor: takes in a solution and an array of mutation rates, setting the 
	 * 		solution to the solution chromosome and the mutation rates array
	 * 		to the static double array
	 */
	public IndivGlobalGeneSpecMutate(int[] solution, double[] mutationRates) {
		super(solution);
		
		this.mutationRates = mutationRates;
	}
	
	/*
	 * Constructor: creates a random array, but does not change the static mutation rate 
	 * 		array
	 */
	public IndivGlobalGeneSpecMutate(int solutionLength) {
		super(solutionLength);
	}
	
	/*
	 * Constructor: sets a solution to a new individual. Does not change the static
	 * 		mutation rate array
	 */
	public IndivGlobalGeneSpecMutate(int[] solution) {
		super(solution);
	}

	/*
	 * (non-Javadoc)
	 * @see geneticAlgorithm.Individual#equals(geneticAlgorithm.Individual)
	 * @param Individual
	 * 		takes in an individual that will be compare to this individual
	 * @return boolean
	 * 		true if both solution chromosomes are the same false otherwise
	 */
	@Override
	public boolean equals(Individual indiv) {
		if(this.solutionChromosome.length != indiv.solutionChromosome.length) {
			return false;
		}
		for(int i = 0; i < this.solutionChromosome.length; i++) {
			if(this.solutionChromosome[i] != indiv.solutionChromosome[i]) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public void mutation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Individual> crossover(Individual in) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Individual createRandomIndiv() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see geneticAlgorithm.Individual#copy()
	 * @return Individual
	 * 		creates a deep copy of the individual
	 */
	@Override
	public Individual copy() {
		//create copy of individual
		IndivGlobalGeneSpecMutate copyIndiv = new IndivGlobalGeneSpecMutate(this.solutionChromosome.clone());
		return copyIndiv;
	}
	
	/*
	 * (non-Javadoc)
	 * @see geneticAlgorithm.Individual#getMutationRate()
	 */
	@Override
	public double getMutationRate() {
		
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * @see geneticAlgorithm.Individual#getType()
	 * @return String
	 * 		"Global Gene Specific Mutation" as that is the type of individual it is
	 */
	@Override
	public String getType() {
		return "Global Gene Specific Mutation";
	}

}
