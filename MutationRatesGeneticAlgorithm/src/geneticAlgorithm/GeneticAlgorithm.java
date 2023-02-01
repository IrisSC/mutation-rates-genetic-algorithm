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
		int populationSize = 101;
		int tournamentSize = 5;
		int numGenerations = 100;
		int numRuns = 100;
		
		
		//create stuff to print data into excel
		// workbook object
        XSSFWorkbook workbook = new XSSFWorkbook();
  
        // spreadsheet object
        XSSFSheet spreadsheet = workbook.createSheet("GA Date");
  
        // creating a row object
        XSSFRow row;
  
        // This data needs to be written (Object[])
        List<Object[]> GATestData = new ArrayList<Object[]>();
		
		//create knapsack
		//KnapSack1 sack1 = new KnapSack1();
		//Knapsack2 sack1 = new Knapsack2();
		//Knapsack3 sack1 = new Knapsack3();
		//Knapsack4 sack1 = new Knapsack4();
		Knapsack5 sack1 = new Knapsack5();
		
		//create array to store the data from multiple runs
		int[][] max = new int[numGenerations][numRuns];
		double[][] avg = new double[numGenerations][numRuns];
		int[][] min = new int[numGenerations][numRuns];
		
		GATestData.add(new Object[] {"Generation", "Max Fitness", "Min Fitness",
				"Avg Fitness", "Max Stand Dev", "Avg Stand Dev", "Last Max"});
		int numValid = 0;
		//the number of runs for the GA
		for(int j = 0; j < numRuns; j++) {
			//create static mutation individual
			//IndivStaticMutate indiv1 = new IndivStaticMutate(sack1.weights.length, 0.2);
			IndivSelfAdaptMutate indiv1 = new IndivSelfAdaptMutate(sack1.weights.length, 0.2);
			
			//create population
			Population pop = new Population(populationSize, indiv1, sack1);
			
			/*GATestData.add(new Object[] {Integer.toString(0), Integer.toString(pop.maxFitness()), 
					Integer.toString(pop.minFitness()), Double.toString(pop.avgFitness())});
			*/
			
			max[0][j] = pop.maxFitness();
			avg[0][j] = pop.avgFitness();
			min[0][j] = pop.minFitness();
			
			//run GA
			for(int i = 0; i < numGenerations; i++) {
				pop = pop.generateNewPop(tournamentSize);
				
				max[i][j] = pop.maxFitness();
				avg[i][j] = pop.avgFitness();
				min[i][j] = pop.minFitness();
				
				/*GATestData.add(new Object[] {Integer.toString(i+1), Integer.toString(pop.maxFitness()), 
						Integer.toString(pop.minFitness()), Double.toString(pop.avgFitness())});
				*/
				
				/*if(i%5 == 4) {
					GATestData.put(Integer.toString(i + 2),new Object[] { Integer.toString(pop.maxFitness()), 
							Integer.toString(pop.minFitness()), Double.toString(pop.avgFitness())});
				}*/
				
				//System.out.println(pop.maxFitness());
			}
			
			//print out information 
			System.out.println(pop.maxFitness());
			Individual bestFit = pop.getBestFitIndiv();
			for(int i = 0; i < bestFit.length; i++) {
				System.out.print(bestFit.getSolutionChromosome()[i]);
			}
			System.out.println("");
			System.out.println("percent close: " + (double)pop.maxFitness()/(double)sack1.getMaxPossibleValue());
			
			System.out.println(sack1.isValid(bestFit));
			if(sack1.isValid(bestFit)) {
				numValid++;
			}
		}
		System.out.print(numValid);
		
		//get the avgerages 
		for(int i = 0; i < numGenerations; i++) {
			int maxTotal = 0;
			int minTotal = 0;
			Double avgTotal = 0.0;
			for(int j = 0; j < numRuns; j++) {
				maxTotal = maxTotal + max[i][j];
				minTotal = minTotal + min[i][j];
				avgTotal = avgTotal + avg[i][j];
			}
			double maxAvg = (double)(maxTotal)/(double)numRuns;
			double avgAvg = (double)(avgTotal)/(double)numRuns;
			//get standard deviations
			double maxStandDev = 0.0;
			double avgStandDev = 0.0;
			for(int j = 0; j < numRuns; j++) {
				int maxFitness = max[i][j];
				maxStandDev = maxStandDev + Math.pow((double)maxFitness-maxAvg, 2);
				
				double avgFitness = avg[i][j];
				avgStandDev = avgStandDev + Math.pow((double)avgFitness-avgAvg, 2);
			}
			maxStandDev = Math.round(Math.sqrt(maxStandDev/numRuns)*100.0)/100.0;
			avgStandDev = Math.round(Math.sqrt(avgStandDev/numRuns)*100.0)/100.0;
			
			int lastMax = max[i][numRuns-1];
			
			GATestData.add(new Object[] {Integer.toString(i), Double.toString((double)(maxTotal)/(double)numRuns), 
					Double.toString((double)(minTotal)/(double)numRuns), Double.toString((double)(avgTotal)/(double)numRuns),
					Double.toString(maxStandDev), Double.toString(avgStandDev), Integer.toString(lastMax)});
			
		}
		
		
		//GATestData.put("22",new Object[] { Integer.toString(pop.maxFitness()), Integer.toString(pop.minFitness()), Double.toString(pop.avgFitness())});
		  
        int rowid = 0;
  
        // writing the data into the sheets...
  
        for (int i = 0; i < 101; i++) {
  
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = GATestData.get(i);
            int cellid = 0;
  
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }
  
        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        FileOutputStream out = new FileOutputStream(
            new File("C:/Users/19IrisOS/Desktop/Dickinson College/Comp Sci Research Project/researchDataTest.xlsx"));
  
        workbook.write(out);
        out.close();
	}
}
