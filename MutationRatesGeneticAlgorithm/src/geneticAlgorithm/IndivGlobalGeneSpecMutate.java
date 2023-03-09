package geneticAlgorithm;

import java.util.List;

public class IndivGlobalGeneSpecMutate extends Individual{

	public IndivGlobalGeneSpecMutate(int solutionLength) {
		super(solutionLength);
		// TODO Auto-generated constructor stub
	}
	
	public IndivGlobalGeneSpecMutate(int[] solution) {
		super(solution);
		// TODO Auto-generated constructor stub
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
		IndivGlobalGeneSpecMutate copyIndiv = 
						new IndivGlobalGeneSpecMutate(this.solutionChromosome.clone());
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
