package com.codility.lessons.StacksQueues;

public class Nesting {

	public int solution1(String S) {
		int N = S.length();
		// if the length of string s is odd, then it can't be nested.
		if (N % 2 == 1)
			return 0;
		char[] stack = new char[N];
		int num = 0;
		for (int i = 0; i < N; i++) {
			// push the '(' into the stack
			if (S.charAt(i) == '(')
				stack[num++] = S.charAt(i);
			// if the stack is not empty, pop the top element out.
			else if (num != 0)
				num--;
			// other situation means it's not a nested string
			else
				return 0;
		}
		if (num == 0)
			return 1;
		else
			return 0;
	}

	public int solution2(String S) {
		int leftBracketNum = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(') {
				leftBracketNum++;
			} else {
				if (leftBracketNum == 0) {
					return 0;
				}
				leftBracketNum--;
			}
		}
		return leftBracketNum == 0 ? 1 : 0;
	}

}
