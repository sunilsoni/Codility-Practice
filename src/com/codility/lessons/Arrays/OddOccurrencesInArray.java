package com.codility.lessons.Arrays;
/**
 *  *
 */

public class OddOccurrencesInArray {

	public static int solution(int[] A) {
		int unpaired = 0;
		for (int number : A) {
			printBinaryFormat(number);
			System.out.println(" number===>"+number);
			unpaired ^= number;
			printBinaryFormat(unpaired);
			System.out.println(" unpaired===>"+unpaired);
			System.out.println("<=========>");
		}
		return unpaired;
	}
	
	public static void main(String[] args) {
		int[] A = {9,3,9,3,9,7,9};
		
		int res = solution(A);
		printBinaryFormat(res);
		System.out.println(" res===>"+res);

		//https://codility.com/demo/results/trainingNRQ4RE-4T9/
	}
	 public static void printBinaryFormat(int number){
	        int binary[] = new int[25];
	        int index = 0;
	        while(number > 0){
	            binary[index++] = number%2;
	            number = number/2;
	        }
	        for(int i = index-1;i >= 0;i--){
	            System.out.print(binary[i]);
	        }
	    }
}
