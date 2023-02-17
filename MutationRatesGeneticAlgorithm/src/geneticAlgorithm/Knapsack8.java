package geneticAlgorithm;

public class Knapsack8 extends Knapsack{

	public Knapsack8() {
		this.cap = 921;
		this.maxValue = 4392;
		int [] weights = {9, 96, 25, 98, 50, 34, 95, 95, 49, 5,
				57, 97, 49, 103, 16, 47,76, 29, 89, 84,
				11, 42, 33, 8, 99, 20, 43, 77, 94, 10};
		this.weights = weights;
		int [] values = {209, 54, 101, 49, 103, 261, 296, 246, 204, 234, 303, 259, 13, 273, 
				144, 170, 209, 11, 299, 134, 71, 129, 253, 278, 81, 302, 83, 182, 189, 151};
		this.values = values;
	}
	
}
