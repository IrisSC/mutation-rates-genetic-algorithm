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
		
		//create stuff to print data into excel
		 // workbook object
        XSSFWorkbook workbook = new XSSFWorkbook();
  
        // spreadsheet object
        XSSFSheet spreadsheet = workbook.createSheet("GA Date");
  
        // creating a row object
        XSSFRow row;
  
        // This data needs to be written (Object[])
        List<Object[]> GATestData = new ArrayList<Object[]>();
		
		//create static mutation individual
		IndivStaticMutate indiv1 = new IndivStaticMutate(80, 0.3);
		
		//create knapsack
		//KnapSack1 sack1 = new KnapSack1();
		//Knapsack2 sack1 = new Knapsack2();
		//Knapsack3 sack1 = new Knapsack3();
		Knapsack4 sack1 = new Knapsack4();
		
		//create population
		Population pop = new Population(11, indiv1, sack1);
		
		GATestData.add(new Object[] {"Generation", "Max Fitness", "Min Fitness", "Avg Fitness"});
		
		GATestData.add(new Object[] {Integer.toString(0), Integer.toString(pop.maxFitness()), 
				Integer.toString(pop.minFitness()), Double.toString(pop.avgFitness())});
		
		//run GA
		for(int i = 0; i < 100; i++) {
			pop = pop.generateNewPop(10);
			
			GATestData.add(new Object[] {Integer.toString(i+1), Integer.toString(pop.maxFitness()), 
					Integer.toString(pop.minFitness()), Double.toString(pop.avgFitness())});
			
			/*if(i%5 == 4) {
				GATestData.put(Integer.toString(i + 2),new Object[] { Integer.toString(pop.maxFitness()), 
						Integer.toString(pop.minFitness()), Double.toString(pop.avgFitness())});
			}*/
			
			System.out.println(pop.maxFitness());
		}
		
		//print out information 
		System.out.println(pop.maxFitness());
		Individual bestFit = pop.getBestFitIndiv();
		for(int i = 0; i < bestFit.length; i++) {
			System.out.print(bestFit.getSolutionChromosome()[i]);
		}
		System.out.println("");
		System.out.println("percent close: " + (double)pop.maxFitness()/(double)sack1.getMaxPossibleValue());
		
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
