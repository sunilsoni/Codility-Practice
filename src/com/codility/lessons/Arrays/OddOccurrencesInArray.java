package com.codility.lessons.Arrays;
/**
 * 
 * <p>A non-empty zero-indexed array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

<p>For example, in array A such that:

  <i>A[0] = 9  A[1] = 3  A[2] = 9</i>
  <i>A[3] = 3  A[4] = 9  A[5] = 7</i>
  <i>A[6] = 9</i>
<p>the elements at indexes 0 and 2 have value 9,
<p>the elements at indexes 1 and 3 have value 3,
<p>the elements at indexes 4 and 6 have value 9,
<p>the element at index 5 has value 7 and is unpaired.
<p>Write a function:

<p>class Solution { public int solution(int[] A); }

<p>that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

<p>For example, given array A such that:

  <i>A[0] = 9  A[1] = 3  A[2] = 9</i>
  <i>A[3] = 3  A[4] = 9  A[5] = 7</i>
  <i>A[6] = 9</i>
<p>the function should return 7, as explained in the example above.

<p>Assume that:

<p>N is an odd integer within the range [1..1,000,000];
<p>each element of array A is an integer within the range [1..1,000,000,000];
<p>all but one of the values in A occur an even number of times.
<p>Complexity:

<p>expected worst-case time complexity is O(N);
<p>expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
<p>Elements of input arrays can be modified.
 *
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
