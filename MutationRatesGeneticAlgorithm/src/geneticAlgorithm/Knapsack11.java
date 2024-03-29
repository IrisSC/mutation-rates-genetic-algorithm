package geneticAlgorithm;

public class Knapsack11 extends Knapsack{
	
	public Knapsack11() {
		this.cap =  9939;
		this.maxValue = -1;
		int [] weights = {68, 48, 36, 42, 9,72, 84, 33, 47, 48,
				36, 39, 53, 76, 74, 63, 85, 95, 85, 79,
				31, 53, 60, 33, 103, 25, 18, 34, 54, 83,
				60, 37, 88, 38, 66, 52, 40, 39, 87, 99,
				98, 55, 9, 102, 80, 80, 54, 51, 42, 77,
				96, 77, 73, 21, 74, 34, 14, 39, 93, 65,
				32, 68, 95, 4, 81, 7 ,62, 14, 37, 15,
				29, 38, 67, 76, 5, 9, 73, 47, 29, 75,
				51, 52, 95, 87, 64, 54, 92, 98, 87, 95,
				23, 40, 75, 19, 34, 98, 91, 46, 78, 44,
				62, 18, 83, 76, 92, 60, 85, 9, 98, 27,
				60, 68, 86, 18, 96, 78, 84, 90, 13, 59,
				49, 70, 64, 31, 83, 57, 59, 49, 67, 70,
				89, 35, 93, 95, 67, 15, 75, 89, 87, 100,
				81, 101, 25, 69, 98, 14, 28, 48, 9, 72,
				25, 7, 32, 74, 96, 35, 33, 52, 12, 32,
				99, 89, 83, 49, 45, 10, 79, 25, 58, 73,
				37, 20, 93, 46, 93, 93, 91, 92, 48, 98,
				59, 36, 28, 52, 48, 17, 83, 78, 11, 86,
				16, 10, 56, 11, 28, 8, 8 ,67, 70, 64,
				63, 98, 98, 43, 91, 89, 69, 22, 17, 88,
				35, 17, 75, 99, 27, 81, 46, 42, 46, 14,
				71, 70, 83, 77, 87, 50, 84, 23, 44, 23, 103,
				103, 57, 42, 50, 99, 77, 37 ,91, 63, 48,
				71, 92, 60, 47, 67, 40, 50, 20, 12, 35,
				102, 96, 72, 53, 68, 31, 103, 47, 37, 59,
				36, 4, 10, 4, 96, 29, 95, 20, 80, 45,
				9, 80, 87, 21, 15, 77, 101, 65, 79, 36,
				85, 84, 82, 18, 28, 35, 80, 100, 27, 42,
				48, 79, 52, 97, 98, 60, 8, 76, 7 };
		this.weights = weights;
		int [] values = {166, 25, 97, 75, 54, 224, 47, 141, 157, 192,
				122, 251, 230, 14, 212, 215, 302, 12, 226, 93,
				249, 136, 80, 39, 85, 289, 107, 198, 235, 250,
				57, 188, 87, 248, 157, 78, 49, 161, 69, 77,
				100, 133, 197, 254, 240, 125, 84, 44, 9, 49,
				195, 6, 219, 85, 47, 251, 177, 216, 165, 180,
				92, 153, 61, 274, 207, 23, 217, 122, 255, 22,
				124, 190, 173, 250, 194, 211, 24, 177, 28, 251,
				302, 61, 170, 117, 156, 37, 198, 126, 72, 115,
				124, 300, 176, 252, 57, 94, 298, 133, 190, 144,
				275, 242, 12, 97, 74, 146, 231, 173, 91, 100,
				88, 175, 38, 274, 157, 66, 188, 121, 114, 165,
				242, 89, 239, 25, 294, 23, 74, 95, 27, 131,
				275, 8, 118, 190, 196, 302, 241, 82, 36, 229,
				145, 62, 158, 53, 109, 161, 180, 144, 146, 244,
				230, 63, 182, 135, 19, 103 ,135, 290, 212, 205,
				19, 173, 117, 73, 127, 129, 101, 16, 10, 182,
				178, 179, 205, 209, 256, 4, 186, 225, 117, 196,
				283, 299, 175, 13, 49 ,92, 291, 204, 139, 292,
				246, 22, 150, 118, 64, 176, 44, 56, 102, 264,
				87, 49, 169, 242, 204, 259, 278, 54, 190, 112,
				134, 294, 46, 70, 149, 42, 119, 281, 188, 30,
				105, 13, 69, 228, 275, 147, 227, 188, 206, 90,
				12, 25, 282, 84, 120, 75, 133, 64, 205, 180,
				157, 123, 247, 205, 40, 69, 127, 136, 147, 14,
				186, 177, 190, 283, 16, 219, 295, 127, 39, 114,
				140, 37, 47, 168, 155, 190, 224, 85, 26, 285,
				65, 177, 278, 57, 181, 142, 169, 159, 166, 192,
				50, 218, 216, 179, 145, 216, 220, 301, 117, 55,
				227, 122, 232, 55, 22, 17, 23, 264, 41, 77 };
		this.values = values;
	}

}
