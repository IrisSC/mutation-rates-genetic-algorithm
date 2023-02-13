package geneticAlgorithm;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

public class Population {
	List<Individual> pop = new ArrayList<Individual>();
	int numPop;
	Knapsack knapsack;
	//create random object
	protected static Random rand = new Random();
	
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
	public List<Individual> getPopulation(){
		return this.pop;
	}
	
	/*
	 * This method adds an individual to the population. And increases the population
	 * size by one
	 */
	public void addIndiv(Individual indiv) {
		this.pop.add(indiv);
		this.numPop = this.numPop + 1;
	}
	
	/* 
	 * @return int
	 * 		This function returns the max fitness of the population
	 */
	public int maxFitness() {
		int maxFitness = 0;
		
		for(int i = 0; i < this.pop.size(); i++) {
			Individual indiv = this.pop.get(i);
			int fitness = this.knapsack.fitness(indiv);
			if(fitness > maxFitness) {
				//check to make sure individual is a valid solution
				if(this.knapsack.isValid(indiv)) {
					maxFitness = fitness; 
				}
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
		double totalFitness = 0;
		double totalIndivs = 0.0;
		
		for(int i = 0; i < pop.size(); i++) {
			Individual indiv = pop.get(i);
			if(this.knapsack.isValid(indiv)) {
				int fitness = knapsack.fitness(indiv);
				totalFitness = totalFitness + fitness;
				totalIndivs =+ 1;
			}
		}
		return Math.round((totalFitness/totalIndivs)*100.0)/100.0;
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
			stanDev = stanDev + Math.pow((double)fitness-mean, 2);
		}
		
		stanDev = Math.round(Math.sqrt(stanDev/this.numPop)*100.0)/100.0;
		
		return stanDev;
	}
	
	public Individual getParent(int tournamnetSize) {
		int currentIndiv = rand.nextInt(this.numPop);
		int bestFitIndiv = currentIndiv;
		int bestFittess = knapsack.fitness(this.pop.get(currentIndiv));
		
		for(int i = 0; i < tournamnetSize; i++) {
			currentIndiv = rand.nextInt(this.numPop);
			int currentFittness = knapsack.fitness(this.pop.get(currentIndiv));
			if(currentFittness > bestFittess) {
				bestFittess = currentFittness;
				bestFitIndiv = currentIndiv;
			}
		}
		
		return this.pop.get(bestFitIndiv);
	}
	
	/*
	 * @return Individual
	 * 		returns the best fit individual in the population
	 */
	public Individual getBestFitIndiv() {
		Individual bestFit = this.pop.get(0);
		int bestFitness = this.knapsack.fitness(bestFit);
		
		for(int i = 1; i < this.numPop; i++) {
			int currentFitness = this.knapsack.fitness(this.pop.get(i));
			if(currentFitness > bestFitness) {
				//check that the individual represetns a valid solution
				if(this.knapsack.isValid(this.pop.get(i))) {
					bestFitness = currentFitness;
					bestFit = this.pop.get(i).copy();
				}
			}
		}
		
		return bestFit;
	}
	
	/*
	 * @param int 
	 * 		The size of the tournament selection for getting the parents
	 * @return Population
	 * 		The new population that has been generated through crossover and
	 * mutation. The best fit individual survives intact
	 */
	public Population generateNewPop(int tournamentSize) {
		//Perform crossover 
		Individual parent1 = getParent(tournamentSize);
		Individual parent2 = getParent(tournamentSize);
		Individual bestFit = getBestFitIndiv().copy();
		
		List<Individual> startNewPop = parent1.crossover(parent2);
		
		Population newPop = new Population(startNewPop, this.knapsack);
		
		for(int i = 0; i < (numPop-2)/2; i++) {
			parent1 = getParent(tournamentSize);
			parent2 = getParent(tournamentSize);
			
			List<Individual> newIndivids = parent1.crossover(parent2);
			
			newPop.addIndiv(newIndivids.get(0));
			newPop.addIndiv(newIndivids.get(1));
		}
		
		//Perform mutation
		for(int i = 0; i < newPop.getNumPopulation(); i++) {
			newPop.getPopulation().get(i).mutation();
		}
		//System.out.println(this.knapsack.fitness(bestFit));
		newPop.addIndiv(bestFit);
		
		//add best fit individual
		/*if(this.pop.size() % 2 == 1) {
			newPop.addIndiv(bestFit);
		}
		else if(this.pop.size() % 2 == 0) {
			newPop.getPopulation().remove(newPop.getNumPopulation()-1);
			newPop.addIndiv(getBestFitIndiv());
		}*/
		
		return newPop;
	}
}
