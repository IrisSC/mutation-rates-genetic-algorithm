package geneticAlgorithm;

import java.util.Random;

public class GeneticAlgorithm {
	public static void main(String[] args) {
		//variables used in all exmaples
		int populationNum = 10;
		
		//example one
		int numOfGenes = 10;
		int capWeight = 269;
		int maxValue = 295;
		int[] weights = {95, 4, 60, 32, 23, 72, 80, 62, 65, 46};
		int[] values = {55, 10, 47, 5, 4, 50, 8, 61, 85, 87};
		double[] mutationRate = {0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01};
		
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
		/*for(int i = 0; i < numOfGenes; i++) {
			for(int j=0; j < populationNum; j++) { 
				System.out.print(population[i][j]);
			}
			System.out.println("");
		}*/
		
		//do crossover
		//do mutations
		//return best gene
	}
	public static int[][] generateRandomPopulation(int numOfGenes, int populationNum){
		//create a Random object
		Random rand = new Random();
		//create population
		int[][] population = new int[numOfGenes][populationNum];
		//add gene allelles to population
		for(int i = 0; i < numOfGenes; i++) {
			for(int j=0; j < populationNum; j++) {
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
