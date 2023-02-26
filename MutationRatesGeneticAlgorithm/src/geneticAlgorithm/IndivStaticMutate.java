package geneticAlgorithm;

import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IndivStaticMutate extends Individual{
	
	/*
	 * IndivStaticMutate constructor.
	 * takes in solutionLength and mutationRate
	 * mutationRate is assigned to staticMuationRate
	 * solutionLength is passes to the Individual constructor
	 */
	public IndivStaticMutate(int solutionLength, double mutationRate) {
		super(solutionLength);
		
		//set mutation rate
		this.mutationRate = mutationRate;
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
		this.mutationRate = mutationRate;
	}
	
	/*
	 * (non-Javadoc)
	 * @see geneticAlgorithm.Individual#equals(geneticAlgorithm.Individual)
	 * 
	 * @param Individual
	 * 		the individual that this individual is checking if they are the same
	 * @return boolean
	 * 		true if the indiv's solutionChomosome is equal to this solutionChomosome else
	 * return false
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
	
	/*
	 * (non-Javadoc)
	 * @see geneticAlgorithm.Individual#mutation()
	 * 
	 * Generates random double between 0 and 1 for each gene
	 * id random number is less than mutationRate the gene is mutated
	 */
	@Override
	public void mutation() {
		System.out.print(" " + 1);
		//goes through every gene in the solution
		for(int i=0; i < solutionChromosome.length; i++) {
			double mutate = rand.nextDouble();
			//if random double is less then the static mutation rate then mutate
			if(mutate <= mutationRate) {
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
	 * @returns List<Individual>
	 * 		returns the new solutions created from crossover
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
		
		IndivStaticMutate indiv1 = new IndivStaticMutate(newSolution1, this.mutationRate);
		IndivStaticMutate indiv2 = new IndivStaticMutate(newSolution2, this.mutationRate);
		newSolution.add(indiv1);
		newSolution.add(indiv2);
		
		return newSolution;
	}
	
	/*
	 * (non-Javadoc)
	 * @see geneticAlgorithm.Individual#createRandomIndiv()
	 * 
	 * @return Individual
	 * 		a new static mutation individual with a randomly gnerate solution
	 */
	public Individual createRandomIndiv() {
		//create new individual
		IndivStaticMutate indiv = new IndivStaticMutate(this.length, this.mutationRate);
		
		return indiv;
	}
	
	/*
	 * (non-Javadoc)
	 * @see geneticAlgorithm.Individual#copy()
	 * @return Individual
	 * 		a deep copy of an individual
	 */
	@Override
	public Individual copy() {
		IndivStaticMutate copyIndiv = new IndivStaticMutate(this.solutionChromosome.clone(), this.mutationRate);
		return copyIndiv;
	}
	
	/*
	 * Sets the mutation rate
	 */
	public void setMutationRate(double mutationRate) {
		this.mutationRate = mutationRate;
	}
	
	/*
	 * returns that mutation rate
	 */
	public double getMutationRate() {
		return this.mutationRate;
	}
	
	/*
	 * (non-Javadoc)
	 * @see geneticAlgorithm.Individual#getType()
	 * @returns String
	 * 		returns the String "Static" since this is the static mutation rate
	 */
	@Override
	public String getType() {
		return "Static";
	}
}
