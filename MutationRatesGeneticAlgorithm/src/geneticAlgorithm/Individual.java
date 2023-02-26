package geneticAlgorithm;

import java.util.List;
import java.util.Random;

public abstract class Individual {
	//length of solution
	protected int length;
	//this array represents a solution to the problem
	protected int[] solutionChromosome;
	//the mutation rate  (used by the static & self-adaptive Individuals)
	protected double mutationRate;
	//create random object
	protected static Random rand = new Random();
	
	/*
	 * Individual constructor that takes in the length of the solution
	 * the mutation rate and mutation rate chromosome are set to be 0.2
	 * the solution is randomly generated
	 */
	public Individual(int solutionLength) {
		//set solution length
		this.length = solutionLength;
		
		//create Individual solution
		this.solutionChromosome = createSolution(solutionLength);
	}
	
	/*
	 * Individual constructor that takes in the solution, length of the solution and mutation rate
	 * mutation rate chromosome are set to be 0.2
	 */
	public Individual(int[] solution) {
		//set solution length
		this.length = solution.length;
		
		//set individual solution
		this.solutionChromosome = new int[solution.length];
		this.solutionChromosome = solution.clone();
	}
	
	/*
	 * @param solutionLength
	 * 		the length os the solution
	 * @returns int[]
	 * 		a randomly generate solution. This solution is made out of 1's and 0's
	 */
	private static int[] createSolution(int solutionLength) {
		//create solution
		int[] solution = new int[solutionLength];
		//assigns each gene a 1 or 0
		for(int i = 0; i < solutionLength; i ++) {
			int random = rand.nextInt(2); 
			solution[i] = random;
		}
		return solution;
	}
	
	/*
	 * @param solutionLength
	 * 		length of the solution
	 * @param mutatuon rate
	 * 		default mutation rate 
	 * @return double[]
	 * 		an array the length of the solution filled with thedefault mutation rate
	 */
	private static double[] createUniformMutationChromosome(int solutionLength, double mutationRate) {
		double[] mutationChromosome = new double[solutionLength];
		for(int i = 0; i < solutionLength; i++) {
			mutationChromosome[i] = mutationRate;
		}
		return mutationChromosome;
	}
	
	/*
	 * Each type of individual will have different criteria for an individual being equal
	 */
	public abstract boolean equals(Individual indiv);
	
	/*
	 * Each type of individual will mutate differently
	 */
	public abstract void mutation();
	
	
	/*
	 * Each type of individual will have a different set of things to crossover
	 */
	public abstract List<Individual> crossover(Individual in);
	
	/*
	 * Implementation should create a new individual with a randomly generate solution
	 * of its individual type
	 */
	public abstract Individual createRandomIndiv();
	
	/*
	 * creates a deep copy of an individual
	 */
	public abstract Individual copy();
	
	/*
	 * @return the mutation rate
	 */
	public abstract double getMutationRate();
	
	/*
	 * @return String
	 * 		the name of the type of Individual that the solution is
	 */
	public abstract String getType();
	
	/*
	 * @returns the length of the solution
	 */
	public int getLength() {
		return this.length;
	}
	
	/*
	 * @returns the solution
	 */
	public int[] getSolutionChromosome() {
		return this.solutionChromosome;
	}
}
