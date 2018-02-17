package com.codility.lessons.Sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Compute number of distinct values in an array.
 */
public class Distinct {
    public int solution1(int[] A) {
        Set<Integer> numberSet = new HashSet<Integer>();
        for (int number : A) {
            numberSet.add(number);
        }
        return numberSet.size();
    }

    public int solution2(int[] A) {
        int N = A.length;
        if (N == 0)
            return 0;
        // the built-in sorting function performs O(n*log(n)) time complexity
        // even in the worst case
        Arrays.sort(A);
        int num = 1;
        int preDist = A[0];
        for (int i = 1; i < N; i++) {
            // add 1 to the number when there is a bigger element.
            if (A[i] != preDist) {
                preDist = A[i];
                num++;
            }
        }
        return num;
    }


}
