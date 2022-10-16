package geneticAlgorithm;

import java.util.Random;

public class Individual {
	//length of solution
	private int length;
	//this array represents a solution to the problem
	private int[] solutionChromosome;
	//self-adapting mutation rate for testing
	private double mutationRate;
	//self-adapting gene specific mutation rate (another chromosome)
	private double[] geneSpecificMutationRates; 
	
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
		
		//set mutation rate
		this.mutationRate = 0.2;
		
		//create gene specific mutation rates
		this.geneSpecificMutationRates = createUniformMutationChromosome(solutionLength, (double)0.2);
	}
	
	/*
	 * Individual constructor that takes in the length of the solution and mutation rate
	 * mutation rate chromosome are set to be 0.2
	 * the solution is randomly generated
	 */
	public Individual(int solutionLength, double mutationRate) {
		//set solution length
		this.length = solutionLength;
		
		//create individual solution
		this.solutionChromosome = createSolution(solutionLength);
		
		//set mutation rate
		this.mutationRate = mutationRate;
		
		//create gene specific mutation rates
		this.geneSpecificMutationRates = createUniformMutationChromosome(solutionLength, (double)0.2);
	}
	
	/*
	 * Individual constructor that takes in the solution, length of the solution and mutation rate
	 * mutation rate chromosome are set to be 0.2
	 */
	public Individual(int solutionLength, double mutationRate, int[] solution) {
		//set solution length
		this.length = solutionLength;
		
		//set individual solution
		this.solutionChromosome = new int[solutionLength];
		this.solutionChromosome = solution.clone();
		
		//set mutation rate
		this.mutationRate = mutationRate;
		
		//create gene specific mutation rates
		this.geneSpecificMutationRates = createUniformMutationChromosome(solutionLength, (double)0.2);
	}
	
	/*
	 * @param solutionLength
	 * 		the length os the solution
	 * @returns int[]
	 * 		a randomly generate solution. This solution is made out of 1's and 0's
	 */
	private static int[] createSolution(int solutionLength) {
		//create a Random object
		Random rand = new Random();
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
	/*
	 * @returns the mutation rate
	 */
	public double getMutationRate() {
		return this.mutationRate;
	}
	
	/*
	 * @returns the mutation chromosome
	 */
	public double[] getGeneSpecificMutationRate() {
		return this.geneSpecificMutationRates;
	}
	
	/*
	 * sets the mutation rate
	 */
	public void setMuationRate(int mutationRate) {
		this.mutationRate = mutationRate;
	}
}
