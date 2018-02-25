package com.codility.lessons.StacksQueues;

import java.util.Arrays;
import java.util.Stack;

public class StoneWall {
	public int solution1(int[] H) {
		int[] heights = Arrays.copyOf(H, H.length + 1);
		Stack<Integer> increasingHeights = new Stack<Integer>();
		int blockNum = 0;
		for (int height : heights) {
			while (!increasingHeights.empty() && increasingHeights.peek() >= height) {
				if (increasingHeights.peek() > height) {
					blockNum++;
				}
				increasingHeights.pop();
			}
			increasingHeights.push(height);
		}
		return blockNum;
	}

	public int solution2(int[] H) {
		int N = H.length;
		int[] stack = new int[N];
		int num = 0;
		stack[num++] = H[0];
		int result = 1;
		for (int i = 1; i < N; i++) {
			// store the stonewall in ascending order and pop out the larger
			// stonewall than the current stonewall
			while (num > 0 && stack[num - 1] > H[i]) {
				num--;
			}
			// if the stack is empty or the top of stack isn't equal to the
			// current stonewall, then we should push the current stonewall in
			// the stack and add 1 to the result.
			if (num == 0 || stack[num - 1] != H[i]) {
				stack[num++] = H[i];
				result++;
			}
		}
		return result;
	}

}
