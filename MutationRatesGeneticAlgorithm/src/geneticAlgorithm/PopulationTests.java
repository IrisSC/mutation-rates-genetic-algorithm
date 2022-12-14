package geneticAlgorithm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class PopulationTests {
	
	@Test
	void constructor1() {
		IndivStaticMutate indiv1 = new IndivStaticMutate(10, 0.2);
		KnapSack1 sack1 = new KnapSack1();
		
		Population pop1 = new Population(50, indiv1, sack1);
		
		assertEquals("check the numPop is 50", pop1.getNumPopulation(), 50);
		assertEquals("check the population list size is 50",
				pop1.getPopulation().size(), 50);
	}
	
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
		
		KnapSack1 sack1 = new KnapSack1();
		
		Population pop = new Population(indivList, sack1);
		
		assertEquals("check the numPop is 4", pop.getNumPopulation(), 4);
		assertEquals("check the population list size is 4",
				pop.getPopulation().size(), 4);
	}
	
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
		
		KnapSack1 sack1 = new KnapSack1();
		
		Population pop = new Population(indivList, sack1);
		
		//This is knapsack 1
		assertEquals("check knapsack length is 10", pop.getKnapsack().weights.length, 10);
		
		Knapsack2 sack2 = new Knapsack2();
		
		pop.setKnapsack(sack2);
		//This is knapsack 2
		assertEquals("check knapsack length is 20", pop.getKnapsack().weights.length, 20);
		
	}
	
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
		
		KnapSack1 sack1 = new KnapSack1();
		
		Population pop = new Population(indivList, sack1);
		
		assertEquals("min fitness value equals 10", pop.minFitness(), 10);
	}
	
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
		
		KnapSack1 sack1 = new KnapSack1();
		
		Population pop = new Population(indivList, sack1);
		
		assertEquals("max fitness value equals 159", pop.maxFitness(), 159);
	}
	
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
		
		KnapSack1 sack1 = new KnapSack1();
		
		Population pop = new Population(indivList, sack1);
		
		assertEquals("avg fitness value equals 116.25", pop.avgFitness(), 116.25, 0);
	}
	
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
		
		KnapSack1 sack1 = new KnapSack1();
		
		Population pop = new Population(indivList, sack1);
		
		assertEquals("stanard deviation fitness value equals 61.54", pop.stanDevFitness(), 61.54, 0);
	}
	
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
		
		KnapSack1 sack1 = new KnapSack1();
		
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
		
		KnapSack1 sack1 = new KnapSack1();
		
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
		
		KnapSack1 sack1 = new KnapSack1();
		
		Population pop = new Population(indivList, sack1);
		
		pop = pop.generateNewPop(2);
		
		assertEquals("indivNum is equal to 5", pop.getNumPopulation(), 5);
	}
	
}
