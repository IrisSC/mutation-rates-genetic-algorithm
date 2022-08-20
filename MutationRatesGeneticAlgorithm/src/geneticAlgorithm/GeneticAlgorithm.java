package geneticAlgorithm;

import java.util.Random;

public class GeneticAlgorithm {
	public static void main(String[] args) {
		//variables used in all exmaples
		int populationNum = 4;
		
		//example one
		int numOfGenes = 10;
		int capWeight = 269;
		int maxValue = 295;
		int[] weights = {95, 4, 60, 32, 23, 72, 80, 62, 65, 46};
		int[] values = {55, 10, 47, 5, 4, 50, 8, 61, 85, 87};
		double[] mutationRates = {0.5, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01};
		
		//individuals to test the fitness function with
		int[]indiv1 = {1, 1, 1, 1, 1, 1, 0, 0, 0, 0}; //return -1
		int[] indiv2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; //return 0
		int[] indiv3 = {1, 0, 1, 1, 0, 0, 1, 0, 0, 0}; //return 115
		
		int test = fitnessFunction(capWeight, weights, values, indiv3);
		//System.out.println(test);
		
		//genetic algorithm
		//create population
		int[][] population = generateRandomPopulation(numOfGenes, populationNum);
		//test that it created a population with genes 1's and 0's
		for(int i = 0; i < populationNum; i++) {
			for(int j=0; j < numOfGenes; j++) { 
				System.out.print(population[i][j]);
			}
			System.out.println("");
		}
		System.out.println("New Population");
		//do crossover
		//need to change to copy
		int[][] newPop = newPop(capWeight, weights, values, population, numOfGenes, populationNum).clone();
		for(int i = 0; i < newPop.length; i++) {
			for(int j=0; j < numOfGenes; j++) { 
				System.out.print(newPop[i][j]);
			}
			System.out.println("");
		}
		//do mutations
		mutations(newPop, mutationRates, numOfGenes);
		System.out.println("mutated individuals");
		for(int i = 0; i < newPop.length; i++) {
			for(int j=0; j < numOfGenes; j++) { 
				System.out.print(newPop[i][j]);
			}
			System.out.println("");
		}
		//return best gene
	}
	public static void mutations(int[][] population, double[] mutationRates, int numOfGenes) {
		//create a Random object
		Random rand = new Random();
		
		for(int i = 0; i < population.length; i++) {
			for(int j=0; j < numOfGenes; j++) {
				int mutate = rand.nextInt(100);
				if(mutate < mutationRates[j]*100) {
					if(population[i][j] == 0) {
						population[i][j] = 1;
					}else {
						population[i][j] = 0;
					}
				}
			}
		}
	}
	public static int[][] newPop(int capWeight, int[] weights, int[] values, 
			int[][] population, int numOfGenes, int populationNum){
		//gives room to include the fittest one in the population
		if(populationNum%2 == 0) {
			populationNum = populationNum + 1;
		}
		
		//create new population
		int[][] newPop = new int[populationNum][numOfGenes];
		
		for(int i = 0; i < populationNum/2; i++) {
			//select ones in ternimant
			int[] touramentIndivs = new Random().ints(0, populationNum-1).distinct().limit(4).toArray();
			//pick the two with the highest fitness
			int[] twoFittested = twoHighestFitness(capWeight, weights, values, population, 
					touramentIndivs, 2, numOfGenes);
			//crossover
			for(int j = 0; j < numOfGenes; j++) {
				if(j < numOfGenes/2) {
					//first half
					newPop[i][j] = population[twoFittested[0]][j];
					newPop[i+populationNum/2][j] = population[twoFittested[1]][j];
				}else {
					//second half switched
					newPop[i][j] = population[twoFittested[1]][j];
					newPop[i+populationNum/2][j] = population[twoFittested[0]][j];
				}
			}
		}
		int[] touramentIndivs = new Random().ints(0, populationNum-1).distinct().limit(4).toArray();
		//get fittest individual
		int fittest = highestFitness(capWeight, weights, values, population, numOfGenes);
		
		//add fittest to new population
		for(int i = 0; i < numOfGenes; i++) {
			newPop[populationNum-1][i] = population[fittest][i];
		}
		return newPop;
	}
	public static int[] twoHighestFitness(int capWeight, int[] weights, int[] values, int[][] population,
			int[] tournamentIndiv, int numGenerated, int numOfGenes) {
		//contains the number in the population f the two highest individuals
		//set so it will at least of a couple highest
		int[] highest = {0, 1};
		//defualt values for the two highest
		int high1 = -1;
		int high2 = -1;
		//iterates through each one in the termanent
		for(int i = 0; i < 4; i++) {
			//copies current individual in the teramines
			int[] individual = new int[numOfGenes];
			for(int j = 0; j < numOfGenes; j++) {
				individual[j] = population[tournamentIndiv[i]][j];
			}
			//gets the individuals fittness
			int fitness = fitnessFunction(capWeight, weights, values, individual);
			//if the fitness is higher then any of the two highest, it will reset the
			//highest fitness
			if(fitness > high1) {
				high2 = high1;
				high1 = fitness;
				highest[1] = highest[0];
				highest[0] = tournamentIndiv[i];
			}else if(fitness > high2){
				high2 = fitness;
				highest[1] = tournamentIndiv[i];
			}
		}
		return highest;
	}
	
	public static int highestFitness(int capWeight, int[] weights, int[] values, int[][] population, int numOfGenes) {
		//highest is the indext of the highest and high is the fitness value
		int highest = 0;
		int high = -1;
		
		for(int i = 0; i < population.length; i++) {
			//gets the fitness for each individual in the population
			int[] individual = new int[numOfGenes];
			for(int j = 0; j < numOfGenes; j++) {
				individual[j] = population[i][j];
			}
			int fitness = fitnessFunction(capWeight, weights, values, individual);
			//if fitness is higher then switch highest fitness
			if(fitness > high) {
				high = fitness;
				highest = i;
			}
		}
		//return the index of the individual with the highest fitness
		return highest;
	}
	public static int[][] generateRandomPopulation(int numOfGenes, int populationNum){
		//create a Random object
		Random rand = new Random();
		//create population
		int[][] population = new int[populationNum][numOfGenes];
		//add gene allelles to population
		for(int i = 0; i < populationNum; i++) {
			for(int j=0; j < numOfGenes; j++) {
				int random = rand.nextInt(2); 
				population[i][j] = random;
			}
		}
		return population;
	}
	public static int fitnessFunction(int capWeight, int[] weights, int[] values, int[] individual) {
		//integers to hold the total weight and value of the individual
		int totWeight = 0;
		int totValue = 0;
		
		//iterate through each gene to get the value and weight
		for(int i = 0; i < individual.length; i++) {
			int gene = individual[i];
			if(gene == 1) {
				totWeight = totWeight + weights[i];
				totValue = totValue + values[i];
			}
		}
		if(totWeight > capWeight) {
			return -1;
		}
		else {
			return totValue;
		}
	}
}
