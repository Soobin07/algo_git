package jungol;

import java.util.Scanner;

public class C1161 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		hanoi(N, 1, 3, 2);
	}
	
	public static void move(int N, int start, int to) {
		System.out.printf("%s : %d -> %d%n", N, start, to);
	}
	public static void hanoi(int N, int start, int to, int via) {
		if(N == 1) 
			move(1, start, to);
		else {
			hanoi(N-1, start, via, to);
			move(N, start, to);
			hanoi(N-1, via, to, start);
		}
	}
}
