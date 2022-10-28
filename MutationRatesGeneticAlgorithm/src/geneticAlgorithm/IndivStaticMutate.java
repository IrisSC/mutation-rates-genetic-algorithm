package geneticAlgorithm;

import java.util.ArrayList;
import java.util.List;
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
	public IndivStaticMutate(int[] solution, double mutationRate) {
		super(solution);
		
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
	public List<Individual> crossover(Individual in){
		//Random rand = new Random();
		int crossoverpoint = (int)this.length/2;
		
		List<Individual> newSolution = new ArrayList<Individual>();
		
		int[] newSolution1 = new int[this.length];
		int[] newSolution2 = new int[this.length];
		
		for(int i = 0; i < crossoverpoint; i++) {
			newSolution1[i] = this.solutionChromosome[i];
			newSolution2[i] = in.solutionChromosome[i];
		}
		for(int j = crossoverpoint; j < this.length; j++) {
			newSolution1[j] = in.solutionChromosome[j];
			newSolution2[j] = this.solutionChromosome[j];
		}
		
		IndivStaticMutate indiv1 = new IndivStaticMutate(newSolution1, this.staticMutationRate);
		IndivStaticMutate indiv2 = new IndivStaticMutate(newSolution2, this.staticMutationRate);
		newSolution.add(indiv1);
		newSolution.add(indiv2);
		
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
