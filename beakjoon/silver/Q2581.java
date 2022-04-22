package beakjoon.silver;

import java.util.Scanner;

public class Q2581 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] primes = new int[10000];
		int size = 0;
		for(int i = 2 ; i <= 10000 ; i++) {
			boolean flag = true;
			for(int j = 2 ; j * j <= i ; j++) {
				if(i % j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) primes[size++] = i;
		}
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int min = -1;
		int sum = 0;
		for(int i = 0 ; i < size ; i++) {
			if(primes[i] >= M && primes[i] <= N) {
				if(min == -1) min = primes[i];
				sum += primes[i];
			}
		}
		if(min != -1) {
			System.out.println(sum);
		}
		System.out.println(min);
	}
}
