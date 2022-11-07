package tw.brad.myjava;

public class Z_Codewars_kyu8_countPositivesSumNegatives {
	//Given an array of integers.
	//Return an array, where the first element is the count of positives numbers and 
	//the second element is sum of negative numbers. 0 is neither positive nor negative.
	//
	//If the input is an empty array or is null, return an empty array.
	//
	//Example
	//For input [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15], you should return [10, -65].		
	
	public static int[] countPositivesSumNegatives(int[] input) {

		int[] ret = new int[2];
		int[] empty = {};
		if(input == null || input.length==0) {
			return empty;
		}else {
			for (int i=0; i<input.length; i++) {
				if (input[i] > 0) {
					ret[0]++;
				}else if (input[i] < 0) {
					ret[1] += input[i];			
				}
			}
			return ret;
		}
		
	}
	
	public static void main(String[] args) {
//		int[] test = {5,6,7,19,76,-5,-8,-20};
//		int[] test = {};
		int[] test = null;
		for(int x : countPositivesSumNegatives(test)) {
			System.out.print(x+" ");
		}
	}
}

