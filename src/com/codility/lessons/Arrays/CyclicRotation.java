package com.codility.lessons.Arrays;

import java.util.Arrays;

/**
 * A zero-indexed array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is also moved to the first place.

For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]. The goal is to rotate array A K times; that is, each element of A will be shifted to the right by K indexes.

Write a function:

class Solution { public int[] solution(int[] A, int K); }

that, given a zero-indexed array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given array A = [3, 8, 9, 7, 6] and K = 3, the function should return [9, 7, 6, 3, 8].

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */
public class CyclicRotation {

	public static void main(String[] args) {
	
	//https://codility.com/demo/results/trainingUBWFTE-G5D/
	int[]	A = {-3, 8, 9, -7, 6} ;
	int K = 3;
	
    int[] sol1 = solution1(A,K);
    System.out.println("sol1-->"+Arrays.toString(sol1));
    
    int[] sol2 = solution2(A,K);
    System.out.println("sol2-->"+Arrays.toString(sol2));
    
    int[] sol3 = solution3(A,K);
    System.out.println("sol3-->"+Arrays.toString(sol3));
    
    
    int[] sol4 = solution4(A,K);
    System.out.println("sol4-->"+Arrays.toString(sol4));
	}
	
	
	public static int [] solution1(int [] A, int K) {

	    int size = A.length;
	    int ret[] = new  int [size];

	    if (K < 0 || K > 100 || size == 0) {
	        return ret;
	    }

	    if (size == 1) {
	        return A;
	    }

	    for (int i = 0; i < size; i++) {
	        ret[(i + K) % size] = A[i];
	        
	      //when i=0 then (0+3)=3 =>(3 modulo 5)= 3
	    }

	    return ret;
	}
	
	public static int [] solution2(int [] A, int K) 
    {
        int N = A.length;
        if (N==0)
            return A;
        if (K>=N)
            K %= N;
        if (K==0)
            return A;
        int [] rotA = new  int [N];
        for (int i=0; i<N; i++)
            rotA[i] = (i<K) ? A[N+i-K] : A[i-K];
        return rotA;
    }
	
	public static int[] solution3(int[] A, int K) {
        int length = A.length;
        if (length == 0) {
            return A;
        }
        int[] result = new int[length];
        int rIdx = 0;
        int times = K % length;
        int idx = length - times;
        for (int i = idx; i < length; i++) {
            result[rIdx] = A[i];
            rIdx++;
        }
        for (int i = 0; i < idx; i++) {
            result[rIdx] = A[i];
            rIdx++;
        }
        return result;
    }
	
	  public static int[] solution4(int[] A, int K) {

	        int[] result = new int[A.length];

	        for (int i = 0; i < result.length; i++) {
	            int newPosition = (i + K) % result.length;
	            result[newPosition] = A[i];
	        }

	        return result;
	    }
}
