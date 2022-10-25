package geneticAlgorithm;

import java.util.Random;

public class IndivStaticMutate extends Individual{
	
	//the static mutation rate 
	private double staticMutationRate;
	
	/*
	 * IndivStaticMutate constructor.
	 * takes in solutionLength and mutationRate
	 * mutationRate is assigned to staticMuationRate
	 * solutionLength is passes to the Individual constructor
	 */
	public IndivStaticMutate(int solutionLength, double mutationRate) {
		super(solutionLength);
		
		//set mutation rate
		this.staticMutationRate = mutationRate;
	}
	
	/*
	 * IndivStaticMutate constructor.
	 * takes in solutionLength, solution, and mutationRate
	 * mutationRate is assigned to staticMuationRate
	 * solutionLength and solution are is passes to the Individual constructor
	 */
	public IndivStaticMutate(int solutionLength, int[] solution, double mutationRate) {
		super(solutionLength, solution);
		
		//set mutation rate
		this.staticMutationRate = mutationRate;
	}
	
	/*
	 * (non-Javadoc)
	 * @see geneticAlgorithm.Individual#mutation()
	 * 
	 * Generates random double between 0 and 1 for each gene
	 * id random number is less than mutationRate the gene is mutated
	 */
	@Override
	public void mutation() {
		
		//goes through every gene in the solution
		for(int i=0; i < solutionChromosome.length; i++) {
			double mutate = rand.nextDouble();
			//if random double is less then the static mutation rate then mutate
			if(mutate <= staticMutationRate) {
				if(solutionChromosome[i] == 1) {
					solutionChromosome[i] = 0;
				}else {
					solutionChromosome[i] = 1;
				}
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see geneticAlgorithm.Individual#crossover(geneticAlgorithm.Individual)
	 * 
	 * @param Individual in
	 * 		the individual that this individual is being crossed over with
	 * @returns int[]
	 * 		returns the new solution created from crossover
	 */
	@Override
	public int[] crossover(Individual in){
		//Random rand = new Random();
		int crossoverpoint = (int)this.length/2;
		
		int[] newSolution = new int[this.length];
		for(int i = 0; i < crossoverpoint; i++) {
			newSolution[i] = this.solutionChromosome[i];
		}
		for(int j = crossoverpoint; j < this.length; j++) {
			newSolution[j] = in.solutionChromosome[j];
		}
		return newSolution;
	}
	
	/*
	 * Sets the static mutation rate
	 */
	public void setMutationRate(double mutationRate) {
		this.staticMutationRate = mutationRate;
	}
	
	/*
	 * returns that static mutation rate
	 */
	public double getMutationRate() {
		return this.staticMutationRate;
	}
}
