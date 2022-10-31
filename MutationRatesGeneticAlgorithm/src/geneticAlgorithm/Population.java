package geneticAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Population {
	List<Individual> pop = new ArrayList<Individual>();
	int numPop;
	Knapsack knapsack;
	
	/*
	 * Population constructor
	 * Generates numPop number of individual as the type that was inputed
	 */
	public Population(int numPop, Individual indiv, Knapsack knapsack) {
		this.numPop = numPop;
		this.knapsack = knapsack;
		//generate pop from create new individual
		pop.add(indiv);
		for(int i=1; i < numPop; i++) {
			Individual newIndiv = indiv.createRandomIndiv();
			pop.add(newIndiv);
		}
	}
	
	/*
	 * Population Constructor
	 * @param List<Individual>
	 * 		The list of individuals in the population
	 * @param knapsack
	 * 		the knapsack problem that this population is trying to solve
	 */
	public Population(List<Individual> pop, Knapsack knapsack) {
		this.pop = pop;
		this.numPop = pop.size();
		this.knapsack = knapsack;
	}
	
	/*
	 * @returns int
	 * 		number of individuals in the population
	 */
	public int getNumPopulation() {
		return this.numPop;
	}
	
	/*
	 * @return Knapsack
	 * 		the knapsack problem for this population
	 */
	public Knapsack getKnapsack() {
		return this.knapsack;
	}
	
	/*
	 * @param Knapsack
	 * 		input the new Knapsack problem for this population
	 */
	public void setKnapsack(Knapsack sack) {
		this.knapsack = sack;
	}
	
	/*
	 * @returns List<Individual>
	 * 		the List of individuals in the population
	 */
	public List<Individual> getPopultion(){
		return this.pop;
	}
	
	/* 
	 * @return int
	 * 		This function returns the max fitness of the population
	 */
	public int maxFitness() {
		int maxFitness = 0;
		
		for(int i = 0; i < pop.size(); i++) {
			Individual indiv = pop.get(i);
			int fitness = knapsack.fitness(indiv);
			if(fitness > maxFitness) {
				maxFitness = fitness; 
			}
		}
		return maxFitness;
	}
	
	/*
	 * @return int
	 * 		This function returns the min fitness of the population
	 */
	public int minFitness() {
		int minFitness = knapsack.getCap();
		
		for(int i = 0; i < pop.size(); i++) {
			Individual indiv = pop.get(i);
			int fitness = knapsack.fitness(indiv);
			if(fitness < minFitness) {
				minFitness = fitness; 
			}
		}
		return minFitness;
	}
	
	/*
	 * @return double
	 * 		This function returns the average or mean fitness of the population 
	 */
	public double avgFitness() {
		int totalFitness = 0;
		
		for(int i = 0; i < pop.size(); i++) {
			Individual indiv = pop.get(i);
			int fitness = knapsack.fitness(indiv);
			totalFitness = totalFitness + fitness;
		}
		return totalFitness/this.numPop;
	}
	
	/*
	 * @return double
	 * 		This function returns the standard deviation of the fitness values of 
	 * all the individuals in the population. 
	 */
	public double stanDevFitness() {
		double mean = this.avgFitness();
		
		double stanDev = 0.0;
		
		for(int i=0; i < this.pop.size(); i++) {
			Individual indiv = pop.get(i);
			int fitness = knapsack.fitness(indiv);
			stanDev = stanDev + Math.pow(fitness-mean, 2);
		}
		
		stanDev = Math.sqrt(stanDev/this.numPop);
		
		return stanDev;
	}
}
