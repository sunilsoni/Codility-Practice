package com.codility.lessons.CountingElements;

/**
 * <p>https://app.codility.com/demo/results/training4GF5TP-THG/ </p>
 *
 */
public class PermutationCheck {

    public int solution(int[] A) {
        boolean[] used = new boolean[A.length];
        for (int number : A) {
            if (number < 1 || number > A.length || used[number - 1]) {
                return 0;
            }
            used[number - 1] = true;
        }
        return 1;
    }

}
