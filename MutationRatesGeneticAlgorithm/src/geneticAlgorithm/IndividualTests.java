package geneticAlgorithm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class IndividualTests {

	/*
	 * Tests the constructor that takes in the length of the solution
	 */
	@Test
	void createIndividual1() {
		IndivStaticMutate test1 = new IndivStaticMutate(5, 0.2);
		
		assertEquals("length was set correctly", test1.getLength(), 5);
		
		assertEquals("length of solution is correct", test1.getSolutionChromosome().length, 5);
		if(test1.getSolutionChromosome()[0] == 1) {
			assertEquals("first gene is solution is a 1", test1.getSolutionChromosome()[0], 1);
		}else {
			assertEquals("first gene is solution is a 0", test1.getSolutionChromosome()[0], 0);
		}
		
		assertEquals("mutation rate set correctly", test1.getMutationRate(), 0.2, 0);
	}
	
	/*
	 * Tests the constructor that takes in the length of the solution, 
	 * 		mutation rate, and solution
	 */
	@Test
	void createIndividual2() {
		int[] solution = {1, 0, 0};
		IndivStaticMutate test2 = new IndivStaticMutate(solution, 0.4);
		
		assertEquals("length was set correctly", test2.getLength(), 3);
		assertEquals("length of solution is correct", test2.getSolutionChromosome().length, 3);
		
		assertEquals("gene at index 0 is 1", test2.getSolutionChromosome()[0], 1);
		assertEquals("gene at index 1 is 0", test2.getSolutionChromosome()[1], 0);
		assertEquals("gene at index 2 is 0", test2.getSolutionChromosome()[2], 0);
	}
	
	/*
	 * Tests the setMutationRate method
	 */
	@Test
	void setMutationRate() {
		IndivStaticMutate test3 = new IndivStaticMutate(4, 0.2);
		
		assertEquals("mutation rate set correctly", test3.getMutationRate(), 0.2, 0);
		
		test3.setMutationRate(0.3);
		
		assertEquals("mutation rate reset to 0.3", test3.getMutationRate(), 0.3, 0);
	}
	
	@Test
	void staticMutateEquals() {
		int[] solution1 = {1, 0, 1, 0};
		int[] solution2 = {1, 1, 1, 0};
		
		IndivStaticMutate indiv1 = new IndivStaticMutate(solution1, 0.2);
		IndivStaticMutate indiv2 = new IndivStaticMutate(solution1, 0.2);
		IndivStaticMutate indiv3 = new IndivStaticMutate(solution2, 0.2);
		
		assertTrue("Indiv1 and Indiv2 are equal", indiv1.equals(indiv2));
		assertFalse("Indiv1 and Indiv3 are not equal", indiv1.equals(indiv3));
	}
	
	/*
	 * Tests the mutation function for the static individual
	 */
	@Test
	void staticMutationMethod() {
		//create new individual with static mutation
		IndivStaticMutate test4 = new IndivStaticMutate(100, 0.2);
		
		//count the number of genes mutated vs genes
		double numOfGenes = 0;
		double numOfGenesMutated = 0;
		
		//mutates the individuals solution n times
		for(int i=0; i < 1000; i++) {
			int[] oldSolution = test4.solutionChromosome.clone();
			test4.mutation();
			
			numOfGenes = numOfGenes + test4.getLength();
			for(int j=0; j < test4.getLength(); j++) {
				if(oldSolution[j] != test4.solutionChromosome[j]) {
					numOfGenesMutated = numOfGenesMutated + 1;
				}
			}
		}
		
		//gets the rate of mutations in this test
		double testMutationRate = numOfGenesMutated/numOfGenes;
		
		System.out.println(numOfGenes);
		System.out.println(numOfGenesMutated);
		System.out.println(testMutationRate);
		
		assertEquals("test mutation rate is close to actaul mutation rate", 
				test4.getMutationRate(), 0.2, 0);
	}
	
	/*
	 * Tests that the mutation rate does change when the self-adapting mutation
	 * 	individual is mutated 1000 times
	 */
	@Test
	void selfAdaptingMutationMethod() {
		//create new individual with self-adapting mutation rate
		IndivSelfAdaptMutate test4 = new IndivSelfAdaptMutate(100, 0.2);
		
		boolean changedMutationRate = false;
		
		for(int i = 0; i < 100; i++) {
			double oldMutationRate = test4.getMutationRate();
			test4.mutation();
			System.out.println(test4.getMutationRate());
			
			if(test4.getMutationRate() != oldMutationRate) {
				changedMutationRate = true;
			}
		}
		
		assertTrue("test that mutation rate changes", changedMutationRate);
	}
	
	/*
	 * Tests the crossover function for the static individual
	 */
	@Test
	void staticCrossoverMethod() {
		//create solutions for the parent individuals
		int[] solution1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] solution2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		//create the parent individuals
		IndivStaticMutate test5 = new IndivStaticMutate(solution1,  0.2);
		IndivStaticMutate test6 = new IndivStaticMutate(solution2,  0.2);
		
		//crossover the parent individual
		List<Individual> crossoverIndivs = test5.crossover(test6);
		
		//get the two children individuals
		IndivStaticMutate test7 = (IndivStaticMutate) crossoverIndivs.get(0);
		IndivStaticMutate test8 = (IndivStaticMutate) crossoverIndivs.get(1);
		
		//test child one crossover point
		assertEquals("gene at index 0 is 1", test7.getSolutionChromosome()[0], 1);
		assertEquals("gene at index 3 is 1", test7.getSolutionChromosome()[3], 1);
		assertEquals("gene at index 5 is 0", test7.getSolutionChromosome()[5], 0);
		assertEquals("gene at index 9 is 0", test7.getSolutionChromosome()[9], 0);
		
		//test child two crossover point
		assertEquals("gene at index 0 is 0", test8.getSolutionChromosome()[0], 0);
		assertEquals("gene at index 3 is 0", test8.getSolutionChromosome()[3], 0);
		assertEquals("gene at index 5 is 1", test8.getSolutionChromosome()[5], 1);
		assertEquals("gene at index 9 is 1", test8.getSolutionChromosome()[9], 1);
	}
	
	@Test
	void selfAdaptiveCrossoverMethod() {
		//create solutions for the parent individuals
		int[] solution1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] solution2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		//create the parent individuals
		IndivSelfAdaptMutate test9 = new IndivSelfAdaptMutate(solution1,  0.4);
		IndivSelfAdaptMutate test10 = new IndivSelfAdaptMutate(solution2,  0.3);
		
		//crossover the parent individual
		List<Individual> crossoverIndivs = test9.crossover(test10);
		
		//get the two children individuals
		IndivSelfAdaptMutate test7 = (IndivSelfAdaptMutate) crossoverIndivs.get(0);
		IndivSelfAdaptMutate test8 = (IndivSelfAdaptMutate) crossoverIndivs.get(1);
		
		//test child one crossover point
		assertEquals("gene at index 0 is 1", test7.getSolutionChromosome()[0], 1);
		assertEquals("gene at index 3 is 1", test7.getSolutionChromosome()[3], 1);
		assertEquals("gene at index 5 is 0", test7.getSolutionChromosome()[5], 0);
		assertEquals("gene at index 9 is 0", test7.getSolutionChromosome()[9], 0);
		
		//test child two crossover point
		assertEquals("gene at index 0 is 0", test8.getSolutionChromosome()[0], 0);
		assertEquals("gene at index 3 is 0", test8.getSolutionChromosome()[3], 0);
		assertEquals("gene at index 5 is 1", test8.getSolutionChromosome()[5], 1);
		assertEquals("gene at index 9 is 1", test8.getSolutionChromosome()[9], 1);
		
		//test that the mutation rates crossed over
		assertEquals("child1 has parent1s mutation rate", test7.getMutationRate(), 0.4, 0);
		assertEquals("child2 has parent2s mutation rate", test8.getMutationRate(), 0.3, 0);
	}
	
	/*
	 * Test copy Individual for static individual
	 */
	@Test
	void staticCopy() {
		//create solution for individual
		int[] solution1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		
		//create the individuals
		IndivStaticMutate originalIndiv = new IndivStaticMutate(solution1,  0.2);
		
		//copy individual
		Individual copyIndiv = originalIndiv.copy();
		
		//change original individual solution chromosome
		originalIndiv.getSolutionChromosome()[0] = 0;
		
		assertEquals("gene at index 0 is 0", originalIndiv.getSolutionChromosome()[0], 0);
		assertEquals("gene at index 0 is 0", copyIndiv.getSolutionChromosome()[0], 1);
		
	}
	
	/*
	 * Tests the constructors for the global gene specific individual
	 */
	@Test
	void globalGeneSpecificConstructors() {
		
		//intialize all the needed informtaion
		double mutationRate = 0.3;
		double[] mutationRates = {0.4, 0.4, 0.4, 0.4, 0.4, 0.3, 0.3, 0.3, 0.3, 0.3, 0.2, 
				0.2, 0.2, 0.2, 0.2, 0.1, 0.1, 0.1, 0.1, 0.1};
		Knapsack2 sack = new Knapsack2();
		int solutionLength = 20;
		int[] solution = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
		
		//test constructor 0
		IndivGlobalGeneSpecMutate indiv0 = new IndivGlobalGeneSpecMutate(solutionLength, 
				mutationRate, sack);
		
		assertEquals("the average mutation rate should be 0.3", 
				Math.round(indiv0.getMutationRate()*100)/(double)100, 0.3, 0);
		assertEquals("any mutation rate should be 0.3", indiv0.getMutationRates()[5], 
				0.3, 0);
		assertEquals("length of mutationRates is 20", indiv0.getMutationRates().length, 20);
		
		//test constructor 2
		IndivGlobalGeneSpecMutate indiv2 = new IndivGlobalGeneSpecMutate(solutionLength);
		
		assertEquals("the average mutation rate for indiv2 is should be 0.3", 
				Math.round(indiv2.getMutationRate()*100)/(double)100, 0.3, 0);
		assertEquals("the mutation rate for any gene should be 0.3", 
				indiv2.getMutationRates()[7], 0.3, 0);
		assertEquals("length of mutationRates is 20", indiv0.getMutationRates().length, 20);
		
		//test constructor 1
		IndivGlobalGeneSpecMutate indiv1 = new IndivGlobalGeneSpecMutate(solution, 
				mutationRates, sack);
		
		assertEquals("the average mutation rate is should be 0.25", 
				Math.round(indiv1.getMutationRate()*100)/(double)100, 0.25, 0);
		assertEquals("the mutation rate for gene 0 should be 0.4", 
				indiv1.getMutationRates()[0], 0.4, 0);
		assertEquals("the mutation rate for gene 10 should be 0.2", 
				indiv1.getMutationRates()[10], 0.2, 0);
		
		//test constructor 3
		IndivGlobalGeneSpecMutate indiv3 = new IndivGlobalGeneSpecMutate(solution);
		
		assertEquals("the average mutation rate for indiv2 is should be 0.25", 
				Math.round(indiv3.getMutationRate()*100)/(double)100, 0.25, 0);
		assertEquals("the mutation rate for gene 0 should be 0.4", 
				indiv3.getMutationRates()[0], 0.4, 0);
		assertEquals("the mutation rate for gene 10 should be 0.2", 
				indiv3.getMutationRates()[10], 0.2, 0);
		assertEquals("length of mutationRates is 20", indiv0.getMutationRates().length, 20);
	}
}
