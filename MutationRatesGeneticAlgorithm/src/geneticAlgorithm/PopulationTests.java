package geneticAlgorithm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class PopulationTests {
	
	/*
	 * Test that the first constructor works. this constructor takes in the number of 
	 * individuals in the population, an original indiv, and a knapsack
	 */
	@Test
	void constructor1() {
		IndivStaticMutate indiv1 = new IndivStaticMutate(10, 0.2);
		Knapsack1 sack1 = new Knapsack1();
		
		Population pop1 = new Population(50, indiv1, sack1);
		
		assertEquals("check the numPop is 50", pop1.getNumPopulation(), 50);
		assertEquals("check the population list size is 50",
				pop1.getPopulation().size(), 50);
	}
	
	/*
	 * Test that the second constructor works. This constructor takes in a List of 
	 * individuals and a knapsack
	 */
	@Test
	void constructor2() {
		IndivStaticMutate indiv1 = new IndivStaticMutate(10, 0.2);
		IndivStaticMutate indiv2 = new IndivStaticMutate(10, 0.2);
		IndivStaticMutate indiv3 = new IndivStaticMutate(10, 0.2);
		IndivStaticMutate indiv4 = new IndivStaticMutate(10, 0.2);
		
		List<Individual> indivList = new ArrayList<Individual>();
		indivList.add(indiv1);
		indivList.add(indiv2);
		indivList.add(indiv3);
		indivList.add(indiv4);
		
		Knapsack1 sack1 = new Knapsack1();
		
		Population pop = new Population(indivList, sack1);
		
		assertEquals("check the numPop is 4", pop.getNumPopulation(), 4);
		assertEquals("check the population list size is 4",
				pop.getPopulation().size(), 4);
	}
	
	/*
	 * Tests that the knapsack can be set to a different knapsack
	 */
	@Test
	void knapsackSetter() {
		IndivStaticMutate indiv1 = new IndivStaticMutate(10, 0.2);
		IndivStaticMutate indiv2 = new IndivStaticMutate(10, 0.2);
		IndivStaticMutate indiv3 = new IndivStaticMutate(10, 0.2);
		IndivStaticMutate indiv4 = new IndivStaticMutate(10, 0.2);
		
		List<Individual> indivList = new ArrayList<Individual>();
		indivList.add(indiv1);
		indivList.add(indiv2);
		indivList.add(indiv3);
		indivList.add(indiv4);
		
		Knapsack1 sack1 = new Knapsack1();
		
		Population pop = new Population(indivList, sack1);
		
		//This is knapsack 1
		assertEquals("check knapsack length is 10", pop.getKnapsack().weights.length, 10);
		
		Knapsack2 sack2 = new Knapsack2();
		
		pop.setKnapsack(sack2);
		//This is knapsack 2
		assertEquals("check knapsack length is 20", pop.getKnapsack().weights.length, 20);
		
	}
	
	/*
	 * Tests that when the knapsack is changed the fitness of individuals change
	 */
	@Test
	void knapsackFitnessChanges() {
		int[] solution0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
		
		int[] solution1 = {1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 
				0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 
				0, 1, 1, 0, 0, 0, 1, 0, 1, 0};
		
		IndivSelfAdaptMutate indiv0 = new IndivSelfAdaptMutate(solution0, 0.2);
		IndivSelfAdaptMutate indiv1 = new IndivSelfAdaptMutate(solution1, 0.2);
		
		Knapsack6 sack6 = new Knapsack6();
		Knapsack7 sack7 = new Knapsack7();
		
		Population pop0 = new Population(1, indiv0, sack6);
		Population pop1 = new Population(1, indiv1, sack7);
		
		//int fitness = sack6.fitness(indiv1);
		//assertEquals("indiv1 fitness is 0 with sack 6", fitness, 0);
		
		assertEquals("max fitness is 17 for knapsack 6", pop0.maxFitness(), 17);
		assertEquals("max fitness is -- for knapsack 7", pop1.maxFitness(), 2737);
		
		pop0.setKnapsack(sack7);
		pop1.setKnapsack(sack6);
		
		assertEquals("max fitness is 29 for knapsack 7", pop0.maxFitness(), 29);
		assertEquals("max fitness is 0 for knapsack 6", pop1.maxFitness(), 0);
	}
	
	/*
	 * Tests that the population will return the correct minimum fitness in 
	 * the population
	 */
	@Test
	void minFitnessValue() {
		int[] solution1 = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] solution2 = {0, 1, 0, 0, 1, 1, 0, 0, 0, 1};
		int[] solution3 = {0, 1, 1, 1, 1, 0, 1, 0, 1, 0};
		int[] solution4 = {0, 1, 0, 0, 0, 1, 0, 0, 1, 0};
		
		IndivStaticMutate indiv1 = new IndivStaticMutate(solution1, 0.2);
		IndivStaticMutate indiv2 = new IndivStaticMutate(solution2, 0.2);
		IndivStaticMutate indiv3 = new IndivStaticMutate(solution3, 0.2);
		IndivStaticMutate indiv4 = new IndivStaticMutate(solution4, 0.2);
		
		List<Individual> indivList = new ArrayList<Individual>();
		indivList.add(indiv1);
		indivList.add(indiv2);
		indivList.add(indiv3);
		indivList.add(indiv4);
		
		Knapsack1 sack1 = new Knapsack1();
		
		Population pop = new Population(indivList, sack1);
		
		assertEquals("min fitness value equals 10", pop.minFitness(), 10);
	}
	
	/*
	 * Tests that the population will return the correct maximum fitness in 
	 * the population
	 */
	@Test
	void maxFitnessValue() {
		int[] solution1 = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] solution2 = {0, 1, 0, 0, 1, 1, 0, 0, 0, 1};
		int[] solution3 = {0, 1, 1, 1, 1, 0, 1, 0, 1, 0};
		int[] solution4 = {0, 1, 0, 0, 0, 1, 0, 0, 1, 0};
		
		IndivStaticMutate indiv1 = new IndivStaticMutate(solution1, 0.2);
		IndivStaticMutate indiv2 = new IndivStaticMutate(solution2, 0.2);
		IndivStaticMutate indiv3 = new IndivStaticMutate(solution3, 0.2);
		IndivStaticMutate indiv4 = new IndivStaticMutate(solution4, 0.2);
		
		List<Individual> indivList = new ArrayList<Individual>();
		indivList.add(indiv1);
		indivList.add(indiv2);
		indivList.add(indiv3);
		indivList.add(indiv4);
		
		Knapsack1 sack1 = new Knapsack1();
		
		Population pop = new Population(indivList, sack1);
		
		assertEquals("max fitness value equals 159", pop.maxFitness(), 159);
	}
	
	/*
	 * Tests that the population will return the correct average fitness in 
	 * the population
	 */
	@Test
	void avgFitnessValue() {
		int[] solution1 = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] solution2 = {0, 1, 0, 0, 1, 1, 0, 0, 0, 1};
		int[] solution3 = {0, 1, 1, 1, 1, 0, 1, 0, 1, 0};
		int[] solution4 = {0, 1, 0, 0, 0, 1, 0, 0, 1, 0};
		
		IndivStaticMutate indiv1 = new IndivStaticMutate(solution1, 0.2);
		IndivStaticMutate indiv2 = new IndivStaticMutate(solution2, 0.2);
		IndivStaticMutate indiv3 = new IndivStaticMutate(solution3, 0.2);
		IndivStaticMutate indiv4 = new IndivStaticMutate(solution4, 0.2);
		
		List<Individual> indivList = new ArrayList<Individual>();
		indivList.add(indiv1);
		indivList.add(indiv2);
		indivList.add(indiv3);
		indivList.add(indiv4);
		
		Knapsack1 sack1 = new Knapsack1();
		
		Population pop = new Population(indivList, sack1);
		
		assertEquals("avg fitness value equals 116.25", pop.avgFitness(), 116.25, 0);
	}
	
	/*
	 * Tests that the population will return the correct standard deviation of fitness in 
	 * the population
	 */
	@Test
	void stanardDeviation() {
		int[] solution1 = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] solution2 = {0, 1, 0, 0, 1, 1, 0, 0, 0, 1};
		int[] solution3 = {0, 1, 1, 1, 1, 0, 1, 0, 1, 0};
		int[] solution4 = {0, 1, 0, 0, 0, 1, 0, 0, 1, 0};
		
		IndivStaticMutate indiv1 = new IndivStaticMutate(solution1, 0.2);
		IndivStaticMutate indiv2 = new IndivStaticMutate(solution2, 0.2);
		IndivStaticMutate indiv3 = new IndivStaticMutate(solution3, 0.2);
		IndivStaticMutate indiv4 = new IndivStaticMutate(solution4, 0.2);
		
		List<Individual> indivList = new ArrayList<Individual>();
		indivList.add(indiv1);
		indivList.add(indiv2);
		indivList.add(indiv3);
		indivList.add(indiv4);
		
		Knapsack1 sack1 = new Knapsack1();
		
		Population pop = new Population(indivList, sack1);
		
		assertEquals("stanard deviation fitness value equals 61.54", pop.stanDevFitness(), 61.54, 0);
	}
	
	/*
	 * Tests that the population will correctly return the best fit individual 
	 * in the population
	 */
	@Test
	void returnBestFitIndiv() {
		int[] solution1 = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] solution2 = {0, 1, 0, 0, 1, 1, 0, 0, 0, 1};
		int[] solution3 = {0, 1, 1, 1, 1, 0, 1, 0, 1, 0};
		int[] solution4 = {0, 1, 0, 0, 0, 1, 0, 0, 1, 0};
		
		IndivStaticMutate indiv1 = new IndivStaticMutate(solution1, 0.2);
		IndivStaticMutate indiv2 = new IndivStaticMutate(solution2, 0.2);
		IndivStaticMutate indiv3 = new IndivStaticMutate(solution3, 0.2);
		IndivStaticMutate indiv4 = new IndivStaticMutate(solution4, 0.2);
		
		List<Individual> indivList = new ArrayList<Individual>();
		indivList.add(indiv1);
		indivList.add(indiv2);
		indivList.add(indiv3);
		indivList.add(indiv4);
		
		Knapsack1 sack1 = new Knapsack1();
		
		Population pop = new Population(indivList, sack1);
		
		Individual bestFit = pop.getBestFitIndiv();
		
		assertEquals("best fit indiviudal's fitness is 159", sack1.fitness(bestFit), 159);
		
		assertEquals("best fit indiviudal's doesn't have item 0", bestFit.getSolutionChromosome()[0], 0);
		assertEquals("best fit indiviudal's does have item 1", bestFit.getSolutionChromosome()[1], 1);
		assertEquals("best fit indiviudal's does have item 4", bestFit.getSolutionChromosome()[4], 1);
		assertEquals("best fit indiviudal's doesn't have item 5", bestFit.getSolutionChromosome()[5], 0);
		assertEquals("best fit indiviudal's doesn't have item 9", bestFit.getSolutionChromosome()[9], 0);
	}
	
	/*
	 * tests that each parent will eventually be selected
	 */
	@Test
	void getParent1() {
		int[] solution1 = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] solution2 = {0, 1, 0, 0, 1, 1, 0, 0, 0, 1};
		int[] solution3 = {0, 1, 1, 1, 1, 0, 1, 0, 1, 0};
		int[] solution4 = {0, 1, 0, 0, 0, 1, 0, 0, 1, 0};
		
		IndivStaticMutate indiv1 = new IndivStaticMutate(solution1, 0.2);
		IndivStaticMutate indiv2 = new IndivStaticMutate(solution2, 0.2);
		IndivStaticMutate indiv3 = new IndivStaticMutate(solution3, 0.2);
		IndivStaticMutate indiv4 = new IndivStaticMutate(solution4, 0.2);
		
		List<Individual> indivList = new ArrayList<Individual>();
		indivList.add(indiv1);
		indivList.add(indiv2);
		indivList.add(indiv3);
		indivList.add(indiv4);
		
		Knapsack1 sack1 = new Knapsack1();
		
		Population pop = new Population(indivList, sack1);
		
		boolean s1 = false;
		boolean s2 = false;
		boolean s3 = false;
		boolean s4 = false;
		
		for(int i = 0; i < 1000; i++) {
			Individual parent = pop.getParent(2);
			if(parent.equals(indiv1)) {
				s1 = true;
			}else if(parent.equals(indiv2)) {
				s2 = true;
			}else if(parent.equals(indiv3)) {
				s3 = true;
			}else if(parent.equals(indiv4)) {
				s4 = true;
			}
		}
		assertTrue("Individual 1 has been returned as a parent", s1);
		assertTrue("Individual 2 has been returned as a parent", s2);
		assertTrue("Individual 3 has been returned as a parent", s3);
		assertTrue("Individual 4 has been returned as a parent", s4);
	}
	
	/*
	 * tests the generate new population method
	 */
	@Test
	void newPopulation() {
		int[] solution1 = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] solution2 = {0, 1, 0, 0, 1, 1, 0, 0, 0, 1};
		int[] solution3 = {0, 1, 1, 1, 1, 0, 1, 0, 1, 0};
		int[] solution4 = {0, 1, 0, 0, 0, 1, 0, 0, 1, 0};
		
		IndivStaticMutate indiv1 = new IndivStaticMutate(solution1, 0.2);
		IndivStaticMutate indiv2 = new IndivStaticMutate(solution2, 0.2);
		IndivStaticMutate indiv3 = new IndivStaticMutate(solution3, 0.2);
		IndivStaticMutate indiv4 = new IndivStaticMutate(solution4, 0.2);
		
		List<Individual> indivList = new ArrayList<Individual>();
		indivList.add(indiv1);
		indivList.add(indiv2);
		indivList.add(indiv3);
		indivList.add(indiv4);
		
		Knapsack1 sack1 = new Knapsack1();
		
		Population pop = new Population(indivList, sack1);
		
		pop = pop.generateNewPop(2);
		
		assertEquals("indivNum is equal to 5", pop.getNumPopulation(), 4);
	}
	
}
