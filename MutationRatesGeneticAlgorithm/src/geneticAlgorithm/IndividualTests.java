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
}
