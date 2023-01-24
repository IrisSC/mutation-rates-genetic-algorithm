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
		
		assertEquals("cap is 269", sack1.getCap(), 269);
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
	 * Tests that the cap, weights and values are correct for Knapsack Problem 2
	 */
	@Test
	void createKnapsack2() {
		Knapsack2 sack1 = new Knapsack2();
		
		assertEquals("cap is 878", sack1.getCap(), 878);
		assertEquals("weights is length 20", sack1.getWeights().length, 20);
		assertEquals("values is length 20", sack1.getValues().length, 20);
		
		assertEquals("weight at 0 is 92", sack1.getWeights()[0], 92);
		assertEquals("weight at 4 is 84", sack1.getWeights()[4], 84);
		assertEquals("weight at 9 is 44", sack1.getWeights()[9], 44);
		assertEquals("weight at 14 is 25", sack1.getWeights()[14], 25);
		assertEquals("weight at 19 is 58", sack1.getWeights()[19], 58);
		
		assertEquals("value at 0 is 44", sack1.getValues()[0], 44);
		assertEquals("value at 4 is 91", sack1.getValues()[4], 91);
		assertEquals("value at 9 is 54", sack1.getValues()[9], 54);
		assertEquals("value at 14 is 61", sack1.getValues()[14], 61);
		assertEquals("value at 19 is 63", sack1.getValues()[19], 63);
	}
	
	/*
	 * Tests that the cap, weights and values are correct for Knapsack Problem 3
	 */
	@Test
	void createKnapsack3() {
		Knapsack3 sack1 = new Knapsack3();
		
		assertEquals("cap is 1000", sack1.getCap(), 1000);
		assertEquals("weights is length 50", sack1.getWeights().length, 50);
		assertEquals("values is length 50", sack1.getValues().length, 50);
		
		assertEquals("weight at 0 is 80", sack1.getWeights()[0], 80);
		assertEquals("weight at 9 is 25", sack1.getWeights()[9], 25);
		assertEquals("weight at 19 is 32", sack1.getWeights()[19], 32);
		assertEquals("weight at 29 is 30", sack1.getWeights()[29], 30);
		assertEquals("weight at 49 is 1", sack1.getWeights()[49], 1);
		
		assertEquals("value at 0 is 220", sack1.getValues()[0], 220);
		assertEquals("value at 9 is 158", sack1.getValues()[9], 158);
		assertEquals("value at 19 is 101", sack1.getValues()[19], 101);
		assertEquals("value at 29 is 77", sack1.getValues()[29], 77);
		assertEquals("value at 49 is 1", sack1.getValues()[49], 1);
	}
	
	/*
	 * Tests that the cap, weights and values are correct for Knapsack Problem 4
	 */
	@Test
	void createKnapsack4() {
		Knapsack4 sack1 = new Knapsack4();
		
		assertEquals("cap is 1173", sack1.getCap(), 1173);
		assertEquals("weights is length 80", sack1.getWeights().length, 80);
		assertEquals("values is length 80", sack1.getValues().length, 80);
		
		assertEquals("weight at 0 is 40", sack1.getWeights()[0], 40);
		assertEquals("weight at 15 is 55", sack1.getWeights()[15], 55);
		assertEquals("weight at 31 is 16", sack1.getWeights()[31], 16);
		assertEquals("weight at 47 is 58", sack1.getWeights()[47], 58);
		assertEquals("weight at 79 is 19", sack1.getWeights()[79], 19);
		
		assertEquals("value at 0 is 199", sack1.getValues()[0], 199);
		assertEquals("value at 15 is 152", sack1.getValues()[15], 152);
		assertEquals("value at 31 is 100", sack1.getValues()[31], 100);
		assertEquals("value at 47 is 70", sack1.getValues()[47], 70);
		assertEquals("value at 79 is 1", sack1.getValues()[79], 1);
	}
	
	/*
	 * Tests that the cap, weights and values are correct for Knapsack Problem 4
	 */
	@Test
	void createKnapsack5() {
		Knapsack5 sack1 = new Knapsack5();
		
		assertEquals("cap is 3818", sack1.getCap(), 3818);
		assertEquals("weights is length 100", sack1.getWeights().length, 100);
		assertEquals("values is length 100", sack1.getValues().length, 100);
		
		assertEquals("weight at 0 is 54", sack1.getWeights()[0], 54);
		assertEquals("weight at 24 is 58", sack1.getWeights()[24], 58);
		assertEquals("weight at 49 is 55", sack1.getWeights()[49], 55);
		assertEquals("weight at 74 is 99", sack1.getWeights()[74], 99);
		assertEquals("weight at 99 is 9", sack1.getWeights()[99], 9);
		
		assertEquals("value at 0 is 297", sack1.getValues()[0], 297);
		assertEquals("value at 24 is 235", sack1.getValues()[24], 235);
		assertEquals("value at 49 is 184", sack1.getValues()[49], 184);
		assertEquals("value at 74 is 74", sack1.getValues()[74], 74);
		assertEquals("value at 99 is 5", sack1.getValues()[99], 5);
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
	
	/*
	 * Tests that the fitness function for Kapsack Problem 5 returns 0 when the 
	 * cap is exceeded
	 */
	@Test
	void Kapsack5FitnessMaxWeight() {
		Knapsack3 sack4 = new Knapsack3();
		
		int[] solution = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		IndivStaticMutate indiv2 = new IndivStaticMutate(solution, 0.2);
		
		int fitnessValue = sack4.fitness(indiv2);
		
		int[] weights = sack4.getWeights();
		int totalWeight = 0;
		for(int i = 0; i < weights.length; i++) {
			totalWeight = weights[i] + totalWeight;
		}
		System.out.println(totalWeight);
		
		assertEquals("fitness value of indiv2 is 0", fitnessValue, 0);
	}
}
