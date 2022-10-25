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
		IndivStaticMutate test2 = new IndivStaticMutate(3, solution, 0.4);
		
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
}
