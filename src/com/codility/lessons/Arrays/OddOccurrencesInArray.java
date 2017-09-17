package com.codility.lessons.Arrays;

public class OddOccurrencesInArray {

	public int solution(int[] A) {
		int unpaired = 0;
		for (int number : A) {
			unpaired ^= number;
		}
		return unpaired;
	}
	
	public static void main(String[] args) {
		OddOccurrencesInArray odd= new OddOccurrencesInArray();
		
		int[] A = {9,3,9,3,9,7,9};
		
		int res = odd.solution(A);
		System.out.println("res===>"+res);

		//https://codility.com/demo/results/trainingNRQ4RE-4T9/
	}

}
