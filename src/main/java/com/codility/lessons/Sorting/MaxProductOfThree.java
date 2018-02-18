package com.codility.lessons.Sorting;

import java.util.Arrays;

/**
 * Maximize A[P] * A[Q] * A[R] for any triplet (P, Q, R).
 * 
 * @author Sunil
 *
 */
public class MaxProductOfThree {

	public int solution1(int[] A) {
		Arrays.sort(A);
		int N = A.length;
		return Math.max(A[N - 3] * A[N - 2] * A[N - 1], A[0] * A[1] * A[N - 1]);
	}

	public int solution2(int[] A) {
		int N = A.length;
		// the worst-case time complexity is O(N*log(N))
		Arrays.sort(A);
		// the max product of three elements is the product of the last three
		// elements in the sorted array or the product of the first two elements
		// and the last element if the first two elements are negatives.
		return Math.max(A[0] * A[1] * A[N - 1], A[N - 3] * A[N - 2] * A[N - 1]);
	}

	public int solution3(int[] A) {
		// the variable stores the minimal negative element
		int negativeMin = 0;
		// the variable stores the second minimal negative element
		int negativeSecond = 0;
		// the variable stores the third maximal element
		int thirdMax = -1000;
		// the variable stores the second maximal element
		int secondMax = -1000;
		// the variable stores the maximal element
		int maxValue = -1000;
		// get the five variables above in O(N) time complexity
		for (int element : A) {
			if (element < negativeMin) {
				negativeSecond = negativeMin;
				negativeMin = element;
			} else if (element < negativeSecond)
				negativeSecond = element;
			if (element > maxValue) {
				thirdMax = secondMax;
				secondMax = maxValue;
				maxValue = element;
			} else if (element > secondMax) {
				thirdMax = secondMax;
				secondMax = element;
			} else if (element > thirdMax)
				thirdMax = element;
		}
		// the product of the three maximal elements
		int maxProduct = thirdMax * secondMax * maxValue;
		// the number of negative elements is more than 2
		if (negativeSecond != 0)
			// the result is either the product of the three maximal elements or
			// the product of the two minimal negative elements and the maximal
			// positive element.
			return Math.max(negativeMin * negativeSecond * maxValue, maxProduct);
		// the number of negative elements is less than 2
		else
			return maxProduct;
	}

}
