package geneticAlgorithm;

import static org.junit.Assert.assertEquals;
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
				pop1.getPopultion().size(), 50);
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
				pop.getPopultion().size(), 4);
	}
	
	@Test
	void knapsackSetter() {
		//write test when there are more then one Knapsack problems encoded
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
}
