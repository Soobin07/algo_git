package beakjoon.bronze;

import java.util.Scanner;

public class Q2576 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 7;
		int sum = 0;
		int least = 100;

		for (int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			if (tmp % 2 == 1) {
				sum += tmp;
				if(least > tmp) {
					least = tmp;
				}
			}
		}
		
		if(sum == 0) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(least);
		}
	}
}
