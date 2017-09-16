package com.codility.lessons.binarygap;

public class BinaryGap2 {
	public int solution(int N) {
		int pre = -1;
		int len = 0;
	 
		while (N > 0) {
			int k = N & -N;
	 
			int curr = (int) Math.log(k);
	 
			N = N & (N - 1);
	 
			if (pre != -1 && Math.abs(curr - pre) > len) {
				len = Math.abs(curr - pre) + 1;
			}
			pre = curr;
		}
	 
		return len;
	
	}
	
	public static void main(String[] args) {
		BinaryGap2  gap =new BinaryGap2  ();
		
		int n = 9;
		int res = gap.solution(n);
		System.out.println("res--->"+res);
		
		res = gap.solution(529);
		System.out.println("res--->"+res);
		
		res = gap.solution(20);
		System.out.println("res--->"+res);
		
	}
}
