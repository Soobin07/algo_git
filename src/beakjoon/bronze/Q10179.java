package beakjoon.bronze;

import java.util.Scanner;

public class Q10179 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0 ; i < N ; i++) {
			double db = sc.nextDouble();
			System.out.printf("$%.2f\n", (db*0.8));
		}
	}
}
