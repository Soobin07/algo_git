package beakjoon.silver;

import java.util.Scanner;

public class Q20162 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] foods = new int[N];
		for (int i = 0; i < N; i++) {
			foods[i] = sc.nextInt();
		}
		
		int[] maxs = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			int food = foods[i];
			int max = 0;
			for(int j = 0 ; j < i ; j++) {
				if(foods[j] < foods[i]) {
					max = Math.max(max, maxs[j]);
				}
			}
			maxs[i] = max + food;
		}
		
		int max = 0;
		for(int i = 0 ; i < N ; i++) {
			max = Math.max(maxs[i], max);
		}
		
		System.out.println(max);
	}
}
