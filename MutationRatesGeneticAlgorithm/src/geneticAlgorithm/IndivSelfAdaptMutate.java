package geneticAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class IndivSelfAdaptMutate extends IndivStaticMutate{
	
	protected double mutateRate;

	public IndivSelfAdaptMutate(int solutionLength, double mutationRate) {
		super(solutionLength, mutationRate);
		
		mutateRate = 0.5;
	}
	
	public IndivSelfAdaptMutate(int[] solution, double mutationRate) {
		super(solution, mutationRate);
		
		mutateRate = 0.5;
	}
	
	@Override
	public void mutation() {
		System.out.print(" " + 2);
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
		
		//mutate mutation rate
		double mutateMutationRate = rand.nextDouble();
		if(mutateMutationRate <= this.mutateRate) {
			double mutate = rand.nextGaussian()*0.1;
			if(this.staticMutationRate + mutate < 0) {
				this.staticMutationRate = 0.0;
			}else {
				this.staticMutationRate = this.staticMutationRate + mutate;
			}
		}
	}
	
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
		
		IndivSelfAdaptMutate indiv1 = new IndivSelfAdaptMutate(newSolution1, this.staticMutationRate);
		IndivSelfAdaptMutate indiv2 = new IndivSelfAdaptMutate(newSolution2, this.staticMutationRate);
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
		IndivSelfAdaptMutate indiv = new IndivSelfAdaptMutate(this.length, this.staticMutationRate);
				
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
		IndivSelfAdaptMutate copyIndiv = new IndivSelfAdaptMutate(this.solutionChromosome.clone(), this.staticMutationRate);
		return copyIndiv;
	}
	
	@Override
	public String getType() {
		return "Self-Adaptive";
	}
}
