package com.codility.lessons.BinaryGap;

/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.

Assume that:

N is an integer within the range [1..2,147,483,647].
Complexity:

expected worst-case time complexity is O(log(N));
expected worst-case space complexity is O(1).
 */
public class BinaryGap {
	public int solution(int n) { 
		// get rid of right-hand zeros
	    while (n != 0 && (n & 1) == 0) {
	        n >>>= 1;
	    }

	    int max = 0;
	    int gap = 0;
	    while (n != 0) {
	        if ((n & 1) == 0) {
	            gap++;
	            max = Math.max(gap, max);
	        } else {
	            gap = 0;
	        }
	        n >>>= 1;
	    }
	    return max;
	   }
	
	public static void main(String[] args) {
		BinaryGap  gap =new BinaryGap  ();
		
		int n = 1041;
		int res = gap.solution(n);
		System.out.println("res--->"+res);
		
		//example1  example test n=1041=10000010001_2
		res = gap.solution(1041);
		System.out.println("1041--->"+res);
		
		//example2  example test n=15=1111_2
		res = gap.solution(15);
		System.out.println("15--->"+res);
		
		//extremes n=1, n=5=101_2 and n=2147483647=2**31-1
		res = gap.solution(1);
		System.out.println("1--->"+res);
		
		res = gap.solution(5);
		System.out.println("5--->"+res);
		
		res = gap.solution(2147483647);
		System.out.println("2147483647--->"+res);
		
		//trailing_zeroes  n=6=110_2 and n=328=101001000_2
		res = gap.solution(6);
		System.out.println("6(110_2)--->"+res);
		
		res = gap.solution(328);
		System.out.println("328(101001000_2)--->"+res);
		
		res = gap.solution(101001000_2);
		System.out.println("res--->"+res);
		
		//power_of_2  n=5=101_2, n=16=2**4 and n=1024=2**10
		res = gap.solution(5);
		System.out.println("5=101_2--->"+res);
		
		res = gap.solution(16);
		System.out.println("16=2**4--->"+res);
		
		res = gap.solution(1024);
		System.out.println("1024=2**10--->"+res);
		
		//simple1 n=9=1001_2 and n=11=1011_2
		res = gap.solution(9);
		System.out.println("9=1001_2--->"+res);
		
		res = gap.solution(11);
		System.out.println("11=1011_2--->"+res);
		
		//simple2 n=19=10011 and n=42=101010_2
		res = gap.solution(19);
		System.out.println("19=10011--->"+res);
		
		res = gap.solution(42);
		System.out.println("42=101010_2--->"+res);
		
		//simple3 n=1162=10010001010_2 and n=5=101_2
		res = gap.solution(1162);
		System.out.println("1162=10010001010_2--->"+res);
		
		res = gap.solution(5);
		System.out.println("5=101_2--->"+res);
		
		//medium1 n=51712=110010100000000_2 and n=20=10100_2
		res = gap.solution(51712);
		System.out.println("51712=110010100000000_2--->"+res);
		
		res = gap.solution(20);
		System.out.println("20=10100_2--->"+res);
		
		
		//medium2 n=561892=10001001001011100100_2 and n=9=1001_2
		
		//medium3 n=66561=10000010000000001_2
		
		//large1 n=6291457=11000000000000000000001_2
		
		//large2 n=74901729=100011101101110100011100001
		
		//large3 n=805306373=110000000000000000000000000101_2
		
		//large4 n=1376796946=1010010000100000100000100010010_2
		
		//large5 n=1073741825=1000000000000000000000000000001_2
		
		//large6 n=1610612737=1100000000000000000000000000001_2
		
		//Result: Your code is syntactically correct and works properly on the example test.
		//Analysis summary:The solution obtained perfect score.
		//https://codility.com/demo/results/trainingY93KXQ-R34/


	}
}
