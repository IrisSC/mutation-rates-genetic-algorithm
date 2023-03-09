package geneticAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class IndivSelfAdaptMutate extends IndivStaticMutate{
	
	//The mutation rate for the mutation rate
	protected double mutateRate;

	/*
	 * Constructor for the self-adaptive individual
	 * @param int, double
	 * 		takes in the solution length and mutation rate
	 */
	public IndivSelfAdaptMutate(int solutionLength, double mutationRate) {
		super(solutionLength, mutationRate);
		
		mutateRate = 0.5;
	}
	
	/*
	 * Constructor for the self-adaptive individual
	 * @param int[], double
	 * 		takes in the solution and mutation rate
	 */
	public IndivSelfAdaptMutate(int[] solution, double mutationRate) {
		super(solution, mutationRate);
		
		mutateRate = 0.5;
	}
	
	/*
	 * (non-Javadoc)
	 * @see geneticAlgorithm.IndivStaticMutate#mutation()
	 * 
	 * 		Generates random double between 0 and 1 for each gene
	 * id random number is less than mutationRate the gene is mutated
	 * 		Same is done for the mutation rate
	 */
	@Override
	public void mutation() {
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
		
		//mutate mutation rate
		double mutateMutationRate = rand.nextDouble();
		if(mutateMutationRate <= this.mutateRate) {
			double mutate = rand.nextGaussian()*0.01;
			if(this.mutationRate + mutate < 0) {
				this.mutationRate = 0.0;
			}else {
				this.mutationRate = this.mutationRate + mutate;
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see geneticAlgorithm.IndivStaticMutate#crossover(geneticAlgorithm.Individual)
	 * 
	 * @param Individual in
	 * 		the individual that this individual is being crossed over with
	 * @returns List<Individual>
	 * 		returns the new solutions created from crossover
	 */
	@Override
	public List<Individual> crossover(Individual in){
		//cast
		IndivSelfAdaptMutate insa = (IndivSelfAdaptMutate)in;
		
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
		
		IndivSelfAdaptMutate indiv1 = new IndivSelfAdaptMutate(newSolution1, this.mutationRate);
		IndivSelfAdaptMutate indiv2 = new IndivSelfAdaptMutate(newSolution2, insa.mutationRate);
		newSolution.add(indiv1);
		newSolution.add(indiv2);
		
		return newSolution;
	}
	
	/*
	 * (non-Javadoc)
	 * @see geneticAlgorithm.IndivStaticMutate#createRandomIndiv()
	 * return Individual
	 * 		a randomly generated slef adpating mutation rate individual
	 */
	public Individual createRandomIndiv() {
		double mutationRate = rand.nextDouble();
		
		//create new individual
		IndivSelfAdaptMutate indiv = new IndivSelfAdaptMutate(this.length, this.mutationRate);
				
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
		IndivSelfAdaptMutate copyIndiv = new IndivSelfAdaptMutate(this.solutionChromosome.clone(), this.mutationRate);
		return copyIndiv;
	}
	
	/*
	 * (non-Javadoc)
	 * @see geneticAlgorithm.IndivStaticMutate#getType()
	 * 
	 * @returns String
	 * 		returns the String "Self-Adaptive" since this is the self-adaptive
	 *  mutation rate individual
	 */
	@Override
	public String getType() {
		return "Self-Adaptive";
	}
}
