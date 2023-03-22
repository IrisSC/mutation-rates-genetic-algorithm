package geneticAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class IndivGlobalGeneSpecMutate extends Individual{
	
	protected static double[] mutationRates;
	
	protected static Knapsack sack;
	
	protected double mutateRate;
	
	protected int[] mutationValue;
	
	/*
	 * Constructor: creates random solution and the mutation rates to all be the same
	 */
	public IndivGlobalGeneSpecMutate(int solutionLength, double initalMutationRate, Knapsack sack) {
		super(solutionLength);
		
		this.sack = sack;
		
		this.mutateRate = 0.5;

		this.mutationRates = new double[solutionLength];
		this.mutationValue = new int[solutionLength];
		for(int i = 0; i < this.mutationRates.length; i++) {
			this.mutationRates[i] = initalMutationRate;
			this.mutationValue[i] = 0;
		}
	}
	
	/*
	 * Constructor: takes in a solution and an array of mutation rates, setting the 
	 * 		solution to the solution chromosome and the mutation rates array
	 * 		to the static double array
	 */
	public IndivGlobalGeneSpecMutate(int[] solution, double[] mutationRates, Knapsack sack) {
		super(solution);
		
		this.sack = sack;
		
		this.mutateRate = 0.5;
		
		this.mutationRates = mutationRates;
		
		this.mutationValue = new int[solution.length];
		for(int i = 0; i < this.mutationRates.length; i++) {
			this.mutationValue[i] = 0;
		}
	}
	
	/*
	 * Constructor: creates a random array, but does not change the static mutation rate 
	 * 		array
	 */
	public IndivGlobalGeneSpecMutate(int solutionLength) {
		super(solutionLength);
		
		this.mutateRate = 0.5;
		
		this.mutationValue = new int[solutionLength];
		for(int i = 0; i < this.mutationRates.length; i++) {
			this.mutationValue[i] = 0;
		}
	}
	
	/*
	 * Constructor: sets a solution to a new individual. Does not change the static
	 * 		mutation rate array
	 */
	public IndivGlobalGeneSpecMutate(int[] solution) {
		super(solution);
		
		this.mutateRate = 0.5;
		
		this.mutationValue = new int[solution.length];
		for(int i = 0; i < this.mutationRates.length; i++) {
			this.mutationValue[i] = 0;
		}
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
	
	/*
	 * (non-Javadoc)
	 * @see geneticAlgorithm.Individual#mutation()
	 * 
	 * Mutates every each according to the mutation rate of that specific gene. Will
	 * then mutate the mutation rate using a Gausain distribution. The Gaussian 
	 * distrubition gets moved one stand deviation to the right if mutating that gene has 
	 * a postive effect and 1 stand deviation to the left if mutating that gene has a 
	 * negative effect
	 */
	@Override
	public void mutation() {
		//go through every gene
		for(int i = 0; i < this.solutionChromosome.length; i++) {
			double mutate = this.rand.nextDouble();
			if(mutate < this.mutationRates[i]) {
				//safe fitness of individual
				IndivGlobalGeneSpecMutate copyIndiv0 = new IndivGlobalGeneSpecMutate(this.solutionChromosome);
				int fitnessBefore = sack.fitness(copyIndiv0);
				
				//mutate gene
				if(solutionChromosome[i] == 1) {
					solutionChromosome[i] = 0;
				}else {
					solutionChromosome[i] = 1;
				}
				
				//get new fitness of individual
				IndivGlobalGeneSpecMutate copyIndiv1 = new IndivGlobalGeneSpecMutate(this.solutionChromosome);
				int fitnessAfter = sack.fitness(copyIndiv1);
				
				//record if mutation was good or bad
				if(fitnessBefore > fitnessAfter) {
					mutationValue[i] = mutationValue[i] - 1;
				}else if(fitnessBefore < fitnessAfter){
					mutationValue[i] = mutationValue[i] + 1;
				}
			}
		}
		
		//mutate mutation rates
		for(int i = 0; i < this.mutationValue.length; i++) {
			double mutateMutation = this.rand.nextDouble();
			if(mutateMutation < this.mutateRate) {
				double mutate = rand.nextGaussian()*0.05;
				if(mutationValue[i] > 0) {
					mutate = mutate + 0.05;
				}else if(mutationValue[i] < 0) {
					mutate = mutate - 0.05;
				}
				
				//make sure mutation rate does not go below zero
				if(this.mutationRates[i] + mutate < 0) {
					this.mutationRates[i] = 0.0;
				}else {
					this.mutationRates[i] = this.mutationRates[i] + mutate;
				}
			}
		}
		
	}
	/*
	 * (non-Javadoc)
	 * @see geneticAlgorithm.Individual#crossover(geneticAlgorithm.Individual)
	 * @param Individaul
	 * 		takes in the second parent individual who will be used to create offspring
	 * @return <List> Individual
	 * 		two children individuals. these individuals are of the type IndivGlobalGeneSpecMutate
	 */
	@Override
	public List<Individual> crossover(Individual in) {
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
		
		IndivGlobalGeneSpecMutate indiv1 = new IndivGlobalGeneSpecMutate(newSolution1);
		IndivGlobalGeneSpecMutate indiv2 = new IndivGlobalGeneSpecMutate(newSolution2);
		newSolution.add(indiv1);
		newSolution.add(indiv2);
		
		return newSolution;
	}
	
	/*
	 * (non-Javadoc)
	 * @see geneticAlgorithm.Individual#createRandomIndiv()
	 * @return Individual
	 * 		a IndivGlobalGeneSpecMutate individual with a random solution
	 */
	@Override
	public Individual createRandomIndiv() {
		IndivGlobalGeneSpecMutate randIndiv = new IndivGlobalGeneSpecMutate(this.length);
		return randIndiv;
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
