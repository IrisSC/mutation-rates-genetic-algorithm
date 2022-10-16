package geneticAlgorithm;

import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IndividualTests {

	/*
	 * Tests the constructor that takes in the length of the solution
	 */
	@Test
	void createIndividual1() {
		Individual test1 = new Individual(5);
		
		assertEquals("length was set correctly", test1.getLength(), 5);
		
		assertEquals("length of solution is correct", test1.getSolutionChromosome().length, 5);
		if(test1.getSolutionChromosome()[0] == 1) {
			assertEquals("first gene is solution is a 1", test1.getSolutionChromosome()[0], 1);
		}else {
			assertEquals("first gene is solution is a 0", test1.getSolutionChromosome()[0], 0);
		}
		
		assertEquals("mutation rate set correctly", test1.getMutationRate(), 0.2, 0);
		
		assertEquals("length of mutation chromosome is correct",
				test1.getGeneSpecificMutationRate().length, 5);
		assertEquals("mutation chromosome set correctly", 
				test1.getGeneSpecificMutationRate()[0], 0.2, 0);
	}
	
	/*
	 * Tests the constructor that takes in the length of the solution, and mutation rate
	 */
	@Test
	void createIndividual2() {
		Individual test2 = new Individual(6, 0.7);
		
		assertEquals("length was set correctly", test2.getLength(), 6);
		assertEquals("length of solution is correct", test2.getSolutionChromosome().length, 6);
		assertEquals("mutation rate set correctly", test2.getMutationRate(), 0.7, 0);
		
		assertEquals("length of mutation chromosome is correct",
				test2.getGeneSpecificMutationRate().length, 6);
	}
	
	/*
	 * Tests the constructor that takes in the length of the solution, 
	 * 		mutation rate, and solution
	 */
	@Test
	void createIndividual3() {
		int[] solution = {1, 0, 0};
		Individual test3 = new Individual(3, 0.4, solution);
		
		assertEquals("length was set correctly", test3.getLength(), 3);
		assertEquals("length of solution is correct", test3.getSolutionChromosome().length, 3);
		
		assertEquals("gene at index 0 is 1", test3.getSolutionChromosome()[0], 1);
		assertEquals("gene at index 1 is 0", test3.getSolutionChromosome()[1], 0);
		assertEquals("gene at index 2 is 0", test3.getSolutionChromosome()[2], 0);
		
		assertEquals("length of mutation chromosome is correct",
				test3.getGeneSpecificMutationRate().length, 3);
	}
	
	/*
	 * Tests the setMutationRate method
	 */
	@Test
	void setMutationRate() {
		Individual test4 = new Individual(4);
		
		assertEquals("mutation rate set correctly", test4.getMutationRate(), 0.2, 0);
		
		test4.setMuationRate(0.3);
		
		assertEquals("mutation rate reset to 0.3", test4.getMutationRate(), 0.3, 0);
	}
}
