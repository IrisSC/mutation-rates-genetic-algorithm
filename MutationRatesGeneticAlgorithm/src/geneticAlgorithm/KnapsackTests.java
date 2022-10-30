package geneticAlgorithm;

import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KnapsackTests {
	
	/*
	 * Tests that the cap, weights and values are correct for Knapsack Problem 1
	 */
	@Test
	void createKnapsack1() {
		KnapSack1 sack1 = new KnapSack1();
		
		assertEquals("cap is 295", sack1.getCap(), 295);
		assertEquals("weights is length 10", sack1.getWeights().length, 10);
		assertEquals("values is length 10", sack1.getValues().length, 10);
		
		assertEquals("weight at 0 is 95", sack1.getWeights()[0], 95);
		assertEquals("weight at 1 is 4", sack1.getWeights()[1], 4);
		assertEquals("weight at 5 is 72", sack1.getWeights()[5], 72);
		assertEquals("weight at 7 is 62", sack1.getWeights()[7], 62);
		assertEquals("weight at 9 is 46", sack1.getWeights()[9], 46);
		
		assertEquals("value at 0 is 55", sack1.getValues()[0], 55);
		assertEquals("value at 1 is 10", sack1.getValues()[1], 10);
		assertEquals("value at 5 is 50", sack1.getValues()[5], 50);
		assertEquals("value at 7 is 61", sack1.getValues()[7], 61);
		assertEquals("value at 9 is 87", sack1.getValues()[9], 87);
	}
	
	/*
	 * Tests that the fitness returns the combined values of the individuals
	 * in the Knapsack
	 */
	@Test
	void Knapsack1Fitness() {
		KnapSack1 sack2 = new KnapSack1();
		
		int[] solution = {0, 0, 0, 0, 0, 1, 0, 0, 0, 1};
		IndivStaticMutate indiv1 = new IndivStaticMutate(solution, 0.2);
		
		int fitnessValue = sack2.fitness(indiv1);
		
		assertEquals("fitness calue of indiv1 is 137", fitnessValue, 137);
	}
	/*
	 * Tests that the fitness function for Kapsack Problem 1 returns 0 when the 
	 * cap is exceeded
	 */
	@Test
	void Kapsack1FitnessMaxWeight() {
		KnapSack1 sack3 = new KnapSack1();
		
		int[] solution = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		IndivStaticMutate indiv2 = new IndivStaticMutate(solution, 0.2);
		
		int fitnessValue = sack3.fitness(indiv2);
		
		assertEquals("fitness value of indiv2 is 0", fitnessValue, 0);
	}
}
