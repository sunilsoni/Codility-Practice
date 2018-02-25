package com.codility.lessons.StacksQueues;

import java.util.Stack;

public class Brackets {
	public int solution1(String S) {
		Stack<Character> leftBrackets = new Stack<Character>();
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			if (ch == ')' || ch == ']' || ch == '}') {
				if (leftBrackets.empty()) {
					return 0;
				}
				char top = leftBrackets.pop();
				if ((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')) {
					return 0;
				}
			} else {
				leftBrackets.push(ch);
			}
		}
		return leftBrackets.empty() ? 1 : 0;
	}

}
