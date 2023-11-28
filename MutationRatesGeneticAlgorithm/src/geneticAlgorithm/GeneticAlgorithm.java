package geneticAlgorithm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GeneticAlgorithm {

	public static void main(String[] args) throws IOException {
		//setting sizes
		int populationSize = 100;
		int tournamentSize = 2; 
		int numGenerations = 500;
		int numRuns = 100;
		
		
		//create stuff to print data into excel
		// workbook object
        XSSFWorkbook workbook = new XSSFWorkbook();
  
        // spreadsheet object
        XSSFSheet spreadsheet = workbook.createSheet("GA Date");
        XSSFSheet spreadsheet1 = workbook.createSheet("Mutation Data");
  
        // creating a row object
        XSSFRow row;
        XSSFRow row1;
  
        // This data needs to be written (Object[])
        List<Object[]> GATestData = new ArrayList<Object[]>();
        List<Object[]> mutationData = new ArrayList<Object[]>();
		
		//create knapsack
		Knapsack1 sack1 = new Knapsack1();
		//Knapsack2 sack1 = new Knapsack2();
		//Knapsack3 sack1 = new Knapsack3();
		//Knapsack4 sack1 = new Knapsack4();
		//Knapsack5 sack1 = new Knapsack5();
		//Knapsack9 sack1 = new Knapsack9();
		//Knapsack10 sack2 = new Knapsack10();
		//Knapsack11 sack3 = new Knapsack11();
		//Knapsack6 sack1 = new Knapsack6();
		//Knapsack7 sack2 = new Knapsack7();
		//Knapsack8 sack3 = new Knapsack8();
		//Knapsack12 sack1 = new Knapsack12();
		
		//create array to store the data from multiple runs
		int[][] max = new int[numGenerations][numRuns];
		double[][] avg = new double[numGenerations][numRuns];
		int[][] min = new int[numGenerations][numRuns];
		double[][] mutationRates = new double[numGenerations][numRuns];
		
		//hold information for gene specific mutation rates
		double[][][] geneSpecifcMutationRates = new double[numGenerations][numRuns][sack1.weights.length];
		
		GATestData.add(new Object[] {"Generation", "Max Fitness", "Min Fitness",
				"Avg Fitness", "Max Stand Dev", "Avg Stand Dev", "Last Max", 
				"Avg Mutation Rate", "Avg Mutation Rate Stand Dev"});
		int numValid = 0;
		//the number of runs for the GA
		for(int j = 0; j < numRuns; j++) {
			//create static mutation individual
			//IndivStaticMutate indiv1 = new IndivStaticMutate(sack1.weights.length, 0.004);
			//IndivSelfAdaptMutate indiv1 = new IndivSelfAdaptMutate(sack1.weights.length, 0.1);
			IndivGlobalGeneSpecMutate indiv1 = new IndivGlobalGeneSpecMutate(sack1.weights.length, 0.1, sack1);
			
			//create population
			Population pop = new Population(populationSize, indiv1, sack1);
			
			/*GATestData.add(new Object[] {Integer.toString(0), Integer.toString(pop.maxFitness()), 
					Integer.toString(pop.minFitness()), Double.toString(pop.avgFitness())});
			*/
			
			max[0][j] = pop.maxFitness();
			avg[0][j] = pop.avgFitness();
			min[0][j] = pop.minFitness();
			mutationRates[0][j] = pop.avgMutationRate();
			
			if(indiv1.getType().equals("Global Gene Specific Mutation")) {
				double[] mutationRatesThisGen = indiv1.getMutationRates();
				for(int h = 0; h < sack1.weights.length; h++) {
					geneSpecifcMutationRates[0][j][h] = mutationRatesThisGen[h];
				}
			}
			
			//run GA
			for(int i = 1; i < numGenerations; i++) {
				pop = pop.generateNewPop(tournamentSize);
				
				max[i][j] = pop.maxFitness();
				avg[i][j] = pop.avgFitness();
				min[i][j] = pop.minFitness();
				mutationRates[i][j] = pop.avgMutationRate();
				
				if(indiv1.getType().equals("Global Gene Specific Mutation")) {
					double[] mutationRatesThisGen = indiv1.getMutationRates();
					for(int h = 0; h < sack1.weights.length; h++) {
						geneSpecifcMutationRates[i][j][h] = mutationRatesThisGen[h];
					}
				}
				
				/*if(i==499) {
					pop.setKnapsack(sack2);
				}else if(i==999) {
					pop.setKnapsack(sack3);
				}*/
				
				/*GATestData.add(new Object[] {Integer.toString(i+1), Integer.toString(pop.maxFitness()), 
						Integer.toString(pop.minFitness()), Double.toString(pop.avgFitness())});
				*/
				
				/*if(i%5 == 4) {
					GATestData.put(Integer.toString(i + 2),new Object[] { Integer.toString(pop.maxFitness()), 
							Integer.toString(pop.minFitness()), Double.toString(pop.avgFitness())});
				}*/
			}
			
			//print out information 
			System.out.println(pop.maxFitness());
			Individual bestFit = pop.getBestFitIndiv();
			for(int i = 0; i < bestFit.length; i++) {
				System.out.print(bestFit.getSolutionChromosome()[i]);
			}
			System.out.println("");
			System.out.println("percent close: " + (double)pop.maxFitness()/(double)pop.getKnapsack().getMaxPossibleValue());
			
			System.out.println(pop.getKnapsack().isValid(bestFit));
			if(pop.getKnapsack().isValid(bestFit)) {
				numValid++;
			}
		}
		System.out.print(numValid);
		
		//get the avgerages 
		for(int i = 0; i < numGenerations; i++) {
			int maxTotal = 0;
			int minTotal = 0;
			Double avgTotal = 0.0;
			Double mutationRateTotal = 0.0;
			for(int j = 0; j < numRuns; j++) {
				maxTotal = maxTotal + max[i][j];
				minTotal = minTotal + min[i][j];
				avgTotal = avgTotal + avg[i][j];
				mutationRateTotal = mutationRateTotal + mutationRates[i][j];
			}
			double maxAvg = (double)(maxTotal)/(double)numRuns;
			double avgAvg = (double)(avgTotal)/(double)numRuns;
			double avgMutationRate = mutationRateTotal/(double)numRuns;
			//get standard deviations
			double maxStandDev = 0.0;
			double avgStandDev = 0.0;
			double mutationRateStandDev = 0.0;
			for(int j = 0; j < numRuns; j++) {
				int maxFitness = max[i][j];
				maxStandDev = maxStandDev + Math.pow((double)maxFitness-maxAvg, 2);
				
				double avgFitness = avg[i][j];
				avgStandDev = avgStandDev + Math.pow((double)avgFitness-avgAvg, 2);
				
				double mutationRate = mutationRates[i][j];
				mutationRateStandDev = mutationRateStandDev + 
						Math.pow((double)mutationRate-avgMutationRate, 2);
				
			}
			maxStandDev = Math.round(Math.sqrt(maxStandDev/numRuns)*100.0)/100.0;
			avgStandDev = Math.round(Math.sqrt(avgStandDev/numRuns)*100.0)/100.0;
			mutationRateStandDev = Math.round(Math.sqrt(mutationRateStandDev/numRuns)*100.0)/100.0;
			
			int lastMax = 0;
			if(i < numRuns) {
				lastMax = max[numGenerations-1][i];
			}
			
			GATestData.add(new Object[] {Integer.toString(i), Double.toString((double)(maxTotal)/(double)numRuns), 
					Double.toString((double)(minTotal)/(double)numRuns), Double.toString((double)(avgTotal)/(double)numRuns),
					Double.toString(maxStandDev), Double.toString(avgStandDev), Integer.toString(lastMax),
					Double.toString(mutationRateTotal/(double)numRuns), Double.toString(mutationRateStandDev)});
			
		}
		
		//average the mutation rates across runs
		double[][] geneSpecificMutationRateAverage = new double[numGenerations][sack1.weights.length];
		for(int i = 0; i < numGenerations; i++) {
			for(int j = 0; j < sack1.weights.length; j++) {
				double totalMutationRate = 0.0;
				for(int h = 0; h < numRuns; h++) {
					totalMutationRate = totalMutationRate + geneSpecifcMutationRates[i][h][j];
				}
				totalMutationRate = totalMutationRate/(double)numRuns;
				geneSpecificMutationRateAverage[i][j] = totalMutationRate;
			}
		}
		
		//create object to be printed
		for(int i = 0; i < numGenerations; i++) {
			Object[] mutationRatesOfGeneration = new Object[sack1.getWeights().length];
					//(Object[]) new Object();
				//{Double.toString(geneSpecificMutationRateAverage[i][0])};
			for(int j = 0; j < sack1.getWeights().length; j++) {
				mutationRatesOfGeneration[j] = Double.toString(geneSpecificMutationRateAverage[i][j]);
			}
			mutationData.add(mutationRatesOfGeneration);
		}
		
		
		//GATestData.put("22",new Object[] { Integer.toString(pop.maxFitness()), Integer.toString(pop.minFitness()), Double.toString(pop.avgFitness())});
		  
        int rowid = 0;
  
        // writing the data into the sheets...
  
        for (int i = 0; i < numGenerations + 1; i++) {
  
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = GATestData.get(i);
            int cellid = 0;
  
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
 
        }
        
        rowid = 0;
        for (int i = 0; i < numGenerations; i++) {
        	  
            row1 = spreadsheet1.createRow(rowid++);
            Object[] objectArr = mutationData.get(i);
            int cellid = 0;
  
            for (Object obj : objectArr) {
                Cell cell = row1.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
 
        }
  
        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        FileOutputStream out = new FileOutputStream(
            new File("C:/Users/iriss/OneDrive/Documents/GAResearch/researchDataTest.xlsx"));
  
        workbook.write(out);
        out.close();
	}
}
