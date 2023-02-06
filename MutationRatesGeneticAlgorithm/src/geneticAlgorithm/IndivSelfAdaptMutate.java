package geneticAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class IndivSelfAdaptMutate extends IndivStaticMutate{

	public IndivSelfAdaptMutate(int solutionLength, double mutationRate) {
		super(solutionLength, mutationRate);
	}
	
	public IndivSelfAdaptMutate(int[] solution, double mutationRate) {
		super(solution, mutationRate);
	}
	
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
		
		//mutate mutation rate
		double mutateMutationRate = rand.nextDouble();
		if(mutateMutationRate <= staticMutationRate) {
			this.staticMutationRate = this.staticMutationRate + rand.nextGaussian()*0.01;
		}
	}
	
	public List<Individual> crossover(IndivSelfAdaptMutate in){
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
		IndivSelfAdaptMutate indiv2 = new IndivSelfAdaptMutate(newSolution2, in.staticMutationRate);
		newSolution.add(indiv1);
		newSolution.add(indiv2);
		
		return newSolution;
	}
	
	public Individual createRandomIndiv() {
		double mutationRate = this.rand.nextDouble();
		
		//create new individual
		IndivSelfAdaptMutate indiv = new IndivSelfAdaptMutate(this.length, mutationRate);
				
		return indiv;
	}
}
