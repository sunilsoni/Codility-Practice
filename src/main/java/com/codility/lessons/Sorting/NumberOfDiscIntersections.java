package com.codility.lessons.Sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Compute the number of intersections in a sequence of discs.
 * 
 * @url https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/
 * 
 * @author Sunil
 *
 */
public class NumberOfDiscIntersections {

	public int solution1(int[] A) {
		int N = A.length;
		if (N < 2)
			return 0;
		// intervals stores the two elements : i - A[i] and i + A[i]
		long[][] intervals = new long[N][2];
		for (int i = 0; i < N; i++) {
			intervals[i][0] = (long) i - A[i];
			intervals[i][1] = (long) i + A[i];
		}
		// using the lambda expression to sort a two dimensional array by the
		// intervals left end in ascending order
		Arrays.sort(intervals, (long[] a, long[] b) -> Long.signum(a[0] - b[0]));
		int result = 0;
		for (int i = 0; i < N - 1; i++) {
			// using the intervals' right end as the key value of binary search
			long rightEnd = intervals[i][1];
			int binarySearchLeft = i + 1;
			int binarySearchRight = N - 1;
			int resultIndex = i;
			// using the binary search to find the number of intersections
			while (binarySearchLeft <= binarySearchRight) {
				int binarySearchMid = (binarySearchLeft + binarySearchRight) / 2;
				if (intervals[binarySearchMid][0] <= rightEnd) {
					resultIndex = binarySearchMid;
					binarySearchLeft = binarySearchMid + 1;
				} else
					binarySearchRight = binarySearchMid - 1;
			}
			// count the number of intersections
			result += (resultIndex - i);
			if (result > 10000000)
				return -1;
		}
		return result;
	}

	public int solution2(int[] A) {
		int N = A.length;
		if (N < 2)
			return 0;
		// stores the number of discs which start at each point
		int[] discStart = new int[N];
		// stores the number of discs which end at each point
		int[] discEnd = new int[N];
		for (int i = 0; i < N; i++) {
			discStart[Math.max(0, i - A[i])]++;
			// the result of i + A[i] could be over the max integer in java and
			// it will become a negative integer.
			if (i + A[i] < 0)
				discEnd[N - 1]++;
			else
				discEnd[Math.min(N - 1, i + A[i])]++;
		}
		// the number of discs which haven't been calculated at a very point
		int unCalcDiscNo = 0;
		int result = 0;
		for (int i = 0; i < N; i++) {
			if (discStart[i] > 0) {
				// calculate the product of the number of discs that haven't
				// been calculated and the number of started discs at this point
				result += unCalcDiscNo * discStart[i];
				// calculate the number of intersections of the started discs at
				// this point, the algorithm is 1+2+...+N = N*(N-1)/2
				result += discStart[i] * (discStart[i] - 1) / 2;
				if (result > 10000000)
					return -1;
				// add the number of start discs to unCalcDiscNo
				unCalcDiscNo += discStart[i];
			}
			if (discEnd[i] > 0)
				// subtract the calculated discs from unCalcDiscNo
				unCalcDiscNo -= discEnd[i];
		}
		return result;
	}

	static final int LIMIT = 10000000;

	public int solution3(int[] A) {
		Point[] points = new Point[A.length * 2];
		for (int i = 0; i < A.length; i++) {
			points[i * 2] = new Point((long) i - A[i], Type.LOWER);
			points[i * 2 + 1] = new Point((long) i + A[i], Type.UPPER);
		}

		Arrays.sort(points, new PointComparator());

		int intersectNum = 0;
		int openedNum = 0;
		for (Point point : points) {
			if (point.type.equals(Type.LOWER)) {
				intersectNum += openedNum;
				if (intersectNum > LIMIT) {
					return -1;
				}
				openedNum++;
			} else {
				openedNum--;
			}
		}
		return intersectNum;
	}
}

class PointComparator implements Comparator<Point> {
	@Override
	public int compare(Point p1, Point p2) {
		if (p1.y != p2.y) {
			return (int) Math.signum(p1.y - p2.y);
		}
		return p1.type.equals(Type.LOWER) ? -1 : 1;
	}
}

class Point {
	long y;
	Type type;

	Point(long y, Type type) {
		this.y = y;
		this.type = type;
	}
}

enum Type {
	LOWER, UPPER

}
