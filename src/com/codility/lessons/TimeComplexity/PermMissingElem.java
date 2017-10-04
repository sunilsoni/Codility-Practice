package com.codility.lessons.TimeComplexity;

import java.util.Arrays;

/**
 * A zero-indexed array A consisting of N different integers is given. The array
 * contains integers in the range [1..(N + 1)], which means that exactly one
 * element is missing.
 * 
 * Your goal is to find that missing element.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a zero-indexed array A, returns the value of the missing element.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 2 A[1] = 3 A[2] = 1 A[3] = 5 the function should return 4, as it is
 * the missing element.
 * 
 * Assume that:
 * 
 * N is an integer within the range [0..100,000]; the elements of A are all
 * distinct; each element of array A is an integer within the range [1..(N +
 * 1)]. Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(1), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 *
 */
public class PermMissingElem {

	public static void main(String[] args) {
		int[] input = {2,3,1,5};
		int result = missingElem(input);
		System.out.println("result1--->"+result);
		
		result = solution(input);
		System.out.print("result11--->"+result);

	}

	static int missingElem(int[] A){ // Function to Find Missing Element
		long sum = 0; // Will Hold Sum of All Numbers from 1 to N+1
		long arraysum = 0; // Will Hold Sum of All Numbers in Array
		long missing = 0; // Will Hold Missing Value

		for (int i = 0; i < A.length; i++) {// Get Sum of All Numbers from 1 to  N+1, and Array
			sum += (i + 1);
			arraysum += A[i];
		}
		sum += A.length + 1; // Add Last Number in Range (N+1)
		missing = sum - arraysum; // Subtract Sum of Array from Sum of Range to get Missing Value
		return (int) missing; // Return Missing Value
	}
	
	//https://codility.com/demo/results/trainingPRHEBN-NCZ/
	static int solution(int[] data) {
        long N = data.length + 1;
        long total = (N * (N + 1)) / 2;
        long sum = 0L;
        for (int i : data) {
            sum += i;
        }
        return (int) (total - sum);
    }
	static int solution1(int[] A) {
		if(A == null){
			return 0;
		}
		long arraySum = Arrays.stream(A).asLongStream().sum();
		long N = A.length+1;
		long expectedSum = (N*(N+1))/2;
        return (int)(expectedSum-arraySum);
    }
	

}
