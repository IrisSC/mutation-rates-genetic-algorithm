package geneticAlgorithm;

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
		System.out.println(test);
		//genetic algorithm
		//create population
		//do crossover
		//do mutations
		//return best gene
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
