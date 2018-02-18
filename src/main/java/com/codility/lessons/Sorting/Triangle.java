package com.codility.lessons.Sorting;

import java.util.Arrays;

/**
 * Determine whether a triangle can be built from a given set of edges.
 * 
 * @author Sunil
 *
 */
public class Triangle {

	public int solution1(int[] A) {
		Arrays.sort(A);
		System.out.println("Lenght Of Array =" + A.length);
		for (int i = 0; i < A.length - 2; i++) {
			System.out.println("A[" + i + "] + A[" + (i + 1) + "] > " + "A[" + (i + 2) + "]");
			if ((long) A[i] + A[i + 1] > A[i + 2]) {
				System.out.println("A[" + i + "] + A[" + (i + 1) + "] > " + "A[" + (i + 2) + "]");
				System.out.println("Triplet is (" + i + ", " + (i + 1) + ", " + (i + 2) + ")");
				return 1;
			}
		}
		return 0;
	}

	public int solution2(int[] A) {
		int N = A.length;
		if (N < 3)
			return 0;
		Arrays.sort(A);
		for (int i = 0; i < N - 2; i++) {
			if (A[i] > 0 && A[i] > A[i + 2] - A[i + 1]) {
				System.out.println("Triplet is (" + i + ", " + (i + 2) + ", " + (i + 1) + ")");
				return 1;
			}
		}
		return 0;
	}

}
